<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>框架</title>
</head>
<frameset rows="15%,*">                        <!-- 设置窗口为上下两部分  -->
<frame src="top.jsp" noresize="noresize" scrolling="no"  name="top">                   <!-- 设置第一部分窗口显示的内容 -->
<frameset cols="10%,*">                        <!-- 设置第二部分窗口显示的内容 -->
   <frame src="${pageContext.request.contextPath}/userHandler/selectfunction.do?user_name=${user1.user_name}" noresize="noresize" scrolling="no" name="left"/>
   <frame src="right.jsp" noresize="noresize" scrolling="auto" name="right"/>
</frameset>



</frameset><noframes></noframes>

<body>
</body>







</html>
