package org.apache.jsp.Files.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dao.ClassifyDAO;
import java.sql.ResultSet;

public final class download_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
ResultSet rs=ClassifyDAO.filelist(); 
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write(".submit {\r\n");
      out.write("    background-color: #7a8fe2; /* Green */\r\n");
      out.write("    border: none;\r\n");
      out.write("    color: white;\r\n");
      out.write("    padding: 15px 32px;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("    font-size: 16px;\r\n");
      out.write("    margin: 4px 2px;\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write(".table-bordered {\r\n");
      out.write("border: 0px solid #dddddd;\r\n");
      out.write("border-collapse: separate;\r\n");
      out.write("border-left: 0;\r\n");
      out.write("-webkit-border-radius: 4px;\r\n");
      out.write("-moz-border-radius: 4px;\r\n");
      out.write("border-radius: 4px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".table {\r\n");
      out.write("width: 90%;\r\n");
      out.write("height: 100%;\r\n");
      out.write("margin-bottom: 20px;\r\n");
      out.write("background-color: transparent;\r\n");
      out.write("border-collapse: collapse;\r\n");
      out.write("border-spacing: 0;\r\n");
      out.write("display: table;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".widget.widget-table .table {\r\n");
      out.write("margin-bottom: 0;\r\n");
      out.write("border: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".widget.widget-table .widget-content {\r\n");
      out.write("padding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".widget .widget-header + .widget-content {\r\n");
      out.write("border-top: none;\r\n");
      out.write("-webkit-border-top-left-radius: 0;\r\n");
      out.write("-webkit-border-top-right-radius: 0;\r\n");
      out.write("-moz-border-radius-topleft: 0;\r\n");
      out.write("-moz-border-radius-topright: 0;\r\n");
      out.write("border-top-left-radius: 0;\r\n");
      out.write("border-top-right-radius: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".widget .widget-content {\r\n");
      out.write("padding: 20px 15px 15px;\r\n");
      out.write("background: #FFF;\r\n");
      out.write("border: 0px solid #D5D5D5;\r\n");
      out.write("-moz-border-radius: 5px;\r\n");
      out.write("-webkit-border-radius: 5px;\r\n");
      out.write("border-radius: 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".widget .widget-header {\r\n");
      out.write("position: relative;\r\n");
      out.write("height: 60px;\r\n");
      out.write("line-height: 40px;\r\n");
      out.write("background: #E9E9E9;\r\n");
      out.write("background: -moz-linear-gradient(top, #fafafa 0%, #e9e9e9 100%);\r\n");
      out.write("background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #fafafa), color-stop(100%, #e9e9e9));\r\n");
      out.write("background: -webkit-linear-gradient(top, #fafafa 0%, #e9e9e9 100%);\r\n");
      out.write("background: -o-linear-gradient(top, #fafafa 0%, #e9e9e9 100%);\r\n");
      out.write("background: -ms-linear-gradient(top, #fafafa 0%, #e9e9e9 100%);\r\n");
      out.write("background: linear-gradient(top, #fafafa 0%, #e9e9e9 100%);\r\n");
      out.write("text-shadow: 0 1px 0 #fff;\r\n");
      out.write("border-radius: 5px 5px 0 0;\r\n");
      out.write("box-shadow: 0 2px 5px rgba(0,0,0,0.1),inset 0 1px 0 white,inset 0 -1px 0 rgba(255,255,255,0.7);\r\n");
      out.write("border-bottom: 1px solid #bababa;\r\n");
      out.write("filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#FAFAFA', endColorstr='#E9E9E9');\r\n");
      out.write("-ms-filter: \"progid:DXImageTransform.Microsoft.gradient(startColorstr='#FAFAFA', endColorstr='#E9E9E9')\";\r\n");
      out.write("border: 1px solid #D5D5D5;\r\n");
      out.write("-webkit-border-top-left-radius: 4px;\r\n");
      out.write("-webkit-border-top-right-radius: 4px;\r\n");
      out.write("-moz-border-radius-topleft: 4px;\r\n");
      out.write("-moz-border-radius-topright: 4px;\r\n");
      out.write("border-top-left-radius: 4px;\r\n");
      out.write("border-top-right-radius: 4px;\r\n");
      out.write("-webkit-background-clip: padding-box;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("thead {\r\n");
      out.write("display: table-header-group;\r\n");
      out.write("vertical-align: middle;\r\n");
      out.write("border-color: inherit;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".widget .widget-header h3 {\r\n");
      out.write("top: 2px;\r\n");
      out.write("position: relative;\r\n");
      out.write("left: 10px;\r\n");
      out.write("display: inline-block;\r\n");
      out.write("margin-right: 3em;\r\n");
      out.write("font-size: 14px;\r\n");
      out.write("font-weight: 600;\r\n");
      out.write("color: #555;\r\n");
      out.write("line-height: 18px;\r\n");
      out.write("text-shadow: 1px 1px 2px rgba(255, 255, 255, 0.5);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".widget .widget-header [class^=\"icon-\"], .widget .widget-header [class*=\" icon-\"] {\r\n");
      out.write("display: inline-block;\r\n");
      out.write("margin-left: 13px;\r\n");
      out.write("margin-right: -2px;\r\n");
      out.write("font-size: 16px;\r\n");
      out.write("color: #555;\r\n");
      out.write("vertical-align: middle;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath() );
      out.write("/DownloadFile\">\r\n");
      out.write("\r\n");
      out.write("<input type=\"submit\" name=\"submit\" value=\"Download\" class=\"submit\" id=\"a1\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("<!--<input type=\"submit\" name=\"submit\" value=\"Delete\" class=\"button_example\" id=\"a1\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t--><table id=\"results\" class=\"table table-striped table-bordered\" style=\"width: 500 ; color: black\";>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>Select</th>\r\n");
      out.write("\t\t<th>Id</th>\r\n");
      out.write("\t\t<th>File Name</th>\r\n");
      out.write("\t\t<th>Date and Time</th>\r\n");
      out.write("\t\t<th>ClusterID</th>\r\n");
      out.write("\t\t<th>LBA</th>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t ");

	 int count=1;
	if(rs!=null)
		while(rs.next())
		{
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\">");
      out.print(count++ );
      out.write("&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<input name=\"chk\" type=\"checkbox\" value=\"");
      out.print(rs.getInt(1) );
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"center\">");
      out.print(rs.getInt(1) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td align=\"center\">");
      out.print(rs.getString(2) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td align=\"center\">");
      out.print(rs.getString(3) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td align=\"center\">");
      out.print(rs.getInt(4) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td align=\"center\">");
      out.print(rs.getString(5) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t");
}
	
      out.write(" \r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
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
