package com.tc.controller;

import com.tc.entity.ExamPlan;
import com.tc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by htc on 2017/4/21.
 */
@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("getExamBe")
    @ResponseBody
    public List<ExamPlan> getExamBe(HttpServletRequest req, HttpServletResponse resp ) {

        List<ExamPlan> s=studentService.getExamBe(1310400114);
        if(s.size()==0){
            System.out.println("null");
        }else {
            System.out.println("get data");
        }
        return null;
    }
}
