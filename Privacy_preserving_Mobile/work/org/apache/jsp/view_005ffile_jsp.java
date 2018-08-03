package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.supportclass.*;
import java.util.*;
import com.dao.*;
import com.user.action.*;
import java.io.*;

public final class view_005ffile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("     \r\n");
      out.write("     \r\n");
      out.write("     \r\n");
      out.write("      \r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>upload File</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");


String catName = request.getParameter("catName");

//session.setAttribute("CNM", catName);
String no1 = request.getParameter("no");

String fileName = request.getParameter("fnm");





String fn=request.getParameter("clusterid");









if(no1.equals("0"))
{

//ArrayList<String> s = UserDAO.getKeywords();





      out.write("\r\n");
      out.write("<body background=\"");
      out.print(request.getContextPath());
      out.write("/Images/back4.jpg\">\r\n");
      out.write("\r\n");
      out.write("<form name=\"m_user\" method=\"post\" action=\"#\" onsubmit=\"return checkFormValidator()\"  enctype=\"multipart/form-data\" >\r\n");
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("\t<div align=\"left\" style=\"position: absolute;top: 40px;left:100px;\">\r\n");
      out.write("\t  <table border=\"0\" width=\"100%\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t  <td width=\"50%\">\r\n");
      out.write("\t\t\t<p align=\"center\"><b><font color=#000 size=\"5\" >File Status</font></b></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t  </table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t  <center>\r\n");
      out.write("\t  <br>\r\n");
      out.write("\t  <table align=\"center\"  width=\"500px\" style=\"position: absolute;top: 80px;left:100px;color: #000;font-size: 25px;\">\r\n");
      out.write("\t  \r\n");
      out.write("\t  \t\t\t\t<tr><td>&nbsp;</td></tr>\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t<td colspan=\"1\" >");
      out.print(fileName+" is Belongs to "+"<font>"+catName);
      out.write("</td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t  </table>\r\n");
      out.write("\t  \r\n");
      out.write("\t  </center>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</center>\r\n");
      out.write("</form>\r\n");
      out.write("<br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");



if(catName.equals("Sensitive"))
{
	
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<script>\r\n");
      out.write("\r\n");
      out.write("\tvar x;\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("    if (confirm(\"These File Contains Sensistive Data it Encrypt and Split the file into blocks and uploaded to cloud ?\") == true)\r\n");
      out.write("     {\r\n");
      out.write("        x = \"YES\";\r\n");
      out.write("        \r\n");
      out.write("        window.location.href = \"view_file.jsp?no=\"+7+\"&x=\"+x;\r\n");
      out.write("    } \r\n");
      out.write("    else {\r\n");
      out.write("        x = \"NO\";\r\n");
      out.write("        window.location.href = \"view_file.jsp?no=\"+7+\"&x=\"+x;\r\n");
      out.write("    }\r\n");
      out.write("\t</script>\r\n");
      out.write("\t");

}
else if(catName.equals("Nonsensitive"))
{
	
	
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\talert(\"File is Nonsensitive and id is Splitted in to block uploaded to cloud Sucessfully...\")\r\n");
      out.write("\t</script>\r\n");
      out.write("\t");

	
	
	
}
	






}




if(no1.equals("7"))
{
	
	System.out.println("xvxv");
	String val = request.getParameter("x");
	
	RequestDispatcher rd=null;
	
	
	if(val.trim().equals("YES"))
	{
		
		
		
		String f_no=session.getAttribute("str").toString();
		String ffs = session.getAttribute("file").toString();
		String Fileblockpath = session.getAttribute("Fileblockpath").toString();
		String cs = session.getAttribute("sensitive").toString();
		
		
		int f_n=Integer.parseInt(f_no);
		
		Packet1.formPacket(ffs,cs,Fileblockpath,f_n);
		
		response.sendRedirect("view_file.jsp?no=9");
		
		
		
		
		
		
	}
	else
	{
		
		System.out.println("xvxv 1");
	}
		
}
if(no1.equals("9"))
{
	
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\talert(\"File is Splitted in to block uploaded to cloud Sucessfully...\")\r\n");
      out.write("\t</script>\r\n");
      out.write("\t");

}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	if(Utility.parse(request.getParameter("no"))==1)
    {
      out.write("\r\n");
      out.write("    \t<script type=\"text/javascript\">\r\n");
      out.write("    \talert(\"New Keywords updated Successfully\")\r\n");
      out.write("    \t</script>\t\t\t\r\n");
      out.write("    ");
}
	if(Utility.parse(request.getParameter("no"))==2)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:-10px;font-size: 20px;color: #994c00;font-family: monotype corsiva;\">\t\r\n");
      out.write("\t\t\t<p>Opp's something went wrong.....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");

	}
	if(Utility.parse(request.getParameter("no"))==3)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:-10px;font-size: 20px;color: #994c00;font-family: monotype corsiva;\">\t\r\n");
      out.write("\t\t\t<p>File Already Exist.....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");

	}
	if(Utility.parse(request.getParameter("no"))==5)
	{
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\talert(\"This File is not Belongs to Any Category\")\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t");

	}
	
      out.write("\r\n");
      out.write("\r\n");
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
