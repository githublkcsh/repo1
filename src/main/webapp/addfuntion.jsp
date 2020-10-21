<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加用户</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/functionHandler/addfunction.do" method="post">
    权限名称：<input type="text" name="function_name"><br>
    权限路径：<input type="test" name="function_address"><br>
    父权限：
    <select name="fatherFunction">
        <option value="none">===请选择===</option>
        <option value="none">无</option>
        <c:forEach var="fatherFunction" items="${allFatherFunction}">
            <option value=${fatherFunction.function_name}>${fatherFunction.function_name}</option>
        </c:forEach>
    </select><br>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
</body>
</html>
