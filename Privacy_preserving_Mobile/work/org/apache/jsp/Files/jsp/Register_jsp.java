package org.apache.jsp.Files.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.supportclass.*;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write(" \r\n");
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
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom CSS -->\r\n");
      out.write("    <link href=\"css/business-casual.css\" rel=\"stylesheet\">\r\n");
      out.write("\t\r\n");
      out.write("    <!-- Fonts -->\r\n");
      out.write("    <!-- <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800\" rel=\"stylesheet\" type=\"text/css\"> -->\r\n");
      out.write("    <link href=\"css/font_style1.css\" rel=\"stylesheet\">\r\n");
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
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"css/dzyngiri.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link href=\"fonts/pacifico/stylesheet.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
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
      out.write("<style type=\"text/css\">\r\n");
      out.write("    #wrapper \r\n");
      out.write("    {\r\n");
      out.write("        width:350px;\r\n");
      out.write("        margin:0 auto;\r\n");
      out.write("        font-family:Verdana, sans-serif;\r\n");
      out.write("        top: 150px;\r\n");
      out.write("        position: absolute;\r\n");
      out.write("        left: 250px;\r\n");
      out.write("    }\r\n");
      out.write("    legend {\r\n");
      out.write("        color:#994c00;\r\n");
      out.write("        font-size:16px;\r\n");
      out.write("        padding:0 10px;\r\n");
      out.write("        background:#fff;\r\n");
      out.write("        -moz-border-radius:4px;\r\n");
      out.write("        box-shadow: 0 1px 5px rgba(4, 129, 177, 0.5);\r\n");
      out.write("        padding:5px 10px;\r\n");
      out.write("        text-transform:uppercase;\r\n");
      out.write("        font-family:Helvetica, sans-serif;\r\n");
      out.write("        font-weight:bold;\r\n");
      out.write("    }\r\n");
      out.write("    fieldset {\r\n");
      out.write("        border-radius:4px;\r\n");
      out.write("        background: #fff; \r\n");
      out.write("        background: -moz-linear-gradient(#fff, #f9fdff);\r\n");
      out.write("        background: -o-linear-gradient(#fff, #f9fdff);\r\n");
      out.write("        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#fff), to(#f9fdff)); /\r\n");
      out.write("        background: -webkit-linear-gradient(#fff, #f9fdff);\r\n");
      out.write("        padding:20px;\r\n");
      out.write("        border-color:#336600;\r\n");
      out.write("    }\r\n");
      out.write("    input,\r\n");
      out.write("    textarea {\r\n");
      out.write("        color: #CC6633;\r\n");
      out.write("        background: #fff;\r\n");
      out.write("        border: 1px solid #CCCCCC;\r\n");
      out.write("        color: #aaa;\r\n");
      out.write("        font-size: 14px;\r\n");
      out.write("        line-height: 1.2em;\r\n");
      out.write("        margin-bottom:15px;\r\n");
      out.write("\r\n");
      out.write("        -moz-border-radius:4px;\r\n");
      out.write("        -webkit-border-radius:4px;\r\n");
      out.write("        border-radius:4px;\r\n");
      out.write("        box-shadow: 0 1px 2px rgba(0, 0, 0, 0.1) inset, 0 1px 0 rgba(255, 255, 255, 0.2);\r\n");
      out.write("    }\r\n");
      out.write("    input[type=\"text\"],\r\n");
      out.write("    input[type=\"password\"]{\r\n");
      out.write("        padding: 8px 6px;\r\n");
      out.write("        height: 22px;\r\n");
      out.write("        width:280px;\r\n");
      out.write("    }\r\n");
      out.write("    input[type=\"text\"]:focus,\r\n");
      out.write("    input[type=\"password\"]:focus {\r\n");
      out.write("        background:#fff;\r\n");
      out.write("        text-indent: 0;\r\n");
      out.write("        z-index: 1;\r\n");
      out.write("        color: #000;\r\n");
      out.write("        -webkit-transition-duration: 400ms;\r\n");
      out.write("        -webkit-transition-property: width, background;\r\n");
      out.write("        -webkit-transition-timing-function: ease;\r\n");
      out.write("        -moz-transition-duration: 400ms;\r\n");
      out.write("        -moz-transition-property: width, background;\r\n");
      out.write("        -moz-transition-timing-function: ease;\r\n");
      out.write("        -o-transition-duration: 400ms;\r\n");
      out.write("        -o-transition-property: width, background;\r\n");
      out.write("        -o-transition-timing-function: ease;\r\n");
      out.write("        width: 280px;\r\n");
      out.write("        \r\n");
      out.write("        border-color:#CC6633;\r\n");
      out.write("        box-shadow:#CC6633;\r\n");
      out.write("        opacity:0.6;\r\n");
      out.write("    }\r\n");
      out.write("    input[type=\"submit\"]{\r\n");
      out.write("        background: #994c00;\r\n");
      out.write("        border: none;\r\n");
      out.write("        text-shadow: 0 -1px 0 rgba(0,0,0,0.3);\r\n");
      out.write("        text-transform:uppercase;\r\n");
      out.write("        color: #eee;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("        font-size: 15px;\r\n");
      out.write("        margin: 10px 80px;\r\n");
      out.write("        padding: 5px 22px ;\r\n");
      out.write("        -moz-border-radius: 4px;\r\n");
      out.write("        border-radius: 4px;\r\n");
      out.write("        -webkit-border-radius:4px;\r\n");
      out.write("        -webkit-box-shadow: 0px 1px 2px rgba(0,0,0,0.3);\r\n");
      out.write("        -moz-box-shadow: 0px 1px 2px rgba(0,0,0,0.3);\r\n");
      out.write("        box-shadow: 0px 1px 2px rgba(0,0,0,0.3);\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("    }\r\n");
      out.write("   \r\n");
      out.write("    .small {\r\n");
      out.write("        line-height:14px;\r\n");
      out.write("        font-size:12px;\r\n");
      out.write("        color:#999898;\r\n");
      out.write("        margin-bottom:3px;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
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
      out.write("\r\n");
      out.write("        <form action=\"");
      out.print(request.getContextPath());
      out.write("/NewUser\" class=\"login-form\" method=\"post\">\r\n");
      out.write("            <fieldset>\r\n");
      out.write("                <legend>User Register</legend>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <input type=\"text\" name=\"loginid\" placeholder=\"Login ID\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <input type=\"text\" name=\"name\" placeholder=\"Name\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <input type=\"password\" name=\"pass\" placeholder=\"Password\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div>\r\n");
      out.write("                    <input type=\"text\" name=\"email\" placeholder=\"Email\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                 <div>\r\n");
      out.write("                    <input type=\"text\" name=\"phone\" placeholder=\"Phone Number\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <input type=\"submit\" name=\"submit\" value=\"Register\"/>\r\n");
      out.write("            </fieldset>    \r\n");
      out.write("        </form>\r\n");
      out.write("    ");
	
		int no=Utility.parse(request.getParameter("no"));
		if(no==1)
		{
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div  style=\"position: absolute;top: 500px;left: 300px;color: #336633;font-size: 20px; \">\t\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t $().toastmessage('showErrorToast', \"UserId Already Exist ..!\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</script></div>\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t");

		}
		
      out.write("\r\n");
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
      out.write("    <script src=\"js/jquery.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap Core JavaScript -->\r\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\r\n");
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
