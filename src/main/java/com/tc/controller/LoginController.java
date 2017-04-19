package com.tc.controller;

import com.tc.constants.FieldConstants;
import com.tc.constants.MsgConstants;
import com.tc.constants.UrlConstants;
import com.tc.entity.User;
import com.tc.service.UserService;
import com.tc.utils.ChkUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by htc on 2017/4/19.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 登陆
     * @param request
     * @param response
     * @param session
     * @param userParam
     * @return
     */
    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, HttpSession session,User userParam){
        try {
            //判断参数
            if (userParam==null || ChkUtil.isEmpty(userParam.getAccount()) ||ChkUtil.isEmpty(userParam.getPwd())){
                return new ModelAndView(UrlConstants.LOGIN, FieldConstants.ERR, MsgConstants.LESS_PARAM);
            }

            //验证账号
            int i=userService.getUserNum(userParam);
            if(i==0){
                return new ModelAndView(UrlConstants.LOGIN,FieldConstants.ERR,MsgConstants.ACCOUNT_NOT_EXIST);
            }
            String password=ChkUtil.MD5(userParam.getPwd());
            userParam.setPwd(password);

            //验证密码
            User user=userService.getUserInfoByAccount(userParam);
            if(user==null){
                return new ModelAndView(UrlConstants.LOGIN,FieldConstants.ERR,MsgConstants.PASSWORD_ERROR);
            }
            //放入session
            session.setAttribute(FieldConstants.ONLINE_USER,user);

            ServletContext application=session.getServletContext();
            application.setAttribute(FieldConstants.NEW_SESSION_ID,session.getId());
            application.setAttribute(FieldConstants.SESSION_ID,session.getId());
            application.setAttribute(session.getId(),session);

            //返回主页面
            return new ModelAndView(UrlConstants.REDIRECT_STUDENT_INDEX_JSP);
        } catch (Exception e) {
            e.printStackTrace();

            return new ModelAndView(UrlConstants.LOGIN,FieldConstants.ERR,MsgConstants.LOGIN_FAIL);
        }
    }

    /**
     * 退出登陆
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping("exit")
    public ModelAndView exit(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        try {
            session.invalidate();
            return new ModelAndView(UrlConstants.REDIRECT_LOGIN_JSP);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView(UrlConstants.LOGIN,FieldConstants.ERR,MsgConstants.EXIT_FAIL);
        }
    }

}
