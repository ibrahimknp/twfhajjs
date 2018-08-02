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
import com.plus.app.client.async.V_Luk_City_Service;
import com.plus.app.server.ExceptionsContainer;
import com.plus.app.server.HibernateUtil;
import com.plus.app.shared.MyExceptions;
import com.plus.app.shared.dao.V_Luk_City;
import com.plus.app.shared.wrapper.V_Luk_City_Wrapper;

public class V_Luk_City_ServiceImpl extends RemoteServiceServlet implements V_Luk_City_Service{
	
	private static final long	serialVersionUID	= -8480133366196663439L;
	ExceptionsContainer excep=ExceptionsContainer.getInstance();
	private static Logger log = Logger.getLogger( V_Luk_City_ServiceImpl.class );
	Date dt = new Date();
	
	public String save(V_Luk_City_Wrapper meta)throws MyExceptions
	{
		Session session=HibernateUtil.currentSession();
		try 
		{
			session.beginTransaction();
			
			session.save(meta.getV_Luk_City());
			session.getTransaction().commit();
			
			return (meta.getV_Luk_City().getId()).toString();
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
	
	public V_Luk_City_Wrapper save_return(V_Luk_City_Wrapper meta)throws MyExceptions
	{
		Session session=HibernateUtil.currentSession();
		try 
		{
			session.beginTransaction();
			
			session.save(meta.getV_Luk_City());
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
	public String update(V_Luk_City_Wrapper meta)throws MyExceptions
	{
		Session session=HibernateUtil.currentSession();
		try 
		{
			session.beginTransaction();
			
			session.update(meta.getV_Luk_City());
			session.getTransaction().commit();
			
			return (meta.getV_Luk_City().getId()).toString();
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
	public V_Luk_City_Wrapper update_return(V_Luk_City_Wrapper meta)throws MyExceptions
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
				V_Luk_City_Wrapper mm = new V_Luk_City_Wrapper();
				mm.setQuery(meta.getReturn_query());
				meta = getListData(mm);
				V_Luk_City hv =(V_Luk_City)meta.getListV_Luk_City().get(0);
				meta.setV_Luk_City(hv);
			}
			else
			{
				session.update(meta.getV_Luk_City());
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
	
	public V_Luk_City_Wrapper deleteSave(V_Luk_City_Wrapper meta)throws MyExceptions
	{
		Session session=HibernateUtil.currentSession();
		try 
		{
			session.beginTransaction();
			
			
			Query qry=session.createQuery(meta.getQuery());
			qry.executeUpdate();
			List<V_Luk_City> lst=meta.getListV_Luk_City();
			for(V_Luk_City s : lst)
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
	
	public V_Luk_City_Wrapper getListData(V_Luk_City_Wrapper meta)throws MyExceptions
	{
		Session session=HibernateUtil.currentSession();
		try 
		{
			session.beginTransaction();
			
			List lst=new ArrayList();
			lst=session.createQuery(meta.getQuery()).list();
			session.getTransaction().commit();
			meta.setListV_Luk_City(lst);
			
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
	
	public V_Luk_City_Wrapper getTableData(V_Luk_City_Wrapper meta)throws MyExceptions
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
			meta.setListV_Luk_City(lst);
			
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



