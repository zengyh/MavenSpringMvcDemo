<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>index.jsp</title>
<style type="text/css">
    a{
       display: block;
       margin-bottom: 17px;
    }
</style>
</head>
<body>
     <a href="${pageContext.request.contextPath}/hello/world" target="_blank">以Get方式发起/hello/world请求</a>
     <a href="${pageContext.request.contextPath}/jsp/send-helloworld-post.jsp" target="_blank">跳转到“以POST方式发起/hello/world请求”的页面</a>
     <a href="${pageContext.request.contextPath}/jsp/send-helloworld2.jsp" target="_blank">跳转到“发起/hello/world2请求"的页面</a>
     <a href="${pageContext.request.contextPath}/say/helloworld" target="_blank">处理ResetFul风格的URL例子（以Get方式发起/say/helloworld请求，将URL路径中/say/的下个内容作为页面内容显示）</a>
     <a href="${pageContext.request.contextPath}/say?msg=helloworld" target="_blank">Controller获取请求参数的例子1（以Get方式发起/say?msg=helloworld请求，将请求参数msg的值作为页面内容显示）</a>
     <a href="${pageContext.request.contextPath}/say2?msg=helloworld" target="_blank">Controller获取请求参数的例子2（以Get方式发起/say2?msg=helloworld请求，将请求参数msg的值作为页面内容显示）</a>
     <a href="${pageContext.request.contextPath}/say3?msg=helloworld" target="_blank">Controller获取请求参数的例子3（以Get方式发起/say3?msg=helloworld请求，将请求参数msg的值作为页面内容显示）</a>
     <a href="${pageContext.request.contextPath}/users/view/1/use/ModelAndView" target="_blank">Controller中如何将model数据返回给页面，方式一：通过org.springframework.web.servlet.ModelAndView实现</a>
     <a href="${pageContext.request.contextPath}/users/view/1/use/Model" target="_blank">Controller中如何将model数据返回给页面，方式二：通过org.springframework.ui.Model实现</a>
     <a href="${pageContext.request.contextPath}/users/view/1/use/ModelMap" target="_blank">Controller中如何将model数据返回给页面，方式三：通过org.springframework.ui.ModelMap实现</a>
     <a href="${pageContext.request.contextPath}/users/view/1/use/Map" target="_blank">Controller中如何将model数据返回给页面，方式四：通过java.util.Map实现</a>
     <a href="${pageContext.request.contextPath}/users/view/1/use/SessionAttributes" target="_blank">Controller中如何将model数据返回给页面，方式五：通过jorg.springframework.web.bind.annotation.SessionAttributes标注指定Model中的某些数据也存储到HttpSession中</a>
     <a href="${pageContext.request.contextPath}/users/view/1/use/ModelAttribute" target="_blank">Controller中如何将model数据返回给页面，方式六：通过jorg.springframework.web.bind.annotation.SessionAttributes实现</a>

</body>
</html>