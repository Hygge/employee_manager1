<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
	<form class="form-horizontal">
		<input type="hidden" name="B"  value="show">
	<h5 class="page-header alert-info" style="margin:0px; padding:10px; margin-bottom:10px;">
        基本信息
        </h5>
        <div class="row">
        	<div class="col-sm-7">
            	<div class="form-group">
                	<label class="col-sm-3 control-label">部门名称</label>
                	<div  class="col-sm-9">
                    	<p class="form-control-static">${sessionScope.buMen.bname}</p>
                    </div>
                </div>
            </div>
        	<div class="col-sm-7">
            	<div class="form-group">
                	<label class="col-sm-3 control-label">部门描述</label>
                	<div  class="col-sm-9">
                       	<p class="form-control-static">${sessionScope.buMen.bMiaoShu}</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
        	<div class="col-sm-3 col-sm-offset-3">
            	<a href="${pageContext.request.getContextPath()}/departmentQueryServlet" class="btn btn-warning">返回上一级</a>
            </div>
        </div>

</form>
  </body>
</html>
