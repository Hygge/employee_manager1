package com.web.servlet.department;

import com.pojo.BuMen;
import com.service.BuMenService;
import com.service.Impl.BuMenServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/BuMenByNameServlet")
public class BuMenByNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        BuMenService service=new BuMenServiceImpl();
        String bumenName = request.getParameter("bumenName");
        List<BuMen> query = service.query(bumenName);
        HttpSession session=request.getSession();
        session.setAttribute("buMen",query);
        request.getRequestDispatcher("/view/department/departmentQuery.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
