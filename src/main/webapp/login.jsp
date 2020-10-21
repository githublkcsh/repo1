<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>权限管理系统</title>
		<link rel="stylesheet"type="text/css"href="css/login01.css" />
		<link rel="stylesheet"type="text/css"href="css/bootstrap.min.css" />
	    <script src="js/jquery-3.3.1.js"></script>
	    <script src="http://code.jquery.com/jquery-2.1.0.js"></script>
	    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	    <script type="text/javascript">
	       $(function()
	       {
	    	   //1.给登录按钮绑定单机事件
	    	   $("#btn_sub").click(function(){
	    		   $.post("loginServlet",$("#loginForm").serialize(),function(data){
	    			   if(data.flag){
	    				   //登陆成功
	    				   location.href="index.html";
	    				   
	    			   }else{
	    				   //登录失败
	    				   $("#errorMsg").html(data.errorMsg);
	    			   }
	    		   });
	    	   });
	       });
	       function  method02() {
	            //页面跳转，相对于地址栏里的内容改变   可以实现回退
	            window.location.href='zhuce.html';

	        }
	    
	    </script>
	    
	</head>
	<body>
		<div class="container-fluid header">
			<h1>权限管理系统</h1>
		</div>
		<div class="middle">
			<h1 align="center" class="h">欢迎登录权限系统</h1>
			<form  id="loginForm" action="${pageContext.request.contextPath }/userHandler/login.do" method="post"accept-charset="utf-8">
				<div class="login-ic">
					<label class="label">用户名:</label>
		           <input type="text"name="user_name" placeholder="用户名" class="login-ic" color="white"/><br />
				 </div>
		        <div class="login-ic">
					<label class="label">密&nbsp;&nbsp;&nbsp;码:</label>
		           <input type="password"name="user_password" placeholder="密码" class="login-ic"/>
		        </div>
				<div class="log-bwn">
			
				<input type="submit" class="log-bwn"value="登录">
				</div>
				<br />
				
				<a href="${pageContext.request.contextPath}/resign.jsp">还没有账号，前往注册</a>
				
		</form>
		</div>
		<div class="container-fluid loginbm">
			<div class="row company">
			            版权所有，仅供学习 2020
			 </div>
		</div>
		
	</body>
</html>
