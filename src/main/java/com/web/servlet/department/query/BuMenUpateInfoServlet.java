package com.web.servlet.department.query;

import com.pojo.BuMen;
import com.service.BuMenService;
import com.service.Impl.BuMenServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BuMenUpateidServlet")
public class BuMenUpateInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println(id);
        BuMenService service1=new BuMenServiceImpl();
        BuMen queryid = service1.queryid(Integer.parseInt(id));
        request.getSession().setAttribute("buMens",queryid);

        request.getRequestDispatcher("/view/department/departmentUpdate.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
