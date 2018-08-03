package com.test;

public class TrainingData
{

	public static void classifiProcess(String filname)
	{

		if (filname.contains("Cardio"))
		{
			Category.insertTerms(filname, 1);
		}
		else if (filname.contains("Digestive"))
		{
			Category.insertTerms(filname, 2);

		} 
		else if (filname.contains("Neurology")) 
		{
			Category.insertTerms(filname, 3);
		}
		else
		{
			Category.insertTerms(filname, 4);
		}

	}
	
	public static void main(String[] args)
	{
		
		//classifiProcess("Cardio.txt");
		//classifiProcess("Digestive.txt");
		
	//classifiProcess("Neurology.txt");
		//classifiProcess("Respiratory.txt");
	}
}
