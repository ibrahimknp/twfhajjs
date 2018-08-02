package com.plus.app.server.async;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.plus.app.client.async.Dummy_Service;
import com.plus.app.server.ExceptionsContainer;
import com.plus.app.server.HibernateUtil;
import com.plus.app.shared.MyExceptions;
import com.plus.app.shared.dao.Dummy;
import com.plus.app.shared.wrapper.Dummy_Wrapper;

public class Dummy_ServiceImpl extends RemoteServiceServlet implements Dummy_Service{
	
	private static final long	serialVersionUID	= -8480133366196663439L;
	ExceptionsContainer excep=ExceptionsContainer.getInstance();
	private static Logger log = Logger.getLogger( Dummy_ServiceImpl.class );
	Date dt = new Date();
	
	public String save(Dummy_Wrapper meta)throws MyExceptions
	{
		Session session=HibernateUtil.currentSession();
		try 
		{
			session.beginTransaction();
			
			session.save(meta.getDummy());
			session.getTransaction().commit();
			
			return (meta.getDummy().getId()).toString();
		} 
		catch (Throwable thr) 
		{
			log.error("save",thr);
			session.getTransaction().rollback();			
			MyExceptions my=MyExceptions.getInstance();
			String message=excep.getErrorMessage(thr);
			my.setMessage(message);	
			throw my;
		}
	}
	
	public Dummy_Wrapper save_return(Dummy_Wrapper meta)throws MyExceptions
	{
		Session session=HibernateUtil.currentSession();
		try 
		{
			session.beginTransaction();
			
			session.save(meta.getDummy());
			session.getTransaction().commit();
			
			return meta;
		} 
		catch (Throwable thr) 
		{
			log.error("save_return",thr);
			session.getTransaction().rollback();			
			MyExceptions my=MyExceptions.getInstance();
			String message=excep.getErrorMessage(thr);
			my.setMessage(message);	
			throw my;
		}
	}
	public String update(Dummy_Wrapper meta)throws MyExceptions
	{
		Session session=HibernateUtil.currentSession();
		try 
		{
			session.beginTransaction();
			
			session.update(meta.getDummy());
			session.getTransaction().commit();
			
			return (meta.getDummy().getId()).toString();
		} 
		catch (Throwable thr) 
		{
			log.error("update",thr);
			session.getTransaction().rollback();			
			MyExceptions my=MyExceptions.getInstance();
			String message=excep.getErrorMessage(thr);
			my.setMessage(message);	
			throw my;
		}
	}
	public Dummy_Wrapper update_return(Dummy_Wrapper meta)throws MyExceptions
	{
		Session session=HibernateUtil.currentSession();
		Connection	connection = null;
		Statement stmt = null;
		try 
		{
			session.beginTransaction();
			
			if(meta.getQuery()!=null)
			{
				connection = session.connection();
				stmt= connection.createStatement();
				stmt.executeUpdate(meta.getQuery());
				if(meta.getReturn_query()==null)
					throw new NullPointerException("Return Query not found for refresh the grid");
				Dummy_Wrapper mm = new Dummy_Wrapper();
				mm.setQuery(meta.getReturn_query());
				meta = getListData(mm);
				Dummy hv =(Dummy)meta.getListDummy().get(0);
				meta.setDummy(hv);
			}
			else
			{
				session.update(meta.getDummy());
				session.getTransaction().commit();
			}
			
			
			
			return meta;
		} 
		catch (Throwable thr) 
		{
			log.error("update_return",thr);
			session.getTransaction().rollback();			
			MyExceptions my=MyExceptions.getInstance();
			String message=excep.getErrorMessage(thr);
			my.setMessage(message);	
			throw my;
		}
		finally
		{
			try {
				stmt.close();
				connection.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public Dummy_Wrapper deleteSave(Dummy_Wrapper meta)throws MyExceptions
	{
		Session session=HibernateUtil.currentSession();
		try 
		{
			session.beginTransaction();
			
			
			Query qry=session.createQuery(meta.getQuery());
			qry.executeUpdate();
			List<Dummy> lst=meta.getListDummy();
			for(Dummy s : lst)
			{
				session.save(s); 
			}
			session.getTransaction().commit();
			
			return meta;
		} 
		catch (Throwable thr) 
		{
			log.error("deleteSave",thr);
			session.getTransaction().rollback();			
			MyExceptions my=MyExceptions.getInstance();
			String message=excep.getErrorMessage(thr);
			my.setMessage(message);	
			throw my;
		}
	}
	
	public Dummy_Wrapper getListData(Dummy_Wrapper meta)throws MyExceptions
	{
		Session session=HibernateUtil.currentSession();
		try 
		{
			session.beginTransaction();
			
			List lst=new ArrayList();
			lst=session.createQuery(meta.getQuery()).list();
			session.getTransaction().commit();
			meta.setListDummy(lst);
			
			return meta;
		} 
		catch (Throwable thr) 
		{
			log.error("getListData",thr);
			session.getTransaction().rollback();			
			MyExceptions my=MyExceptions.getInstance();
			String message=excep.getErrorMessage(thr);
			my.setMessage(message);	
			throw my;
		}
	}
	
	public Dummy_Wrapper getTableData(Dummy_Wrapper meta)throws MyExceptions
	{
		Session session=HibernateUtil.currentSession();
		try 
		{
			session.beginTransaction();
						
			List lst=new ArrayList();
			Query qry=session.createQuery(meta.getQuery());
			qry.setFirstResult(meta.getStartRow());
			qry.setMaxResults(meta.getMaxRow());
			// qry.setFetchSize(5);
			lst=qry.list();
			session.getTransaction().commit();
			meta.setListDummy(lst);
			
			return meta;
		} 
		catch (Throwable thr) 
		{
			log.error("getTableData",thr);
			session.getTransaction().rollback();			
			MyExceptions my=MyExceptions.getInstance();
			String message=excep.getErrorMessage(thr);
			my.setMessage(message);	
			throw my;
		}
	}	
	
}


