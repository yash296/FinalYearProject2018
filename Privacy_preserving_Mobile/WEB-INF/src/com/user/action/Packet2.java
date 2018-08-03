package com.user.action;


/*import com.DAOFactory.CommonDAO;
import com.database.Database;*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Random;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClassifyDAO;
import com.dna.DNA_Main;
import com.util.FileUpload;


/*import com.util.MD5;
import com.util.Utility;*/
public class Packet2 extends HttpServlet 
{
    static int upload_flag;
    static int download_flag;
    static int num1;
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;	
	static byte[] byteArray=new byte[512];
	static Random random=new Random();
	static boolean flag_new=false;
	
	static String readFile(File fileName) throws IOException
	{
		
	    BufferedReader br = new BufferedReader(new FileReader(fileName.getAbsolutePath()));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
	
	
	public static boolean formPacket(File file, String root1,String root2 ,int fno) throws NoSuchAlgorithmException 
	{	
		File file5 = null;	
		int nChunks = 0;
		int fileSize=0;
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		String FILE_NAME="";
		String hash_blk_nos=null;
		int originalfilesize=0;
		String ftpserver = "ftp.drivehq.com";
        String ftpusername = "privacypreserving123";
        String ftppassword = "finditthere123";
        String dirToUploadFile="CloudData";
        sb1.append(dirToUploadFile);
		try 
		{ 
			//String FILE_NAME1 = FILE_NAME;
			
			String pack="500";//Utility.getPro("Packet");
			int  PART_SIZE=Integer.parseInt(pack);
			System.out.println(" - PACKET PACKET PACKET===============+++++++++++++++++++++++++++++++++++++++++++++- - "+ PART_SIZE);
			
			 FILE_NAME=file.getName();
            String extension = "";
			
			int i = FILE_NAME.lastIndexOf('.');
			
			System.out.println("i is"+i);
			
			if (i > 0)
			{
				
			 extension = FILE_NAME.substring(i+1);
			 System.out.println("extension of the file is     "  +extension);
			 
			 }
			
			String FILE_NAME5=FILE_NAME.replace(".", "_");
			
			
			
			FileInputStream inputStream;
			
			String newFileName;
			
			FileOutputStream filePart;
			
			 fileSize = (int) file.length();
			 originalfilesize=fileSize;
			 
			System.out.println("file size is>>>>>>>>>>>>>>>>>>>>>>>>>>"+fileSize);
			
			int read = 0, readLength = PART_SIZE;
			
			byte[] byteChunkPart;
			
			try 
			{
				
				inputStream = new FileInputStream(file);
				
				while (fileSize > 0) 
				{
					
					if (fileSize <= PART_SIZE) 
					{
						readLength = fileSize;
						
						
					}
					
					byteChunkPart = new byte[readLength];
			
					read = inputStream.read(byteChunkPart, 0, readLength);
					
					System.out.println("read is )))))))))))))))))"+read);
					
					fileSize -= read;
					
					System.out.println("file size after read"+fileSize);
					
					assert (read == byteChunkPart.length);
					
					
					
					
					System.out.println("byte chunk part lenght is//////"+byteChunkPart.length);
					
					nChunks++;
					
					System.out.println("Number of chunks are   "+nChunks);
					
					newFileName = FILE_NAME5 + ".p"+ Integer.toString(nChunks - 1);
					
					System.out.println("new file name is "+newFileName);
					
					
				    
					try
					{
					
				     
				     filePart = new FileOutputStream(new File(root2+"\\"+fno+"blk_"+Integer.toString(nChunks - 1)));
					 file5=new File(root2+"\\"+fno+"\\blk_"+Integer.toString(nChunks - 1));
					System.out.println("new filepart is "+filePart);
					String filepathh=root2+"\\"+fno+"blk_"+Integer.toString(nChunks - 1);
					filePart.write(byteChunkPart);
					filePart.flush();
					filePart.close();
				     
					byteChunkPart = null;
					filePart = null;
					
					
					
					
					
					
					
					String hashcode=MD5.MD(new File(filepathh));
					
					
					
					
					
					
						String filename2= file5.getName();
						String blockname1 = filename2.replaceAll("[0-9]",""); 
					    String blockname2 = blockname1.replaceAll("_","");
					    // String blockname2=newFileName;
					     System.out.println("===========Perferct Block name======"+blockname2); 
				    
					     String blkname=fno+"blk_"+Integer.toString(nChunks - 1);
					     
					     
					     
					     System.out.println("<<<<<<<<<<+blkname"+blkname);
					     
					  String blockidandflag=ClassifyDAO.insertblockname(fno,blkname,hashcode);
					  String a[]=blockidandflag.split("~~");
					  int blockid=Integer.parseInt(a[0]);
					   String flag7=a[1];
					    
					    
				//=================Hadoop Upload Process starts===========================	    
					    
					    
					   
					    		File file1=new File(filepathh);
			    				FileUpload.upload(ftpserver,ftpusername,ftppassword,blkname,file1,dirToUploadFile);
			    		
					    
					    
				     sb.append(blockid);
				     sb.append("-");
				     
				    }
					catch(Exception e)
					{
						e.printStackTrace();
					}       
				
				}
				
				inputStream.close();
			}
			catch (IOException exception) 
			{
				exception.printStackTrace();
			}
	     	}
			
			catch (Exception exception) 
			{
				exception.printStackTrace();
			}
		
	        
			
	        
	      
	      
		 hash_blk_nos = sb.toString();
		 System.out.println("========hash_block======"+hash_blk_nos);
		/* String date=Utility.getDate();
		 String time=Utility.getTime();
		 String day=Utility.getDay();*/
		 
		 int file_size2=0,no_padding=0;
		 System.out.println("file size before insertion>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+originalfilesize);
		 boolean flag2=ClassifyDAO.update_file_lba( fno, hash_blk_nos);
		 System.out.println("---insert into m_file_one table---"+flag2);
		// return upload_flag;
		 return flag_new;
		} 
		
		
	
	public static void main(String[] args) throws IOException 
	{
	//Packet1 P = new Packet1();
	//File F = new File("JavaV1.txt");
	//Packet1.formPacket(F);
	}
}
