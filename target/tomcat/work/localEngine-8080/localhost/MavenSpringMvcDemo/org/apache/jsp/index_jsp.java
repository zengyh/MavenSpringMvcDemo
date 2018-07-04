package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title>index.jsp</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("    a{\r\n");
      out.write("       display: block;\r\n");
      out.write("       margin-bottom: 17px;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/hello/world\" target=\"_blank\">以Get方式发起/hello/world请求</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/jsp/send-helloworld-post.jsp\" target=\"_blank\">跳转到“以POST方式发起/hello/world请求”的页面</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/jsp/send-helloworld2.jsp\" target=\"_blank\">跳转到“发起/hello/world2请求\"的页面</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/say/helloworld\" target=\"_blank\">处理ResetFul风格的URL例子（以Get方式发起/say/helloworld请求，将URL路径中/say/的下个内容作为页面内容显示）</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/say?msg=helloworld\" target=\"_blank\">Controller获取请求参数的例子1（以Get方式发起/say?msg=helloworld请求，将请求参数msg的值作为页面内容显示）</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/say2?msg=helloworld\" target=\"_blank\">Controller获取请求参数的例子2（以Get方式发起/say2?msg=helloworld请求，将请求参数msg的值作为页面内容显示）</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/say3?msg=helloworld\" target=\"_blank\">Controller获取请求参数的例子3（以Get方式发起/say3?msg=helloworld请求，将请求参数msg的值作为页面内容显示）</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/say4?msg=helloworld\" target=\"_blank\">Controller获取请求参数的例子4（以Get方式发起/say4?msg=helloworld请求，将请求参数msg的值作为页面内容显示）</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/users/view/1/use/ModelAndView\" target=\"_blank\">Controller中如何将model数据返回给页面，方式一：通过org.springframework.web.servlet.ModelAndView实现</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/users/view/1/use/Model\" target=\"_blank\">Controller中如何将model数据返回给页面，方式二：通过org.springframework.ui.Model实现</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/users/view/1/use/ModelMap\" target=\"_blank\">Controller中如何将model数据返回给页面，方式三：通过org.springframework.ui.ModelMap实现</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/users/view/1/use/Map\" target=\"_blank\">Controller中如何将model数据返回给页面，方式四：通过java.util.Map实现</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/users/view/1/use/SessionAttributes\" target=\"_blank\">Controller中如何将model数据返回给页面，方式五：通过org.springframework.web.bind.annotation.SessionAttributes标注指定Model中的某些数据也存储到HttpSession中</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/users/view/1/use/ModelAttribute\" target=\"_blank\">Controller中如何将model数据返回给页面，方式六：通过org.springframework.web.bind.annotation.ModelAttribute实现</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/users/view/1/use/HttpSession\" target=\"_blank\">Controller中如何将model数据返回给页面，方式七：直接将数据存到HttpSession，让页面可以获取</a>     \r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/users/view/1/use/HttpServletRequest\" target=\"_blank\">Controller中如何将model数据返回给页面，方式八：直接将数据存到HttpServletRequest，让页面可以获取</a>     \r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/redirect/demo1\" target=\"_blank\">Spring MVC重定向demo,方式一：方法返回的URI（相对路径）中加上\"redirect:\"前缀，声明要重定向到该地址</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/redirect/demo2\" target=\"_blank\">Spring MVC重定向demo,方式二：使用HttpServletResponse对象进行重定向，HttpServletResponse对象通过方法入参传入</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/voidMethod/demo1\" target=\"_blank\">Controller中void方法的声明demo,方式一：通过声明HttpServletResponse类型的方法入参，来使用HttpServletResponse对象</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/voidMethod/demo2\" target=\"_blank\">Controller中void方法的声明demo,<font color='red'>错误</font>的方式二：void方法不定义HttpServletResponse类型的入参，HttpServletResponse对象通过RequestContextHolder上下文获取</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/user?add\" target=\"_blank\">表单提交demo</a>\r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/onefile?upload\" target=\"_blank\">单个文件上传</a>    \r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/mutilpartfile?upload\" target=\"_blank\">多文件上传</a>  \r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/uploaded-files/preview\" target=\"_blank\">预览上传到服务器上的所有图片</a> \r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/jsontype/view1/users/1\" target=\"_blank\">Controller返回JSON数据的demo，方式一：使用@ResponseBody标注</a>          \r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/jsontype/view2/users/1\" target=\"_blank\">Controller返回JSON数据的demo，方式二：使用ResponseEntity</a> \r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/jsontype/view3/users/1\" target=\"_blank\">Controller返回JSON数据的demo，方式三：使用HttpServletResponse对象返回JSON数据</a> \r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/databind/demo/object?user.userName=Tom&admin.userName=Administrator\" target=\"_blank\">Spring MVC同属性多对象绑定Demo</a> \r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/databind/demo/list?users[0].userName=Tom&users[1].userName=Sally\" target=\"_blank\">Spring MVC绑定List对象Demo</a> \r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/databind/demo/set?users[0].userName=Tom&users[1].userName=Sally\" target=\"_blank\">Spring MVC绑定Set对象Demo</a> \r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/databind/demo/map?users[user1].userName=Tom&users[user2].userName=Sally\" target=\"_blank\">Spring MVC绑定Map对象Demo</a> \r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/jsp/jsondata-bind-demo.jsp\" target=\"_blank\">跳转到Spring MVC绑定Json对象Demo页面</a> \r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/jsp/xmldata-bind-demo.jsp\" target=\"_blank\">跳转到Spring MVC绑定Xml对象Demo页面</a> \r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/databind/demo/date.do?date=2017-11-19\" target=\"_blank\">Spring MVC绑定Date对象Demo</a> \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
