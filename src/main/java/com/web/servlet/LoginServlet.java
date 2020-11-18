package com.web.servlet;

import com.pojo.Employee;
import com.service.EmployeeService;
import com.service.Impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        EmployeeService employeeService=new EmployeeServiceImpl();
        HttpSession session = request.getSession();

        //获取填写的账户密码
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username+password);
        Employee employee=employeeService.login(username,password);
        if ( employee != null){
            //登录成功
//            将员工存入session
            session.setAttribute("yname",employee.getyName());
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
//            登录失败
              request.setAttribute("login_msg","用户名或密码错误！");
              request.getRequestDispatcher("login.jsp").forward(request,response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
