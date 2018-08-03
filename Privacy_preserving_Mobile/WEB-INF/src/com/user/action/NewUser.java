
package com.user.action;

import javax.servlet.RequestDispatcher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;


public class NewUser extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			String userid=request.getParameter("loginid");
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			String email=request.getParameter("email");
			
			String pho_no=request.getParameter("phone");
			
			
			RequestDispatcher rd = null;
			String path = null;
			UserDAO userDao=UserDAO.getInstance();
			
			boolean f = UserDAO.checkAlreadyExist(userid);
			
			if(!f)
			{

				boolean result=userDao.addUser(userid, pass,name,email,pho_no);
				if(result)
				{
						rd = request.getRequestDispatcher("index.jsp?no=4");
						rd.forward(request,response);
						
				}
				else
				{
					response.sendRedirect("index.jsp?no=3");
				}	
			}
			else
			{
				
				rd = request.getRequestDispatcher("/Files/jsp/Register.jsp?no=1");
				rd.forward(request,response);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
