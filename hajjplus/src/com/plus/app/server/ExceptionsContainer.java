package com.plus.app.server;

import java.sql.BatchUpdateException;

import org.hibernate.HibernateException;

import com.inet.ora.Ora3SQLException;

public class ExceptionsContainer {
	
	public static ExceptionsContainer instance=new ExceptionsContainer();
	
	public static ExceptionsContainer getInstance()
	{
		return instance;
	}
	
	public String getErrorMessage(Throwable ex)
	{
		if (ex instanceof HibernateException)
		{
			HibernateException hiber=(HibernateException)ex;
			int length=hiber.getThrowables().length;
			System.out.println("Lenght : "+length);
			for(int a=0;a<length;a++)
			{
				Throwable thr=hiber.getThrowable(a);
				if(thr instanceof BatchUpdateException) 
				{
					BatchUpdateException exp_name = (BatchUpdateException) thr;
					String message=exp_name.getMessage();
					try {
						String s = message.substring(message.indexOf("ORA-"));
						message = s.substring(s.indexOf("ORA-"),s.indexOf("."));	
					} catch (Exception e) {
						// TODO: handle exception
					}
										
					return message;
				}
			}
		}
		else if(ex instanceof Ora3SQLException)
		{
			Ora3SQLException hiber=(Ora3SQLException)ex;
			int errorCode=hiber.getErrorCode();
			return String.valueOf(errorCode);
		}
		
		return ex.getMessage();
	}
	
	public String getErrorConstraintMessage(String constraint,String error,Throwable ex)
	{
		//System.out.println(ex);
		if (ex instanceof HibernateException)
		{
			HibernateException hiber=(HibernateException)ex;
			int length=hiber.getThrowables().length;
			for(int a=0;a<length;a++)
			{
				Throwable thr=hiber.getThrowable(a);
				//System.out.println(thr);
				if(thr instanceof BatchUpdateException) 
				{
					BatchUpdateException exp_name = (BatchUpdateException) thr;
					String message=exp_name.getMessage();
					System.out.println(message);
					if(message.indexOf(constraint)!=-1)
						return error;
						else
					return message;
				}
			}
		}
		else if(ex instanceof Ora3SQLException)
		{
			Ora3SQLException hiber=(Ora3SQLException)ex;
			int errorCode=hiber.getErrorCode();
			if(String.valueOf(constraint).equals(""+errorCode))
			return hiber.getMessage();
		}
		
		return ex.getMessage();
	}
	

}
