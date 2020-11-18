package com.web.servlet.department;

import com.pojo.BuMen;
import com.service.BuMenService;
import com.service.Impl.BuMenServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/departmentQueryServlet")
public class DepartmentQueryServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("我进来了");

        BuMenService buMenService=new BuMenServiceImpl();
        List<BuMen> buMen = buMenService.queryAll();
        request.setAttribute("buMen",buMen);
        System.out.println("跳转");
        request.getRequestDispatcher("/view/department/departmentQuery.jsp").forward(request,response);


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
