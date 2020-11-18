package com.web.servlet.employee;

import com.pojo.BuMen;
import com.pojo.Employee;
import com.service.BuMenService;
import com.service.EmployeeService;
import com.service.Impl.BuMenServiceImpl;
import com.service.Impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/EmployeeQueryServlet")
public class EmployeeQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("1跳转");
        request.setCharacterEncoding("utf-8");
        EmployeeService employeeService=new EmployeeServiceImpl();
        BuMenService buMenService=new BuMenServiceImpl();
        List<BuMen> buMens = buMenService.queryAll();
        List<Employee> employees = employeeService.queryAll();
        HttpSession session=request.getSession();

        session.setAttribute("buMen",buMens);
        session.setAttribute("employees",employees);
        System.out.println("跳转");
        request.getRequestDispatcher("/view/employee/employeeQuery.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
