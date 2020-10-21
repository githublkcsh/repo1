<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新用户</title>
    <script type="text/javascript">
        function chooseFunction() {
            window.open('updateRoleFunction.jsp');
        }

        function submitFunction(){
            var formElement = document.getElementById('myform');
            with(formElement){
                action='${pageContext.request.contextPath }/roleHandler/updateRoleById.do';
                method='post';
                submit();
            }
        }

    </script>

</head>
<body>
<form id="myform">
	id:<input type='text' name='role_id' readonly='readonly' value=${updateRole.role_id}><br>
	角色名称：<input type="text" name="role_name" value=${updateRole.role_name}><br>
	<button onclick="chooseFunction()">更新权限</button><br>
	<textarea id="function" name="function" value=${updateRole.role_name} cols="30" rows="5" ></textarea><br>
    <%--value=${functionNames}--%>
	<input type='button' value='更新' onclick="submitFunction()">
	<input type='reset' value='清空'>
	</form>

</body>
</html>