<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/8/6
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
    <script>
        window.onload = function(){
            //给选中按钮添加单击事件
            document.getElementById("addSelected").onclick = function(){
                if(confirm("您确定要选中条目吗？")){

                    var flag = false;
                    //判断是否有选中条目
                    var cbs = document.getElementsByName("uid");
                    for (var i = 0; i < cbs.length; i++) {
                        if(cbs[i].checked){
                            //有一个条目选中了
                            flag = true;
                            break;
                        }
                    }

                    if(flag){//有条目被选中
                        //表单提交
                        document.getElementById("form").submit();
                    }

                }

            }
            //1.获取第一个cb
            document.getElementById("firstCb").onclick = function(){
                //2.获取下边列表中所有的cb
                var cbs = document.getElementsByName("uid");
                //3.遍历
                for (var i = 0; i < cbs.length; i++) {
                    //4.设置这些cbs[i]的checked状态 = firstCb.checked
                    cbs[i].checked = this.checked;

                }

            }


        }

    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/deptHandler/addSelected.do" method="post">

    <table width="90%" align="center" cellpadding="0" cellspacing="0" border="1px">
        <tr align="center">

            <td>状态</td>
            <td>编号</td>
            <td>员工姓名</td>
        </tr>

        <c:forEach items="${user012}" var="b" varStatus="s">
        <tr align="center">

               <td> <input type="checkbox"  name="uid" id="firstCb" checked="checked" value=${b.user_id}></td>


                <td>${s.count}</td>
                <td>${b.user_name}</td>




        </tr>
        </c:forEach>

        <c:forEach items="${userlist}" var="c" varStatus="s">
        <tr align="center">
                    <td><input type="checkbox"  name="uid" id="firstCb" value=${c.user_id}></td>
                    <td>${s.count}</td>
                    <td>${c.user_name}</td>
        </tr>
        </c:forEach>

    </table>
    <button href="javascript:void(0)" id="addSelected" >添加选中</button>
</form>

</body>
</html>
