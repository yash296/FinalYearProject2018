package com.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.dao.UserDAO;

public class Category 
{

	public static boolean insertTerms(String filename,int catid)
	{
		boolean status=false;
		try
		{
			File f = new File(filename);
			
			FileInputStream fstream = new FileInputStream(f);
	  		
	  		DataInputStream in = new DataInputStream(fstream);
	        BufferedReader br = new BufferedReader(new InputStreamReader(in));
	        
	  		String strLine;
	  		
	  		while ((strLine = br.readLine()) != null) 	
	  		{
	  			
	  			UserDAO.insertWord(strLine.trim(), catid);
	  			
	  		}
	  		in.close();
	  		
	  		status=true;
	  		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}
