package com.web.servlet.department;

import com.pojo.BuMen;
import com.service.BuMenService;
import com.service.Impl.BuMenServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/BuMenUpdateServlet")
public class BuMenUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Map<String, String[]> parameterMap = request.getParameterMap();
        BuMen buMen=new BuMen();
        try{
            BeanUtils.populate(buMen,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        BuMenService service=new BuMenServiceImpl();
        boolean update = service.update(buMen);
        if (update){
            response.sendRedirect(request.getContextPath()+"/view/department/departmentQuery.jsp");
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
