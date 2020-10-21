<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
     function deleteUser(id){
    	 //
    	if(confirm("您确定要删除吗？"))
         location.href="${pageContext.request.contextPath }/userHandler/deleteuser.do?user_id="+id;
     }
</script>
</head>
<body>
<div style="width:90%; margin:0 auto;  ">
      <div style="float:left;" >

        <form class="form-inline" action="${pageContext.request.contextPath}/findUserByPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <label for="exampleInputName3">id</label>
                <input type="text" name="address" value="${condition.address[0]}" class="form-control" id="exampleInputName3" >
            </div>

            
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>

    <div style="float:right; ">

        
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>

    </div>
  </div>
     <table width="90%" align="center" cellpadding="0" cellspacing="0" border="1px">
          <tr align="center">
               <td><input type="checkbox" id="firstCb"></td>
               <td>编号</td>
               <td>用户id</td>
               <td>姓名</td>
               <td>年龄</td>
               <td>性别</td>
               <td>密码</td>
               <td>身份证</td>
               <td>部门</td>
               <td>操作</td>
          </tr>
        
          <c:forEach var="element" items="${currentuser.currentUser}" varStatus="s">
           <tr align="center">
            <td><input type="checkbox" id="firstCb1"></td>
            <td>${s.count}</td>
            <td>${element.user_id}</td>
             <td>${element.user_name}</td>
             <td>${element.user_age}</td>
             <td>${element.user_sex}</td>
             <td>${element.user_password}</td>
             <td>${element.idcard_no }</td>
             <td>${element.dept_name}</td>
             <td><a href="${pageContext.request.contextPath }/userHandler/update.do?user_id=${element.user_id}">更新</a> <a href="javascript:deleteUser(${element.user_id});">删除</a></td>
             </tr>
             </c:forEach>
             <tr >
                <td colspan="10" align="right">共${currentuser.totalPage}页&nbsp;&nbsp;&nbsp;
                  <a href="${pageContext.request.contextPath}/userHandler/finduser.do?currentPageNo=1">首页</a>&nbsp;&nbsp;&nbsp;
                   <a href="${pageContext.request.contextPath }/userHandler/finduser.do?currentPageNo=${currentuser.prePageNo}">上一页</a>&nbsp;&nbsp;&nbsp;
                    <c:forEach begin="1" end="${currentuser.totalPage}" step="1" var="element">
                        <a href="${pageContext.request.contextPath}/userHandler/finduser.do?currentPageNo=${element}">${element}</a>&nbsp;&nbsp;&nbsp;
                  
                  </c:forEach>
                  <a href="${pageContext.request.contextPath}/userHandler/finduser.do?currentPageNo=${currentuser.nextPageNo}">下一页</a>&nbsp;&nbsp;&nbsp;
                  <a href="${pageContext.request.contextPath}/userHandler/finduser.do?currentPageNo=${currentuser.totalPage}">尾页</a>&nbsp;&nbsp;&nbsp;
                    
                
                </td>
             
             </tr>

      </table>


</body>
</html>