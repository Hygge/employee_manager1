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


	<form class="form-inline" action="${pageContext.request.getContextPath()}/BuMenByNameServlet" method="post">
		<div class="row alert alert-info" style="margin:0px; padding:0px; padding-left:50px;">
			<div class="form-group">
				<label>部门名称</label> <input type="text" class="form-control" name="bumenName"
					placeholder="请输入部门名称">

			</div>
			<input type="submit" class="btn btn-danger" value="查询"> <a
				href="view/department/departmentAdd.jsp" class="btn btn-success">添加部门信息</a>
		</div>
		<div class="row" style="padding:15px;">
			<table class="table">
				<tr>
					<th>部门编号</th>
					<th>部门名称</th>
					<th>部门描述</th>
					<th>操作</th>
				</tr>
				<C:forEach items="${sessionScope.buMen}" var="buMens" >
					<tr>
					<td nam="id">${buMens.id}</td>
					<td><a href="${pageContext.request.getContextPath()}/BuMenByIdsServlet?id=${buMens.id}">${buMens.bName}</a></td>
					<td>${buMens.bMiaoShu}</td>
					<td><a href="${pageContext.request.getContextPath()}/BuMenUpateidServlet?id=${buMens.id}">修改</a> <a href="BuMenDeleteServlet?id=${buMens.id}">删除</a>
					</td>
				</tr>
				</C:forEach>

			</table>

		</div>
	</form>



</body>
</html>
