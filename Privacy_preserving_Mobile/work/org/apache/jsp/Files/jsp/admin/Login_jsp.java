package org.apache.jsp.Files.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("    <title>Privacy Preserving Cloud Computing</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap Core CSS -->\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath());
      out.write("/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom CSS -->\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath());
      out.write("/css/business-casual.css\" rel=\"stylesheet\">\r\n");
      out.write("\t\r\n");
      out.write("    <!-- Fonts -->\r\n");
      out.write("    <!-- <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800\" rel=\"stylesheet\" type=\"text/css\"> -->\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath());
      out.write("/css/font_style1.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("   <script src=\"");
      out.print(request.getContextPath());
      out.write("/jquery.toastmessage.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath());
      out.write("/jquery.toastmessage.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\t  var _gaq = _gaq || [];\r\n");
      out.write("\t  _gaq.push(['_setAccount', 'UA-29231762-1']);\r\n");
      out.write("\t  _gaq.push(['_setDomainName', 'dzyngiri.com']);\r\n");
      out.write("\t  _gaq.push(['_trackPageview']);\r\n");
      out.write("\t\r\n");
      out.write("\t  (function() {\r\n");
      out.write("\t\tvar ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;\r\n");
      out.write("\t\tga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';\r\n");
      out.write("\t\tvar s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);\r\n");
      out.write("\t  })();\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--Stylesheets-->\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/css/dzyngiri.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/fonts/pacifico/stylesheet.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<!--Scripts-->\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js\"></script>\r\n");
      out.write("<!--Sliding icons-->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("\t$(\".username\").focus(function() {\r\n");
      out.write("\t\t$(\".user-icon\").css(\"left\",\"-48px\");\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\".username\").blur(function() {\r\n");
      out.write("\t\t$(\".user-icon\").css(\"left\",\"0px\");\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(\".password\").focus(function() {\r\n");
      out.write("\t\t$(\".pass-icon\").css(\"left\",\"-48px\");\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\".password\").blur(function() {\r\n");
      out.write("\t\t$(\".pass-icon\").css(\"left\",\"0px\");\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"brand\">Privacy-Preserving Data Encryption Strategy</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"box\">\r\n");
      out.write("                <div class=\"col-lg-12 text-center\">\r\n");
      out.write("                    <div id=\"carousel-example-generic\" class=\"carousel slide\">\r\n");
      out.write("                       \r\n");
      out.write("                        \r\n");
      out.write("     <h2 class=\"brand-before\">\r\n");
      out.write("                        <small>Welcome to</small>\r\n");
      out.write("     </h2>                    \r\n");
      out.write(" \r\n");
      out.write("<form name=\"login-form\" class=\"login-form\" action=\"");
      out.print(request.getContextPath());
      out.write("/UserLogin\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("\t<!--Header-->\r\n");
      out.write("    <div class=\"header\">\r\n");
      out.write("    <h1>Admin Login Form</h1>\r\n");
      out.write("    \r\n");
      out.write("    </div>\r\n");
      out.write("    <!--END header-->\r\n");
      out.write("\t\r\n");
      out.write("\t<!--Input fields-->\r\n");
      out.write("    <div class=\"content\">\r\n");
      out.write("\t<!--USERNAME--><input name=\"userid\" type=\"text\" class=\"input username\" placeholder=\"UserId\" /><!--END USERNAME-->\r\n");
      out.write("    <!--PASSWORD--><input name=\"password\" type=\"password\" class=\"input password\" placeholder=\"Password\" /><!--END PASSWORD-->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--END Input fields-->\r\n");
      out.write("    \r\n");
      out.write("    <!--Buttons-->\r\n");
      out.write("    <div class=\"footer\">\r\n");
      out.write("    <!--Login button--><input type=\"submit\" name=\"submit\" value=\"Admin\" class=\"button\" /><!--END Login button-->\r\n");
      out.write("    <!--Login button--><a href=\"");
      out.print(request.getContextPath());
      out.write("/index.jsp\">User Login</a><!--END Login button-->\r\n");
      out.write("    \r\n");
      out.write("    <!--Register button--><input type=\"submit\" name=\"submit\" value=\"Register\" class=\"register\" /><!--END Register button-->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--END Buttons-->\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("<!--end login form-->\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("                        \r\n");
      out.write("</div>\r\n");
      out.write("                   \r\n");
      out.write("                    \r\n");
      out.write("                   \r\n");
      out.write("                   \r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("    </div>\r\n");
      out.write("   \r\n");
      out.write("    <!-- jQuery -->\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap Core JavaScript -->\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Script to Activate the Carousel -->\r\n");
      out.write("    <script>\r\n");
      out.write("    $('.carousel').carousel({\r\n");
      out.write("        interval: 5000 //changes the speed\r\n");
      out.write("    })\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
