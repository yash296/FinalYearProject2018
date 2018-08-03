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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("    <title>Privacy Preserving Cloud Computing</title>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap Core CSS -->\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom CSS -->\n");
      out.write("    <link href=\"css/business-casual.css\" rel=\"stylesheet\">\n");
      out.write("\t\n");
      out.write("    <!-- Fonts -->\n");
      out.write("    <!-- <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800\" rel=\"stylesheet\" type=\"text/css\"> -->\n");
      out.write("    <link href=\"css/font_style1.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\n");
      out.write("   <script src=\"");
      out.print(request.getContextPath());
      out.write("/jquery.toastmessage.js\" type=\"text/javascript\"></script>\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath());
      out.write("/jquery.toastmessage.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("\t  var _gaq = _gaq || [];\n");
      out.write("\t  _gaq.push(['_setAccount', 'UA-29231762-1']);\n");
      out.write("\t  _gaq.push(['_setDomainName', 'dzyngiri.com']);\n");
      out.write("\t  _gaq.push(['_trackPageview']);\n");
      out.write("\t\n");
      out.write("\t  (function() {\n");
      out.write("\t\tvar ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;\n");
      out.write("\t\tga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';\n");
      out.write("\t\tvar s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);\n");
      out.write("\t  })();\n");
      out.write("\t</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--Stylesheets-->\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<link href=\"css/dzyngiri.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("<link href=\"fonts/pacifico/stylesheet.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("\n");
      out.write("<!--Scripts-->\n");
      out.write("<script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js\"></script>\n");
      out.write("<!--Sliding icons-->\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("$(document).ready(function() {\n");
      out.write("\t$(\".username\").focus(function() {\n");
      out.write("\t\t$(\".user-icon\").css(\"left\",\"-48px\");\n");
      out.write("\t});\n");
      out.write("\t$(\".username\").blur(function() {\n");
      out.write("\t\t$(\".user-icon\").css(\"left\",\"0px\");\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t$(\".password\").focus(function() {\n");
      out.write("\t\t$(\".pass-icon\").css(\"left\",\"-48px\");\n");
      out.write("\t});\n");
      out.write("\t$(\".password\").blur(function() {\n");
      out.write("\t\t$(\".pass-icon\").css(\"left\",\"0px\");\n");
      out.write("\t});\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div class=\"brand\">Privacy-Preserving Data Encryption Strategy</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"box\">\n");
      out.write("                <div class=\"col-lg-12 text-center\">\n");
      out.write("                    <div id=\"carousel-example-generic\" class=\"carousel slide\">\n");
      out.write("                       \n");
      out.write("                        \n");
      out.write("     <h2 class=\"brand-before\">\n");
      out.write("                        <small>Welcome to</small>\n");
      out.write("     </h2>                    \n");
      out.write(" \n");
      out.write("<form name=\"login-form\" class=\"login-form\" action=\"");
      out.print(request.getContextPath());
      out.write("/UserLogin\" method=\"post\">\n");
      out.write("\n");
      out.write("\t<!--Header-->\n");
      out.write("    <div class=\"header\">\n");
      out.write("    <h1>User Login Form</h1>\n");
      out.write("    \n");
      out.write("    </div>\n");
      out.write("    <!--END header-->\n");
      out.write("\t\n");
      out.write("\t<!--Input fields-->\n");
      out.write("    <div class=\"content\">\n");
      out.write("\t<!--USERNAME--><input name=\"userid\" type=\"text\" class=\"input username\" placeholder=\"UserId\" /><!--END USERNAME-->\n");
      out.write("    <!--PASSWORD--><input name=\"password\" type=\"password\" class=\"input password\" placeholder=\"Password\" /><!--END PASSWORD-->\n");
      out.write("    </div>\n");
      out.write("    <!--END Input fields-->\n");
      out.write("    \n");
      out.write("    <!--Buttons-->\n");
      out.write("    <div class=\"footer\">\n");
      out.write("    <!--Login button--><a href=\"");
      out.print(request.getContextPath());
      out.write("/Files/jsp/admin/Login.jsp\">Admin Login</a><!--END Login button-->\n");
      out.write("    <!--Login button--><input type=\"submit\" name=\"submit\" value=\"User\" class=\"button\" /><!--END Login button-->\n");
      out.write("    \n");
      out.write("    <!--Register button--><input type=\"submit\" name=\"submit\" value=\"Register\" class=\"register\" /><!--END Register button-->\n");
      out.write("    </div>\n");
      out.write("    <!--END Buttons-->\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("<!--end login form-->\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("                        \n");
      out.write("</div>\n");
      out.write("                   \n");
      out.write("                    \n");
      out.write("                   \n");
      out.write("                   \n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("      \n");
      out.write("\n");
      out.write("      \n");
      out.write("    </div>\n");
      out.write("   \n");
      out.write("    <!-- jQuery -->\n");
      out.write("    <script src=\"js/jquery.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap Core JavaScript -->\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Script to Activate the Carousel -->\n");
      out.write("    <script>\n");
      out.write("    $('.carousel').carousel({\n");
      out.write("        interval: 5000 //changes the speed\n");
      out.write("    })\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
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
