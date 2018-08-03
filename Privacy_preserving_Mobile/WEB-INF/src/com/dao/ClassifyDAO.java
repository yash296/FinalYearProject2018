/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import com.dao.*;




public class ClassifyDAO 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static ClassifyDAO classDAO=null;
	private ClassifyDAO()
	{
		
	}
	public static ClassifyDAO getInstance()
	{
		if(classDAO == null)
		{
			classDAO= new ClassifyDAO();
		}
		return classDAO;
	}
	
	
	public static ResultSet getFile_Name()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select cls_f_id,cls_f_name from cls_file");
		
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return resultSet;
	}
	
	public static ArrayList getWeightage(int fid)
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select cls_no_of_times from cls_parent where cls_f_id='"+fid+"'");
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return list;
	}
	
	public static ArrayList getChildWeightage(int fid)
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select cls_no_of_times from cls_child where cls_f_id='"+fid+"'");
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return list;
	}
	
	public static int getFileId(String fnm)
	{
		
		int fid=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select cls_f_id from cls_file where cls_f_name='"+fnm+"'");
		
			while(resultSet.next())
			{
				fid = resultSet.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return fid;
	}
	
	public static ArrayList getContentWeightage(int fid)
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select cls_no_of_times from cls_content where cls_f_id='"+fid+"'");
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return list;
	}
	
	public static String getTot(int fid)
	{
		StringBuffer sb =new StringBuffer();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select cls_parent_tag_total,cls_child_tag_total,cls_content_total from cls_file where cls_f_id='"+fid+"'");
			
			while(resultSet.next())
			{
				sb.append(resultSet.getInt(1)+"~"+resultSet.getInt(2)+"~"+resultSet.getInt(3));
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return sb.toString();
	}
	
	
	public static boolean getParentTag_Total(String fnm)
	{
		System.out.println("Start ============================================");
		boolean f =false;
		int count=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select cls_no_of_times from cls_parent where cls_f_id=(select cls_f_id from cls_file where cls_f_name='"+fnm+"')");
		
			while(resultSet.next())
			{
				
				count=count+resultSet.getInt(1);
				
			}
			
			System.out.println("++++++++++++++++++++++++++++++= "+count);
			f = updateParentTotal(count,fnm);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return f;
	}
	
	public static boolean getChildTag_Total(String fnm)
	{
		boolean f =false;
		int count=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select cls_no_of_times from cls_child where cls_f_id=(select cls_f_id from cls_file where cls_f_name='"+fnm+"')");
		
			while(resultSet.next())
			{
				
				count=count+resultSet.getInt(1);
				
			}
			
			f = updateChildTotal(count,fnm);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		/*finally
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}*/
		return f;
	}
	
	public static boolean getContent_Total(String fnm)
	{
		boolean f =false;
		int count=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select cls_no_of_times from cls_content where cls_f_id=(select cls_f_id from cls_file where cls_f_name='"+fnm+"')");
		
			while(resultSet.next())
			{
				
				count=count+resultSet.getInt(1);
				
			}
			
			f = updateContentTotal(count,fnm);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return f;
	}
	
	
	public static boolean updateParentTotal(int total,String fname)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("update cls_file set cls_parent_tag_total='"+total+"' where cls_f_name='"+fname+"'");
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}
	
	public static boolean updateParentWeightage(double weight,int fid,int count)
	{
		boolean flag=false;
		try
		{
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			String sql = "update cls_parent set cls_weightage='"+weight+"' where cls_f_id='"+fid+"' and cls_no_of_times='"+count+"'";
			
			System.out.println("----------------------------------"+sql);
			int i = statement.executeUpdate(sql);
			
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}
	
	public static boolean updateChildWeightage(double weight,int fid,int count)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			String sql = "update cls_child set cls_weightage='"+weight+"' where cls_f_id='"+fid+"' and cls_no_of_times='"+count+"'";
			
			System.out.println("------_________________________________------"+sql);
			int i = statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}
	
	public static boolean updateContentWeightage(double weight,int fid,int count)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			String sql = "update cls_content set cls_weightage='"+weight+"' where cls_f_id='"+fid+"' and cls_no_of_times='"+count+"'";
			
			System.out.println("++++++++_________________________________++++++++++"+sql);
			int i = statement.executeUpdate(sql);
			
			
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}
	
	public static boolean updateChildTotal(int total,String fname)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("update cls_file set cls_child_tag_total='"+total+"' where cls_f_name='"+fname+"'");
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}
	
	public static boolean updateContentTotal(int total,String fname)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("update cls_file set cls_content_total='"+total+"' where cls_f_name='"+fname+"'");
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}
	
	
	
	public static int selectFileid(String username)
	{
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select cls_f_id from cls_file where cls_f_name='"+username+"'");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return i;
	}
	
	
	
	
	
	public static boolean addFile(String filenam)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			String sql="insert into cls_file(cls_f_name) values('"+filenam+"')";
			
			System.out.println("________________________"+sql);
			int i=statement.executeUpdate(sql);
			
			if(i!=0)
			{
				flag=true;
			}
			
			
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}
	
	
	
	 public static boolean fileExist(String filename) throws SQLException
		{
			boolean flag=false;
			

			try
			{
				DAO dao=DAO.getInstance();
				connection=dao.connector();
				statement = connection.createStatement();

				String sql="select *from cls_file where cls_f_name='"+filename+"'";
				
				resultSet=(ResultSet) statement.executeQuery(sql);

				while(resultSet.next())
				{
		
					flag=true;
				}

			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			finally
			{
				connection.close();
			}

			return flag;
		}
	    
	
	// tag reading process methods //
	
	
	public static boolean checkParent_Tag(String wor,int fid)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select *from cls_parent where cls_parent_tag='"+wor+"' and cls_f_id='"+fid+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			flg = true;
		}
		//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}

	public static boolean insert_Tag(String wor,int count,int fid)
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				String sql = "insert into cls_parent(cls_parent_tag,cls_no_of_times,cls_f_id) values('"+wor+"','"+count+"','"+fid+"')";
				
				//System.out.println(sql);
				statement.executeUpdate(sql);
				flg=true;
				
			
			
			//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}

	public static boolean update_Tag(String wor,int count,int fid)
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				String sql = "update cls_parent set cls_no_of_times='"+count+"' where cls_parent_tag='"+wor+"' and cls_f_id='"+fid+"'";
				
				//System.out.println(sql);
				statement.executeUpdate(sql);
				flg=true;
				
			
			
			//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static int select_parentIdTag(String ptag,int fid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select cls_parent_id from cls_parent where cls_parent_tag='"+ptag+"' and cls_f_id='"+fid+"'";
		
		System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			
		id = resultSet.getInt(1);	
		}
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return id;
	}

	public static String select_parentIdTag1(String ptag,int fid)
	{
		String str="";
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select cls_parent_id from cls_parent where cls_parent_tag='"+ptag+"' and cls_f_id='"+fid+"'";
		
		System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			
			str = resultSet.getInt(1)+"~";	
		}
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return str;
	}

	
	public static boolean checkContent(String wor,int fid,int pid)
	{
		
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select *from cls_content where cls_content='"+wor.trim()+"' and cls_f_id='"+fid+"' and cls_parent_id='"+pid+"'";
		
		System.out.println("********************************* "+sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			flg = true;
		}
		//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean checkChild_Tag(String wor,int fid,int pid)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select *from cls_child where cls_child_tag='"+wor+"' and cls_f_id='"+fid+"' and cls_parent_id='"+pid+"'";
		
		System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			flg = true;
		}
		//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean insertChild_Tag(String wor,int parentid,int count,int fid)
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				String sql = "insert into cls_child(cls_child_tag,cls_parent_id,cls_no_of_times,cls_f_id) values('"+wor+"','"+parentid+"','"+count+"','"+fid+"')";
				
				//System.out.println(sql);
				statement.executeUpdate(sql);
				flg=true;
				
			
			
			//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}

	public static boolean insertContent(String wor,int parentid,int count,int fid)
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				String sql = "insert into cls_content(cls_content,cls_parent_id,cls_no_of_times,cls_f_id) values('"+wor+"','"+parentid+"','"+count+"','"+fid+"')";
				
				//System.out.println(sql);
				statement.executeUpdate(sql);
				flg=true;
				
			
			
			//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	

	public static ResultSet selectFiles()
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				String sql = "select *from cls_file";
				
				//System.out.println(sql);
				resultSet = statement.executeQuery(sql);
				
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}


	public static int select_childIdTag(String ptag,int pid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select cls_no_of_times from cls_child where cls_child_tag='"+ptag+"' and cls_parent_id='"+pid+"'";
		
		System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			
		id = resultSet.getInt(1);	
		}
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return id;
	}

	public static int select_contentId(String ptag,int pid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select cls_no_of_times from cls_content where cls_content='"+ptag+"' and cls_parent_id='"+pid+"'";
		
		System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			
		id = resultSet.getInt(1);	
		}
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return id;
	}
	
	public static ResultSet select_ParentTag(int fid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select a.cls_parent_id,a.cls_parent_tag,a.cls_no_of_times,b.cls_f_name from cls_parent a,cls_file b where a.cls_f_id='"+fid+"'";
		
		System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}
	
	public static ResultSet select_ChildTag(int pid,int fid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select a.cls_child_tag,a.cls_parent_id,a.cls_no_of_times,b.cls_f_name from cls_child a,cls_file b where a.cls_f_id='"+fid+"' and a.cls_parent_id='"+pid+"'";
		
		System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}
	
	public static ResultSet select_Content(int pid,int fid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select a.cls_content,a.cls_parent_id,a.cls_no_of_times,b.cls_f_name from cls_content a,cls_file b where a.cls_f_id='"+fid+"' and a.cls_parent_id='"+pid+"'";
		
		System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}

	public static boolean updateChild_Tag(String wor,int pid,int fid)
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				int count =  select_childIdTag(wor,pid);
				
				count=count+1;
				
				String sql = "update cls_child set cls_no_of_times='"+count+"' where cls_child_tag='"+wor+"' and cls_parent_id='"+pid+"' and cls_f_id='"+fid+"'";
				
				//System.out.println(sql);
				statement.executeUpdate(sql);
				flg=true;
				
			
			
			//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}

	public static boolean updateContent(String wor,int pid,int fid)
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				int count =  select_contentId(wor,pid);
				
				count=count+1;
				
				String sql = "update cls_content set cls_no_of_times='"+count+"' where cls_content='"+wor+"' and cls_parent_id='"+pid+"' and cls_f_id='"+fid+"'";
				
				//System.out.println(sql);
				statement.executeUpdate(sql);
				flg=true;
				
			
			
			//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	//-========---------------=======================------------------=========================
	
	public static int insertinto_m_file_new(String filename,int clusterid)
	{
		boolean flg = false;
		String date_time="";
		int f_no=0;
		try
		{
			
			
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			
			String sql1 = "SELECT CURDATE(),CURTIME()";

			
			System.out.println(sql1);
			resultSet = statement.executeQuery(sql1);
			
			while(resultSet.next())
			{
				date_time=resultSet.getString(1)+" "+resultSet.getString(2);
			}
			
			
            String sql2 = "SELECT * from m_file";

			
			System.out.println(sql2);
			resultSet = statement.executeQuery(sql2);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				System.out.println("flag==========================="+flag);
				//System.out.println(sql);
				statement.executeUpdate(sql3);
			}
			else
			{
				
			}
			
			
			
			
			
			
				String sql = "insert into m_file(f_name,date_and_time,cluster_id) values('"+filename+"','"+date_time+"','"+clusterid+"')";
				
				//System.out.println(sql);
				int i=0;
			 i=statement.executeUpdate(sql);
			if(i!=0)	
			{
				flg=true;
			}
			
			if(flg)
			{
				String sql4 = "SELECT f_no from m_file where f_name='"+filename+"'  ";
				resultSet = statement.executeQuery(sql4);
				
				while(resultSet.next())
				{
					f_no=resultSet.getInt(1);
				}
				
			}
			
			
			//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return f_no;
	}
	
	public static String getClustername(int catid)
	{
		String name="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select cluster_name from m_cluster where cluster_id='"+catid+"'";
		
		System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			
			name = resultSet.getString(1);	
		}
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return name;
	}
	
	public static String insertblockname(int f_no,String blkname,String hashcode)
	{
		boolean flag=false;
		boolean flag7=false;
		
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql3="select * from m_blocks where hash_code='"+hashcode+"'";
			resultSet=statement.executeQuery(sql3);
			while(resultSet.next())
			{
				flag7=true;
			}
			
			if(flag7)
			{
				String sql4="select instance from m_blocks where hash_code='"+hashcode+"' ";
				int instance=0;
				System.out.println("________________________"+sql4);
				resultSet=statement.executeQuery(sql4);
				
				while(resultSet.next())
				{
					instance=resultSet.getInt(1);
				}
				
				instance=instance+1;
				String sql5="update m_blocks set instance='"+instance+"' where hash_code='"+hashcode+"'";
				
				System.out.println("________________________"+sql5);
				int i=statement.executeUpdate(sql5);
				
				if(i!=0)
				{
					
				}
				
			}
			else
			{
			
			int instnce=1;
			String sql="insert into m_blocks(f_no,blocks,hash_code,instance) values('"+f_no+"','"+blkname+"','"+hashcode+"','"+instnce+"')";
			
			System.out.println("________________________"+sql);
			int i=statement.executeUpdate(sql);
			
			if(i!=0)
			{
				flag=true;
			}
			}
			
			/*if(flag)
			{*/
				String sql2="select id from m_blocks where hash_code='"+hashcode+"'";
				resultSet=statement.executeQuery(sql2);
				while(resultSet.next())
				{
					id=resultSet.getInt(1);
				}
			/*}*/
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		StringBuffer sb=new StringBuffer();
		sb.append(id);
		sb.append("~~");
		sb.append(flag7);
		return sb.toString();
	}
	
	public static boolean update_file_lba(int f_no,String lba)
	{
		boolean flag=false;
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			String sql="update m_file set lba='"+lba+"'where f_no='"+f_no+"'";
			
			System.out.println("________________________"+sql);
			int i=statement.executeUpdate(sql);
			
			if(i!=0)
			{
				flag=true;
			}
			
			
			
			
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}
	
	
	
	
	
	
	
	
	public static String getblockname(String id)
	{
		
		ArrayList list = new ArrayList();
		String blkname="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select blocks from m_blocks where id='"+id+"'");
		
			while(resultSet.next())
			{
				blkname=resultSet.getString(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return blkname;
	}
	
	
	
	public static String getLBA(String fid)
	{
		
		ArrayList list = new ArrayList();
		String LBA="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select lba from m_file where f_no='"+fid+"'");
		
			while(resultSet.next())
			{
				LBA=resultSet.getString(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return LBA;
	}
	
	public static ResultSet filelist()
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		    String sql = "select * from m_file";
		
		System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}
	public static String getlbablocks(String fileid)
	{
		String data1="";
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select lba from m_file where f_no='"+fileid+"'");
		
			while(resultSet.next())
			{
				 data1=resultSet.getString(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return data1;
	}
	
	public static String getblocks(String hashid)
	{
		//String fileid= ConvertArrayToString.convertToString(id);
		String hashblkname=null;
		try {
			DAO dao=DAO.getInstance();
			connection = dao.connector();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select blk_name from m_hash_code where hash_unique_code='"
							+ hashid + "'");
			while (resultSet.next()) {
				hashblkname = resultSet.getString(1);
			}
			System.out.println("Block Name to return : " +hashblkname);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getFileName()....."
					+ e);
		}
		return hashblkname;
	}
	
	public static String getfilename(String fid)
	{
		
		ArrayList list = new ArrayList();
		String fname="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select f_name from m_file where f_no='"+fid+"'");
		
			while(resultSet.next())
			{
				fname=resultSet.getString(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return fname;
	}
	
	public static int getcluster(String fid)
	{
		
		ArrayList list = new ArrayList();
		int fname = 0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select cluster_id from m_file where f_no='"+fid+"'");
		
			while(resultSet.next())
			{
				fname=resultSet.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return fname;
	}
	
	
	
	

}
