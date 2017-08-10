<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>当个文件上传demo，本案例限制了只能上传图片</title>
<script type="text/javascript">
     function checkFile(el){
    	 var files = el.files;  //获取选择的文件对象
    	 var allowTypes = ["image/jpeg","image/png","image/x-png","image/bmp","image/gif"]; //允许上传的文件类型
    	 var maxFileSize = 50 * 1024 * 1024;  //允许上传的单个文件的大小限制，最大能上传50M
    	 var allowUpload = true; //经过校验之后是否允许上传
    	 var errorMessage = "";  //校验文件之后，文件不符合要求的提示信息
    	 
    	 for(var i=0; i< files.length; i++){
    	      var fileName = files[i].name;    //文件名
    	      var fileType = files[i].type;    //文件类型
    	      var fileSize = files[i].size;    //文件大小，单位为byte（字节）
    	      
    	      var typeAccepted = false;
    	      for(var j = 0; j < allowTypes.length; j++){
    	    	  if(allowTypes[j] == fileType){
    	    		  typeAccepted = true;
    	    		  break;
    	    	  }
    	      }
    	      if(typeAccepted != true){
    	    	  errorMessage += fileName + "不是图片，只能上传图片！";
    	    	  allowUpload = false;
    	      }
    	      
    	      if(typeAccepted && fileSize > maxFileSize){
    	    	  errorMessage += fileName+"的文件大小超出了50M限制！";
    	    	  allowUpload = false;
    	      }
    	 }
    	 
    	 if(allowUpload != true){
    		 el.outerHTML = el.outerHTML; //清空选择的文件
    		 alert(errorMessage);
    	 }
     }
     
     function checkForm(){
    	 if(document.getElementById("file1").value == ""){
    		 alert("请选择要上传的文件！");
    		 return false;
    	 }
    	 return true;
     }
</script>
</head>
<body>
   <form action="${pageContext.request.contextPath}/onefile/upload" method="post" enctype="multipart/form-data" onsubmit="return checkForm();">
        <input type="file" name="file1" id="file1" onchange="checkFile(this)"/> <br>
        <input type="submit" value="提交"/>
   </form>
</body>
</html>