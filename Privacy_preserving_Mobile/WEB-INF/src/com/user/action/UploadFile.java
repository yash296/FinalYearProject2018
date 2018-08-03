/**
 * 
 */
package com.user.action;


import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FilenameUtils;

import com.dao.ClassifyDAO;
import com.dao.UserDAO;
import com.globaldata.Global;
import com.supportclass.Calculation;
import com.supportclass.ReadFile;

public class UploadFile extends HttpServlet
{
	
	javax.swing.Timer access_timer;
	String id="",str="",Fileblockpath="",sensitive="";
	String filename="", server="",user="",pass="",dirToCreate="",delete_ouput_path="";
	String dwn_file_path="",decrpt_file_path="";
	String ftpserver = "ftp.drivehq.com";
    String ftpusername = "privacypreserving123";
    String ftppassword = "finditthere123";
    String username = "";
    String dirToUploadFile="";
    File ff=null;
    ServletInputStream sis=null;
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
			{
		
		Calendar currentDate1 = Calendar.getInstance();
		SimpleDateFormat formatt=new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat formatte=new SimpleDateFormat("HH:mm:ss");
		String date1 = formatt.format(currentDate1.getTime());
		String time1 = formatte.format(currentDate1.getTime());
		
		System.out.println("Start Time  :"+time1);
		String catname=null;
		
		String dest =" ", dest1=" ";
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession hs = request.getSession();

		// id = hs.getAttribute("name").toString();

		FileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
		try 
		{

			List fileItems = servletFileUpload.parseRequest(request);
			
			System.out.println("fileItems:"+fileItems);

			FileItem file = (FileItem) fileItems.get(0);
			
			
			System.out.println("File>>>>>>>>>:"+file);
			
			// Write input File into Upload_Files //
			
			String fileName = request.getRealPath("") + "/Upload_Files/"+ file.getName();
			
		     System.out.println("fileName===="+fileName);
			
			OutputStream outputStream = new FileOutputStream(fileName);
			InputStream inputStream = file.getInputStream();

			int readBytes = 0;
			byte[] buffer = new byte[10000];
			while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1)
			{
				outputStream.write(buffer, 0, readBytes);
			}
			outputStream.close();
			inputStream.close();
						
			
			if (file.getName() != null )
			{
				
			//	UserDAO.refereshTrans();
				
				File file1=new File(fileName);
				
				String filename=file1.getName();
				
				System.out.println("File"+filename);
				
			//	UserDAO.emptyTables();
		        
				boolean file_exist = UserDAO.fileExist(filename);
				
				if(file_exist)
				{
					
					 rd = request.getRequestDispatcher("/Files/jsp/upload_file.jsp?no=3");
						
					 rd.forward(request, response);
				}
				else
				{
					
						// Date and Time Function //
						
						Calendar currentDate = Calendar.getInstance();
						SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
						SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
						String date = formatter.format(currentDate.getTime());
						String time = formatter1.format(currentDate.getTime());
						
						date = date + "  " + time;
					
						
					//boolean f = UserDAO.addFile(filename);
					
					//System.out.println("Status :"+f);
					
					// Read  file //
					ArrayList<String> key_data = ReadFile.readfile(fileName);
					
					System.out.println("Arraylist Size :"+key_data.size());
					
					 String counts=TextSearch.text_count(key_data,file.getName());
					 String counters[]=counts.split("~~");
					 
					 
					
					             
					             

					 
					 int count1=Integer.parseInt(counters[0]);
					 int count2=Integer.parseInt(counters[1]);
					
					
					 System.out.println("=============================="+count1+"/"+count2);
					 
					 
					 
					 
					// if(file.equals(arg0))
					 
					 
					 
					 
					 
					 if(count1>count2)
						
					 {
						 
						 //response.sendRedirect(request.getContextPath()+"/view_file.jsp?catName="+catname+"&fnm="+file.getName()+"&no=1");
						 
						 
						
						 
						 
						 
						
						 sensitive = request.getRealPath("") + "/Uploaded_Files/Cluster_1/"+ file.getName();
						
						 Fileblockpath = request.getRealPath("") + "/File_Blocks/";
							
					     System.out.println("fileName CAR===="+sensitive);
						
						OutputStream outputStream1 = new FileOutputStream(sensitive);
						InputStream inputStream1 = file.getInputStream();

						int readBytes1 = 0;
						byte[] buffer1 = new byte[10000];
						while ((readBytes1 = inputStream1.read(buffer1, 0, 10000)) != -1)
						{
							outputStream1.write(buffer1, 0, readBytes1);
						}
						outputStream1.close();
						inputStream1.close();
						
						ff=new File(sensitive);
						int clusterid=1;
						
						
						
						
						int f_no=ClassifyDAO.insertinto_m_file_new(filename,clusterid);
						
						
						
						System.out.println("fno"+f_no);
						catname =ClassifyDAO.getClustername(clusterid); 
						
						
						
						System.out.println("<<<<<<<<<<<<<<"+filename);
						
						str = Integer.toString(f_no);
						
						
						System.out.println("str:"+str);
						
						
						
						
						
						
						//response.sendRedirect("view_file.jsp?catName="+catname+"&fnm="+file.getName()+"&no=0");
						
					
						
						
						
						
						
						
						
					 }
					
					 if(count2>count1)
					 {
						 
						 
						 
						 String nonsensitive = request.getRealPath("") + "/Uploaded_Files/Cluster_2/"+ file.getName();
						 String Fileblockpath = request.getRealPath("") + "/File_Blocks/";	
						 System.out.println("fileName digestive===="+nonsensitive);
							
							OutputStream outputStream1 = new FileOutputStream(nonsensitive);
							InputStream inputStream1 = file.getInputStream();

							int readBytes1 = 0;
							byte[] buffer1 = new byte[10000];
							while ((readBytes1 = inputStream1.read(buffer1, 0, 10000)) != -1)
							{
								outputStream1.write(buffer1, 0, readBytes1);
							}
							outputStream1.close();
							inputStream1.close();
						
							int clusterid=2;
							ff=new File(nonsensitive);
							int f_no=ClassifyDAO.insertinto_m_file_new(filename,clusterid);
							catname =ClassifyDAO.getClustername(clusterid);
							
							
							//String filePath = request.getRealPath("") + "/" + "config.properties";
							
							Packet2.formPacket(ff, nonsensitive,Fileblockpath,f_no);
							
							//response.sendRedirect(request.getContextPath()+"/FTPUpload?path="+digestive+"&fname="+filename);
							
							
							
							 
							
							
					 }
					 
					 
					
					 
					 
					if(catname!=null)
					 {
						
						session.setAttribute("str", str);
						
						session.setAttribute("Fileblockpath", Fileblockpath);
						session.setAttribute("sensitive", sensitive);
						session.setAttribute("file", ff.getPath());
						session.setAttribute("CName", catname);
						session.setAttribute("filenm", file.getName());
						session.setAttribute("CName", catname);
						session.setAttribute("filenm", file.getName());
						response.sendRedirect("view_file.jsp?catName="+catname+"&fnm="+file.getName()+"&no=0");
						 
					 }
					 else
					 {
						 response.sendRedirect("Files/jsp/upload_file.jsp?no=5");
						 
					 }
					
					
				}

			}
			

			
			
		}

		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
}
