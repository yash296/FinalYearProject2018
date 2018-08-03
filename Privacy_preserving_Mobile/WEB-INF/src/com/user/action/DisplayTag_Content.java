package com.user.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;

public class DisplayTag_Content extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			{
	
		HttpSession s=req.getSession();
		String fid = s.getAttribute("fid").toString();
		
		RequestDispatcher rd=null;
		String sunm = req.getParameter("submit");
		
		
		if(sunm.trim().equals("View Child Tag"))
		{
			//String parentid = req.getParameter("pid");
			
			//String fileid = req.getParameter("fid");
			
			ResultSet rs =UserDAO.select_ChildTag(Integer.parseInt(fid));
			
			try {
				
				if(rs.next())
				{
					
					rs = UserDAO.select_ChildTag(Integer.parseInt(fid));
					req.setAttribute("rs", rs);
					
					rd = req.getRequestDispatcher("/Files/jsp/view_tagElement.jsp?no1=1");
					rd.forward(req, resp);
				}
				else
				{
					
					rd = req.getRequestDispatcher("/Files/jsp/view_tagElement.jsp?no=1");
					rd.forward(req, resp);
				}
				
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(sunm.trim().equals("View Content Elements"))
		{
		
			//String parentid = req.getParameter("pid");
			
			//String fileid = req.getParameter("fid");
			
			ResultSet rs =UserDAO.select_Content( Integer.parseInt(fid));
			
			try {
				
				if(rs.next())
				{
					rs = UserDAO.select_Content( Integer.parseInt(fid));
					req.setAttribute("rs", rs);
					
					rd = req.getRequestDispatcher("/Files/jsp/view_tagElement.jsp?no1=2");
					rd.forward(req, resp);
				}
				else
				{
					
					rd = req.getRequestDispatcher("/Files/jsp/view_tagElement.jsp?no=1");
					rd.forward(req, resp);
				}
				
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(sunm.trim().equals("View Structure Vector"))
		{
			
			ResultSet rs =UserDAO.select_Vector(Integer.parseInt(fid));
			
			try {
				
				if(rs.next())
				{
					rs = UserDAO.select_Vector( Integer.parseInt(fid));
					req.setAttribute("rs", rs);
					
					rd = req.getRequestDispatcher("/Files/jsp/view_tagElement.jsp?no1=3");
					rd.forward(req, resp);
				}
				else
				{
					
					rd = req.getRequestDispatcher("/Files/jsp/view_tagElement.jsp?no=1");
					rd.forward(req, resp);
				}
				
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(sunm.trim().equals("View Content Vector"))
		{
			
			ResultSet rs =UserDAO.select_ConVector(Integer.parseInt(fid));
			
			try
			{
				
				if(rs.next())
				{
					rs = UserDAO.select_ConVector(Integer.parseInt(fid));
					req.setAttribute("rs", rs);
					
					rd = req.getRequestDispatcher("/Files/jsp/view_tagElement.jsp?no1=4");
					rd.forward(req, resp);
				}
				else
				{
					
					rd = req.getRequestDispatcher("/Files/jsp/view_tagElement.jsp?no=1");
					rd.forward(req, resp);
				}
				
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(sunm.trim().equals("Final Category"))
		{
			
			ResultSet rs =UserDAO.select_classify(Integer.parseInt(fid));
			
			try
			{
				
				if(rs.next())
				{
					rs = UserDAO.select_classify(Integer.parseInt(fid));
					req.setAttribute("rs", rs);
					
					rd = req.getRequestDispatcher("/Files/jsp/view_tagElement.jsp?no1=5");
					rd.forward(req, resp);
				}
				else
				{
					rd = req.getRequestDispatcher("/Files/jsp/view_tagElement.jsp?no=1");
					rd.forward(req, resp);
				}
				
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
