<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="image" uri="http://yh.zeng/tag/image" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>预览上传到服务器上的图片</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<style>
   .imgBorder{
       float: left;
       border: 1px solid gray;
       margin-top:5px;
       margin-right: 5px;
       padding: 10px;
       color: gray;
       font-size: 10px;
   }
   .imgClass{
       cursor: pointer;
   }
</style>
<script type="text/javascript">
   $(function(){
	   $("img.imgClass").click(function(){
            window.open($(this).attr("src"));
	   });
   });
</script>
</head>
<body>
<c:forEach items="${requestScope.imgFileNames}" var="fileName" varStatus="i">
   <div class="imgBorder">
      ${fileName}.${requestScope.imgFileTypes[i.index]}<br>
      <image:scale src="${pageContext.request.contextPath}/uploaded-files/preview/${requestScope.imgFileTypes[i.index]}/${fileName}" styleClass="imgClass" width="300"/>
   </div>
</c:forEach>
</body>
</html>