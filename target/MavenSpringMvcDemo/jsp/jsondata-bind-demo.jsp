<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>绑定Json数据的Demo</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
   function sendData(){
	   var jsonObject =$("#jsonData").val();
	   $.ajax({ 
		   type: "POST", 
		   url: "${pageContext.request.contextPath}/databind/demo/json", 
		   contentType: "application/json; charset=utf-8", 
		   data: jsonObject, 
		   dataType: "html", 
		   success: function (data,textStatus) { 
			   $("#returnContent").html(data);
		   }, 
		   error: function (XMLHttpRequest, textStatus, errorThrown) { 
			   $("#returnContent").html(textStatus);
		   } 
       }); 
   }
</script>
</head>
<body>
   要发送的Json数据内容：<br>
  <textarea id="jsonData" rows="8" cols="40">{"userName":"张三","age":"22"}</textarea><br>
  <input type="button" value="发送" onclick="sendData();"/><br>
  返回的内容：<br>
  <div id="returnContent"></div>
</body>
</html>