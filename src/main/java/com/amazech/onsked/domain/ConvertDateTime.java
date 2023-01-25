package com.amazech.onsked.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ConvertDateTime implements Serializable {
	private static final long serialVersionUID = 8516136148633671357L;
	

	public String convertMMddyyyyToMMMddyyyy(String date){
		    String convertedDate = "";
		    SimpleDateFormat inputDateFormat = new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat outputDateFormat = new SimpleDateFormat("MMM-dd-yyyy");
			inputDateFormat.setLenient(false);

			try {
				convertedDate = outputDateFormat.format(inputDateFormat.parse(date));
				System.out.println(" %%%% format the date by anand method "+date);
			} catch (ParseException pe) {
				// Date is not in MM/DD/YYYY format
			}
			return convertedDate;
	}
	
	public String convertyyyyMMddToMMMddyyyy(String date){
	    String convertedDate = "";
	    SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat outputDateFormat = new SimpleDateFormat("MMM-dd-yyyy");
		inputDateFormat.setLenient(false);

		try {
			convertedDate = outputDateFormat.format(inputDateFormat.parse(date));
			System.out.println(" %%%% format the date by anand method "+date);
		} catch (ParseException pe) {
			// Date is not in MM/DD/YYYY format
		}
		return convertedDate;
	}
	
	public String convertDateFormat(String date,String inputFormat,String outputFormat){
	    String convertedDate = "";
	    SimpleDateFormat inputDateFormat = new SimpleDateFormat(inputFormat);
		SimpleDateFormat outputDateFormat = new SimpleDateFormat(outputFormat);
		inputDateFormat.setLenient(false);

		try {
			convertedDate = outputDateFormat.format(inputDateFormat.parse(date));
			System.out.println(" %%%% format the date by anand method "+date);
		} catch (ParseException pe) {
			// Date is not in MM/DD/YYYY format
		}
		return convertedDate;
	}
	
	public String ConvertTimeZoneOfTimeStamp(String fromTimeZone,String toTimeZone,String date){
	    
	      //Date date = new Date();
		Date dt = null;
		  SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  try {
			  dateFormatGmt.setTimeZone(TimeZone.getTimeZone(fromTimeZone));
			dt = dateFormatGmt.parse(date);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      DateFormat toFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	      TimeZone toTimezn = TimeZone.getTimeZone(toTimeZone);
	      toFormat.setTimeZone(toTimezn);
			
	      System.out.println("-->"+toTimeZone+":secondTime.. "+toTimezn+" ,,," + toFormat.format(dt));
	      return toFormat.format(dt);
	    
	}
	
	public String ConvertTimeZoneOfTimeStampAmPm(String fromTimeZone,String toTimeZone,String date){
	    
	      //Date date = new Date();
		Date dt = null;
		  SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MM-dd h:mm:ss a");
		  try {
			  dateFormatGmt.setTimeZone(TimeZone.getTimeZone(fromTimeZone));
			dt = dateFormatGmt.parse(date);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      DateFormat toFormat = new SimpleDateFormat("yyyy-MM-dd h:mm:ss a");
	      TimeZone toTimezn = TimeZone.getTimeZone(toTimeZone);
	      toFormat.setTimeZone(toTimezn);
			
	      System.out.println("-->"+toTimeZone+":secondTime.. "+toTimezn+" ,,," + toFormat.format(dt));
	      return toFormat.format(dt);
	    
	}
	
	public String ConvertTimeZoneOfTime(String fromTimeZone,String toTimeZone,String time){
	    
	      //Date date = new Date();
		Date dt = null;
		  SimpleDateFormat dateFormatGmt = new SimpleDateFormat("HH:mm:ss");
		  try {
			  dateFormatGmt.setTimeZone(TimeZone.getTimeZone(fromTimeZone));
			dt = dateFormatGmt.parse(time);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      DateFormat toFormat = new SimpleDateFormat("HH:mm:ss");
	      TimeZone toTimezn = TimeZone.getTimeZone(toTimeZone);
	      toFormat.setTimeZone(toTimezn);
			
	      System.out.println("-->"+toTimeZone+":secondTime.. "+toTimezn+" ,,," + toFormat.format(dt));
	      return toFormat.format(dt);
	}
}
