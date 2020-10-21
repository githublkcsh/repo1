<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新用户</title>
    <script type="text/javascript">
        function chooseFunction() {
            window.open('updateRoleUser.jsp');
        }

        function submitFunction(){
            var formElement = document.getElementById('myform');
            with(formElement){
                action='${pageContext.request.contextPath }/roleHandler/updateUserroleById.do';
                method='post';
                submit();
            }
        }

    </script>

</head>
<body>
<form id="myform">
	用户id:<input type='text' name='user_id' readonly='readonly' value=${user4.user_id}><br>
	用户名称：<input type="text" name="user_name" value=${user4.user_name}><br>
	角色名称：<input type="text" name="role_name" value=${user4.role_name}><br>
	<button onclick="chooseFunction()">更新角色</button><br>
	<textarea id="role" name="roles"  cols="30" rows="5"  ></textarea><br>
    <%--value=${functionNames}--%>
	<input type='button' value='更新' onclick="submitFunction()">
	<input type='reset' value='清空'>
	</form>

</body>
</html>