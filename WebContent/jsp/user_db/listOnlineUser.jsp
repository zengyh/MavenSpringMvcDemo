<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/head.jspf" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>在线用户列表--数据库DEMO</title>
  </head>
  
  <body>
       当前登录用户：<c:if test="${not empty currentUser}">${currentUser.userName}</c:if><br>
        在线用户数量：${userCount}<br>
    <center><h1>在线用户列表</h1></center>
    <table border="1" width="80%" align="center">
       <thead>
          <tr>
            <td>
                                       用户名
            </td>
            <td>
                                       密码
            </td>          
          </tr>
       </thead>
       <tbody>
       <c:forEach items="${userList}" var="user">
           <tr>
              <td>
                ${user.userName}
              </td>
              <td>
                ${user.password}
              </td>
           </tr>
       </c:forEach>
       </tbody>
    </table>
    <a href="${contextPath}jsp/user_db/index.jsp">返回主页</a>
  </body>
</html>
