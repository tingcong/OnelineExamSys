package com.tc.controller;

import com.tc.constants.MsgConstants;
import com.tc.constants.NumberConstants;
import com.tc.entity.Resp;
import com.tc.entity.Teacher;
import com.tc.service.TeacherService;
import com.tc.utils.XMLUtil;
import net.sf.json.JSONObject;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

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
    public Resp getTeacherInfoForSelect(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

    @RequestMapping("addQuestion")
    @ResponseBody
    public Resp addQuestion(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //response.setCharacterEncoding("utf-8");
        //response.setContentType("text/html;charset=utf-8");
        String param="";
        Resp resp=new Resp();
        Enumeration enumeration=request.getParameterNames();
        while(enumeration.hasMoreElements()){
            param=(String)enumeration.nextElement();
        }
        Map map= JSONObject.fromObject(param);
        String projectRealPath=request.getSession().getServletContext().getRealPath("");
        String projectRootRealPath=projectRealPath.substring(0,projectRealPath.indexOf("target"));
        System.out.println(map.get("answer").toString());
        /*文件路径*/
        String filePath=projectRootRealPath+"\\src\\main\\webapp\\file\\questionLibrary\\"+map.get("subject")+"\\"+map.get("questionType")+"-"+map.get("level")+".xml";
        try {
            XMLUtil.updatePaper(filePath,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.setStatus(NumberConstants.STATUS_OK);
        return resp;
    }
//    C:\Users\TingCong\IdeaProjects\OnelineExamSys\src\main\webapp\file\questionLibrary\1\1-c.xml
}
