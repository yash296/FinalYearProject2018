package com.supportclass;

import java.text.DecimalFormat;
import java.util.ArrayList;

import com.dao.ClassifyDAO;
import com.dao.UserDAO;

public class Calculation 
{

	public static int countVal(String count)
	{
		int coun=0;
		String[] s = count.split("~");
		
		for(int i=0;i<s.length;i++)
		{
		coun = coun+Integer.parseInt(s[i].trim());
			
		}
		
		return coun;
		
	}
	
	public static boolean updateNewKeyword(String catnm)
	{
		
		ArrayList<String> s = UserDAO.getKeywords();
		System.out.println("Key Words :"+s);
		if(catnm.equals("Sensitive"))
		{
			for(int i=0;i<s.size();i++)
			{
				UserDAO.updateNewOntology(s.get(i), catnm);
				
			}
			
		}
		if(catnm.equals("Nonsensitive"))
		{
			
			for(int i=0;i<s.size();i++)
			{
				UserDAO.updateNewOntology(s.get(i), catnm);
				
			}
		}
		
		return true;
		
		
	}
	
	public static boolean findFuzzy(String file_id)
	{
		String tot = UserDAO.getTot(Integer.parseInt(file_id));
		
		String[] ptot = tot.split("~");
		
		StringBuffer sb = new StringBuffer();
		ArrayList rs = UserDAO.getWeightage(Integer.parseInt(file_id));
		
		DecimalFormat df = new DecimalFormat( "#.##" );  
		
		for(int i=0;i<rs.size();i++)
		{
			int weig = Integer.parseInt(rs.get(i).toString().trim());
			
			Double percentage = ((double)weig/Integer.parseInt(ptot[0].trim())) * 100; 
			sb.append(percentage+"~");
			UserDAO.updateParentWeightage(Double.parseDouble(df.format(percentage)), Integer.parseInt(file_id),weig);
			System.out.println("weitage xc:"+percentage+"weig "+weig);
		}
		
		System.out.println("============================================");
		
		System.out.println("+++++++++++++++ Start Child Update ++++++++++++++ ");
		ArrayList list = UserDAO.getChildWeightage(Integer.parseInt(file_id));
		
		for(int i=0;i<list.size();i++)
		{
			int weig = Integer.parseInt(list.get(i).toString().trim());
			
			
			Double percentage = ((double)weig/Integer.parseInt(ptot[1].trim())) * 100; 
			
			UserDAO.updateChildWeightage(Double.parseDouble(df.format(percentage)), Integer.parseInt(file_id),weig);
			System.out.println("weitage xc:"+percentage+"weig "+weig);
		}
		
		System.out.println("=========================================");
		
		System.out.println("**************** Start Content Update **************** ");
		ArrayList content = UserDAO.getContentWeightage(Integer.parseInt(file_id));
		
		for(int i=0;i<content.size();i++)
		{
			int weig = Integer.parseInt(content.get(i).toString().trim());
			
			
			Double percentage = ((double)weig/Integer.parseInt(ptot[1].trim())) * 100; 
			
			UserDAO.updateContentWeightage(Double.parseDouble(df.format(percentage)), Integer.parseInt(file_id),weig);
			System.out.println("weitage xc:"+percentage+"weig "+weig);
		}
		
		return true;
		
	}
	
	public static boolean findRank(String file_id)
	{
		
		boolean f=false;
		StringBuffer sb = new StringBuffer();
		
		// Get Weightage from parent table //
		ArrayList rs = UserDAO.getWeight(Integer.parseInt(file_id));
		
		DecimalFormat df = new DecimalFormat( "#.##" );  
		
		for(int i=0;i<rs.size();i++)
		{
			
			StringBuffer sb1 = new StringBuffer();
			
			String dat = rs.get(i).toString().trim();
			
			String[] tag_weight=dat.split("~");
			
			String cls_weight = UserDAO.getClassify_Weight(Integer.parseInt(file_id), tag_weight[0].trim());
			
			//System.out.println("hhhh "+cls_weight.trim());
			//System.out.println("cls_weight :"+cls_weight);
			
			if(cls_weight.trim().equals(""))
			{
				
				//System.out.println("Classify Weightage :"+cls_weight);
				
				double weig = Double.parseDouble(tag_weight[1].trim());
				
				
				Double percentage = 0.0; 
				sb.append(percentage+"~");
				
				// update rank into m_parent table //
				UserDAO.updateRank(Double.parseDouble(df.format(percentage)), Integer.parseInt(file_id),tag_weight[0].trim());
				
				//System.out.println("Rank for Parent Tag: "+percentage+"weig "+weig);
			}
			else
			{
				//System.out.println("Classify Weightage :"+cls_weight);
				
				double weig = Double.parseDouble(tag_weight[1].trim());
				
				Double percentage = (weig/Double.parseDouble(cls_weight.trim())) * 100; 
				sb.append(percentage+"~");
				
				// update rank into m_parent table //
				UserDAO.updateRank(Double.parseDouble(df.format(percentage)), Integer.parseInt(file_id),tag_weight[0].trim());
				
				//System.out.println("Rank for Parent Tag: "+percentage+"weig "+weig);	
			}
			
		}
		System.out.println("Rank :"+sb.toString());
		//System.out.println("============================================");
		
		ArrayList rs1 = UserDAO.getChild_Weight(Integer.parseInt(file_id));
		
		 
		
		for(int i=0;i<rs1.size();i++)
		{
			
			String dat = rs1.get(i).toString().trim();
			
			String[] tag_weight=dat.split("~");
			
			String cls_weight = UserDAO.getClassify_ChildWeight(Integer.parseInt(file_id), tag_weight[0].trim());
			
			
			if(cls_weight.trim().equals(""))
			{
				
				//System.out.println("Classify Child Weightage :"+cls_weight);
				
				double weig = Double.parseDouble(tag_weight[1].trim());
				
				Double percentage = 0.0; 
				//sb.append(percentage+"~");
				
				// update rank into m_parent table //
				UserDAO.updateChildRank(Double.parseDouble(df.format(percentage)), Integer.parseInt(file_id),tag_weight[0].trim());
				
				//System.out.println("Rank for Child Tag: "+percentage+"weig "+weig);
			}
			else
			{
				//System.out.println("Classify Child Weightage :"+cls_weight);
				
				double weig = Double.parseDouble(tag_weight[1].trim());
				
				Double percentage = (weig/Double.parseDouble(cls_weight.trim())) * 100; 
				sb.append(percentage+"~");
				
				// update rank into m_parent table //
				UserDAO.updateChildRank(Double.parseDouble(df.format(percentage)), Integer.parseInt(file_id),tag_weight[0].trim());
				
				//System.out.println("Rank for Child Tag: "+percentage+"weig "+weig);
			}
			
		}
		
		System.out.println("============================================");
		
		ArrayList rs2 = UserDAO.getContent_Weight(Integer.parseInt(file_id));
		
		 
		
		for(int i=0;i<rs2.size();i++)
		{
			
			String dat = rs2.get(i).toString().trim();
			
			String[] tag_weight=dat.split("~");
			
			String cls_weight = UserDAO.getClassify_ContentWeight(Integer.parseInt(file_id), tag_weight[0].trim());
			
			if(cls_weight.trim().equals(""))
			{
				
				//System.out.println("Classify Content Weightage :"+cls_weight);
				
				double weig = Double.parseDouble(tag_weight[1].trim());
				
				Double percentage = 0.0; 
				//sb.append(percentage+"~");
				
				// update rank into m_parent table //
				UserDAO.updateContentRank(Double.parseDouble(df.format(percentage)), Integer.parseInt(file_id),tag_weight[0].trim());
				
				//System.out.println("Rank for Content Tag: "+percentage+"weig "+weig);
			}
			else
			{
				
				//System.out.println("Classify Content Weightage :"+cls_weight);
				
				double weig = Double.parseDouble(tag_weight[1].trim());
				
				Double percentage = (weig/Double.parseDouble(cls_weight.trim())) * 100; 
				sb.append(percentage+"~");
				
				// update rank into m_parent table //
				UserDAO.updateContentRank(Double.parseDouble(df.format(percentage)), Integer.parseInt(file_id),tag_weight[0].trim());
				
				//System.out.println("Rank for Content Tag: "+percentage+"weig "+weig);
			}
			
			
		}
		
		f=true;
		
		return f;
		
	}
	
	public static String updateVector(int fileid)
	{
		
		String vector="";
		boolean f=false;
		double vec = 0 ;
		ArrayList list = UserDAO.getStructureRank(fileid);
		
		DecimalFormat df = new DecimalFormat( "#.##" ); 
		
		for(int i=0;i<list.size();i++)
		{
			String str = list.get(i).toString().trim();
			
			vec = vec+Double.parseDouble(str.trim());
			
		}
		
		//System.out.println("Total for Parent Tag :"+vec);
		
		ArrayList list1 = UserDAO.getStructureRank1(fileid);
		
		for(int i=0;i<list1.size();i++)
		{
			String str = list1.get(i).toString().trim();
			
			vec = vec+Double.parseDouble(str.trim());
			
		}
		
		//System.out.println("Total for Child Tag :"+vec);
		
		ArrayList list2 = UserDAO.getTextualRank(fileid);
		
		double content_vec=0;
		
		for(int i=0;i<list2.size();i++)
		{
			String str = list2.get(i).toString().trim();
			
			content_vec = content_vec+Double.parseDouble(str.trim());
			
		}
		
		//System.out.println("Total for Content Vector :"+content_vec);
		
		f = UserDAO.updateVectorVal(fileid, df.format(vec),df.format(content_vec));
		
		vector=vec+"~"+content_vec;
		
		return vector;
		
	}
	
	public static boolean findFuzzy_Classify(int file_id)
	{
		String tot = ClassifyDAO.getTot(file_id);
		
		String[] ptot = tot.split("~");
		
		StringBuffer sb = new StringBuffer();
		ArrayList rs = ClassifyDAO.getWeightage(file_id);
		
		DecimalFormat df = new DecimalFormat( "#.##" );  
		
		for(int i=0;i<rs.size();i++)
		{
			int weig = Integer.parseInt(rs.get(i).toString().trim());
			
			Double percentage = ((double)weig/Integer.parseInt(ptot[0].trim())) * 100; 
			sb.append(percentage+"~");
			ClassifyDAO.updateParentWeightage(Double.parseDouble(df.format(percentage)), file_id,weig);
			//System.out.println("weitage xc:"+percentage+"weig "+weig);
		}
		
		System.out.println("============================================");
		
		System.out.println("+++++++++++++++ Start Child Update ++++++++++++++ ");
		ArrayList list = ClassifyDAO.getChildWeightage(file_id);
		
		for(int i=0;i<list.size();i++)
		{
			int weig = Integer.parseInt(list.get(i).toString().trim());
			
			
			Double percentage = ((double)weig/Integer.parseInt(ptot[1].trim())) * 100; 
			
			ClassifyDAO.updateChildWeightage(Double.parseDouble(df.format(percentage)), file_id,weig);
			//System.out.println("weitage xc:"+percentage+"weig "+weig);
		}
		
		System.out.println("=========================================");
		
		System.out.println("**************** Start Content Update **************** ");
		ArrayList content = ClassifyDAO.getContentWeightage(file_id);
		
		for(int i=0;i<content.size();i++)
		{
			int weig = Integer.parseInt(content.get(i).toString().trim());
			
			
			Double percentage = ((double)weig/Integer.parseInt(ptot[1].trim())) * 100; 
			
			ClassifyDAO.updateContentWeightage(Double.parseDouble(df.format(percentage)), file_id,weig);
			//System.out.println("weitage xc:"+percentage+"weig "+weig);
		}
		
		return true;
		
	}
	
	
	public static void main(String args[])
	{
		
		
			int val1=4; 
			int total=6; 
			Double percentage = ((double)val1/total) * 100; 
			System.out.println(val1+" of "+total+" is equal to ="+percentage+" %"); 
			
		
		/*double d = 103.2345;  
		DecimalFormat df1 = new DecimalFormat( "#.00" );  
		System.out.println( df1.format( d ) ); */ 
		
		
		DecimalFormat df = new DecimalFormat( "#.##" );  
		//System.out.println( df.format( d ) );  
		
		int obtainMarks=80 , totalMarks = 100 ;  
        double avgMarks;  
		avgMarks    = ( ( obtainMarks / totalMarks ) * 100 );
		
		System.out.println("avgMarks :"+df.format(avgMarks)+"( obtainMarks / totalMarks ) "+( obtainMarks / totalMarks ) );
	}
}
