package com.tc.controller;

import com.tc.constants.FieldConstants;
import com.tc.constants.MsgConstants;
import com.tc.constants.NumberConstants;
import com.tc.entity.Resp;
import com.tc.entity.User;
import com.tc.service.UserService;
import com.tc.utils.ChkUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by htc on 2017/4/18.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 验证密码
     * @param request
     * @param response
     * @param userParam
     * @return
     */

    @RequestMapping("checkUserPwd")
    @ResponseBody
    public Resp checkUserPwd(HttpServletRequest request, HttpServletResponse response,User userParam){
        System.out.println(userParam.getAccount()+":"+userParam.getPwd());
       Resp resp=new Resp();
        try {
            //非空验证
            if(ChkUtil.isEmpty(userParam.getPwd())){
                resp.setData(NumberConstants.STATUS_ERROR);
                resp.setMsg(MsgConstants.LESS_PARAM);
                return resp;
            }
            User onlineUser= (User) request.getSession().getAttribute(FieldConstants.ONLINE_USER);
            userParam.setAccount(onlineUser.getAccount());
            userParam.setPwd(ChkUtil.MD5(userParam.getPwd()));
            User user=userService.getUserInfoByAccount(userParam);
            if(user==null){
                resp.setStatus(NumberConstants.STATUS_ERROR);
                resp.setMsg(MsgConstants.PASSWORD_ERROR);
                return resp;
            }
            resp.setStatus(NumberConstants.STATUS_OK);
            resp.setMsg(MsgConstants.PASSWORD_OK);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(NumberConstants.STATUS_ERROR);
            resp.setMsg(MsgConstants.SYSTEM_ERROR);
        }
        return resp;
    }


}
