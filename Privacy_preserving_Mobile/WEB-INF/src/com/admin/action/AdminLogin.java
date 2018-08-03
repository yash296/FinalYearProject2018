package com.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAO;

public class AdminLogin 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		RequestDispatcher rd=null;
		String sunmit = request.getParameter("submit");
		if(sunmit.trim().equals("Admin"))
		{
			HttpSession s = request.getSession();
			
			String uid = request.getParameter("userid");
			
			String pass = request.getParameter("password");
			
			boolean f = AdminDAO.checkUser(uid,pass);
			
			if(f)
			{
				try
				{
				s.setAttribute("adminid", uid);
				rd = request.getRequestDispatcher("Files/jsp/admin/adminhome.jsp");
				rd.forward(request, response);
				
				}
				catch (ServletException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else
			{
				try
				{
				rd = request.getRequestDispatcher("index.jsp?no=1");
				rd.forward(request, response);
				}
				catch (ServletException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		if(sunmit.trim().equals("User"))
		{
			
			try
			{
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			}
			catch (ServletException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(sunmit.trim().equals("Register"))
		{
			
			try
			{
			rd = request.getRequestDispatcher("Files/jsp/Register.jsp");
			rd.forward(request, response);
			}
			catch (ServletException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
