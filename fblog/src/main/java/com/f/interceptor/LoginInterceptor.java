package com.f.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.f.pojo.User;

public class LoginInterceptor implements HandlerInterceptor{

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception arg3) throws Exception {
        System.out.println("--3.完成后处理");
       
        
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        System.out.println("--2.后处理");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("--1.预处理");
       //获取请求的url
        String url = request.getRequestURI();
        //除了login.jsp.......可以公开访问，其他的URL都进行拦截/blogshow.do
        if(url.indexOf("/blogshow.do") >0 ||url.indexOf("/login.do") >0 || url.indexOf("/register.do")>0 ||url.indexOf("/index.do")>0 ||url.indexOf("/logout.do")>0) {
            return true;
        }
        //获取session
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("USER_SESSION");
        //判断session中是否有用户数据，有返回true
        if(user !=null) {
           return true;
        }
        //不符合条件的给出提示信息，并转发到login.jsp
        request.setAttribute("msg","你还没有登录，请先登录");
        request.getRequestDispatcher("/login.do").forward(request, response);;
        return false;
    }
    
}
