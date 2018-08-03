package com.user.action;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.dao.UserDAO;

class TextSearch 
{
	
	public static String text_Search(String file)
	{
		
		StringBuffer sb = new StringBuffer();
		 try
		 {
				
				FileInputStream fstream = new FileInputStream(file);
				DataInputStream in = new DataInputStream(fstream);
		        BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String strLine;
				
				//Read File Line By Line
				while ((strLine = br.readLine()) != null)
				{
					
					//System.out.println ("Input data :"+strLine.trim());
					
					String[] s = strLine.split(" ");
					
					
					for(int i=0;i<s.length;i++)
					{
						
						char chr = strLine.charAt(i);
						
						//sb.append(Character.toLowerCase(s[i].charAt(0))).append(s[i].substring(1)+"~");
						
						sb.append(s[i].toLowerCase()+"~");
					}
					
					sb.append("#");
					
				}
				
				
				in.close();
		}catch (Exception e)
		 {
			
					e.printStackTrace();
		}
		return sb.toString().trim();
	}
	
	public static ArrayList text_filter(String original)
	{
		ArrayList data = new ArrayList();
		String[] s = original.split("#");
		
		for(int i=0;i<s.length;i++)
		{
			
			if(s[i].trim()!=null)
			{
				String[] word = s[i].split("~");
				
				for(int j=0;j<word.length;j++)
				{
					
					String search = word[j].trim();
					search.trim();
					
					System.out.println("Keyword :"+search);
					
					if(search.trim().equals("@") || search.trim().equals("#") || search.equals("&") ||search.equals("%") || search.equals("^"))
					{
						
						System.out.println(" Unnessary Data 1: "+search);
					}
					else if(search.equals(".") ||search.equals(",") || search.equals("*")||search.equals("~") ||search.equals("!") )
					{
						
						System.out.println(" Unnessary Data : "+search);
					}
					else
					{
						boolean f = UserDAO.check(search);
						
						if(f == true)
						{
							//System.out.println("Unwanted data");
							
						}
						else
						{
							data.add(search);
						}
					}
					
				}
				
			}
		}
		
		return data;
		
	}
	//==================================================25/02/2016---------start--------------------------
	public static String text_count(ArrayList<String> datas,String fname)
	{
		
		
		Set<String> unique = new HashSet<String>(datas);
		
		int count1=0,count2=0;
		StringBuffer sb=new StringBuffer();
		
		
		
		for (int i=0;i<datas.size();i++)
		{
			
			System.out.println("temp========================================="+datas.get(i));
			
			int count = Collections.frequency(datas, datas.get(i));
				
			
			int cat=UserDAO.checkkeywordCategorynew(datas.get(i));
			
			if(cat==1)
			{
			boolean flg=false;
			flg=UserDAO.inserttocategorycardio(datas.get(i),count,fname,cat);
			
			count1++;
			
			}
			if(cat==2)
			{
				System.out.println("????????????????");
				boolean flg=false;
			flg=UserDAO.inserttocategorydigestive(datas.get(i),count,fname,cat);
			//if(flg)
			//{
			count2++;
			//}
			}
			
				
		//	System.out.println(temp + ": " +count );
			
			
		 }
		
		sb.append(count1);
		sb.append("~~");
		sb.append(count2);
		sb.append("~~");
		
		return sb.toString();
		
		
		}
	
	
	 public static String readFileContent(String path, Charset encoding) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}
		
	
	//==================================================25/02/2016-----end------------------------------
	
	/*public static void updateCategory(String fnm)
	{
		ArrayList<String> keyword = UserDAO.selectKeyword(fnm);
		
		//System.out.println("Key Words :"+keyword);
		
		for (String temp : keyword)
		{
			
		//	UserDAO.checkkeywordCategory(temp);
			
		}
		
	}*/
	
	
	public static void text_count1(ArrayList datas,String fname)
	{
		
		StringBuffer sb = new StringBuffer();
		Set<String> unique = new HashSet<String>(datas);
		
		for (String temp : unique)
		{
			
			int count = Collections.frequency(datas, temp);
				
			sb.append(temp+"-");
				
			//System.out.println("String buff :"+sb.toString());
			
		}
		//UserDAO.upload1(fname,sb.toString());
		
	}
	
	/*public static void Calculate_Weightage(String fname)
	{
		//System.out.println("============================");
		
		DecimalFormat df = new DecimalFormat( "#.##" );  
		
		StringBuffer sb = new StringBuffer();
		 ArrayList rs = UserDAO.getkey_word(fname);
		 
		 int tot = UserDAO.getFile_total(fname);
		 
		 for(int i=0;i<rs.size();i++)
		 {
			//System.out.println("+++++++++++++++++++++++++++");
			 String key = rs.get(i).toString();
			 
			 String[] s = key.split("@");
			 
			 String keyword=s[0].trim();
			 String weight=s[1].trim();
			 
			 int weig = Integer.parseInt(weight.trim());
				
				Double percentage = ((double)weig/tot) * 100; 
				
				String weightage = df.format(percentage);
				
				boolean fl = UserDAO.update_weigtage(keyword, fname, weightage);
				//System.out.println("Rank :"+df.format(percentage)+"======="+fl);
		 }*/
		
	/*}*/
	
	
   public static void main(String args[])
	{
	   
	   // Read Number of words in text file //
	   String dat = text_Search("test.txt");
	   
	   System.out.println("List Of words :"+dat);
	   
	   // Filter Process
	   ArrayList filtered_data = text_filter(dat);
	   
	   
	   // Word Count Process
	  // text_count(filtered_data);
	   
	   
	   
	}
     
}
