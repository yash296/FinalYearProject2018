package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminDAO 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static AdminDAO AdminDAO=null;
	private AdminDAO()
	{
		
	}
	public static AdminDAO getInstance()
	{
		if(AdminDAO == null)
		{
			AdminDAO= new AdminDAO();
		}
		return AdminDAO;
	}
	public static boolean checkUser(String username,String password)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_admin where admin_id='"+username+"' and admin_pwd='"+password+"'");
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
	public static ResultSet getProfile(String username)
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_admin where admin_id='"+username+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getProfile()....."+e);
		}
		return resultSet;
	}
	public static boolean ChangePass(String name,String pwd)
	{
		boolean flg=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "update m_admin set admin_pwd = '"+pwd+"' where admin_id = '"+name+"' ";
			
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

}
