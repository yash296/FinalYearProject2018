/**
 * 
 */
package com.user.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.ClassifyDAO;
import com.dna.DNA_Main;
import com.util.Utility;

/*import com.DAOFactory.CommonDAO;
import com.database.Database;
import com.util.Utility;*/


public class DownloadFile extends HttpServlet 
{ String processingServerUrl="";
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;	
	
	
	RequestDispatcher rd=null;
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		
		boolean result=false;
		String ftpserver = "ftp.drivehq.com";
        String ftpusername = "privacypreserving123";
        String ftppassword = "finditthere123";
        String downloadDir = "CloudData";
        FileInputStream inStream;
        String headerKey="";
        String headerValue ="";
        /*FileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);*/
		
		
		 //String filePath = request.getRealPath("") + "/" + "config.properties";
		
			String downloadpath=getServletContext().getRealPath("/")+"downloadedfile";
			
			
						
			
		try
		{
			

			
			
		System.out.println("its came into downloadfile>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		String data=request.getParameter("submit");
		if(data.equals("get"))
		{
			
		rd=	request.getRequestDispatcher("/Files/jsp/download.jsp");
	
		rd.forward(request, response);
		
			
		}
		else if(data.equals("Download"))
		{
			HttpSession session = request.getSession();  
			
			 if ( session.getAttribute( "waitPage" ) == null ) 
		       {  
		    	   session.setAttribute( "waitPage", Boolean.TRUE );  
		    	   PrintWriter out = response.getWriter();  
		    	   out.println( "<html><head>" );  
		    	   out.println( "<title>Please Wait...</title>" );  
		       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
		    	   out.println( "</head><body bgcolor=''>" );  
		    	   out.println( "<br>" );
		    	   out.println( "<center>" );
		    	   out.print("<font color='red'>");
		    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
		    	   out.println("</font>");
		    	   out.print("<font color='green'>");
		    	   out.println( "Please,Wait..........<br>  " );
		    	   out.println( "Download Athentication In Process..." );
		    	   out.println( "<br>" );
		    	   out.println("</font>");
		    	   out.println( "<br>" );
		    	   out.print( "<img src='img/giphy.gif'></img><br><br>");
		    	   out.print("<font color='geen'>");
		    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
		    	   out.println( "<br>" );
		    	   out.println( "Downloading is in process..." );
		    	   out.println( "<br>" );
		    	   out.println( "The File is being decrypted...." );
		    	   out.println("</font>");
		    	   out.println( "<br>" );
		    	   out.println( "Please wait....</h1></center");  
		    	   out.close();  
		       }  
		       else 
		       { 
			    	session.removeAttribute( "waitPage" );  
			    	
					try
					{
						
				
		
		String []chk=request.getParameterValues("chk");
		System.out.println("checkbox  content is>>>>>>>>>>>>>>>>>"+chk[0]);
		String chechboxvalue=chk[0];
		
		ArrayList< String> blocksname=new ArrayList<>();
		
		 String lba=ClassifyDAO.getLBA(chk[0]);
		 String arr[]=lba.split("-");
		 
		 for(int i=0;i<arr.length;i++)
		 {
			 
			String blockname =ClassifyDAO.getblockname(arr[i]); 
			blocksname.add(blockname);
			//=================Hadoop Download Process starts===========================
			
			 //FileUpload.filedownload(filePath, downloadpath,blockname);
			 
			//=================Hadoop Download Process ends===========================
			
			
			result=Utility.download(Utility.getPro("server"), Utility.getPro("user"),Utility.getPro("pass"),blockname,downloadpath);
			
			//DNA_Main.DNA_Decrypt_Main(downloadpath,destinationpath);
			
		 }
		
		String fname=ClassifyDAO.getfilename(chk[0]);
		
		System.out.println("blocknames are>>>>>>>>>"+blocksname);
		
		
		List<File> list = new ArrayList<File>();
		
		
		for(int i=0;i<blocksname.size();i++)
		{
			
			
			blocksname.get(i);
			list.add(new File(downloadpath+"/"+blocksname.get(i)));
			
			
			
			
		}
		
		
		String path=request.getRealPath("")+ "/" + "mergedfile/";
		

											File ofile = new File(path+fname);
											
											FileOutputStream fos;
											FileInputStream fis;
											byte[] fileBytes;
											int bytesRead = 0;
											try 
											{
												
											    fos = new FileOutputStream(ofile,true);
											    
											    System.out.println("List contents are>>>>>>................."+list);
											    
											    for (File file : list)
											    {
											    	
											        fis = new FileInputStream(file);
											        
											        
											        
											        fileBytes = new byte[(int) file.length()];
											        
											       
											        
											        bytesRead = fis.read(fileBytes, 0,(int)  file.length());
											        
											        
											        System.out.println("file bytes are>>>>>>>>>>>>>>>>>>>>>>>> "+bytesRead);
											        
											        assert(bytesRead == fileBytes.length);
											        assert(bytesRead == (int) file.length());
											        fos.write(fileBytes);
											        fos.flush();
											        fileBytes = null;
											        fis.close();
											        fis = null;
											        
											        
											    }
											    
											    fos.close();
											    fos = null;
											    
											    // forces download
											    
											   
												
												System.out.println("************************************");
												
												System.out.println("******************merg path******************"+path+fname);
												
												
												String destinationpath=getServletContext().getRealPath("/")+"download/"+fname;

												//Decryption using DNA 
												
												
												System.out.println("Destination>>:"+destinationpath);
												
												
												
												int fname1=ClassifyDAO.getcluster(chk[0]);
												
												
												
												
												if(fname1==1)
												{
												
												DNA_Main obj1 = new DNA_Main();
												int zValue;
												
											    zValue= DNA_Main.DNA_Decrypt_Main(path+fname,destinationpath);
											   
												
											    System.out.println("decrypted successfully...."+zValue);
												File f=new File(destinationpath);
												
												
												 response.sendRedirect(request.getContextPath()+"/Pass?fileNames="+destinationpath+"&download=true");
												
											    /*ServletContext context = getServletContext();
											    String mimeType = context.getMimeType(destinationpath);
											    if (mimeType == null) 
											    {
											    // set to binary type if MIME mapping not found
											    mimeType = "application/octet-stream";
											    }
											    System.out.println("MIME type: " + mimeType);
											    												
											    // modifies response
											    response.setContentType(mimeType);
											    response.setContentLength((int) f.length());

											    System.out.println("=======lenghthhhhh========="+(int) f.length());
											    inStream = new FileInputStream(f);												
											    
											    
											    
											    
											   headerKey = "Content-Disposition";
											   headerValue = String.format("attachment; filename=\"%s\"",f.getName());
											   */ 
											    
												}
												else
												{
												
											    
												
											    /*ServletContext context = getServletContext();
											    String mimeType = context.getMimeType(path+fname);
											    if (mimeType == null) 
											    {
											    // set to binary type if MIME mapping not found
											    mimeType = "application/octet-stream";
											    }
											    System.out.println("MIME type: " + mimeType);
											    												
											    // modifies response
											    response.setContentType(mimeType);
											    response.setContentLength((int) ofile.length());

											    System.out.println("=======lenghthhhhh========="+(int) ofile.length());
											    inStream = new FileInputStream(ofile);												
											    
											    
											    
											    
											    headerKey = "Content-Disposition";
											    headerValue = String.format("attachment; filename=\"%s\"",ofile.getName());*/
													
													response.sendRedirect(request.getContextPath()+"/Pass?fileNames="+path+fname+"&download=true");
													
													
												}
												
												
											    /*response.setHeader(headerKey, headerValue);
											    
											    OutputStream outStream = response.getOutputStream();
											    												
											    byte[] buffer = new byte[100096];
											    int bytesRead1 = -1;
											    												
											    while ((bytesRead1 = inStream.read(buffer)) != -1) 
											    {
											    outStream.write(buffer, 0, bytesRead1);
											    }
											    inStream.close();
											    outStream.close();*/
											    
											    
											    
											    
											}
											catch (Exception exception)
											{
												exception.printStackTrace();
											}
					}	
					catch (Exception exception)
					{
						exception.printStackTrace();
					}		
				
		       }					
					
		}
					
				                   
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
						
	}
	
	       
	
		
	
}

