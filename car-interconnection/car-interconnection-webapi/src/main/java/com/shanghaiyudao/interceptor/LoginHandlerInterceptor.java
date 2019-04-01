package com.shanghaiyudao.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Object loginUser = request.getSession().getAttribute("loginUser");
//        if (loginUser!=null){
//            //用户已经登陆,放行
//            return true;
//        }
//        //用户未登录转发到登陆页面
//        request.setAttribute("msg","没有权限，请登陆！");
//        request.getRequestDispatcher("/index.html").forward(request,response);
//        return false;
//    }
}
