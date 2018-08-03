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
String difference = request.getAttribute("Diff").toString();

System.out.println("difference :"+difference);

ResultSet list = (ResultSet)request.getAttribute("rs");

String no1 = request.getParameter("no1");


if(Integer.parseInt(no1)==0)
{

%>	
</head>
<body onload="startTimer()">


<form action="<%=request.getContextPath()%>/DisplayTag_Content" method="post">
<div style="position: absolute;top: 20px;left:200px;">			
	
		
		<input type="submit" name="submit" value="View Child Tag" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="View Content Elements" >
		<br>
		
		<input type="submit" name="submit" value="View Structure Vector" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="View Content Vector" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="Final Category" >
		
	</div>
			
				
				
				
					<table id="login" align="center" border="1" width="500px" style="position: absolute;top: 100px;left:50px;">
					<tr>
			     			<td colspan="7" align="center"><font style="font-family:cursive;font-size: 20px;color: black;"><b>Parent Structure Details</b></font></td>
			     	</tr>
			     
			     	<tr>
			     	
			     		<th colspan="1" align="center">Parent Tag</th>
			     		<th  colspan="1" align="center">No Of Times</th>
			     		<th  colspan="1" align="center">File Name </th>
			     		<th  colspan="1" align="center">Weightage </th>
			     		
			     		
			     	</tr>
			     	
			     
			     	<%
			     	if(list!=null)
			     	while(list.next())
			     	{
			     	%>
			     	
			     	<tr>
			     		
			     		<td >
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
					<div style="position:absolute;top:450px;left:10px"><b>Time Taken for Preprocessing <%=difference%> secs</b></div>
					<div id="pageNavPosition" style="position:absolute;top:450px;left:450px"></div>
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
if(Integer.parseInt(no1)==1)
{

%>	
</head>
<body onload="startTimer()">


<form action="<%=request.getContextPath()%>/DisplayTag_Content" method="post">

			
				<input type="submit" name="submit" value="View Child Tag" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="View Content Elements" >
		<br>
		
		<input type="submit" name="submit" value="View Structure Vector" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="View Content Vector" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="Final Category" >
				
				
					<table id="login" align="center" border="1" width="500px" style="position: absolute;top: 100px;left:50px;">
					<tr>
			     			<td colspan="7" align="center"><font style="font-family:cursive;font-size: 20px;color: black;"><b>Child Structure Details</b></font></td>
			     	</tr>
			     	
			     
			     	<tr>
			     		<th colspan="1" align="center">Child Tag</th>
			     		<th colspan="1" align="center">Parent Id</th>
			     		<th  colspan="1" align="center">No Of Times</th>
			     		<th  colspan="1" align="center">File Name </th>
			     		<th  colspan="1" align="center">Weightage </th>
			     		
			     		
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
			     		<td >
			     			<%=list.getString(5)%>
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

			
				<input type="submit" name="submit" value="View Child Tag" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="View Content Elements" >
		<br>
		
		<input type="submit" name="submit" value="View Structure Vector" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="View Content Vector" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="Final Category" >
				
				
					<table id="login" align="center" border="1" width="500px" style="position: absolute;top: 100px;left:50px;">
					<tr>
			     			<td colspan="7" align="center"><font style="font-family:cursive;font-size: 20px;color: black;"><b>Content Element Details</b></font></td>
			     	</tr>
			     	
			     
			     	<tr>
			     		<th colspan="1" align="center">Content</th>
			     		<th colspan="1" align="center">Parent Id</th>
			     		<th  colspan="1" align="center">No Of Times</th>
			     		<th  colspan="1" align="center">File Name</th>
			     		<th  colspan="1" align="center">Weightage</th>
			     		
			     		
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
			     		<td >
			     			<%=list.getString(5)%>
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
if(Integer.parseInt(no1)==3)
{

%>	
</head>
<body onload="startTimer()">


<form action="<%=request.getContextPath()%>/DisplayTag_Content" method="post">

			
				<input type="submit" name="submit" value="View Child Tag" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="View Content Elements" >
		<br>
		
		<input type="submit" name="submit" value="View Structure Vector" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="View Content Vector" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="Final Category" >
				
				
					<table id="login" align="center" border="1" width="500px" style="position: absolute;top: 100px;left:50px;">
					<tr>
			     			<td colspan="7" align="center"><font style="font-family:cursive;font-size: 20px;color: black;"><b>Structure Vector Details</b></font></td>
			     	</tr>
			     	
			     
			     	<tr>
			     		<th colspan="1" align="center">File Name</th>
			     		<th colspan="1" align="center">Vector Value</th>
			     		
			     		
			     		
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
if(Integer.parseInt(no1)==4)
{

%>	
</head>
<body onload="startTimer()">


<form action="<%=request.getContextPath()%>/DisplayTag_Content" method="post">

			
				<input type="submit" name="submit" value="View Child Tag" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="View Content Elements" >
		<br>
		
		<input type="submit" name="submit" value="View Structure Vector" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="View Content Vector" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="Final Category" >
				
				
					<table id="login" align="center" border="1" width="500px" style="position: absolute;top: 100px;left:50px;">
					<tr>
			     			<td colspan="7" align="center"><font style="font-family:cursive;font-size: 20px;color: black;"><b>Content Vector Details</b></font></td>
			     	</tr>
			     	
			     
			     	<tr>
			     		<th colspan="1" align="center">File Name</th>
			     		<th colspan="1" align="center">Vector Value</th>
			     		
			     		
			     		
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
if(Integer.parseInt(no1)==5)
{

%>	
</head>
<body onload="startTimer()">


<form action="<%=request.getContextPath()%>/DisplayTag_Content" method="post">

			<input type="submit" name="submit" value="View Child Tag" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="View Content Elements" >
		<br>
		
		<input type="submit" name="submit" value="View Structure Vector" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="View Content Vector" >&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="Final Category" >
				
				
				
					<table id="login" align="center" border="1" width="500px" style="position: absolute;top: 100px;left:50px;">
					<tr>
			     			<td colspan="7" align="center"><font style="font-family:cursive;font-size: 20px;color: black;"><b>Final Classification Details</b></font></td>
			     	</tr>
			     	
			     
			     	<tr>
			     		<th colspan="1" align="center">File Name</th>
			     		<th colspan="1" align="center">Classification</th>
			     		
			     		
			     		
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