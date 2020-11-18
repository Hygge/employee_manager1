<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>部门管理</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script src="js/jquery-1.9.1.min.js"></script>  
<script src="assets/js/bootstrap.min.js"></script>

  </head>
  
  <body>
    <form    class="form-inline" action="EmployeeServlet/byConditionQuery" method="post">
	<div class="row alert alert-info" style="margin:0px; padding:0px; padding-left:50px;">
    	<div class="form-group">
        	<label>员工编号</label>
            <input type="text" class="form-control" name="yid" placeholder="请输入员工编号">
            <label>员工姓名</label>
            <input type="text" class="form-control" name="yname" placeholder="请输入员工姓名">
            <label>员工帐号</label>
            <input type="text" class="form-control" name="yzhanghao" placeholder="请输入员工帐号">
        </div>
        <input type="submit" class="btn btn-danger" value="查询">
    	<a href="view/employee/employeeAdd.jsp" class="btn btn-success">添加员工</a>
    </div>
	<div class="row"  style="padding:15px;">
    	<table class="table" >
        	<tr>
            	<th>员工编号</th>
            	<th>员工姓名</th>
                <th>员工性别</th>
                <th>部门名称</th>
                <th>员工年龄</th>
                <th>电话号码</th>
                <th>员工帐号</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${sessionScope.employees}" var="emps" >

            <tr>
            	<td>${emps.id}</td>
                <td><a href="EmployeeServlet/queryInfo?id=${emps.id}">${emps.yName} </a></td>
                <td>${emps.ySex}</td>
                        <c:forEach items="${sessionScope.buMen}" var="bumen">
        <%--                    判断员工中部门id和部门id相等--%>
                                <c:if test="${bumen.id == emps.bId}">
                                    <td>${bumen.bName}</td>
                                </c:if>
                        </c:forEach>
                <td>${emps.yAge}</td>
                <td>${emps.yTelephone}</td>
                 <td>${emps.yZhanghao}</td>
            	<td>
                	<a href="${pageContext.request.getContextPath()}/EmployeeServlet/updateInfo?id=${emps.id}">修改</a>
                    <a href="EmployeeServlet/delete?id=${emps.id}">删除</a>
                </td>	
            </tr>
            </c:forEach>
        </table>
    
    </div>
</form>
  </body>
</html>
