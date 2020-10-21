<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>

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
			
</style>
	<script type="text/javascript">
        function chooseFunction() {
            window.open('chooseRole.jsp');
        }
        function submitFunction(){
            var formElement = document.getElementById('form');
            /*formElement.action='test.html';
            formElement.method='post';
            formElement.submit();*/
            with(formElement){
                action='${pageContext.request.contextPath}/userHandler/adduser.do';
                method='post';
                submit();
            }
        }

	</script>
</head>
<body >
<div class="middle">
     <h1 align="center"class="h">欢迎注册权限管理系统</h1>
			<form id="form">
				<div class="login-ic">
					<label class="label">&nbsp;用&nbsp;户&nbsp;名&nbsp;:</label>
		           <input type="text"name="user_name" placeholder="用户名" class="login-ic" /><br />
				 </div>
		        <div class="login-ic">
					<label class="label">&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码&nbsp;&nbsp;:</label>
		           <input type="password"name="user_password" placeholder="密码" class="login-ic"/>
		        </div>
				<div class="login-ic">
					<label class="label">&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;龄&nbsp;&nbsp;:</label>
				   <input type="text"name="user_age" placeholder="请输入年龄" class="login-ic"/>
				</div>
				<div class="login-ic">
					<label class="label">&nbsp;&nbsp;性&nbsp;&nbsp;&nbsp;别&nbsp;&nbsp;:</label>
				   <input type="text"name="user_sex" placeholder="请输入性别" class="login-ic"/>
				</div>
				<div class="login-ic">
					<label class="label">&nbsp;&nbsp;部&nbsp;&nbsp;&nbsp;门&nbsp;&nbsp;:</label>
					<select name="dept_id">
						<option>---请选择---</option>
						<c:forEach items="${dept3}" var="c">
							<option value=${c.dept_id}>${c.dept_name}</option>
						</c:forEach>
					</select>
				</div>
				<button onclick="chooseFunction()">选择角色</button><br>
				<textarea id="function" name="roles" cols="30" rows="5"></textarea><br>
				<div class="log-bwn">
				<input type="button"value="注册" onclick="submitFunction()" />
				</div>
</form>
</div>
</body>
</html>