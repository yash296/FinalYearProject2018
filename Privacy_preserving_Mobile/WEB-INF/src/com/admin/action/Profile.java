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
import javax.servlet.http.HttpSession;

import com.dao.AdminDAO;
import com.dao.UserDAO;





public class Profile extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		try
		{
			HttpSession s = request.getSession();
			String id = s.getAttribute("adminid").toString();
			
			System.out.println("Admin Id:"+id);
			
			ResultSet rs=AdminDAO.getProfile(id);
			
			if(rs.next())
			{
				
				rs=AdminDAO.getProfile(id);
				
				request.setAttribute("rs",rs);
				request.setAttribute("admin", id);
				
				RequestDispatcher rd=request.getRequestDispatcher("/Files/jsp/admin/profile.jsp?no=0");
				rd.forward(request, response);
			}
			else
				response.sendRedirect(request.getContextPath()+"/Files/jsp/admin/profile.jsp?no=1");
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in UserProfile Servlet......"+e);
			out.println("Opps's Error is in AdminProfile Servlet......"+e);
		}
	}
}
