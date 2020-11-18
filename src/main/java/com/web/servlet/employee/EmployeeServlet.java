package com.web.servlet.employee;



import com.pojo.Employee;
import com.service.EmployeeService;
import com.service.Impl.EmployeeServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/EmployeeServlet/*")
public class EmployeeServlet extends BaseServlet {

    EmployeeService employeeService=new EmployeeServiceImpl();

    public void queryInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        System.out.println(id);
        List<Employee> queryId = employeeService.queryId(Integer.parseInt(id));
        request.getSession().setAttribute("emps",queryId);
        request.getRequestDispatcher("/view/employee/employeeInfo.jsp").forward(request,response);
    }
    public void updateInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        List<Employee> queryId = employeeService.queryId(Integer.parseInt(id));
        request.getSession().setAttribute("emps",queryId);
        request.getRequestDispatcher("/view/employee/employeeUpdate.jsp").forward(request,response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Employee employee=new Employee();

        try{
            BeanUtils.populate(employee,parameterMap);
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        boolean b = employeeService.updateEmployee(employee);
        if (b){
            response.sendRedirect(request.getContextPath()+"/view/employee/employeeQuery.jsp");
        }else {
            request.getRequestDispatcher("/view/employee/employeeQuery.jsp");
        }
    }

    public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        boolean b = employeeService.deleteEmployee(Integer.parseInt(id));
        if (b){
            response.sendRedirect(request.getContextPath()+"/view/employee/employeeQuery.jsp");
        }else {
            request.getRequestDispatcher("/view/employee/employeeQuery.jsp").forward(request,response);
        }
    }
    public void add(HttpServletRequest request,HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Employee employee = new Employee();

        BeanUtils.populate(employee,parameterMap);

        boolean saven = employeeService.saven(employee);

        System.out.println(employee.toString());
        if (saven){
            response.sendRedirect(request.getContextPath()+"/view/employee/employeeQuery.jsp");
        }else {
            request.getRequestDispatcher("/view/employee/employeeQuery.jsp");
        }

    }
    public void byConditionQuery(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String yname = request.getParameter("yname");
        String yzhanghao = request.getParameter("yzhanghao");
        int id=0;
        try{
            String yid=request.getParameter("yid");
            if (yid != null){
                id=Integer.parseInt(yid);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(yzhanghao);
        EmployeeService service=new EmployeeServiceImpl();

        HttpSession session=request.getSession();
        if (id != 0){
            List<Employee>  queryId= service.queryId(id);
            System.out.println(id);
            session.setAttribute("employees",queryId);

        }else if (yname != null){
            List<Employee> queryName = service.queryName(yname);
            session.setAttribute("employees",queryName);
            System.out.println(yname);

        }else if (yzhanghao != null){
            List<Employee> queryZhanghao = service.queryZhanghao(yzhanghao);
            session.setAttribute("employees",queryZhanghao);
            System.out.println(yzhanghao);

        }

        request.getRequestDispatcher("/view/employee/employeeQuery.jsp").forward(request,response);

    }

}
