<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>选择权限</title>
    <script type="text/javascript">

        function back() {
            var functionString = '';
            var opElementArray = document.getElementsByName("op");
            for (var index=0;index<opElementArray.length;index++){
                var status = opElementArray[index-0].checked;
                if (status==true){
                    console.log("选中："+opElementArray[index-0].value);
                    functionString += opElementArray[index-0].value+'.';
                }
            }
            var index = functionString.length-1;
            functionString=functionString.slice(0,index);
            console.log("字符串值01为："+functionString);
            console.log("字符串值02为："+functionString);
            var functionsElement = window.opener.document.getElementById('function');
            functionsElement.value = functionString;
            console.log("字符串值03为："+functionString);
            window.close();
        }
    </script>

</head>
<body>
<form>
    <dl>
        <c:forEach var="function" items="${AllFunction}">
            <%--权限为父权限--%>
            <c:if test="${empty function.fatherFunction}">
                <dt>
                    <c:set var="fatherFlag" value="false"></c:set>
                    <c:forEach var="roleFunction" items="${updateRole.authorityList}">
                        <c:if test="${function.function_name==roleFunction.function_name}">
                            <input type="checkbox" name="op" value=${function.function_name} checked="checked">${function.function_name}
                            <c:set var="fatherFlag" value="true"></c:set>
                        </c:if>
                    </c:forEach>
                    <c:if test="${fatherFlag==false}"><%--当前角色中没有该权限--%>
                        <input type="checkbox" name="op" value=${function.function_name}>${function.function_name}
                    </c:if>
                </dt>
                <c:forEach var="functionSon" items="${allFunction}">
                    <%--找出所有权限中，父权限为当前权限的子权限--%>
                    <c:if test="${functionSon.fatherFunction.function_name==function.function_name}">
                        <dd>
                            <c:set var="sonFlag" value="false"></c:set>
                            <c:forEach var="roleFunction" items="${updateRole.functionList}">
                                <c:if test="${functionSon.function_name==roleFunction.function_name}">
                                    <input type="checkbox" name="op"  value=${functionSon.function_name} checked="checked">${functionSon.function_name}
                                    <c:set var="sonFlag" value="true"></c:set>
                                </c:if>
                            </c:forEach>
                            <c:if test="${sonFlag==false}"><%--当前角色中没有该权限--%>
                                <input type="checkbox" name="op"  value=${functionSon.function_name}>${functionSon.function_name}
                            </c:if>
                        </dd>
                    </c:if>
                </c:forEach>
            </c:if>
        </c:forEach>
    </dl>
    <input type="reset" value="重置">
    <button onclick="back()">返回</button>
</form>
</body>
</html>