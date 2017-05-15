package com.tc.controller;

import com.tc.constants.MsgConstants;
import com.tc.constants.NumberConstants;
import com.tc.entity.Course;
import com.tc.entity.Resp;
import com.tc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by htc on 2017/5/15.
 */
@Controller
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 获取所有课程名称放入下拉列表
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("getCourseInfoForSelect")
    @ResponseBody
    public Resp getCourseInfoForSelect(HttpServletRequest request, HttpServletResponse response) {
        Resp resp = new Resp();
        try {
            //获取数据
            List<Course> courseList = courseService.getCourseInfoForSelect();
            //判断数据是否为空
            if (courseList.size() == 0) {
                courseList = new ArrayList<Course>();
            }
            //结果不为空
            resp.setStatus(NumberConstants.STATUS_OK);
            resp.setData(courseList);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(NumberConstants.STATUS_ERROR);
            resp.setMsg(MsgConstants.SYSTEM_ERROR);
        }
        return resp;
    }
}
