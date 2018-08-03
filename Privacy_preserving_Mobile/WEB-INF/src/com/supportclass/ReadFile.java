package com.supportclass;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadFile 
{
	
	public static ArrayList<String> readfile(String fileName)
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("the");list.add("they");list.add("of");list.add("on");list.add("will");
		list.add("have");list.add("had");list.add("can");list.add("able");list.add("should");
		list.add("counld");list.add("not");list.add("no");list.add("this");list.add("that");
		list.add("resulting");list.add(".");list.add(",");list.add("#");list.add("@");
		list.add("!");list.add(".");list.add(",");list.add("#");list.add("@");
		list.add("%");list.add("&");list.add("*");list.add("+");list.add("=");
		list.add("is");list.add("was");list.add("their");list.add("when");list.add("from");
		list.add("to");list.add("did");list.add("build-up");list.add("in");
		list.add("a");list.add("its");list.add("as");list.add("also");list.add("need");
		list.add("and");list.add("make");list.add("does");list.add("an");list.add("there");
		list.add("give");list.add("given");list.add("or");list.add("them");list.add("there");
		list.add("then");list.add("more");list.add("most");list.add("large");list.add("larger");
		list.add("largest");list.add("cause");list.add("although");list.add("remains");list.add("type");
		list.add("exact");list.add("such");list.add("strong");list.add("late");list.add("it");list.add("into");
		list.add("for");list.add("are");list.add("with");
		
		
		
		ArrayList<String> output = new ArrayList<String>();
		
		StringBuffer sb = new StringBuffer();
		try
		{
			FileInputStream fstream = new FileInputStream(fileName);
  		
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
        
			String strLine;
  		while ((strLine = br.readLine()) != null) 	
  		{
  			String[] data = strLine.split(" ");
  			
  			for(int i=0;i<data.length;i++)
  			{
  				data[i].toLowerCase();
  	  			if(list.contains(data[i].toLowerCase()))
  	  			{
  	  				
  	  			}
  	  			else
  	  			{
  	  			output.add(data[i]);
  	  				
  	  			}
  	  			
  			}
  			
  			
  			//break;
  			
  		}
  		in.close();
  		
  		System.out.println("Output :"+output);
		}catch(Exception e)
		{
			
		}
		return output;
	}

}
