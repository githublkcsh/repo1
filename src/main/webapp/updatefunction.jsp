<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新权限</title>

</head>
<body>
<form action="${pageContext.request.contextPath }/functionHandler/updatefunction.do" method="post">
	id:<input type='text' name='function_id' readonly='readonly' value=${updateFunction.function_id}><br>
	权限名称：<input type="text" name="function_name" value="${updateFunction.function_name}"><br>
	权限路径：<input type="text" name="function_address" value="${updateFunction.function_address}"><br>
	父权限：
	<select name="fatherFunction_name">
		<c:if test="${empty updateFunction.fatherFunction_name}">
			<option value="none">无</option>
		</c:if>
		<c:if test="${updateFunction.fatherFunction_name!=null}">
			<option value="${updateFunction.fatherFunction_name}" >${updateFunction.fatherFunction_name}</option>
			<option value="none">无</option>
		</c:if>
		<c:forEach var="fatherFunction" items="${allFatherFunction1}">
			<option value="${fatherFunction.function_id}">${fatherFunction.function_name}</option>
		</c:forEach>
	</select><br>
	<input type='submit' value='更新'>
	<input type='reset' value='清空'>
	</form>

</body>
</html>