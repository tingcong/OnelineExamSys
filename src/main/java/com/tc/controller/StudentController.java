package com.tc.controller;

import com.sun.deploy.net.HttpResponse;
import com.tc.constants.FieldConstants;
import com.tc.constants.MsgConstants;
import com.tc.constants.NumberConstants;
import com.tc.entity.ExamPlan;
import com.tc.entity.Resp;
import com.tc.entity.User;
import com.tc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by htc on 2017/4/21.
 */
@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 即将进行的考试
     *
     * @param request
     * @param response
     * @param session
     * @return 考试信息
     */
    @RequestMapping("getExamBe")
    @ResponseBody
    public Resp getExamBe(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Resp resp = new Resp();
        try {
            String account = ((User) session.getAttribute(FieldConstants.ONLINE_USER)).getAccount();
            List<ExamPlan> examBeList = studentService.getExamBe(Integer.parseInt(account));
            if (examBeList.size() == 0) {
                examBeList = new ArrayList<ExamPlan>();
            }
            resp.setData(examBeList);
            resp.setStatus(NumberConstants.STATUS_OK);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(NumberConstants.STATUS_ERROR);
            resp.setMsg(MsgConstants.SYSTEM_ERROR);
        }
        return resp;
    }

    @RequestMapping("getExamIng")
    @ResponseBody
    public Resp getExamIng(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Resp resp = new Resp();
        String account = ((User) session.getAttribute(FieldConstants.ONLINE_USER)).getAccount();
        List<ExamPlan> examPlanList=studentService.getExamIng(Integer.parseInt(account));
        resp.setData(examPlanList);
        return resp;
    }
}
