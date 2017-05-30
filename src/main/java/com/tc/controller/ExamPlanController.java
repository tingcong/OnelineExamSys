package com.tc.controller;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.tc.constants.FieldConstants;
import com.tc.constants.MsgConstants;
import com.tc.constants.NumberConstants;
import com.tc.entity.ExamPlan;
import com.tc.entity.Resp;
import com.tc.entity.User;
import com.tc.service.ExamPlanService;
import com.tc.utils.DatetimeUtil;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Created by htc on 2017/5/16.
 */
@Controller
@RequestMapping("ExamPlan")
public class ExamPlanController {
    @Autowired
    private ExamPlanService examPlanService;
    @RequestMapping("insertExamPlan")
    @ResponseBody
    public Resp insertExamPlan(HttpServletRequest request, HttpServletResponse response){
        Resp resp=new Resp();
        String param="";
        try {
            Enumeration enumeration=request.getParameterNames();
            while(enumeration.hasMoreElements()){
                param=(String)enumeration.nextElement();
            }
            Map paramMap = (Map)JSONObject.fromObject(param);
            paramMap.put("createDt", DatetimeUtil.getLocalDatetime());
            int flag=examPlanService.insertExamPlan(paramMap);
            if(flag!=NumberConstants.STATUS_OK){
                resp.setStatus(NumberConstants.STATUS_ERROR);
                resp.setMsg(MsgConstants.EXCUTE_ERROR);
                return resp;
            }
            resp.setStatus(NumberConstants.STATUS_OK);
            resp.setMsg(MsgConstants.EXCUTE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(NumberConstants.STATUS_ERROR);
            resp.setMsg(MsgConstants.SYSTEM_ERROR);
        }
        return resp;
    }

    @RequestMapping("getAllExamNotSet")
    @ResponseBody
    public Resp getAllExamNotSet(HttpServletResponse response, HttpServletRequest request, HttpSession session){
        Resp resp=new Resp();
        try {
            String account=((User)session.getAttribute(FieldConstants.ONLINE_USER)).getAccount();
            List<ExamPlan> examPlanList=examPlanService.getAllExamNotSet(Integer.parseInt(account));
            if (examPlanList.size()==0){
                examPlanList=new ArrayList<ExamPlan>();
            }
            resp.setData(examPlanList);
            resp.setStatus(NumberConstants.STATUS_OK);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.setStatus(NumberConstants.STATUS_ERROR);
            resp.setData(MsgConstants.SYSTEM_ERROR);
        }
        return resp;
    }

    @RequestMapping("getExamInfoById")
    @ResponseBody
    public Resp getExamInfoById(HttpServletRequest request,HttpServletResponse response ,String examid){
        Resp resp=new Resp();
        try {
            ExamPlan examPlan=examPlanService.getExamInfoById(Integer.parseInt(examid));
            if(examPlan== null){
                examPlan=new ExamPlan();
            }
            resp.setStatus(NumberConstants.STATUS_OK);
            resp.setData(examPlan);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(NumberConstants.STATUS_ERROR);
            resp.setMsg(MsgConstants.SYSTEM_ERROR);
        }
        return resp;
    }

    /**
     * 添加考试题型和分数
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("updatePaperById")
    @ResponseBody
    public Resp updatePaperById(HttpServletRequest request,HttpServletResponse response){
        Resp resp=new Resp();
        String param="";
        try {
            Enumeration enumeration= request.getParameterNames();
            while (enumeration.hasMoreElements()){
                param=(String)enumeration.nextElement();
            }
            System.out.println(param);
            Map map=JSONObject.fromObject(param);
            int flag=examPlanService.updatePaperById(map);
            if(flag==0){
                resp.setStatus(NumberConstants.STATUS_ERROR);
                resp.setMsg(MsgConstants.EXCUTE_ERROR);
                return resp;
            }
            resp.setMsg(MsgConstants.EXCUTE_SUCCESS);
            resp.setStatus(NumberConstants.STATUS_OK);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(NumberConstants.STATUS_ERROR);
            resp.setMsg(MsgConstants.SYSTEM_ERROR);
        }
        return resp;
    }

    /**
     * 开始考试，获取试卷
     * @param request
     * @param response
     * @param examId
     * @return
     */
    @RequestMapping("getPaper")
    @ResponseBody
    public Resp getPaper(HttpServletRequest request,HttpServletResponse response ,String examId){
        Resp resp=new Resp();
        try {
            String projectRealPath=request.getSession().getServletContext().getRealPath("");
            String projectRootRealPath=projectRealPath.substring(0,projectRealPath.indexOf("target"));
            String filePath=projectRootRealPath+"\\src\\main\\webapp\\file\\questionLibrary";
            resp=examPlanService.getPaper(Integer.parseInt(examId),filePath);
            resp.setStatus(NumberConstants.STATUS_OK);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(NumberConstants.STATUS_ERROR);
            resp.setMsg(MsgConstants.SYSTEM_ERROR);
        }
        return resp;
    }
}