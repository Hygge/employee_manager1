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

@WebServlet("/BuMenByIdsServlet")
public class BuMenByInfosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuMenService buMenService=new BuMenServiceImpl();
        String id = request.getParameter("id");
        System.out.println(id);
        BuMen queryid = buMenService.queryid(Integer.parseInt(id));
        request.getSession().setAttribute("buMen",queryid);
        System.out.println(queryid.toString());

        request.getRequestDispatcher("/view/department/departmentInfo.jsp").forward(request,response);
    }
}
