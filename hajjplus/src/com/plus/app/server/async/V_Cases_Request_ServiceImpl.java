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
import com.plus.app.client.async.V_Cases_Request_Service;
import com.plus.app.server.ExceptionsContainer;
import com.plus.app.server.HibernateUtil;
import com.plus.app.shared.MyExceptions;
import com.plus.app.shared.dao.V_Cases_Request;
import com.plus.app.shared.wrapper.V_Cases_Request_Wrapper;

public class V_Cases_Request_ServiceImpl extends RemoteServiceServlet implements V_Cases_Request_Service{
	
	private static final long	serialVersionUID	= -8480133366196663439L;
	ExceptionsContainer excep=ExceptionsContainer.getInstance();
	private static Logger log = Logger.getLogger( V_Cases_Request_ServiceImpl.class );
	Date dt = new Date();
	
	public String save(V_Cases_Request_Wrapper meta)throws MyExceptions
	{
		Session session=HibernateUtil.currentSession();
		try 
		{
			session.beginTransaction();
			
			session.save(meta.getV_Cases_Request());
			session.getTransaction().commit();
			
			return (meta.getV_Cases_Request().getId()).toString();
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
	
	public V_Cases_Request_Wrapper save_return(V_Cases_Request_Wrapper meta)throws MyExceptions
	{
		Session session=HibernateUtil.currentSession();
		try 
		{
			session.beginTransaction();
			
			session.save(meta.getV_Cases_Request());
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
	public String update(V_Cases_Request_Wrapper meta)throws MyExceptions
	{
		Session session=HibernateUtil.currentSession();
		try 
		{
			session.beginTransaction();
			
			session.update(meta.getV_Cases_Request());
			session.getTransaction().commit();
			
			return (meta.getV_Cases_Request().getId()).toString();
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
	public V_Cases_Request_Wrapper update_return(V_Cases_Request_Wrapper meta)throws MyExceptions
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
				V_Cases_Request_Wrapper mm = new V_Cases_Request_Wrapper();
				mm.setQuery(meta.getReturn_query());
				meta = getListData(mm);
				V_Cases_Request hv =(V_Cases_Request)meta.getListV_Cases_Request().get(0);
				meta.setV_Cases_Request(hv);
			}
			else
			{
				session.update(meta.getV_Cases_Request());
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
	
	public V_Cases_Request_Wrapper deleteSave(V_Cases_Request_Wrapper meta)throws MyExceptions
	{
		Session session=HibernateUtil.currentSession();
		try 
		{
			session.beginTransaction();
			
			
			Query qry=session.createQuery(meta.getQuery());
			qry.executeUpdate();
			List<V_Cases_Request> lst=meta.getListV_Cases_Request();
			for(V_Cases_Request s : lst)
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
	
	public V_Cases_Request_Wrapper getListData(V_Cases_Request_Wrapper meta)throws MyExceptions
	{
		Session session=HibernateUtil.currentSession();
		try 
		{
			session.beginTransaction();
			
			List lst=new ArrayList();
			lst=session.createQuery(meta.getQuery()).list();
			session.getTransaction().commit();
			meta.setListV_Cases_Request(lst);
			
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
	
	public V_Cases_Request_Wrapper getTableData(V_Cases_Request_Wrapper meta)throws MyExceptions
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
			meta.setListV_Cases_Request(lst);
			
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



