<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>以POST方式发起/hello/world请求</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
  function helloworld2_GET(){
	   $.get("${pageContext.request.contextPath}/hello/world2",function(result){
		    $("#content1").html(result);
	   });
  }
  function helloworld2_POST(){
	   $.post("${pageContext.request.contextPath}/hello/world2",function(result){
		    $("#content2").html(result);
	   });
  }
</script>
</head>
<body>
      <br>
      <a href="#" onclick="helloworld2_GET()">以GET方式发起/hello/world2请求</a>
      <br>
      <a href="#" onclick="helloworld2_POST()">以POST方式发起/hello/world2请求</a>
      <br>
      <br>
      <h2>GET返回的内容:</h2>
      <div id="content1">
      </div>
      <br>
      <br>
      <h2>POST返回的内容:</h2>
      <div id="content2">
      </div>
</body>
</html>