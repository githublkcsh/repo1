<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加角色</title>
    <script type="text/javascript">
        function chooseFunction() {
            window.open('chooseFunction.jsp');
        }

        function submitFunction(){
            var formElement = document.getElementById('myform');
            /*formElement.action='test.html';
            formElement.method='post';
            formElement.submit();*/
            with(formElement){
                action='${pageContext.request.contextPath }/roleHandler/addrole.do';
                method='post';
                submit();
            }
        }

    </script>
</head>
<body>
<form id="myform">
    角色名称：<input type="text" name="role_name"><br>
    <button onclick="chooseFunction()">选择权限</button><br>
    <textarea id="function" name="functions" cols="30" rows="5"></textarea><br>
    <input type="button" value="提交" onclick="submitFunction()">
    <input type="reset" value="重置">


</form>
</body>
</html>