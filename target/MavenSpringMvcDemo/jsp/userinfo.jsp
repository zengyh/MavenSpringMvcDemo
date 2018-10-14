<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>userinfo.jsp</title>
</head>
<body>
		<c:if test="${sessionScope.user != null}">
			<h3>HttpSession对象中也存了用户信息！用户信息如下：</h3> 
                        用户编号：${sessionScope.user.no}
            <br>
                        用户名：${sessionScope.user.userName}
            <br>
                        年龄：${sessionScope.user.age}
        </c:if>
		<c:if test="${requestScope.user != null}">
		    <h3>HttpServletRequest对象中存的用户信息如下：</h3> 
                        用户编号：${requestScope.user.no}
            <br>
                        用户名：${requestScope.user.userName}
            <br>
                        年龄：${requestScope.user.age}
        </c:if>
</body>
</html>