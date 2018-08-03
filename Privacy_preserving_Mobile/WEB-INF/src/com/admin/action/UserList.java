/**
 * 
 */
package com.admin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserList extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		ResultSet rs=null;
		try
		{
			String submit=request.getParameter("submit");
			RequestDispatcher rd=null;
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("Files/jsp/admin/users.jsp");
				rd.forward(request, response);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin UserList Servlet......"+e);
			out.println("Opps's Error is in Admin UserList Servlet......"+e);
		}
	}
}
