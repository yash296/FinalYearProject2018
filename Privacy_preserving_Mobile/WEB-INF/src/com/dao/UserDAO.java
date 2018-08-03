/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.dao.*;




public class UserDAO 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static UserDAO userDAO=null;
	private UserDAO()
	{
		
	}
	public static UserDAO getInstance()
	{
		if(userDAO == null)
		{
			userDAO= new UserDAO();
		}
		return userDAO;
	}
	
	
	public static boolean ChangePass(String name,String pwd)
	{
		boolean flg=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "update m_user set u_pass = '"+pwd+"' where u_id = '"+name+"' ";
			
		 int i=statement.executeUpdate(sql);
			
			if(i!=0)
			{
				flg=true;
			}
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return flg;
		
	}
	public static boolean upload1(String filename, String keyword) 
	{
		boolean flag=false;
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			statement.executeUpdate("insert into m_file (f_name,key_word) values('"+filename+"','"+keyword+"')");
			
			flag=true;
			
			System.out.println("File Insertion Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-uploadS()....."+e);
		}
		return flag;
	}
	
	public static boolean updateNewOntology(String data,String catnm) 
	{
		boolean flag=false;
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			statement.executeUpdate("insert into m_terms (word,cluster_id) values('"+data+"',(select cluster_id from m_cluster where cluster_name='"+catnm+"'))");
			
			flag=true;
			
			System.out.println("File Insertion Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-uploadS()....."+e);
		}
		return flag;
	}
	
	public static ArrayList getkey_word(String fname)
	{
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select *from t_count where f_no=(select f_no from m_file where f_name='"+fname+"')";
		
		
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			
			list.add(resultSet.getString(3)+"@"+resultSet.getString(4));
			
		}
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return list;
	}
	public static boolean check(String wor)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select *from t_word where f_word='"+wor+"'";
		
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
	
	public static boolean checkParent(String wor)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select cluster_id from m_terms where word like '%"+wor+"%' ";
		
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

	public static int getFile_total(String fname)
	{
		int total=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select total from m_file where f_name='"+fname+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			total=resultSet.getInt(1);
		}
		System.out.println("Total:"+total);
		
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return total;
	}

	public static boolean update_weigtage(String keyword,String fname,String weightage)
	{
		boolean flg =false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "update t_count set weightage='"+weightage+"' where f_no=(select f_no from m_file where f_name='"+fname+"') and key_word='"+keyword+"'";
		
		
		int i=statement.executeUpdate(sql);
		
		if(i!=0)
		{
			flg=true;
		}
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	public static boolean count_word(String wor,int count,String fname)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "insert into t_count(f_no,key_word,key_rank) values((select f_no from m_file where f_name='"+fname+"'),'"+wor+"','"+count+"')";
		
		System.out.println("======query imp======"+sql);
		statement.executeUpdate(sql);
		flg=true;
//		System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	
	public static boolean inserttocategory(String wor,int count,String fname,int cat,String tablename)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			
			
		String sql = "insert into '"+tablename+"'(f_no,key_word,key_rank,category_id) values((select f_no from m_file where f_name='"+fname+"'),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		statement.executeUpdate(sql);
		flg=true;
//		System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean updateClassification(String fname,String classify)
	{
		boolean flg=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "update m_file set classification = '"+classify+"' where f_name = '"+fname+"' ";
			
		 int i=statement.executeUpdate(sql);
			
			if(i!=0)
			{
				flg=true;
			}
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return flg;
		
	}
	
	
	public static ArrayList<String> getCloud()
	{
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select c_code,c_url,c_uname,c_pwd from m_cloud where c_code='1'");
		
			while(resultSet.next())
			{
				
				list.add(resultSet.getString(1));
				list.add(resultSet.getString(2));
				list.add(resultSet.getString(3));
				list.add(resultSet.getString(4));
			}
			
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
		return list;
	}
	
	public static ResultSet getFile_Name()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select f_id,f_name from m_file");
		
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return resultSet;
	}
	
	public static boolean insertWord(String word,int cid)
	{
		boolean f =false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("insert into m_terms(word,cluster_id) values('"+word.trim()+"','"+cid+"')");
		
			if(i!=0)
			{
				f=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return f;
	}
	
	public static ArrayList getWeightage(int fid)
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select no_of_times from m_parent where f_id='"+fid+"'");
		
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
	
	public static ArrayList getWeight(int fid)
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select parent_tag,weightage from m_parent where f_id='"+fid+"'");
			
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1)+"~"+resultSet.getString(2));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return list;
	}
	
	public static ArrayList getChild_Weight(int fid)
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select child_tag,weightage from m_child where f_id='"+fid+"'");
			
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1)+"~"+resultSet.getString(2));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return list;
	}
	
	public static ArrayList getContent_Weight(int fid)
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select content,weightage from m_content where f_id='"+fid+"'");
			
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1)+"~"+resultSet.getString(2));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return list;
	}
	
	public static ArrayList getStructureRank(int fid)
	{
		
		ArrayList list = new ArrayList();
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select rank from m_parent where f_id='"+fid+"'");
			
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1));
				
			}
			
			System.out.println("List :"+list);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return list;
	}
	
	public static ArrayList getStructureRank1(int fid)
	{
		
		ArrayList list = new ArrayList();
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select rank from m_child where f_id='"+fid+"'");
			
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1));
				
			}
			
			System.out.println("List :"+list);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return list;
	}
	
	public static ArrayList getTextualRank(int fid)
	{
		
		ArrayList list = new ArrayList();
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select rank from m_content where f_id='"+fid+"'");
			
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1));
				
			}
			
			System.out.println("List :"+list);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return list;
	}
	
	public static boolean updateVectorVal(int fid,String vectorval,String contentvec)
	{
		
		boolean flg=false;
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("update m_file set struct_vector='"+vectorval+"',content_vector='"+contentvec+"' where f_id='"+fid+"'");
			
		if(i!=0)
		{
			flg=true;
		}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return flg;
	}
	
	public static String getClassify_Weight(int fid,String ptag)
	{
		
		String cls_weight="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select cls_weightage from cls_parent where cls_parent_tag='"+ptag+"'");
			
		
			while(resultSet.next())
			{
				cls_weight=resultSet.getString(1);
			}
			
			System.out.println("cls_weightage :"+cls_weight);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return cls_weight;
	}
	
	public static String getClassify_ChildWeight(int fid,String ptag)
	{
		
		String cls_weight="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select cls_weightage from cls_child where cls_child_tag='"+ptag+"'");
			
		
			while(resultSet.next())
			{
				cls_weight=resultSet.getString(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return cls_weight;
	}
	
	public static String getClassify_ContentWeight(int fid,String ptag)
	{
		
		String cls_weight="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select cls_weightage from cls_content where cls_content='"+ptag+"'");
			
		
			while(resultSet.next())
			{
				cls_weight=resultSet.getString(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		
		return cls_weight;
	}
	
	public static ArrayList getChildWeightage(int fid)
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select no_of_times from m_child where f_id='"+fid+"'");
		
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
	
	public static ArrayList getContentWeightage(int fid)
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select no_of_times from m_content where f_id='"+fid+"'");
		
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
			resultSet = statement.executeQuery("select parent_tag_total,child_tag_total,content_total from m_file where f_id='"+fid+"'");
			
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
			resultSet = statement.executeQuery("select no_of_times from m_parent where f_id=(select f_id from m_file where f_name='"+fnm+"')");
		
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
	public static ArrayList<String>  selectKeyword(String fnm)
	{
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			String sql = "select key_word from t_count where f_no=(select f_no from m_file where f_name='"+fnm+"')";
			
			System.out.println(sql);
			
			resultSet = statement.executeQuery(sql);
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->selectKeyword(String userid): "+ e);
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
		return list;
	}
	public static boolean checkkeywordCategory(String key)
	{
		boolean f=false;
		int catcode=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select cluster_id from m_terms where word='"+key+"'");
		
			while(resultSet.next())
			{
				catcode = resultSet.getInt(1);
			}
			
			//System.out.println("Category Code :"+catcode);
			updateCatCode(key,catcode);	
			f=true;
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->selectKeyword(String userid): "+ e);
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
	
	public static ArrayList<String> checkClustering()
	{
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select key_rank,category_id from t_count where category_id>=1");
		
			while(resultSet.next())
			{
				
				list.add(resultSet.getInt(1)+"~"+resultSet.getInt(2));
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->selectKeyword(String userid): "+ e);
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
		return list;
	}
	
	public static int getRank(int catid)
	{
		int rank=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select key_rank from t_count where category_id='"+catid+"'");
		
			while(resultSet.next())
			{
				rank = resultSet.getInt(1);
			
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->selectKeyword(String userid): "+ e);
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
		return rank;
	}
	
	public static String getCategory(int code)
	{
		String catname="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select category_name from m_cluster where cluster_id='"+code+"'");
		
			while(resultSet.next())
			{
				
				catname = resultSet.getString(1);
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->selectKeyword(String userid): "+ e);
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
		return catname;
	}
	
	public static ArrayList<String> getKeywords()
	{
		
		ArrayList<String> arrayList = new ArrayList<String>();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select key_word from t_count where key_rank>=7");
		
			while(resultSet.next())
			{
				
				arrayList.add(resultSet.getString(1));
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->selectKeyword(String userid): "+ e);
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
		return arrayList;
	}
	
	public static boolean refereshTrans()
	{
		boolean f =false;
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("truncate table t_count");
		
			if(i!=0)
			{
				f=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->updateCatCode(String userid): "+ e);
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
	
	public static boolean updateCatCode(String key,int code)
	{
		boolean f =false;
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("update t_count set category_id='"+code+"' where key_word='"+key+"'");
		
			if(i!=0)
			{
				f=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->updateCatCode(String userid): "+ e);
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
	
	public static boolean getContent_Total(String fnm)
	{
		boolean f =false;
		int count=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select no_of_times from m_content where f_id=(select f_id from m_file where f_name='"+fnm+"')");
		
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
			int i = statement.executeUpdate("update m_file set parent_tag_total='"+total+"' where f_name='"+fname+"'");
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
			int i = statement.executeUpdate("update m_parent set weightage='"+weight+"' where f_id='"+fid+"' and no_of_times='"+count+"'");
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
	
	public static boolean updateRank(double weight,int fid,String count)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("update t_count set rank='"+weight+"' where f_id='"+fid+"' and parent_tag='"+count+"'");
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
	
	public static boolean updateChildRank(double weight,int fid,String count)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("update m_child set rank='"+weight+"' where f_id='"+fid+"' and child_tag='"+count+"'");
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
	
	public static boolean updateContentRank(double weight,int fid,String count)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("update m_content set rank='"+weight+"' where f_id='"+fid+"' and content='"+count+"'");
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
			int i = statement.executeUpdate("update m_child set weightage='"+weight+"' where f_id='"+fid+"' and no_of_times='"+count+"'");
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
			int i = statement.executeUpdate("update m_content set weightage='"+weight+"' where f_id='"+fid+"' and no_of_times='"+count+"'");
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
			int i = statement.executeUpdate("update m_file set child_tag_total='"+total+"' where f_name='"+fname+"'");
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
			int i = statement.executeUpdate("update m_file set content_total='"+total+"' where f_name='"+fname+"'");
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
	
	
	
	public static boolean checkUser(String username,String password)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where u_id='"+username+"' and u_pass='"+password+"'");
			while(resultSet.next())
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
	
	public static boolean checkAlreadyExist(String userid)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where u_id='"+userid+"'");
			while(resultSet.next())
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
	public static int selectFileid(String username)
	{
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select f_id from m_file where f_name='"+username+"'");
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
	
	
	
	
	public boolean addUser(String userid,String password,String name,String email,String phone)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			String sql="insert into m_user(u_id,u_pass,u_name,u_email,u_phone) values('"+userid+"','"+password+"','"+name+"','"+email+"','"+phone+"')";
			
			int i=statement.executeUpdate(sql);
			
			if(i!=0)
			{
				flag=true;
			}
			
			
			//System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}
	
	/* Get Profile Details (Starts) */
	
	public static ResultSet getProfile(String username)
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where u_id='"+username+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getProfile()....."+e);
		}
		return resultSet;
	}
	
	/* Get Profile Details (Ends) */
	
	public String getID(String username)
	{
		String i="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select u_code from m_user where userid='"+username+"'");
			while(resultSet.next())
			{
				i=resultSet.getString(1);
			}
			//System.out.println("User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getID(String userid): ");
			e.printStackTrace();
		}
		return i;
	}
	
	 public static boolean fileExist(String filename) throws SQLException
		{
			boolean flag=false;
			

			try
			{
				DAO dao=DAO.getInstance();
				connection=dao.connector();
				statement = connection.createStatement();

				String sql="select * from m_file where f_name='"+filename+"'";
				
				System.out.println(sql);
				
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
	    
	
	public static boolean editProfile(String [] s) 
	{
		boolean flag=false;
		String sql = "";
		try
		{   
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_user set u_name='"+s[1]+"',u_id='"+s[2]+"',u_email='"+s[3]+"',u_phone='"+s[4]+"' where u_no='"+s[0]+"'";
			//System.out.println("******* Edit User Profile Info *********\n");
		System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			//System.out.println("User Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-editProfile() :");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean chnagePass(int id,String cpass) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_user set password='"+cpass+"' where u_code='"+id+"'";
			//System.out.println("******* Change User Password Info *********\n");
			//System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			//System.out.println("User Change Pass Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-chnagePass() : ");
			e.printStackTrace();
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
		String sql = "select *from m_parent where parent_tag='"+wor+"' and f_id='"+fid+"'";
		
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
				String sql = "insert into m_parent(parent_tag,no_of_times,f_id) values('"+wor+"','"+count+"','"+fid+"')";
				
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
				String sql = "update m_parent set no_of_times='"+count+"' where parent_tag='"+wor+"' and f_id='"+fid+"'";
				
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
		String sql = "select parent_id from m_parent where parent_tag='"+ptag+"' and f_id='"+fid+"'";
		
		//System.out.println(sql);
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

	
	public static boolean checkContent(String wor,int fid,int pid)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select *from m_content where content='"+wor+"' and f_id='"+fid+"' and parent_id='"+pid+"'";
		
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
	
	public static boolean checkChild_Tag(String wor,int fid,int pid)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select *from m_child where child_tag='"+wor+"' and f_id='"+fid+"' and parent_id='"+pid+"'";
		
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
	
	public static boolean insertChild_Tag(String wor,int parentid,int count,int fid)
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				String sql = "insert into m_child(child_tag,parent_id,no_of_times,f_id) values('"+wor+"','"+parentid+"','"+count+"','"+fid+"')";
				
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
				String sql = "insert into m_content(content,parent_id,no_of_times,f_id) values('"+wor+"','"+parentid+"','"+count+"','"+fid+"')";
				
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
	
	public static boolean addFile(String filename)
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				String sql = "insert into m_file(f_name) values('"+filename+"')";
				
				System.out.println(sql);
				int i = statement.executeUpdate(sql);
				if(i!=0)
				{
					flg=true;
					
				}
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	/*public static boolean emptyTables()
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				String sql = "Delete from m_file";
				String sql1 = "Delete from m_parent";
				String sql2 = "Delete from m_child";
				String sql3 = "Delete from m_content";
				
				//System.out.println(sql);
				int i = statement.executeUpdate(sql);
				int i1 = statement.executeUpdate(sql1);
				int i2 = statement.executeUpdate(sql2);
				int i3 = statement.executeUpdate(sql3);
				if(i!=0)
				{
					flg=true;
					
				}
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
*/
	public static ResultSet selectFiles()
	{
		boolean flg = false;
		try
		{
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
				String sql = "select *from m_file";
				
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
		String sql = "select no_of_times from m_child where child_tag='"+ptag+"' and parent_id='"+pid+"'";
		
		//System.out.println(sql);
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
		String sql = "select no_of_times from m_content where content='"+ptag+"' and parent_id='"+pid+"'";
		
		//System.out.println(sql);
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
		String sql = "select a.parent_tag,a.no_of_times,b.f_name,a.weightage from m_parent a,m_file b where a.f_id='"+fid+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}
	
	public static ResultSet select_ChildTag(int fid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select a.child_tag,a.parent_id,a.no_of_times,b.f_name,a.weightage from m_child a,m_file b where a.f_id='"+fid+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}
	
	public static ResultSet select_Content(int fid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select a.content,a.parent_id,a.no_of_times,b.f_name,a.weightage from m_content a,m_file b where a.f_id='"+fid+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}

	public static ResultSet select_Vector(int fid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select f_name,struct_vector from m_file where f_id='"+fid+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}
	
	public static ResultSet select_ConVector(int fid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select f_name,content_vector from m_file where f_id='"+fid+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}
	
	public static ResultSet select_classify(int fid)
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select f_name,classification from m_file where f_id='"+fid+"'";
		
		//System.out.println(sql);
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
				
				String sql = "update m_child set no_of_times='"+count+"' where child_tag='"+wor+"' and parent_id='"+pid+"' and f_id='"+fid+"'";
				
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
				
				String sql = "update m_content set no_of_times='"+count+"' where content='"+wor+"' and parent_id='"+pid+"' and f_id='"+fid+"'";
				
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
	
	//-----------------------------------------------------------------------------25/02/2016------------==========================================
	public static int checkkeywordCategorynew(String key)
	{
		boolean f=false;
		int catcode=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select cluster_id from m_terms where word='"+key+"'");
			String sql="select cluster_id from m_terms where word='"+key+"'";
			System.out.println("========================="+sql);
			while(resultSet.next())
			{
				catcode = resultSet.getInt(1);
			}
			System.out.println("============catcode============="+catcode);
			
			//System.out.println("Category Code :"+catcode);
			/*updateCatCode(key,catcode);	
			f=true;*/
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->selectKeyword(String userid): "+ e);
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
		return catcode;
	}
	public static boolean inserttocategorycardio(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			
           String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_1 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			/*int c=count7+count;
			String sql3 = "update m_cardiology set key_rank='"+c+"' where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( )) and key_word='"+wor+"'";
			
			System.out.println("======sql3 imp======"+sql3);
			statement.executeUpdate(sql3);*/
		}
		
		
		else
		{
		
		
		
		String sql = "insert into m_cluster_1(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
	   return flg;
	}
	public static boolean inserttocategorynumerology(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			
			
			
			
			String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_3 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			/*int c=count7+count;
			String sql3 = "update m_neurology set key_rank='"+c+"' where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( )) and key_word='"+wor+"'";
			
			System.out.println("======sql3 imp======"+sql3);
			statement.executeUpdate(sql3);*/
		}
		
		
		else
		{
		
			
			
			
			
			
			
			
			
			
			
		String sql = "insert into m_cluster_3(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	public static boolean inserttocategorydigestive(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			
			
            String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_2 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			
		}
		
		
		else
		{

			
			
		String sql = "insert into m_cluster_2(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	public static boolean inserttocategoryrespiratory(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
            String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_4 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			
		}
		
		
		else
		{

	
			
		String sql = "insert into m_cluster_4(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
//====================================================================================================	
	
	public static boolean inserttocategorydental(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
            String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_5 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			
		}
		
		
		else
		{

	
			
		String sql = "insert into m_cluster_5(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean inserttocategoryforensic(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
            String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_6 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			
		}
		
		
		else
		{

	
			
		String sql = "insert into m_cluster_6(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean inserttocategoryhistology(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
            String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_8 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			
		}
		
		
		else
		{

	
			
		String sql = "insert into m_cluster_8(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean inserttocategorymicro(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
            String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_9 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			
		}
		
		
		else
		{

	
			
		String sql = "insert into m_cluster_9(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean inserttocategorynephro(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
            String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_10 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			
		}
		
		
		else
		{

	
			
		String sql = "insert into m_cluster_10(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean inserttocategoryobesity(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
            String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_11 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			
		}
		
		
		else
		{

	
			
		String sql = "insert into m_cluster_11(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean inserttocategoryoncology(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
            String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_12 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			
		}
		
		
		else
		{

	
			
		String sql = "insert into m_cluster_12(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean inserttocategoryopthomology(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
            String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_13 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			
		}
		
		
		else
		{

	
			
		String sql = "insert into m_cluster_13(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean inserttocategoryorthology(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
            String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_14 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			
		}
		
		
		else
		{

	
			
		String sql = "insert into m_cluster_14(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean inserttocategoryotorhinology(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
            String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_15 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			
		}
		
		
		else
		{

	
			
		String sql = "insert into m_cluster_15(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean inserttocategorypaediatrics(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
            String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_16 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			
		}
		
		
		else
		{

	
			
		String sql = "insert into m_cluster_16(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean inserttocategorypathology(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
            String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_17 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			
		}
		
		
		else
		{

	
			
		String sql = "insert into m_cluster_17(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean inserttocategoryphysiology(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
            String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_18 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			
		}
		
		
		else
		{

	
			
		String sql = "insert into m_cluster_18(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean inserttocategoryphycology(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
            String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_19 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			
		}
		
		
		else
		{

	
			
		String sql = "insert into m_cluster_19(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean inserttocategorysurgery(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
            String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_20 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			
		}
		
		
		else
		{

	
			
		String sql = "insert into m_cluster_20(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	public static boolean inserttocategorygynocology(String wor,int count,String fname,int cat)
	{
		String tabname="m_file";
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
            String sql4 = "SELECT * from m_file";

			
			System.out.println(sql4);
			resultSet = statement.executeQuery(sql4);
			boolean flag=true;
			while(resultSet.next())
			{
				flag=false;
			}
			
			if(flag)
			{
             String sql3 = "ALTER TABLE m_file AUTO_INCREMENT = 1001";
				
				//System.out.println(sql);
				statement.executeUpdate(sql3);
				
			}
			
			
			
			
		String sql2="select key_rank from m_cluster_7 where f_no=(SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ) and key_word='"+wor+"' ";	
		System.out.println("======sql2 imp======"+sql2);
		ResultSet rs= statement.executeQuery(sql2);
		int count7=0;
		while(rs.next())
		{
			count7=rs.getInt(1);
			
		}
		
		if(count7>0)
		{
			
		}
		
		
		else
		{

	
			
		String sql = "insert into m_cluster_7(f_no,key_word,key_rank,cluster_id) values((SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '"+tabname+"' AND table_schema = DATABASE( ) ),'"+wor+"','"+count+"','"+cat+"')";
		
		System.out.println("======query imp======"+sql);
		int i=0;
		i=statement.executeUpdate(sql);
		if(i>0)
		{
			flg=true;
		}
//		System.out.println("Search status:"+flg);
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
