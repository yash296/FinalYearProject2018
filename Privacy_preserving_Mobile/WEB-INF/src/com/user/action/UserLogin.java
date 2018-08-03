
package com.user.action;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAO;
import com.dao.UserDAO;


public class UserLogin extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		RequestDispatcher rd=null;
		String sunmit = request.getParameter("submit");
		
		if(sunmit.trim().equals("User"))
		{
			HttpSession s = request.getSession();
			
			String uid = request.getParameter("userid");
			
			String pass = request.getParameter("password");
			
			boolean f = UserDAO.checkUser(uid,pass);
			
			if(f)
			{
				try
				{
				s.setAttribute("userid", uid);
				rd = request.getRequestDispatcher("Files/jsp/home.jsp");
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
