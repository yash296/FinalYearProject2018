<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="com.supportclass.*"%>
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>upload File</title>
<style type="text/css">

.submit {
    background-color: #7a8fe2; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}


</style>
</head>
<body background="<%=request.getContextPath()%>/Images/back4.jpg">


<form name="m_user" method="post" action="<%=request.getContextPath()%>/UploadFile" onsubmit="return checkFormValidator()" method="post"  enctype="multipart/form-data" target="myframe" >

<center>
	<div align="left" style="position: absolute;top: 40px;left:100px;">
	  <table border="0" width="100%">
		<tr>
		  <td width="50%">
			<p align="center"><b><font color=#993333 size="5" >Upload File</font></b></td>
		</tr>
	  </table>
	</div>
	<div align="center">
	  <center>
	  <br>
	  <table align="center"  width="500px" style="position: absolute;top: 80px;left:100px;">
	  
	  				<tr><td>&nbsp;</td></tr>
			     	<tr>
			     		
			     		<td colspan="1" >Select File :</td>
			     		<td colspan="1"><input type="file" name="file" > </td>
			     		
			     	</tr>
			     	
			     	<tr><td>&nbsp;</td></tr>
			     	
			     	
		
	  </table>
	  </center>
	</div>
	</center>
<center>
<br>
<div style="position: absolute;top: 200px;left: 250px;">
 <input type="submit" value="Preprocess" onclick="return checkPassword()" class="submit"/></div>
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
		<div class="success" id="message" style="position:absolute;top:-10px;font-size: 20px;color: #994c00;font-family: monotype corsiva;">	
			<p>This File is not belongs to Particular Category!!!!</p>
		</div>			
	<%
	}
	%>


</body>
</html>