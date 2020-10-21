<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>上面的内容</title>
</head>

<body>
<h1 align="center">欢迎使用后台管理系统</h1>
<div align="right">欢迎:&nbsp;&nbsp;${user01.user_name }回来&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/Servlet/LogoutServlet">注销</a></div>


</body>
</html>
