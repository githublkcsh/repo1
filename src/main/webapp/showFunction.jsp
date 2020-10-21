<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
        function deleteUser(id){
            //
            if(confirm("您确定要删除吗？"))
                location.href="${pageContext.request.contextPath }/functionHandler/deleteFunction.do?function_id="+id;
        }
	</script>

</head>
<body>

	<table border='1px' align='center' width='70%' cellpadding='0'
		cellspacing='0'>
		<tr align='center'>
			<td>编号</td>
			<td>权限名称</td>
			<td>权限路径</td>
			<td>父权限</td>
			<td>操作</td>
		</tr>
<!-- session.setAttribute("functionPage", pageUnitForFunction); -->
		<c:forEach var="function" items="${currentfunction.currentFunction}" varStatus="functionstatus">
			<tr align='center'>
				<td>${functionstatus.count }</td>
				<td>${function.function_name }</td>
				<td>
					<c:if test="${empty function.function_address}">
						/
					</c:if>
					<c:if test="${function.function_address!=null}">
						${function.function_address }
					</c:if>
				</td>
				<td>
					<c:if test="${empty function.fatherFunction_name}">
						/
					</c:if>
					<c:if test="${function.fatherFunction_name!=null}">
						${function.fatherFunction_name}
					</c:if>
				</td>
				<td>
				  <a href='${pageContext.request.contextPath }/functionHandler/selectFunctionById.do?function_id=${function.function_id}'>更新</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:deleteUser(${function.function_id});">删除</a>
				</td>
			</tr>
		</c:forEach>

		<tr >
			<td colspan="10" align="right">共${currentfunction.totalPage}页&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/functionHandler/selectFunction.do?currentPageNo=1">首页</a>&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/functionHandler/selectFunction.do?currentPageNo=${currentfunction.prePageNo}">上一页</a>&nbsp;&nbsp;&nbsp;
				<c:forEach begin="1" end="${currentfunction.totalPage}" step="1" var="element">
					<a href="${pageContext.request.contextPath}/functionHandler/selectFunction.do?currentPageNo=${element}">${element}</a>&nbsp;&nbsp;&nbsp;

				</c:forEach>
				<a href="${pageContext.request.contextPath}/functionHandler/selectFunction.do?currentPageNo=${currentfunction.nextPageNo}">下一页</a>&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/functionHandler/selectFunction.do?currentPageNo=${currentfunction.totalPage}">尾页</a>&nbsp;&nbsp;&nbsp;


			</td>

		</tr>
	</table>



</body>
</html>