<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/head.jspf" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>登陆--数据库DEMO</title>
  </head>
  <body>
    <form action="${contextPath}user/logon"  method="post" >
            用户名：<input type="text" name="userName" value="${user.userName}"/><br>
            密码：<input type="text" name="password" value="${user.password}"/><br>
      <input type="submit" value="登陆"/>
    </form>
    <c:if test="${not empty errorMsg}"><font color="red">${errorMsg}</font></c:if><br>
    <a href="${contextPath}user/listOnlineUser">在线用户列表</a>
    <a href="${contextPath}jsp/user_db/index.jsp">返回主页</a>
  </body>
</html>
