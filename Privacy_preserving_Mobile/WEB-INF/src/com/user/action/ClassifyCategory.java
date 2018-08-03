package com.user.action;

import java.util.ArrayList;

public class ClassifyCategory
{
	
	public static String findCategory(ArrayList<Integer> arrayList,ArrayList<String> list)
	{
		String category=" ";
		if(arrayList.size()==1)
		{
			category = list.get(0);
		}
		else if(arrayList.size()==2)
		{
			int a,b;
			a = arrayList.get(0);
			b = arrayList.get(1);
			
			if(a>b)
			{
				category = list.get(0);	
			}
			else
			{
				category = list.get(1);	
			}
		}
		else if(arrayList.size()==3)
		{
			
			int a,b,c;
			a = arrayList.get(0);
			b = arrayList.get(1);
			c = arrayList.get(2);
			
			if(a>b && a>c)
			{
				category = list.get(0);	
			}
			else if(b>c)
			{
				category = list.get(1);	
			}
			else
			{
				category = list.get(2);	
			}
			
		}
		else 
		{
			int a,b,c,d;
			a = arrayList.get(0);
			b = arrayList.get(1);
			c = arrayList.get(2);
			d = arrayList.get(3);
			
			//System.out.println("Array :"+arrayList);
			if(a>b && a>c && a>d)
			{
				//System.out.println("Array 1:"+a);
				category = list.get(0);	
			}
			else if(b>c && b>d)
			{
				//System.out.println("Array 2:"+b);
				category = list.get(1);	
			}
			else if(c>d)
			{
				//System.out.println("Array 3:"+c);
				category = list.get(2);	
			}
			else
			{
				//System.out.println("Array 4:"+d);
				category = list.get(3);	
			}
		}
		return category;
		
	}

}
