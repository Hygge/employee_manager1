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
    <form  class="form-horizontal" action="${pageContext.request.contextPath}/BuMenUpdateServlet" method="post">
		<h5 class="page-header alert-info" style="margin:0px; padding:10px; margin-bottom:10px;">
        基本信息
        </h5>
        <div class="row">
        	<div class="col-sm-7"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">部门名称</label>
                	<div  class="col-sm-9">
                    	<input type="text" class="form-control" name="bname" placeholder="${sessionScope.buMens.bName}"/>
                    </div>
                </div>
            </div>
        	<div class="col-sm-7"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">部门描述</label>
                	<div  class="col-sm-9">
                    	<textarea  class="form-control" rows="5" name="bmiaoshu" placeholder="${sessionScope.buMens.bMiaoShu}" ></textarea>
                    
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
        	<div class="col-sm-3 col-sm-offset-3">
            	<input type="submit" class="btn btn-success" value="修改部门">
                <input type="reset" class="btn  btn-danger" value="重置信息">
            </div>
        </div>
  

</form>
  </body>
</html>
