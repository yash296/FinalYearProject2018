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
String fid = request.getParameter("fid");

System.out.println("File Id :"+fid);
ResultSet list = (ResultSet)request.getAttribute("rs");

String no1 = request.getParameter("no1");


if(Integer.parseInt(no1)==0)
{

%>	
</head>
<body onload="startTimer()">


<form action="<%=request.getContextPath()%>/DisplayTag_Content" method="post">
<div style="position: absolute;top: 20px;left:400px;">			
	
	<input type="hidden" name="fid" value="<%=fid%>">
		<input type="submit" name="submit" value="Child Tag" ><br>
		</br>
		<input type="submit" name="submit" value="View Content" >
	</div>
			
				
				
				
					<table id="login" align="center" border="1" width="500px" style="position: absolute;top: 100px;left:50px;">
					<tr>
			     			<td colspan="7" align="center"><font style="font-family:cursive;font-size: 20px;color: black;"><b>Parent Tag Details</b></font></td>
			     	</tr>
			     	
			     
			     	<tr>
			     	<th colspan="1" align="center">Select</th>
			     		<th colspan="1" align="center">Parent Tag</th>
			     		<th  colspan="1" align="center">No Of Times</th>
			     		<th  colspan="1" align="center">File Name </th>
			     		
			     		
			     	</tr>
			     	
			     
			     	<%
			     	if(list!=null)
			     	while(list.next())
			     	{
			     	%>
			     	
			     	<tr>
			     		
			     		
			     		<td align="center">
			     			<input type="checkbox" name="pid" value="<%=list.getString(1)%>" readonly="readonly">
			     		</td>
			     		
			     		<td >
			     			<%=list.getString(2)%>
			     		</td>
			     		<td >
			     			<%=list.getString(3)%>
			     		</td>
			     		
			     		<td >
			     			<%=list.getString(4)%>
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
    
    </div>
					
					<%
int no=Utility.parse(request.getParameter("no"));
if(no==1)
{
	%>
		<div class="error" id="message" style="position: absolute;top: 10px;color:red;font-size: 20px;">	
			<p>Something wrong</p>
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

<%
}
if(Integer.parseInt(no1)==1)
{

%>	
</head>
<body onload="startTimer()">


<form action="<%=request.getContextPath()%>/DisplayTag_Content" method="post">

			
				
				
				
					<table id="login" align="center" border="1" width="500px" style="position: absolute;top: 100px;left:50px;">
					<tr>
			     			<td colspan="7" align="center"><font style="font-family:cursive;font-size: 20px;color: black;"><b>Child Tag Details</b></font></td>
			     	</tr>
			     	
			     
			     	<tr>
			     		<th colspan="1" align="center">Child Tag</th>
			     		<th colspan="1" align="center">Parent Id</th>
			     		<th  colspan="1" align="center">No Of Times</th>
			     		<th  colspan="1" align="center">File Name </th>
			     		
			     		
			     	</tr>
			     	
			     
			     	<%
			     	if(list!=null)
			     	while(list.next())
			     	{
			     	%>
			     	
			     	<tr>
			     		
			     		
			     		<td align="center">
			     			<%=list.getString(1)%>
			     		</td>
			     		
			     		<td >
			     			<%=list.getString(2)%>
			     		</td>
			     		
			     		<td >
			     			<%=list.getString(3)%>
			     		</td>
			     		<td >
			     			<%=list.getString(4)%>
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
			<p>Something wrong</p>
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

<%
}
if(Integer.parseInt(no1)==2)
{

%>	
</head>
<body onload="startTimer()">


<form action="<%=request.getContextPath()%>/DisplayTag_Content" method="post">

			
				
				
				
					<table id="login" align="center" border="1" width="500px" style="position: absolute;top: 100px;left:50px;">
					<tr>
			     			<td colspan="7" align="center"><font style="font-family:cursive;font-size: 20px;color: black;"><b>Keyword Details</b></font></td>
			     	</tr>
			     	
			     
			     	<tr>
			     		<th colspan="1" align="center">Content</th>
			     		<th colspan="1" align="center">Parent Id</th>
			     		<th  colspan="1" align="center">No Of Times</th>
			     		<th  colspan="1" align="center">File Name </th>
			     		
			     		
			     	</tr>
			     	
			     
			     	<%
			     	if(list!=null)
			     	while(list.next())
			     	{
			     	%>
			     	
			     	<tr>
			     		
			     		
			     		<td align="center">
			     			<%=list.getString(1)%>
			     		</td>
			     		
			     		<td >
			     			<%=list.getString(2)%>
			     		</td>
			     		
			     		<td >
			     			<%=list.getString(3)%>
			     		</td>
			     		<td >
			     			<%=list.getString(4)%>
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
    
    </div>
					
					<%
int no=Utility.parse(request.getParameter("no"));
if(no==1)
{
	%>
		<div class="error" id="message" style="position: absolute;top: 10px;color:red;font-size: 20px;">	
			<p>Something wrong</p>
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

<%
}
%>
		
</body>
</html>