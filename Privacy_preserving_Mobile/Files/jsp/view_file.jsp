<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="com.supportclass.*"%>
     <%@page import="java.util.*"%>
     <%@page import="com.dao.*"%>
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>upload File</title>

</head>

<%

String catName = request.getParameter("catName");

String fileName = request.getParameter("fnm");

/* ArrayList<String> s = UserDAO.getKeywords(); */

%>
<body background="<%=request.getContextPath()%>/Images/back4.jpg">

<form name="m_user" method="post" action="<%=request.getContextPath()%>/UploadFile" onsubmit="return checkFormValidator()"  enctype="multipart/form-data" >

<center>
	<div align="left" style="position: absolute;top: 40px;left:100px;">
	  <table border="0" width="100%">
		<tr>
		  <td width="50%">
			<p align="center"><b><font color=#993333 size="5" >File Status</font></b></td>
		</tr>
	  </table>
	</div>
	<div align="center">
	  <center>
	  <br>
	  <table align="center"  width="500px" style="position: absolute;top: 80px;left:100px;color: #FFF;font-size: 25px;">
	  
	  				<tr><td>&nbsp;</td></tr>
			     	<tr>
			     		<td colspan="1" ><%=fileName+" is Belongs to "+"<font>"+catName%></td>
			     	</tr>
			     	
	  </table>
	  
	  </center>
	</div>
	</center>
<center>
<br>
<%-- <%
if(s.size()!=0)
{
	%>
	
	<script>

    var x;
    if (confirm("These keywords are more than 7 times used in this file") == true)
     {
        x = "OK";
        window.location.href = "view_file.jsp?no="+3+"&x="+x;
    } 
    else {
        x = "Cancel";
        window.location.href = "view_file.jsp?no="+3+"&x="+x;
    }

	</script>
	<%
}
%> --%>
<%
	if(Utility.parse(request.getParameter("no"))==3)
	{
		//System.out.println("xvxv");
		String val = request.getParameter("x");
		
		//String user = session.getAttribute("userid").toString();
		
		//System.out.println("xvxv   cxbcv cxbvcb :"+val+"User Id :"+user);
		
		if(val.trim().equals("OK"))
		{
			
			//System.out.println("xvxv");
			
		}
		else
		{
			
			
		}
		
	%>
	
	
	  
	<%
}
%>
</center>
</form>
<%
	if(Utility.parse(request.getParameter("no"))==1)
    {%>
    	<div class="success" id="message" style="position:absolute;top:-10px;font-size: 20px;color:#994c00;font-family: monotype corsiva;">	
    		<p>Preprocessed Completed Successfully.....!</p>
    	</div>			
    <%}
	if(Utility.parse(request.getParameter("no"))==2)
	{%>
		<div class="success" id="message" style="position:absolute;top:-10px;font-size: 20px;color: #994c00;font-family: monotype corsiva;">	
			<p>Opp's something went wrong.....!</p>
		</div>			
	<%
	}
	if(Utility.parse(request.getParameter("no"))==3)
	{%>
		<div class="success" id="message" style="position:absolute;top:-10px;font-size: 20px;color: #994c00;font-family: monotype corsiva;">	
			<p>File Already Exist.....!</p>
		</div>			
	<%
	}
	if(Utility.parse(request.getParameter("no"))==5)
	{%>
	<script type="text/javascript">
	alert("This File is not Belongs to Any Category")
	</script>
				
	<%
	}
	%>


</body>
</html>