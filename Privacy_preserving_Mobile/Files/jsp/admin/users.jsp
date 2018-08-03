<%@page language="java" import="java.sql.*,com.dao.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>UserList</title>
</head>
<body onload="startTimer()">
<%!
Connection connection=null;
Statement statement=null;
ResultSet resultset=null;
String uid="";
String name="";
String email="";
String phone="";
%>

<%
DAO dao=DAO.getInstance();
connection=dao.connector();
statement = connection.createStatement();
resultset = statement.executeQuery("select * from m_user");
%>
<center><h2>All the User Details</h2></center>
<table align="center" border="1" width="80%">
	<tr>
	<td width="26%">
	<p align="center"><font size="4"><b>User_Id</b></font></p>
	</td>
	<td width="27%">
	<p align="center"><font size="4">&nbsp;<b>User Name</b></font></p>
	</td>
	<td width="26%">
	<p align="center"><font size="4">&nbsp;<b>User_Email</b></font></p>
	</td>
	<td width="26%">
	<p align="center"><font size="4">&nbsp;<b>Phone Number</b></font></p>
	</td>
	
</tr>
	<%
	int count=0;
	while(resultset.next())
	{
	    uid=resultset.getString(2);
		name=resultset.getString(4);
		email=resultset.getString(5);
		phone=resultset.getString(6);
		
		%>
	<tr>
	<td width="26%" align="center" ><%=uid%></td>		
	<td width="27%" align="center" ><%=name%></td>
	<td width="26%" align="center" ><%=email%></td>
	<td width="26%" align="center" ><%=phone%></td>
	</tr>
	<%
	}
	%>
</table>
</body>
</html>