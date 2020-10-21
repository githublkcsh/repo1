<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左边</title>
</head>
<body>

	<dl>
		<c:forEach var="elementforfunction" items="${functionuser }">

			<dt>
				<a href="${elementforfunction.key.path }" target="right">${elementforfunction.key.name }</a>
			</dt>

			<c:forEach var="elementson" items="${elementforfunction.value }">
				<dd>

					<c:if test="${not (fn:contains(elementson.name, '删除') or fn:contains(elementson.name, '更新')) }">
						<a href="${pageContext.request.contextPath }${elementson.path }"
							target="right">${elementson.name }</a>
					</c:if>


				</dd>
			</c:forEach>



		</c:forEach>


	</dl>
	
	<hr/>
	<dl>
		<c:forEach var="list2" items="${list}">
			<c:if test="${empty list2.fatherFunction}">
				<dt>${list2.function_name}</dt>

			<c:forEach var="list01" items="${list}">
				<c:if test="${list01.fatherFunction.function_name==list2.function_name}">
					<dd><a href="${pageContext.request.contextPath}${list01.function_address}" target="right">${list01.function_name}</a></dd>
				</c:if>
			</c:forEach>
            </c:if>
		</c:forEach>
	  <%--<dt><a href='javascript:void(0)' target="right">用户管理</a></dt>--%>
	  <%--<dd><a href='${pageContext.request.contextPath }/userHandler/finduser.do' target="right">查找用户</a></dd>--%>
	  <%--<dd><a href='${pageContext.request.contextPath }/userHandler/adduser01.do' target="right">添加用户</a></dd>--%>
	  <%--<dt><a href='javascript:void(0)' target="right">身份证管理</a></dt>--%>
	  <%--<dd><a href='${pageContext.request.contextPath }/idCardHander/findAllIdcard.do' target="right">查找身份证</a></dd>--%>
	  <%--<dd><a href='${pageContext.request.contextPath }/addidcard.jsp' target="right">添加身份证</a></dd>--%>
	  <%--<dt><a href='javascript:void(0)' target="right">部门管理</a></dt>--%>
	   <%--<dd><a href='${pageContext.request.contextPath }/deptHandler/selectDept.do' target="right">查找部门</a></dd>--%>
		<%--<dd><a href='${pageContext.request.contextPath }/adddept.jsp' target="right">添加部门</a></dd>--%>
		<%--<dt><a href='javascript:void(0)' target="right">权限管理</a></dt>--%>
		<%--<dd><a href='${pageContext.request.contextPath }/functionHandler/selectFunction.do' target="right">查找权限</a></dd>--%>
		<%--<dd><a href='${pageContext.request.contextPath }/functionHandler/findAllFatherFunction.do' target="right">添加权限</a></dd>--%>
		<%--<dt><a href='javascript:void(0)' target="right">角色管理</a></dt>--%>
		<%--<dd><a href='${pageContext.request.contextPath }/roleHandler/selectRole.do' target="right">查找角色</a></dd>--%>
		<%--<dd><a href='${pageContext.request.contextPath }/roleHandler/selectUserRole.do' target="right">查找用户角色</a></dd>--%>
		<%--<dd><a href='${pageContext.request.contextPath }/roleHandler/allfunction.do' target="right">添加角色</a></dd>--%>
	</dl>
	



</body>
</html>
