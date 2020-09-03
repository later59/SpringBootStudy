package com.rock.comment;

import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截器，登录检查
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     */
    /*@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        if (ObjectUtils.isEmpty(request.getSession().getAttribute("loginName"))) {
            //未登录
            request.setAttribute("msg","没有权限，请登录");
            request.getRequestDispatcher("index.html").forward(request,response);
            return false;
        } else {
            //已登录
            return true;
        }
    }*/
}
