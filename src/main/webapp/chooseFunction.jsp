<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>选择权限</title>
    <script type="text/javascript">
        function setDtStatus(fatherName){
            console.log("参数为："+fatherName);
            var elementArray = document.getElementsByName("op");
            for (var index=0;index<elementArray.length;index++){
                if (elementArray[index].value==fatherName){
                    elementArray[index].checked = true;
                }
            }
        }

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
    <c:forEach var="function" items="${allFunction}">
        <c:if test="${empty function.fatherFunction_name}">
            <c:set var="fatherName" value="${function.function_name}"></c:set>
            <dt><input type="checkbox" name="op" value=${function.function_name}>${function.function_name}</dt>
            <c:forEach var="functionSon" items="${allFunction}">
                <c:if test="${functionSon.fatherFunction_name==function.function_name}">
                    <dd><input type="checkbox" name="op"  value=${functionSon.function_name} onclick="setDtStatus(${fatherName})">${functionSon.function_name}</dd>
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