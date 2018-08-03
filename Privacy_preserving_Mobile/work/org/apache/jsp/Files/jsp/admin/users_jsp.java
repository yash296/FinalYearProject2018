package org.apache.jsp.Files.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.dao.*;

public final class users_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


Connection connection=null;
Statement statement=null;
ResultSet resultset=null;
String uid="";
String name="";
String email="";
String phone="";

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
      out.write("    \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("\r\n");
      out.write("<title>UserList</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("\r\n");
      out.write("\r\n");

DAO dao=DAO.getInstance();
connection=dao.connector();
statement = connection.createStatement();
resultset = statement.executeQuery("select * from m_user");

      out.write("\r\n");
      out.write("<center><h2>All the User Details</h2></center>\r\n");
      out.write("<table align=\"center\" border=\"1\" width=\"80%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td width=\"26%\">\r\n");
      out.write("\t<p align=\"center\"><font size=\"4\"><b>User_Id</b></font></p>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t<td width=\"27%\">\r\n");
      out.write("\t<p align=\"center\"><font size=\"4\">&nbsp;<b>User Name</b></font></p>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t<td width=\"26%\">\r\n");
      out.write("\t<p align=\"center\"><font size=\"4\">&nbsp;<b>User_Email</b></font></p>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t<td width=\"26%\">\r\n");
      out.write("\t<p align=\"center\"><font size=\"4\">&nbsp;<b>Phone Number</b></font></p>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t\r\n");
      out.write("</tr>\r\n");
      out.write("\t");

	int count=0;
	while(resultset.next())
	{
	    uid=resultset.getString(2);
		name=resultset.getString(4);
		email=resultset.getString(5);
		phone=resultset.getString(6);
		
		
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td width=\"26%\" align=\"center\" >");
      out.print(uid);
      out.write("</td>\t\t\r\n");
      out.write("\t<td width=\"27%\" align=\"center\" >");
      out.print(name);
      out.write("</td>\r\n");
      out.write("\t<td width=\"26%\" align=\"center\" >");
      out.print(email);
      out.write("</td>\r\n");
      out.write("\t<td width=\"26%\" align=\"center\" >");
      out.print(phone);
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");

	}
	
      out.write("\r\n");
      out.write("</table>\r\n");
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
