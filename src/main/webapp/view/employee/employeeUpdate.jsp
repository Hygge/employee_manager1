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
   <form  class="form-horizontal" action="EmployeeServlet/update" method="post">
		<h5 class="page-header alert-info" style="margin:0px; padding:10px; margin-bottom:10px;">
        基本信息
        </h5>
        
        <!-- 111 -->
        <div class="row">
        	<div class="col-sm-5"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">员工姓名</label>
                	<div  class="col-sm-9">
                    	<input type="text" class="form-control" name="yName" placeholder="${sessionScope.emps.yName}"/>
                    </div>
                </div>
            </div>
        	<div class="col-sm-5"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">员工年龄</label>
                	<div  class="col-sm-9">
                    	<input type="text" class="form-control" name="yAge" placeholder="${sessionScope.emps.yAge}"/>
                    
                    </div>
                </div>
            </div>
        </div>
       <!-- 111 -->
        <!-- 222 -->
        <div class="row">
        	<div class="col-sm-5"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">电话号码</label>
                	<div  class="col-sm-9">
                    	<input type="text" class="form-control" name="yTelephone" placeholder="${sessionScope.emps.yTelephone}"/>
                    
                    </div>
                </div>
            </div>
        	<div class="col-sm-5"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">员工性别</label>
                	<div  class="col-sm-3">
                    	<select class="form-control" name="ySex">
                        	<option>保密</option>
                        	<option>男</option>
                            <option>女</option>
                        </select>
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
                    	<input type="text" class="form-control" name="yZhanghao" placeholder="${sessionScope.emps.yZhanghao}"/>
                    </div>
                </div>
            </div>
        	<div class="col-sm-5"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">员工密码</label>
                	<div  class="col-sm-9">
                    	<input type="text" class="form-control" name="yPassword" placeholder="请输入员工密码"/>
                    
                    </div>
                </div>
            </div>
        </div>
       <!-- 2222 -->
        
        <div class="row">
        	<div class="col-sm-3 col-sm-offset-4">
            	<input type="submit" class="btn btn-success" value="修改员工">
                <input type="reset" class="btn  btn-danger" value="重置信息">
            </div>
        </div>
  

</form>
  </body>
</html>
