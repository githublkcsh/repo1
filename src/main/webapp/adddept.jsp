<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
			.login-ic {
			background: rgba(82,82,82,0); 
	        margin-bottom:1em;
            padding: 8px;
	        size: 40px;
	        border-bottom: #000000;
		}
		.middle{
	    position: absolute;
		top: 200px;
		width: 400px;
		height: 450px;
		left: 40%;
		margin: 0;
		padding: 0px;
		/* border-style: double;
		border-color: #FF0000; */
	
}
.log-bwn input{
    font-size: 15px;
    font-weight: 700;
    color: #fff;
    padding: 13px 0;
    background: #ff5566;
    display: inline-block;
    width: 100%;
	outline:none;
	border:2px solid #333366;
	cursor:pointer;
	text-transform:uppercase;}
 .body{
  font-family: 'Montserrat', sans-serif;
   font-size: 100%;

   background-size: cover;
}
.label{
	font-size: 20px;}
			
</style>
</head>
<body background="/img/timg%5B1%5D.jpg">
<div class="middle">
     <h1 align="center"class="h">添加部门</h1>
			<form action="${pageContext.request.contextPath}/deptHandler/addDept.do" method="post">
				
				<div class="login-ic">
					<label class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;部&nbsp;&nbsp;门&nbsp;&nbsp;名:</label>
				   <input type="text"name="dept_name" placeholder="请输入部门名" class="login-ic"/>
				</div>
				
				<div class="login-ic">
					<label class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;部门地址:</label>
				   <input type="text"name="dept_address" placeholder="请输入部门地址" class="login-ic"/>
				</div>
				<div class="log-bwn">
				<input type="submit"value="添加" />
				</div>
</form>
</div>
</body>
</html>