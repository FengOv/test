package com.ftt.test.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private HttpSession session;

    //Controller 逻辑执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("start with preHandle ..................");
        String requestURI = request.getRequestURI();
        log.info("当前路径:===>"+requestURI);
        /*
         *
         */
        if(!(handler instanceof HandlerMethod)){
            return Boolean.TRUE;
        }
        if(session.getAttribute("username") == null){
            //未登录
            log.info("end preHandle ..................");
            throw new RuntimeException("还没有登录，不可访问！");
        }else{
            log.info("end preHandle ..................");
            return Boolean.TRUE;
        }
    }

    //Controller 逻辑执行完毕但是视图解析器还未进行解析之前

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info(" start postHandle .........");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info(" after completion ..........");
    }
}
