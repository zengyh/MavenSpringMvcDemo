<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>index.jsp</title>
</head>
<body>
     <a href="${pageContext.request.contextPath}/hello/world" target="_blank">以Get方式发起/hello/world请求</a>
     <br>
     <a href="${pageContext.request.contextPath}/jsp/send-helloworld-post.jsp" target="_blank">跳转到”以POST方式发起/hello/world请求”的页面</a>
     <br>
     <a href="${pageContext.request.contextPath}/jsp/send-helloworld2.jsp" target="_blank">跳转到“发起/hello/world2请求"的页面</a>
</body>
</html>