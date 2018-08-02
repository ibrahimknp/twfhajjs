package com.plus.app.server;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import com.plus.app.client.util.MyLabel;
import com.plus.app.shared.MyExceptions;


public class Util {

	public static int getDiffDay(Date date1,Date date2)
	{
		Calendar c1=Calendar.getInstance();
		c1.setTime(date1);
		long diff1=c1.getTimeInMillis();

		Calendar c2=Calendar.getInstance();
		c2.setTime(date2);
		long diff2=c2.getTimeInMillis();

		long diff=diff2-diff1;
		int difference=(int)(diff/(24*60*60*1000));

		return difference;
	}

	public static Object[] day(int noOfDays,Date sDate,Date eDate)
	{
		int diff=getDiffDay(sDate, eDate)+1;
		//System.out.println("Difference left : "+diff+" NoDays : "+noOfDays+" : "+sDate+" : "+eDate);
		if(diff<=noOfDays)
		{
			Object obj[]=new Object[5];
			Calendar c=Calendar.getInstance();
			c.setTime(eDate);
			c.add(Calendar.DATE, 1);
			//System.out.println(diff+" : "+sDate+" : "+c.getTime());
			int diffs=noOfDays-diff;

			obj[0]=new Integer(diffs);
			obj[1]=c.getTime();
			obj[2]=sDate;
			obj[3]=eDate;
			obj[4]=new Integer(diff);

			return obj;
		}
		else if(diff>noOfDays)
		{
			Object obj[]=new Object[5];
			Calendar c=Calendar.getInstance();
			c.setTime(sDate);
			c.add(Calendar.DATE, noOfDays-1);
			//diff=diff-noOfDays;
			//System.out.println(noOfDays+" : "+sDate+" : "+c.getTime());

			obj[0]=new Integer(noOfDays);
			obj[1]=c.getTime();
			obj[2]=sDate;
			obj[3]=c.getTime();
			obj[4]=new Integer(noOfDays);

			return obj;

		}

		return null;
	}


	   public static Date getConvertDate(String str)throws MyExceptions , ParseException
	   {
		  // System.out.println(">"+str+".");
		   if(str!=null && str.length()!=0)
		   {
		     str = str.replace("-", "/");
			 SimpleDateFormat smp1=new SimpleDateFormat("dd/MM/yyyy");
		     Calendar c1=Calendar.getInstance();
		     c1.setTime(smp1.parse(str));

		     return c1.getTime();
		   }
		   else
			   return null;

	   }
	   public static Date getCurrentDate()throws MyExceptions , ParseException
	   {
		   Calendar c1=Calendar.getInstance();
		   c1.setTime(new Date());
		   c1.set(Calendar.HOUR, 0);
		   c1.set(Calendar.MINUTE, 0);
		   c1.set(Calendar.SECOND, 0);

		   return c1.getTime();
	   }
	   public static String getNextDate()throws MyExceptions , ParseException
	   {
		   Calendar c1=Calendar.getInstance();
		   c1.setTime(new Date());
		   c1.add(Calendar.DATE, 1);
		   c1.set(Calendar.HOUR, 0);
		   c1.set(Calendar.MINUTE, 0);
		   c1.set(Calendar.SECOND, 0);

		   SimpleDateFormat smp = new SimpleDateFormat("dd-MM-yyyy");

		   return smp.format(c1.getTime());
	   }
	   public static Object checkValue(Object obj)
	   {
		   Object str="";
		   if(obj!=null && !(obj.toString().equals("null")))
		   str=obj;

		   return str;
	   }
	   public static Object checkValue(Object objLa,Object objAr,boolean langAr)
	   {
		   Object str="";
		   if(langAr)
		   {
			   if(objAr!=null && !(objAr.toString().equals("null")))
				   str=objAr;
		   }
		   else
		   {
			   if(objLa!=null && !(objLa.toString().equals("null")))
				   str=objLa;
		   }
		   return str;
	   }
	   public static Integer checkNullIntZero(Object str)
		{
			if(str==null)
				return 0;
			else
				return Integer.valueOf(str.toString());
		}

	   public static Date getUtilDate(XMLGregorianCalendar geo)
		{
			try
			{

				Date dt=geo.toGregorianCalendar().getTime();
				Calendar c = Calendar.getInstance();
				c.setTime(dt);
				SimpleDateFormat smp = new SimpleDateFormat("dd-MMM-yyyy");
				String val=smp.format(c.getTime());


				return c.getTime();
			}
			catch(Exception ee)
			{
				return null;
			}

		}

	   public static String getUtilDates(XMLGregorianCalendar geo)
		{
			try
			{

				Date dt=geo.toGregorianCalendar().getTime();
				Calendar c = Calendar.getInstance();
				c.setTime(dt);
				SimpleDateFormat smp = new SimpleDateFormat("dd-MM-yyyy");
				String val=smp.format(c.getTime());


				return val;
			}
			catch(Exception ee)
			{
				return null;
			}

		}

	   /**
	    *
	    * @param eng		english parameter
	    * @param arabic		arabic parameter
	    * @param direction	if pass false then return english else arabic
	    * @return
	    */
	   public static String getLangValue(String eng,String arabic,boolean locale)
	   {
		   if(locale)
			   return arabic;
		   else
			   return eng;
	   }
	   public static void setListData(List list,Object obj[],int row)
	   {
		  
	   }

	   public static Long checkNull(Object obj)
	   {
		   if(obj!=null && obj.toString().length()!=0)
		   {
			  return Long.valueOf(obj.toString());
		   }

		   return null;

	   }
	   public static String checkNullString(Object obj)
	   {
		   if(obj!=null && obj.toString().length()!=0)
		   {
			  return obj.toString();
		   }

		   return null;

	   }
	   public static String split(String str,int index)
		{
		   try {
			   if(str.indexOf(":")!=-1)
				{
					String val[]=str.split(":");
					return val[index].toString();
				}

		} catch (Exception e) {
			// TODO: handle exception
		}
				return null;
		}
}
