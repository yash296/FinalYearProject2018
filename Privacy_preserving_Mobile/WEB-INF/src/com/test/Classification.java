package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import com.dao.ClassifyDAO;
import com.dao.UserDAO;
import com.supportclass.Calculation;

public class Classification
{
	public Classification(String filename, InputStream in)
	{
		System.out.println("Test ---------------------");
		makeRootNode(filename,in);
	}

	private static void makeRootNode(String fnm,InputStream in) {
		try {
			// Use JAXP's DocumentBuilderFactory so that there
			// is no code here that is dependent on a particular
			// DOM parser. Use the system property
			// javax.xml.parsers.DocumentBuilderFactory (set either
			// from Java code or by using the -D option to "java").
			// or jre_dir/lib/jaxp.properties to specify this.

			System.out.println("Test vxcbvxc---------------------");
			
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();

			// Standard DOM code from hereon. The "parse"
			// method invokes the parser and returns a fully parsed
			// Document object. We'll then recursively descend the
			// tree and copy non-text nodes into JTree nodes.
			Document document = builder.parse(in);
			document.getDocumentElement().normalize();

			Element rootElement = document.getDocumentElement();

			String d = rootElement.getNodeName();

			System.out.println("Tag Name :" + d);

			buildTree(fnm,rootElement);
			
			
		 int fid = ClassifyDAO.selectFileid(fnm);
			 
			NodeList chil= rootElement.getChildNodes();
			
			int k=1;
			
			for(int i=0;i<chil.getLength();i++)
			{
				
				if(k==1)
				{
					
					Node c= chil.item(i);
					
					//System.out.println("========= xgxcxc"+c.getNodeName());
					
					
					NodeList sub= c.getChildNodes();
					
					for(int j=0;j<sub.getLength();j++)
					{
						
						Node ch= sub.item(j);
						//System.out.println("========= children un-necessary data from tag :"+ch.getNodeName());
						
					}
					k++;
				}
				else
				{
					
					int s=1;
					Node c= chil.item(i);
					
					System.out.println("========= "+c.getNodeName());
					
					int pid = ClassifyDAO.select_parentIdTag(c.getNodeName(),fid);
					
					System.out.println("Parent ID :"+pid);
					
					//String pid = ClassifyDAO.select_parentIdTag1(c.getNodeName(),fid);
					
					//String[] st = pid.split("~");
					
					//for(int i1=0;i1<st.length;i1++)
					//{
					
						NodeList sub= c.getChildNodes();
						
						
						
						for(int j=0;j<sub.getLength();j++)
						{
							
							if(s==1)
							{

								// un_neccessary data //
								Node ch= sub.item(j);
								//System.out.println("+++++++++++++++++++ children  :"+ch.getNodeName());
								s++;
							}
							else
							{
								int count=1;
								Node ch= sub.item(j);
								//System.out.println("+++++++++++++++++++ children  :"+ch.getTextContent());
								
								String treeNodeLabel = ch.getNodeName();
								
								System.out.println("treeNodeLabel :"+treeNodeLabel.trim());
								
								String content=ch.getTextContent();
								
								System.out.println("+++++++++++++++++++ children "+content.trim());
								
								boolean content_flg = ClassifyDAO.checkContent(content.trim(),fid,pid);
								
								if(!content_flg)
								{
									System.out.println("Insert Content -------------");
									ClassifyDAO.insertContent(content, pid, count,fid);
								}
								else
								{
									System.out.println("Update Content -------------");
									ClassifyDAO.updateContent(content, pid,fid);
								}
								
								boolean f = ClassifyDAO.checkChild_Tag(ch.getNodeName(),fid,pid);
								
								if(!f)
								{
									System.out.println("Insert New---------");
									ClassifyDAO.insertChild_Tag(ch.getNodeName(),pid, count,fid);
									
									
									
								}
								else
								{
									
									System.out.println("Update ---------");
									ClassifyDAO.updateChild_Tag(ch.getNodeName(),pid,fid);
									
									
								}
								
								s=1;
							}
							
							
						}
						
						k=1;
						
						
						boolean child_status = ClassifyDAO.getChildTag_Total(fnm);
						boolean content_status = ClassifyDAO.getContent_Total(fnm);
						
						System.out.println("child_status :"+child_status+"content_status :"+content_status);
					
					
					//}
						
						
					}
					
					/*NodeList sub= c.getChildNodes();
					
					
					
					for(int j=0;j<sub.getLength();j++)
					{
						
						if(s==1)
						{

							// un_neccessary data //
							Node ch= sub.item(j);
							//System.out.println("+++++++++++++++++++ children  :"+ch.getNodeName());
							s++;
						}
						else
						{
							int count=1;
							Node ch= sub.item(j);
							//System.out.println("+++++++++++++++++++ children  :"+ch.getTextContent());
							
							String content=ch.getTextContent();
							
							System.out.println("+++++++++++++++++++ children "+content.trim());
							
							boolean content_flg = ClassifyDAO.checkContent(content.trim(),fid);
							
							if(!content_flg)
							{
								System.out.println("Insert Content -------------");
								ClassifyDAO.insertContent(content, pid, count,fid);
							}
							else
							{
								System.out.println("Update Content -------------");
								ClassifyDAO.updateContent(content, pid,fid);
							}
							
							boolean f = ClassifyDAO.checkChild_Tag(ch.getNodeName(),fid);
							
							if(!f)
							{
								System.out.println("Insert New---------");
								ClassifyDAO.insertChild_Tag(ch.getNodeName(),pid, count,fid);
								
								
								
							}
							else
							{
								
								System.out.println("Update ---------");
								ClassifyDAO.updateChild_Tag(ch.getNodeName(),pid,fid);
								
								
							}
							
							s=1;
						}
						
						
					}
					
					k=1;
					
					
					boolean child_status = ClassifyDAO.getChildTag_Total(fnm);
					boolean content_status = ClassifyDAO.getContent_Total(fnm);
					
					System.out.println("child_status :"+child_status+"content_status :"+content_status);
				
				
				}*/
				
				
			}
			
			
			

		} catch (Exception e) {
			String errorMessage = "Error making root node: " + e;
			System.err.println(errorMessage);
			e.printStackTrace();

		}
	}
	

	private static void Content(Node rootElement)
	{
		
		System.out.println("Start to Read Content-----------");
		
		NamedNodeMap con = rootElement.getAttributes();
		
		for(int i=0;i<con.getLength();i++)
		{
		
			System.out.println("********************8 "+rootElement.getTextContent());
		}
	}

	private static void buildTree(String fnm,Element rootElement)
	{
		
		//System.out.println("Start -----------");
		String rootTreeNode = treeNodeLabel(rootElement);

		//System.out.println("rootTreeNode :"+rootTreeNode);
		
		addParent(fnm,rootTreeNode, rootElement);
		
	}
	
	private static void buildChild(Element rootElement)
	{
		
		System.out.println("Start -----------");
		String rootTreeNode = treeNodeLabel(rootElement);

		System.out.println("rootTreeNode :"+rootTreeNode);
		
		
		
		//addParent(rootTreeNode, rootElement);
		
		

	}

	private static void addParent(String fnm,String parentTreeNode, Node parentXMLElement)
	{

		String d ="";
		int count=1;
		NodeList childElements = parentXMLElement.getChildNodes();
		for (int i = 0; i < childElements.getLength(); i++)
		{
			Node childElement = childElements.item(i);
			if (!(childElement instanceof Text || childElement instanceof Comment))
			{
				
				 d =treeNodeLabel(childElement);
				
				
				 //System.out.println("Parent Data :"+d);
				
				 int fid = ClassifyDAO.selectFileid(fnm);
				 
				boolean f = ClassifyDAO.checkParent_Tag(d,fid);
				
				//System.out.println("Status :"+f);
				if(!f)
				{
					System.out.println("Insert New---------");
					ClassifyDAO.insert_Tag(d, count,fid);
					
					//int pid = DAO.select_parentIdTag(d);
					
					//addChild(d,pid, childElement);
					
					count=1;
				}
				else
				{
					count++;
					//System.out.println("Update ---------");
					
					//int pid = DAO.select_parentIdTag(d);
					
					//addChild(d,pid, childElement);
					
					ClassifyDAO.update_Tag(d, count,fid);
				}
				
				
				//int pid = DAO.select_parentIdTag(d);
				
				//addChild(d,pid, childElement);
				
			}
			
		}
		
		boolean ptotalUpdate_status = ClassifyDAO.getParentTag_Total(fnm);
		
		System.out.println("ptotalUpdate_status :"+ptotalUpdate_status);
		
	}
	
	
	private static String treeNodeLabel(Node childElement)
	{

		String treeNodeLabel ="";
		
		
			
			System.out.println("-----------------------------------");
			NamedNodeMap elementAttributes = childElement.getAttributes();
			
			treeNodeLabel = childElement.getNodeName();

			NodeList ch = childElement.getChildNodes();

		
		
		return (treeNodeLabel);
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		try
		{
		String fnm = "college.xml";
		boolean flg = ClassifyDAO.fileExist(fnm);
		
		System.out.println("File Status :"+flg);
		
		if(!flg)
		{
			ClassifyDAO.addFile(fnm.trim());
			
			Classification xt = new Classification(fnm.trim(),
					
					new FileInputStream(new File(fnm.trim())));
			
			
			int fid = ClassifyDAO.getFileId(fnm);
			
			Calculation.findFuzzy_Classify(fid);
		}
		
		}catch (Exception e)
		{
			
			System.out.println("Exception :"+e.toString());
		}
		
		

		
		
		

	}

}
