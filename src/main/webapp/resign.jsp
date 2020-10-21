<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"type="text/css"href="css/login01.css" />
		<link rel="stylesheet"type="text/css"href="css/bootstrap.min.css" />
	</head>
	<body>
		<div class="container-fluid header">
			<h1>权限管理系统</h1>
		</div>
		<div class="middle">
			<h2 align="center"class="h">欢迎注册权限管理系统</h2>
			<form action="${pageContext.request.contextPath }/registerServlet" method="post">
				<div class="login-ic">
					<label class="label">&nbsp;用&nbsp;户&nbsp;名&nbsp;:</label>
		           <input type="text"name="user_name" placeholder="用户名" class="login-ic" /><br />
				 </div>
		        <div class="login-ic">
					<label class="label">&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码&nbsp;&nbsp;:</label>
		           <input type="password"name="user_password" placeholder="密码" class="login-ic"/>
		        </div>
				<div class="login-ic">
					<label class="label">&nbsp;&nbsp;性&nbsp;&nbsp;&nbsp;别&nbsp;&nbsp;:</label>
				   <input type="text"name="user_sex" placeholder="性别" class="login-ic"/>				</div>
				<div class="login-ic">
					<label class="label">&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;领&nbsp;&nbsp;:</label>
				   <input type="text"name="user_age" placeholder="年龄" class="login-ic"/>
				</div>
				<!-- <div class="log-bwn">
				<input type="button"value="登录" />
				</div> -->
				<br />
				<div class="log-bwn">
				<input type="submit"value="注册" />
				</div>
				
		</form>
		</div>
		<div class="container-fluid loginbm">
			<div class="row company">
			            版权所有，仅供学习 2020
			 </div>
		</div>
		
	</body>
</html>