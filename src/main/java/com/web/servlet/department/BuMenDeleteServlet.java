package com.web.servlet.department;

import com.service.EmployeeService;
import com.service.Impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BuMenDeleteServlet")
public class BuMenDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        EmployeeService employeeService=new EmployeeServiceImpl();
        boolean b = employeeService.deleteEmployee(Integer.parseInt(id));
        if (b){
            response.sendRedirect(request.getContextPath()+"/view/department/departmentQuery.jsp");
        }else {
            request.getRequestDispatcher("/view/department/departmentQuery.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
