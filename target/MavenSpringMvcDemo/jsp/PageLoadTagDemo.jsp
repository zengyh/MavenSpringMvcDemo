<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="page" uri="http://yh.zeng/tag/page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<page:load clazz="edu.mvcdemo.tag.test.PageLoadTagTest" method="loadPage"/>
<html>
<head><title>PageLoadTagTest</title></head>
<body>
   ${msg}
</body>
</html>