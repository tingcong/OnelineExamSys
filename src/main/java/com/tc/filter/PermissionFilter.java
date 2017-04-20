package com.tc.filter;

import com.tc.constants.FieldConstants;
import com.tc.constants.OtherConstants;
import com.tc.constants.UrlConstants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by htc on 2017/4/20.
 */
public class PermissionFilter implements Filter {
    ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        servletContext=filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //得到请求路径
        HttpServletRequest req= (HttpServletRequest) request;
        String uri=req.getRequestURI();

//        System.out.println(uri);

        //判断路径是否是登陆请求 或者 非页面或方法的请求      indexOf 方法返回一个整数值，指出 String 对象内子字符串的开始位置。如果没有找到子字符串，则返回-1。
        if(uri.contains(UrlConstants.LOGIN_JSP) || uri.contains(UrlConstants.LOGIN_REQ) || (uri.indexOf(UrlConstants.POINT_JSP)==-1 && uri.indexOf(UrlConstants.POINT_HTM)==-1)){
            chain.doFilter(request,response);
            return;
        }

        HttpServletResponse resp= (HttpServletResponse) response;
        resp.setHeader(OtherConstants.CONTENT_TYPE,OtherConstants.CONTENT_TYPE_SET);
        resp.setCharacterEncoding(OtherConstants.UTF_8);

        HttpSession session=req.getSession();
        //已经登陆，session未过期
        if(session.getAttribute(FieldConstants.ONLINE_USER)!=null){
            chain.doFilter(request,response);
            return;
        }

        if(uri.equals("/"+UrlConstants.PROJECT_NAME) || uri.equals("/"+UrlConstants.PROJECT_NAME+"/") || uri.equals("/"+UrlConstants.PROJECT_NAME+"/"+UrlConstants.INDEX_JSP)){
            resp.sendRedirect("/"+UrlConstants.PROJECT_NAME+"/"+UrlConstants.LOGIN_JSP);
            return;
        }

        //跳转登陆页面
        resp.sendRedirect("/"+UrlConstants.PROJECT_NAME+"/"+UrlConstants.LOGIN_JSP);

    }

    @Override
    public void destroy() {

    }
}
