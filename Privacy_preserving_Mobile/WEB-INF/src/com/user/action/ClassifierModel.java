package com.user.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supportclass.Calculation;

public class ClassifierModel extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		RequestDispatcher rd = null;
		String file_id = req.getParameter("file");
		
		System.out.println("File Id "+file_id);
		
		
		String vector =  Calculation.updateVector(Integer.parseInt(file_id));
		
		String[] str = vector.split("~");
		
		double structure_vector = Double.parseDouble(str[0].trim());
		
		double content_vector = Double.parseDouble(str[1].trim());
		
		System.out.println("Structure Vector :"+structure_vector);
		System.out.println("Content Vector :"+content_vector);
		
		if((structure_vector>=750) ||(content_vector>=750))
		{
			rd = req.getRequestDispatcher("Files/jsp/classifier.jsp?no=1");
			rd.forward(req, resp);
			
		}
		else if((structure_vector>=500&&structure_vector<=750) ||(content_vector>=500&&content_vector<=750))
		{
			
			rd = req.getRequestDispatcher("Files/jsp/classifier.jsp?no=2");
			rd.forward(req, resp);
		}
		else
		{
			
			rd = req.getRequestDispatcher("Files/jsp/classifier.jsp?no=3");
			rd.forward(req, resp);
		}
		
	}
}
