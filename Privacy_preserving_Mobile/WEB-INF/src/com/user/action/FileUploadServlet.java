package com.user.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

 class FileUpload
{


	public static boolean hadoopfileupload(String filepathh,String configpath)
	{
	
		
		System.out.println("filepath is >>>>>>>>>>>>>>>>>>>>>in hadoop upload"+filepathh);
		System.out.println("config is >>>>>>>>>>>>>>>>>>>>>in hadoop upload"+configpath);
		
		try {
			
		
			
			
		    String	filePath = configpath;
			System.out.println("filepath upload is  hadoopfileupload>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+filePath);
			FileInputStream fileInputStream = new FileInputStream(new File(
					filePath));
			Properties properties = new Properties();
			properties.load(fileInputStream);

			Configuration conf = new Configuration();
			conf.addResource(new Path(properties.getProperty("hadoopLoc")));
			FileSystem fs = FileSystem.get(conf);
			Path pt = new Path(properties.getProperty("hdfsLoc"));
			fs.mkdirs(pt);

			Path src = new Path(filepathh);
			fs.copyFromLocalFile(src, pt);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	public static boolean filedownload(String filepathh,String configpath,String blockname)
	{
	
	try
	{
	String filePath = filepathh;
	
	filePath = filepathh;
	System.out.println("fielpath is downloadhadoop >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+filePath);
	System.out.println("configpath is downloadhadoop >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+configpath);
	System.out.println("blockname is downloadhadoop >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+blockname);
	
	FileInputStream fileInputStream = new FileInputStream(new File(
			filePath));
	Properties properties = new Properties();
	properties.load(fileInputStream);

	Configuration conf = new Configuration();
	conf.addResource(new Path(properties.getProperty("hadoopLoc")));
	FileSystem fs = FileSystem.get(conf);
	//Path pt = new Path(properties.getProperty("hdfsLoc")+"/blockname");
	Path pt = new Path(properties.getProperty("hdfsLoc")+"/"+blockname);
	//Path src = new Path(configpath+blockname);
	//Path src = new Path(configpath + "/shanuuuu.txt");
	Path src = new Path(configpath + "/"+blockname);
	
	
	fs.copyToLocalFile(pt, src);
	//fs.delete(pt);
	
	
	/*Path p=new Path(properties.getProperty("hdfsLoc")+"PalniKannan");
	//fs.mkdirs(p);
	//fs.delete(p);
	Path pt1 = new Path(properties.getProperty("hdfsLoc")+"/PalaniKannan");
	fs.delete(pt1);*/
	//fs.copyToLocalFile(pt, src);
	//fs.co
	

	/*rd=req.getRequestDispatcher("index.jsp");
	rd.forward(req, resp);
	*/
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	
	return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
/*
	public static boolean hadoopfiledownload(String filepathh,String configpath,String blockname)
	{
	
	try
	{
		//String filePath = req.getRealPath("") + "/" + "config.properties";
		
		//filePath = req.getRealPath("") + "/" + "config.properties";
		System.out.println("fielpath is download >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+filepathh);
		
		System.out.println("configpath is download >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+configpath);
		System.out.println("blockname is download >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+blockname);
		
		FileInputStream fileInputStream = new FileInputStream(new File(
				filepathh));
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Configuration conf = new Configuration();
		conf.addResource(new Path(properties.getProperty("hadoopLoc")));
		FileSystem fs = FileSystem.get(conf);
		//Path pt = new Path(properties.getProperty("hdfsLoc")+"/shanu.txt");
		Path pt = new Path(properties.getProperty("hdfsLoc")+"/"+blockname);
		
		

		Path src = new Path(filepathh+blockname);
		fs.copyToLocalFile(pt, src);
		//fs.delete(pt);
		
		
		//Path p=new Path(properties.getProperty("hdfsLoc")+"PalniKannan");
		//fs.mkdirs(p);
		//fs.delete(p);
		//Path pt1 = new Path(properties.getProperty("hdfsLoc")+"/PalaniKannan");
		//fs.delete(pt1);
		//fs.copyToLocalFile(pt, src);
		//fs.co
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	return false;
	
	}*/
	
}
 
