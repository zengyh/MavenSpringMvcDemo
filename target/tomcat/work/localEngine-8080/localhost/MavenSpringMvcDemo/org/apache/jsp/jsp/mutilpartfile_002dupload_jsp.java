package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mutilpartfile_002dupload_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>多文件上传demo，本案例限制了只能上传图片</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("     function checkFile(el){\r\n");
      out.write("    \t var files = el.files;  //获取选择的文件对象\r\n");
      out.write("    \t var allowTypes = [\"image/jpeg\",\"image/png\",\"image/x-png\",\"image/bmp\",\"image/gif\"]; //允许上传的文件类型\r\n");
      out.write("    \t var maxFileSize = 50 * 1024 * 1024;  //允许上传的单个文件的大小限制，最大能上传50M\r\n");
      out.write("    \t var allowUpload = true; //经过校验之后是否允许上传\r\n");
      out.write("    \t var errorMessage = \"\";  //校验文件之后，文件不符合要求的提示信息\r\n");
      out.write("    \t \r\n");
      out.write("    \t for(var i=0; i< files.length; i++){\r\n");
      out.write("    \t      var fileName = files[i].name;    //文件名\r\n");
      out.write("    \t      var fileType = files[i].type;    //文件类型\r\n");
      out.write("    \t      var fileSize = files[i].size;    //文件大小，单位为byte（字节）\r\n");
      out.write("    \t      \r\n");
      out.write("    \t      var typeAccepted = false;\r\n");
      out.write("    \t      for(var j = 0; j < allowTypes.length; j++){\r\n");
      out.write("    \t    \t  if(allowTypes[j] == fileType){\r\n");
      out.write("    \t    \t\t  typeAccepted = true;\r\n");
      out.write("    \t    \t\t  break;\r\n");
      out.write("    \t    \t  }\r\n");
      out.write("    \t      }\r\n");
      out.write("    \t      if(typeAccepted != true){\r\n");
      out.write("    \t    \t  errorMessage += fileName + \"不是图片，只能上传图片！\";\r\n");
      out.write("    \t    \t  allowUpload = false;\r\n");
      out.write("    \t      }\r\n");
      out.write("    \t      \r\n");
      out.write("    \t      if(typeAccepted && fileSize > maxFileSize){\r\n");
      out.write("    \t    \t  errorMessage += fileName+\"的文件大小超出了50M限制！\";\r\n");
      out.write("    \t    \t  allowUpload = false;\r\n");
      out.write("    \t      }\r\n");
      out.write("    \t }\r\n");
      out.write("    \t \r\n");
      out.write("    \t if(allowUpload != true){\r\n");
      out.write("    \t\t el.outerHTML = el.outerHTML; //清空选择的文件\r\n");
      out.write("    \t\t alert(errorMessage);\r\n");
      out.write("    \t }\r\n");
      out.write("     }\r\n");
      out.write("     \r\n");
      out.write("     function checkForm(){\r\n");
      out.write("    \t if(document.getElementById(\"file1\").value == \"\"){\r\n");
      out.write("    \t\t alert(\"请选择要上传的文件！\");\r\n");
      out.write("    \t\t return false;\r\n");
      out.write("    \t }\r\n");
      out.write("    \t return true;\r\n");
      out.write("     }\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/mutilpartfile/upload\" method=\"post\" enctype=\"multipart/form-data\" onsubmit=\"return checkForm();\">\r\n");
      out.write("        <input type=\"file\" name=\"file1\" id=\"file1\" multiple=\"multiple\" onchange=\"checkFile(this)\"/> <br>\r\n");
      out.write("        <input type=\"submit\" value=\"提交\"/>\r\n");
      out.write("   </form>\r\n");
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
