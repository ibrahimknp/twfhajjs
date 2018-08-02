package com.plus.app.server;
 

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.plus.app.shared.MyExceptions;
  
public class ServerValidation {
	
	ExceptionsContainer excep=ExceptionsContainer.getInstance();
	
	private static ServerValidation	instance;
	public static ServerValidation getInstance()
	{
		if(instance == null )
		{
			instance = new ServerValidation();
		}
		return instance;
	}
	
	 
	
	public boolean hotelInOut(String intDate,String outDate,String inOutDate)throws MyExceptions , ParseException
	{
			if(!(intDate==null || outDate==null || inOutDate ==null))
			{   
				intDate=intDate.replace("-", "/"); 
				outDate=outDate.replace("-", "/");
				inOutDate=inOutDate.replace("-", "/");
				
			 	SimpleDateFormat smp=new SimpleDateFormat("dd/MM/yyyy");
				// in date
				Calendar cStart=Calendar.getInstance();
		        cStart.setTime(smp.parse(intDate));
		        Date dinDate = cStart.getTime();
		        
		     // out date
				Calendar cEnd=Calendar.getInstance();
		        cEnd.setTime(smp.parse(outDate));
		        Date doutDate = cEnd.getTime();
		        
		     // inout date
				Calendar cArrival=Calendar.getInstance();
		        cArrival.setTime(smp.parse(inOutDate));
		        Date dinOutlDate = cArrival.getTime();
				
		      
		        if(dinOutlDate.before(dinDate))
		        throw new NullPointerException("Date should be between Hotel In Date and Hotel Out Date ");
		        if(dinOutlDate.after(doutDate))
		        	throw new NullPointerException("Date should be between Hotel In Date and Hotel Out Date");
		         
			}
		
			return true;
	}
	
	
	
	 
}
