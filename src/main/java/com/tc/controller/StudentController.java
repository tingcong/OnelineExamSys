package com.tc.controller;

import com.tc.entity.ExamPlan;
import com.tc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView getExamBe(HttpServletRequest req, HttpServletResponse resp ) {
        ModelAndView modelAndView=new ModelAndView();
        List<ExamPlan> examBeList=studentService.getExamBe(1310400114);
        if(examBeList.size()==0){
            System.out.println("null");
        }else {
            System.out.println("get data");
        }
        modelAndView.addObject("examBeList",examBeList);
        return modelAndView;
    }
}
