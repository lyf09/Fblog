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
        System.out.println("--3.��ɺ���");
       
        
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        System.out.println("--2.����");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("--1.Ԥ����");
       //��ȡ�����url
        String url = request.getRequestURI();
        //����login.jsp.......���Թ������ʣ�������URL����������/blogshow.do
        if(url.indexOf("/blogshow.do") >0 ||url.indexOf("/login.do") >0 || url.indexOf("/register.do")>0 ||url.indexOf("/index.do")>0 ||url.indexOf("/logout.do")>0) {
            return true;
        }
        //��ȡsession
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("USER_SESSION");
        //�ж�session���Ƿ����û����ݣ��з���true
        if(user !=null) {
           return true;
        }
        //�����������ĸ�����ʾ��Ϣ����ת����login.jsp
        request.setAttribute("msg","�㻹û�е�¼�����ȵ�¼");
        request.getRequestDispatcher("/login.do").forward(request, response);;
        return false;
    }
    
}
