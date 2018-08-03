package com.user.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClassifyDAO;
import com.dao.UserDAO;
import com.supportclass.Calculation;
import com.test.Category;
import com.test.Classification;

public class FuzzyCluster extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
	{
		
		
		RequestDispatcher rd = null;
		String category = req.getParameter("file");
		
		System.out.println("File Id"+category);
		
		if(category.trim().equals("Sensitive"))
		{
			System.out.println("File name:"+category);
			
			String files = getServletContext().getRealPath("/")+"Sensitive.txt";
			
			File f =new File(files);
			
			String fileName=f.getName();
			
			
				try
				{
					boolean status = Category.insertTerms(files, 1);
					
					if(status)
					{
												
						rd = req.getRequestDispatcher("/Files/jsp/select_category.jsp?no=1");
						rd.forward(req, resp);
					}
					else
					{
						rd = req.getRequestDispatcher("/Files/jsp/select_category.jsp?no=2");
						rd.forward(req, resp);
					}
				
				}
				catch (Exception e)
				{
					System.out.println("Exception:"+e.toString());
				}
			}
		
		if(category.trim().equals("Nonsensitive"))
		{
			
			String files = getServletContext().getRealPath("/")+"Nonsensitive.txt";
			
			File f =new File(files);
			
			String fileName=f.getName();
				try
				{
					
					boolean flg =Category.insertTerms(files, 2);
					
					if(flg)
					{
					
												
						rd = req.getRequestDispatcher("/Files/jsp/select_category.jsp?no=1");
						rd.forward(req, resp);
					}
					else
					{
						
						
						
						rd = req.getRequestDispatcher("/Files/jsp/select_category.jsp?no=2");
						rd.forward(req, resp);
					}
				
				}catch (Exception e)
				{
					System.out.println("Exception:"+e.toString());
				}
			}
		
	
	}

}
