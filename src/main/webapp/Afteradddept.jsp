<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
         location.href="${pageContext.request.contextPath }/deleteUserByIdServlet?user_id="+id;
     }
</script>
</head>
<body>
<h1>修改后的用户信息</h1>
     <table width="90%" align="center" cellpadding="0" cellspacing="0" border="1px">
          <tr align="center">
               <td><input type="checkbox" id="firstCb"></td>
        
               <td>部门id</td>
               <td>部门名称</td>
               <td>部门地址</td>
               <td>部门员工</td>
            
               
          </tr>
        
          
           <tr align="center">
            <td><input type="checkbox" id="firstCb"></td>
           
            <td>${dept.dept_id}</td>
             <td>${dept.dept_name}</td>
             <td>${dept.dept_address}</td>
             <td>${dept.user_name}</td>
             
             </tr>
             

      </table>


</body>

</html>