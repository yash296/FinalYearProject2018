package com.user.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
	
	public static long timedif(String start,String end) {
		 
		long diffSeconds = 0;
		long dr =0;
		long diffHours =0;
		//String dateStart = "05/09/2012 10:00:00";
		//String dateStop = "05/09/2012 16:00:00";
		
		String dateStart = start;
		String dateStop = end;
		
		System.out.println("dateStart :"+dateStart+" dateStop :"+dateStop);
 
		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
 
		Date d1 = null;
		Date d2 = null;
 
		try {
			d1 = format.parse(dateStart.trim());
			d2 = format.parse(dateStop.trim());
 
			//in milliseconds
			long diff = d2.getTime() - d1.getTime();
 
			 diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			
			//String d = diffHours+":"+diffMinutes+":"+diffSeconds;
			
			// df = Long.parseLong(d.trim());
			 
			// long diffSeconds1 = df / 1000 % 60;
				long diffMinutes1 = diffMinutes;
				
				long diffHours1 = diffHours*60;
				
				 dr = diffMinutes1+diffHours1;
				
				 System.out.println("@@@@@@@@@@@@@@@@@ "+dr);
				
				System.out.print("diffSeconds1 :"+diffMinutes1+">>>>>>>>>>"+diffHours1);
				
 
			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.print(diffSeconds + " seconds.");
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return diffSeconds;
 
	}
	
	public static void main(String[] args) {
		
		timedif("10:00:00","10:30:00");
	}
}


