package com.tc.controller;

import com.tc.constants.FieldConstants;
import com.tc.constants.NumberConstants;
import com.tc.entity.ExamPlan;
import com.tc.entity.ExamResult;
import com.tc.entity.Resp;
import com.tc.entity.User;
import com.tc.mapper.ExamResultMapper;
import com.tc.service.ExamPlanService;
import com.tc.service.ExamResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TingCong on 2017/6/1.
 */
@Controller
@RequestMapping("ExamResult")
public class ExamResultController {

    @Autowired
    private ExamResultService examResultService;

    /**
     * 学生获取考试成绩
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping("getExamResult")
    @ResponseBody
    public Resp getExamResultByStudentId(HttpServletRequest request, HttpServletResponse response , HttpSession session){
        Resp resp=new Resp();
        try {
            Integer account=Integer.parseInt(((User)session.getAttribute(FieldConstants.ONLINE_USER)).getAccount());
            List<ExamResult> examResult=examResultService.getExamResultByStudentId(account);
            resp.setData(examResult);
            resp.setStatus(NumberConstants.STATUS_OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    @RequestMapping("getNotCorrection")
    @ResponseBody
    public Resp getNotCorrection(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception {
        Resp resp=new Resp();
        Map map=new HashMap<>();
        Integer account=Integer.parseInt(((User)session.getAttribute(FieldConstants.ONLINE_USER)).getAccount());

        String projectRealPath=request.getSession().getServletContext().getRealPath("");
        String projectRootRealPath=projectRealPath.substring(0,projectRealPath.indexOf("target"));
        String filePath=projectRootRealPath+"\\src\\main\\webapp\\file\\paperResult";
        map.put("account",account);
        map.put("filePath",filePath);
        examResultService.getNotCorrection(map);
        return null;
    }
}
