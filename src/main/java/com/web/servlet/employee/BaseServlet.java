package com.web.servlet.employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //完成方法的分发
        String uri=req.getRequestURI();
        String methodName=uri.substring(uri.lastIndexOf("/")+1);

//        通过反射获取方法对象
        try{
            Method method=this.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
//            执行此方法
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
