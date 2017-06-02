package com.tc.controller;

import com.tc.constants.FieldConstants;
import com.tc.constants.MsgConstants;
import com.tc.constants.NumberConstants;
import com.tc.entity.ExamPlan;
import com.tc.entity.ExamResult;
import com.tc.entity.Resp;
import com.tc.entity.User;
import com.tc.mapper.ExamResultMapper;
import com.tc.service.ExamPlanService;
import com.tc.service.ExamResultService;
import com.tc.utils.XMLUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by TingCong on 2017/6/1.
 */
@Controller
@RequestMapping("ExamResult")
public class ExamResultController {

    @Autowired
    private ExamResultService examResultService;

    @Autowired
    private ExamPlanService examPlanService;

    /**
     * 学生获取考试成绩
     *
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping("getExamResult")
    @ResponseBody
    public Resp getExamResultByStudentId(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Resp resp = new Resp();
        try {
            Integer account = Integer.parseInt(((User) session.getAttribute(FieldConstants.ONLINE_USER)).getAccount());
            List<ExamResult> examResult = examResultService.getExamResultByStudentId(account);
            resp.setData(examResult);
            resp.setStatus(NumberConstants.STATUS_OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    @RequestMapping("getNotCorrection")
    @ResponseBody
    public Resp getNotCorrection(HttpServletRequest request, HttpServletResponse response, HttpSession session, String examId, String subject) throws Exception {
        Resp resp = new Resp();
        try {
            Map map = new HashMap<>();
            Integer account = Integer.parseInt(((User) session.getAttribute(FieldConstants.ONLINE_USER)).getAccount());
            map.put("paperId", examId);
            String projectRealPath = request.getSession().getServletContext().getRealPath("");
            String projectRootRealPath = projectRealPath.substring(0, projectRealPath.indexOf("target"));
            String filePath = projectRootRealPath + "\\src\\main\\webapp\\file\\paperResult";
            map.put("account", account);
            map.put("subjectId", subject);
            map.put("filePath", filePath);
            List<Map> mapList = examResultService.getNotCorrection(map);
            resp.setData(mapList);
            resp.setStatus(NumberConstants.STATUS_OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    @RequestMapping("getNotCorrectionByTeacherId")
    @ResponseBody
    public Resp getNotCorrectionByTeacherId(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Resp resp = new Resp();
        Integer account = Integer.parseInt(((User) session.getAttribute(FieldConstants.ONLINE_USER)).getAccount());
        List<ExamPlan> examResults = examPlanService.getExamPlanByTeachId(account);
        resp.setData(examResults);
        resp.setStatus(NumberConstants.STATUS_OK);
        return resp;
    }

    @RequestMapping("commitEssayResult")
    @ResponseBody
    public Resp commitEssayResult(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        Resp resp = new Resp();
        Enumeration enumeration = request.getParameterNames();
        String param = null;
        while (enumeration.hasMoreElements()) {
            param = (String) enumeration.nextElement();
        }
        param = "[" + param + "]";
//        System.out.println(param);
        JSONArray jsonArray = JSONArray.fromObject(param);
        List<Map<String, String>> mapList = (List) jsonArray;
        Set<String> studentIdSet = new HashSet<>();
        //获取所有学号
        for (int i = 0; i < mapList.size(); i++) {
            studentIdSet.add(mapList.get(i).get("studentId").toString());
        }
//        <学号,分数>
        Map<Integer, Integer> map = new HashMap<>();
//        for(String set:studentIdSet){
//            map.put(set,Integer.parseInt(set));
//        }
        Integer paperId = null;
        for (String set : studentIdSet) {
//            System.out.println(set);
            Integer totalScore = 0;
            for (int i = 0; i < mapList.size(); i++) {
                paperId = Integer.parseInt(mapList.get(i).get("examId"));
//                System.out.println(mapList.get(i).get("studentId").toString().trim());
//                System.out.println(set.toString().trim());
//                System.out.println("iiiiiiiiiiiiiiii");
                if (mapList.get(i).get("studentId").toString().trim().equals(set.toString().trim())) {
//                    map.put(Integer.parseInt(set),Integer.parseInt(mapList.get(i).get("score")));
                    totalScore = totalScore + Integer.parseInt(mapList.get(i).get("score").toString());
                }
                map.put(Integer.parseInt(set), totalScore);
            }
        }
        if (examResultService.updateEssayScore(map, paperId) == 0) {
            resp.setMsg(MsgConstants.SYSTEM_ERROR);
            resp.setStatus(NumberConstants.STATUS_ERROR);
        }

        ExamPlan examPlan = examPlanService.getExamInfoById(paperId);
        Integer subjectId = examPlan.getSubjectId();
        String projectRealPath = request.getSession().getServletContext().getRealPath("");
        String projectRootRealPath = projectRealPath.substring(0, projectRealPath.indexOf("target"));
        String filePath = projectRootRealPath + "\\src\\main\\webapp\\file\\paperResult\\" + subjectId.toString().trim() + "\\result.xml";
        Map map1 = new HashMap();
        map1.put("filPath", filePath);
        for (int i = 0; i < mapList.size(); i++) {
            map1.put("examId", mapList.get(i).get("examId").toString());
            map1.put("questionId", mapList.get(i).get("questionId").toString());
            XMLUtil.updateEssayResultStatus(filePath, mapList.get(i).get("questionId").toString().trim(), mapList.get(i).get("examId").toString().trim());
        }
        for (String studentId : studentIdSet) {
            Map map2=new HashMap();
            map2.put("paperId",paperId);
            map2.put("studentId",Integer.parseInt(studentId));
            examResultService.updateTotalScore(map2);
        }
        resp.setStatus(NumberConstants.STATUS_OK);
        return resp;
    }
}
