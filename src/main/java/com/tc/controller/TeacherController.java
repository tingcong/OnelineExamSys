package com.tc.controller;

import com.tc.constants.MsgConstants;
import com.tc.constants.NumberConstants;
import com.tc.entity.Resp;
import com.tc.entity.Teacher;
import com.tc.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by htc on 2017/5/16.
 */
@Controller
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("getTeacherInfoForSelect")
    @ResponseBody
    public Resp getTeacherInfoForSelect(HttpServletRequest request, HttpServletResponse response){
        Resp resp=new Resp();

        try {
            List<Teacher> teacherList=teacherService.getTeacherInfoForSelect();
            if(teacherList.size()==0){
                teacherList=new ArrayList<Teacher>();
            }
            resp.setStatus(NumberConstants.STATUS_OK);
            resp.setData(teacherList);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(NumberConstants.STATUS_ERROR);
            resp.setMsg(MsgConstants.SYSTEM_ERROR);
        }
        return resp;
    }
}
