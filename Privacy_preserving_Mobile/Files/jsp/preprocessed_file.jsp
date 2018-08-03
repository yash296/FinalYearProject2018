<html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import="java.sql.*" %>
<%@ page import="com.supportclass.*" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.UserDAO"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>upload File</title>

<script type="text/javascript" src="<%=request.getContextPath() %>/js/style.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/pagination.js"></script>
<%
	
ResultSet list = UserDAO.selectFiles();

	

%>	
</head>
<body onload="startTimer()">

<form action="<%=request.getContextPath()%>/DisplayTag_Content" method="post" >
<div style="position: absolute;top: 20px;left:400px;">			
	
		<input type="submit" name="submit" value="View Tag and Content" >
	</div>
			
				
				
				
					<table id="login" align="center" border="1" width="500px" style="position: absolute;top: 100px;left:50px;">
					<tr>
			     			<td colspan="7" align="center"><font style="font-family:cursive;font-size: 20px;color: black;"><b>File Details</b></font></td>
			     	</tr>
			     	
			     
			     	<tr>
			     		<th colspan="1" align="center">Select</th>
			     		<th  colspan="1" align="center">File Name</th>
			     		<th  colspan="1" align="center">Date and Time </th>
			     		
			     		
			     	</tr>
			     	
			     
			     	<%
			     	if(list!=null)
			     	while(list.next())
			     	{
			     	%>
			     	
			     	<tr>
			     		<td align="center">
			     			<input name="chk" type="checkbox" value="<%=list.getInt(1)%>">
			     		</td>
			     		
			     		<td >
			     			<%=list.getString(2)%>
			     		</td>
			     		
			     		<td >
			     			<%=list.getString(3)%>
			     		</td>
			     		
			     		
			     		
			     	</tr>
			     	
			     	<%
			     	}
			     	list.close();
			     	 %>
			     	
			     	
			     	</table>
					
					</form>
					
					<div id="pageNavPosition" style="position:absolute;top:380px;left:450px"></div>
<script type="text/javascript"><!--
        var pager = new Pager('login',5); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>
				
					
					<%
int no=Utility.parse(request.getParameter("no"));
if(no==1)
{
	%>
		<div class="error" id="message" style="position: absolute;top: 10px;color:red;font-size: 20px;">	
			<p>Please Select atleast One Check box!</p>
		</div>
	<%
}
if(no==2)
{
	%>
		<div class="error" id="message" style="position: absolute;top: -10px;color:red;font-size: 20px;">	
			<p>Please Select Only one Check box!</p>
		</div>
	<%
}
%>
		
</body>
</html>