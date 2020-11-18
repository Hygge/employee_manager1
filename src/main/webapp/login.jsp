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
<title>用户登录</title>
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<script src="js/jquery-1.9.1.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	background: url(images/bg.jpg);
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover; /*让背景基于容器*/
	background-attachment: fixed; /*当内容高度大雨图片高度，背景图像的位置相对viewport固定*/
	margin-left: auto;
	margin-right: auto;
	margin-top: 200px;
	width: 20em;
}
</style>

</head>

<body>
	<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
	<div class="form-group">
    	<label class="sr-only" for="userId">帐号</label>
        <div class="input-group">
        	<div class="input-group-addon">帐号</div>
        	<input type="text" class="form-control" id="userId" name="username" placeholder="请输入帐号"/>
         </div>
    </div>
	<div class="form-group">
    	<label class="sr-only" for="userId">密码</label>
        <div class="input-group">
        	<div class="input-group-addon">密码</div>
        	<input type="password" class="form-control" id="userId" name="password" placeholder="请输入密码"/>
         </div>
    </div>
		<!-- 出错显示的信息框 -->
		<div class="alert alert-warning alert-dismissible" role="alert">
			<strong>${login_msg}</strong>
		</div>
		<!-- 按钮-->
		<input type="submit" style="width:280px;" value="登 录" class="btn btn-success"/>
	</form>

</body>
</html>
