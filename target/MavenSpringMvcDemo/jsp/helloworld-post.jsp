<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>以POST方式发起/hello/world请求</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
  function helloworld(){
	   $.post("${pageContext.request.contextPath}/hello/world",function(result){
		    $("#content").html(result);
	   });
  }
</script>
</head>
<body>
      <a href="#" onclick="helloworld()">以POST方式发起/hello/world请求</a>
      <br>
            返回的内容：
      <div id="content">
      </div>
</body>
</html>