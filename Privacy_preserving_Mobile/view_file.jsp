<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="com.supportclass.*"%>
     <%@page import="java.util.*"%>
     <%@page import="com.dao.*"%>
     <%@page import="com.user.action.*"%>
      <%@page import="java.io.*" %>
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>upload File</title>

</head>

<%

String catName = request.getParameter("catName");

//session.setAttribute("CNM", catName);
String no1 = request.getParameter("no");

String fileName = request.getParameter("fnm");





String fn=request.getParameter("clusterid");









if(no1.equals("0"))
{

//ArrayList<String> s = UserDAO.getKeywords();




%>
<body background="<%=request.getContextPath()%>/Images/back4.jpg">

<form name="m_user" method="post" action="#" onsubmit="return checkFormValidator()"  enctype="multipart/form-data" >

<center>
	<div align="left" style="position: absolute;top: 40px;left:100px;">
	  <table border="0" width="100%">
		<tr>
		  <td width="50%">
			<p align="center"><b><font color=#000 size="5" >File Status</font></b></td>
		</tr>
	  </table>
	</div>
	<div align="center">
	  <center>
	  <br>
	  <table align="center"  width="500px" style="position: absolute;top: 80px;left:100px;color: #000;font-size: 25px;">
	  
	  				<tr><td>&nbsp;</td></tr>
			     	<tr>
			     		<td colspan="1" ><%=fileName+" is Belongs to "+"<font>"+catName%></td>
			     	</tr>
			     	
			     
			     	
	  </table>
	  
	  </center>
	</div>
	</center>
</form>
<br>








<%


if(catName.equals("Sensitive"))
{
	
	%>
	
	<script>

	var x;
	
	
	
    if (confirm("These File Contains Sensistive Data it Encrypt and Split the file into blocks and uploaded to cloud ?") == true)
     {
        x = "YES";
        
        window.location.href = "view_file.jsp?no="+7+"&x="+x;
    } 
    else {
        x = "NO";
        window.location.href = "view_file.jsp?no="+7+"&x="+x;
    }
	</script>
	<%
}
else if(catName.equals("Nonsensitive"))
{
	
	%>
	<script type="text/javascript">
	alert("File is Nonsensitive and id is Splitted in to block uploaded to cloud Sucessfully...")
	</script>
	<%
	
	
	
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
	%>
	<script type="text/javascript">
	alert("File is Splitted in to block uploaded to cloud Sucessfully...")
	</script>
	<%
}
%>



<%
	if(Utility.parse(request.getParameter("no"))==1)
    {%>
    	<script type="text/javascript">
    	alert("New Keywords updated Successfully")
    	</script>			
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