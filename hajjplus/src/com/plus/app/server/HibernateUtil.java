package com.plus.app.server;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil implements Serializable{
	
	static final long serialVersionUID=1L;
	
	public static SessionFactory sessionFactory;
	static Configuration config=new Configuration();
	
	static
	{
		try
		{
			
			config.configure("hibernate.cfg.xml");
			sessionFactory=config.buildSessionFactory();
			
			System.out.println("..."+config.getProperty("hibernate.connection.username")+" - "+new Date());
			
			
			
		}
		catch(Throwable ex)
		{
			System.err.println("Initialization failed : "+ex);
			throw new ExceptionInInitializerError(ex);
		}
		
	}
	
	public static SessionFactory getInstance()
	{
		return sessionFactory;
	}
	
	public static Session currentSession()
	{
		return getInstance().getCurrentSession();
		
	}
	
	
	public static void main(String[] args) 
	{
		System.out.println(new HibernateUtil().getInstance().getCurrentSession());
		System.out.println(new HibernateUtil().getInstance().openSession());
	}
	
	
	

}
