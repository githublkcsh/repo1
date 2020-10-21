<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			
</style>
</head>
<body>
<div class="middle">
      
			<form action="${pageContext.request.contextPath}/userHandler/updateById.do" method="post">
			<div class="login-ic">
					<label class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
				   <input type="text"name="user_id" value="${user.user_id}" class="login-ic" readonly="readonly"/>
				</div>
			
			
			
				<div class="login-ic">
					<label class="label">&nbsp;用&nbsp;户&nbsp;名&nbsp;:</label>
		           <input type="text"name="user_name" value="${user.user_name}" class="login-ic" />
				 </div>
				 <div class="login-ic">
					<label class="label">&nbsp;&nbsp;部&nbsp;&nbsp;&nbsp;门&nbsp;&nbsp;:</label>
				   <input type="text"name="dept_name" value="${user.dept_name}" class="login-ic" readonly="readonly"/>
				</div>
		        
				<div class="login-ic">
					<label class="label">&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;龄&nbsp;&nbsp;:</label>
				   <input type="text"name="user_age" value="${user.user_age}" class="login-ic"/>
				</div>
				<div class="login-ic">
					<label class="label">&nbsp;&nbsp;性&nbsp;&nbsp;&nbsp;别&nbsp;&nbsp;:</label>
				   <input type="text"name="user_sex" value="${user.user_sex}" class="login-ic"/>
				</div>
				<div class="login-ic">
					<label class="label">&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码&nbsp;&nbsp;:</label>
		           <input type="text"name="user_password" value="${user.user_password}" placeholder="密码" class="login-ic"/>
		        </div>
		        <div class="login-ic">
		        <label class="label">&nbsp;身&nbsp;份&nbsp;证&nbsp;:</label>

		            <select  name="idcard_id">
		            <option>---请选择---</option>
                        <c:forEach  items="${idCard1}" var="c" >
                        <option value=${c.idcard_id}>${c.idcard_no}</option>
                        </c:forEach>
                        

					</select>
					
					
					
		        </div>
		         <div class="login-ic">
		        <label class="label">&nbsp;新&nbsp;部&nbsp;门&nbsp;:</label>
					<select name="dept_id">
				    <option>---请选择---</option>
				    <c:forEach items="${dept2}" var="c">
				    <option value=${c.dept_id}>${c.dept_name}</option>
				    </c:forEach>
				  </select>
				  </div>
				<div class="log-bwn">
				<input type="submit"value="修改" />
				</div>
</form>
</div>
</body>
</html>