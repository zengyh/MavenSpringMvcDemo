<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看用户信息</title>
</head>
<body>
              用户编号： ${sessionScope.user.no} <br>
              用户名： ${sessionScope.user.userName} <br>
              年龄：${sessionScope.user.age} 
</body>
</html>