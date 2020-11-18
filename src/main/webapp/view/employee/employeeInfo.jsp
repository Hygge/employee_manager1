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
    <form  class="form-horizontal">
		<h5 class="page-header alert-info" style="margin:0px; padding:10px; margin-bottom:10px;">
        基本信息
        </h5>
        
        <!-- 111 -->
        <div class="row">
        	<div class="col-sm-5"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">员工姓名</label>
                	<div  class="col-sm-9">
                    	<p class="form-control-static">${sessionScope.emps.yName}</p>
                   
                    </div>
                </div>
            </div>
        	<div class="col-sm-5"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">员工年龄</label>
                	<div  class="col-sm-9">
                    		<p class="form-control-static">${sessionScope.emps.yAge}</p>
                    
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-5">
                <div class="form-group">
                    <label class="col-sm-3 control-label">电话号码</label>
                    <div  class="col-sm-9">
                        <p class="form-control-static">${sessionScope.emps.yTelephone}</p>


                    </div>
                </div>
            </div>
        	<div class="col-sm-5"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">员工性别</label>
                	<div  class="col-sm-3">
                   <p class="form-control-static">男</p>
                    </div>
                </div>
            </div>
        </div>
       <!-- 3333 -->
       	<h5 class="page-header alert-info" style="margin:0px; padding:10px; margin-bottom:10px;">
        账户信息
        </h5>
                <!-- 222 -->
        <div class="row">
        	<div class="col-sm-5"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">员工帐号</label>
                	<div  class="col-sm-9">
               <p class="form-control-static">${sessionScope.emps.yZhanghao}</p>
                    </div>
                </div>
            </div>
        	<div class="col-sm-5"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">员工密码</label>
                	<div  class="col-sm-9">
                    	  <p class="form-control-static">${sessionScope.emps.yPassword}</p>
                    
                    </div>
                </div>
            </div>
        </div>
       <!-- 2222 -->
        
        <div class="row">
        	<div class="col-sm-3 col-sm-offset-4">
            	<a href="${pageContext.request.contextPath}/view/employee/employeeQuery.jsp" class="btn btn-warning">返回上一级</a>
            </div>
        </div>
  

</form>

  </body>
</html>
