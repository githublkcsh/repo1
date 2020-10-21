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
            var functionsElement = window.opener.document.getElementById('role');
            functionsElement.value = functionString;
            console.log("字符串值03为："+functionString);
            window.close();
        }
    </script>

</head>
<body>
<form>
    <dl>
        <c:forEach var="role" items="${role4}">
        <c:if test="${empty role.role_name}">
            <c:set var="fatherFlag" value="false"></c:set>
        </c:if>


                 <dt>

                        <c:if test="${role.role_name==user4.role_name}">
                            <input type="checkbox" name="op" value=${role.role_name} checked="checked">${role.role_name}

                        </c:if>

                    <c:if test="${fatherFlag==false}"><%--当前角色中没有该权限--%>
                        <input type="checkbox" name="op" value=${role.role_name}>${role.role_name}
                    </c:if>
            </dt>

        </c:forEach>

    </dl>
    <input type="reset" value="重置">
    <button onclick="back()">返回</button>
</form>
</body>
</html>