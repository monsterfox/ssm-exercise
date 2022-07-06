package com.foxbill.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Servlet优化：
 *   重点：
 *      1.重写HttpServlet中的service()方法，修改请求的分发机制。
 *      2.反射
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求路径
        String uri = request.getRequestURI();
        //2.获取最后一段路径，方法名
        int index = uri.lastIndexOf("/");
        String methodName = uri.substring(index + 1);
        System.out.println(methodName);

        //3.执行方法
        //3.1 获取XxxxServlet的字节码对象 class
        //谁调用我（this所在的方法），我（this）代表谁
        System.out.println(this);
        Class<? extends BaseServlet> cls = this.getClass();
        //3.2 获取方法对象 Method
        try {
            Method method = cls.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            //3.3 执行方法
            method.invoke(this,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
