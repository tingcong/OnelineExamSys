package com.tc.listener;

import com.tc.constants.FieldConstants;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by htc on 2017/4/19.
 */
public class OnlineUserListen implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session=se.getSession();
        ServletContext application=session.getServletContext();
        if(application.getAttribute(FieldConstants.NEW_SESSION_ID)==null){
            application.setAttribute(FieldConstants.NEW_SESSION_ID,session.getId());
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session=se.getSession();
        ServletContext application=session.getServletContext();
        application.removeAttribute(FieldConstants.NEW_SESSION_ID);
    }
}
