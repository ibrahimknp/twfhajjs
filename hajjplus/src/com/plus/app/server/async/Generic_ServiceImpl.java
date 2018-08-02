package com.plus.app.server.async;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.plus.app.client.async.Generic_Service;
import com.plus.app.server.ExceptionsContainer;
import com.plus.app.server.HibernateUtil;
import com.plus.app.server.ServerValidation;
import com.plus.app.shared.MyExceptions;
import com.plus.app.shared.Utils;
import com.plus.app.shared.dao.Generic_Wrapper;

public class Generic_ServiceImpl extends RemoteServiceServlet implements
		Generic_Service {

	private static final long serialVersionUID = -8480133366196663439L;
	ExceptionsContainer excep = ExceptionsContainer.getInstance();
	private static Logger log = Logger.getLogger(Generic_ServiceImpl.class);
	private HashMap hashMess = new HashMap();
	HashMap hash = new HashMap();

	//ResourceBundle resource = ResourceBundle.getBundle("Attachments");
	

	public String updateQuery(Generic_Wrapper meta) throws MyExceptions {
		Session session = HibernateUtil.currentSession();
		try {
			session.beginTransaction();
			if(meta.getCode().equals(Generic_Wrapper.INT_TRIP))
			{
				Query qry = session.createQuery("Update Int_Trip set it_uuser="+meta.getUserId()+", it_udate=sysdate,it_update_status=3 where it_id="+meta.getId());
				qry.executeUpdate();
			}
			Query qry = session.createQuery(meta.getQuery());
			qry.executeUpdate();
			session.getTransaction().commit();
			
			if(meta.getStr()!=null)
			{
				
			}
			
			return "SUCESS";
		} catch (Throwable thr) {
			session.getTransaction().rollback();
			log.error("updateQuery", thr);
			MyExceptions my = MyExceptions.getInstance();
			String message = excep.getErrorMessage(thr);
			my.setMessage(message);
			throw my;
		}
	}

	public String updateListQuery(Generic_Wrapper meta) throws MyExceptions {
		Session session = HibernateUtil.currentSession();
		try {
			session.beginTransaction();
			List lst = meta.getLst();
			Iterator iter = lst.listIterator();
			while (iter.hasNext()) {
				String str = (String) iter.next();
				// System.out.println(str);
				Query qry = session.createQuery(str);
				int result = qry.executeUpdate();

			}
			session.getTransaction().commit();

			return "SUCESS";
		} catch (Throwable thr) {
			session.getTransaction().rollback();
			log.error("updateListQuery", thr);
			MyExceptions my = MyExceptions.getInstance();
			String message = excep.getErrorMessage(thr);
			my.setMessage(message);
			throw my;
		}
	}

	public String getNoOfRecords(Generic_Wrapper meta) throws MyExceptions {
		Session session = HibernateUtil.currentSession();
		try {
			session.beginTransaction();
			List lst = session.createQuery(meta.getQuery()).list();
			Long count = (Long) lst.get(0);

			session.getTransaction().commit();

			return count.toString();
		} catch (Throwable thr) {
			log.error("getNoOfRecords", thr);
			// session.getTransaction().rollback();
			// thr.printStackTrace();

			MyExceptions my = MyExceptions.getInstance();
			String message = excep.getErrorMessage(thr);
			my.setMessage(message);
			throw my;
		}
	}

	public String callProcedure(Generic_Wrapper meta) throws MyExceptions {
		Connection con = null;
		Session session = HibernateUtil.currentSession();
		try {

			session.beginTransaction();
			String str = meta.getQuery();
			if (str != null) {
				Query qry = session.createQuery(str);
				qry.executeUpdate();
			}
			String result = "";
			con = session.connection();
			// System.out.println("server ca");
			CallableStatement prep = con.prepareCall("{ call "
					+ meta.getProcedure() + "}");
			// System.out.println("server ca 1");
			List lst = meta.getParams();
			// System.out.println(lst);
			int a = 0;
			for (; a < lst.size(); a++) {
				// System.out.println("server ca 2:"+lst.get(a));
				if (lst.get(a) instanceof Integer)
					prep.setInt(a + 1, ((Integer) lst.get(a)).intValue());
				else if (lst.get(a) instanceof Long)
					prep.setLong(a + 1, ((Long) lst.get(a)).longValue());
				else if (lst.get(a) instanceof String)
					prep.setString(a + 1, ((String) lst.get(a)));

			}
			prep.registerOutParameter(a + 1, java.sql.Types.VARCHAR);
			// System.out.println("server ca 2:");
			prep.execute();
			// System.out.println("server ca 2:");
			result = prep.getString(a + 1);
			if(result!=null && result.equals("ERROR"))
				throw new NullPointerException("There is an error.. kindly check carefully");
			
			con.close();
			session.getTransaction().commit();

			return result;

		} catch (Throwable thr) {
			// thr.printStackTrace();
			System.out.println("server call pro error :" + thr.getMessage());
			session.getTransaction().rollback();
			// thr.printStackTrace();
			log.error("callProcedure", thr);
			MyExceptions my = MyExceptions.getInstance();
			String message = excep.getErrorMessage(thr);
			if (message.equals("20101"))
				my.setMessage("Hmmm !!! . you are going to delete Employee");
			else if (message.equals("1438"))
				my.setMessage("Group can not be deleted.");
			else
				my.setMessage(message);

			throw my;

		} finally {
			try {

				con.close();
			} catch (Exception e) {

			}
		}
	}

	/**
	 * pass the sql query like in meta.setQuery(SELECT ID,NAME from table)
	 */

	public Generic_Wrapper getSqlData(Generic_Wrapper meta) throws MyExceptions {
		Connection connect = null;
		try {
			int row = 1;

			List lst = new ArrayList();
			Session session = HibernateUtil.currentSession();
			session.beginTransaction();
			connect = session.connection();
			PreparedStatement ps = connect.prepareStatement(meta.getQuery());
			ResultSetMetaData rsmt = ps.getMetaData();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HashMap hash = new HashMap();
				for (int iCount = 1; iCount <= rsmt.getColumnCount(); iCount++) {
					String col = rsmt.getColumnName(iCount);
					hash.put(col, rs.getString(iCount));
				}
				lst.add(hash);
			}
			rs.close();
			ps.close();
			connect.close();
			session.getTransaction().commit();

			meta.setLst(lst);

			return meta;
		} catch (Throwable thr) {

			log.error("getTableData", thr);
			MyExceptions my = MyExceptions.getInstance();
			String message = excep.getErrorMessage(thr);
			my.setMessage(message);
			throw my;
		} finally {
			try {

				connect.close();
			} catch (Exception e) {

			}
		}
	}

	public List<HashMap<String, String>> sqlQuery(String query)throws MyExceptions {
		Connection connect = null;
		try {
			int row = 1;

			List lst = new ArrayList();
			Session session = HibernateUtil.currentSession();
			session.beginTransaction();
			connect = session.connection();
			PreparedStatement ps = connect.prepareStatement(query);
			ResultSetMetaData rsmt = ps.getMetaData();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HashMap hash = new HashMap();
				for (int iCount = 1; iCount <= rsmt.getColumnCount(); iCount++) {
					String col = rsmt.getColumnName(iCount);

					hash.put(col, rs.getString(iCount));
				}
				//System.out.println(hash);
				lst.add(hash);
			}
			rs.close();
			ps.close();
			connect.close();
			session.getTransaction().commit();

			return lst;
		} catch (Throwable thr) {
			thr.printStackTrace();
			log.error("getTableData", thr);
			MyExceptions my = MyExceptions.getInstance();
			String message = excep.getErrorMessage(thr);
			my.setMessage(message);
			throw my;
		} finally {
			try {

				connect.close();
			} catch (Exception e) {

			}
		}
	}

	public String getAlertMessage(String userId) throws MyExceptions {
		if (hashMess.containsKey("0")
				&& hashMess.get("0").toString().length() != 0) {
			return "0:" + hashMess.get("0").toString();
		} else if (hashMess.containsKey(userId)) {
			if (hashMess.get(userId).toString().length() != 0)
				return userId + ":" + hashMess.get(userId).toString();
		}
		return "";
	}

	public void setAlertMessage(String userId, String message)
			throws MyExceptions {
		hashMess.put(userId, message + ":" + new Date().getTime());
	}

	public String getAge(String dt) throws MyExceptions {
		try {
			if (dt != null) {
				dt = dt.replace("-", "/");
				SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");
				Calendar c = Calendar.getInstance();
				c.setTime(smp.parse(dt));
				java.util.Date dobDt = c.getTime();
				int dobYear = dobDt.getYear();

				java.util.Date currDt = new java.util.Date();
				int currYear = currDt.getYear();

				int age = currYear - dobYear;
				if (age == 0)
					age++;

				return String.valueOf(age);
			}
			return String.valueOf(0);
		} catch (Throwable ex) {
			log.error("ERROR: Get Age:", ex);
			MyExceptions my = MyExceptions.getInstance();
			String message = excep.getErrorMessage(ex);
			my.setMessage(message);
			throw my;
		}

	}

	public void uploadFile(String uoCode) throws MyExceptions {
		try {
			URL url = new URL("http://localhost:8080/myurl/MyTest?code=20002");

			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.connect();
			OutputStreamWriter out = new OutputStreamWriter(
					connection.getOutputStream());
			out.write("Hi....");
			out.write("hello world....");
			out.write("hello world India....");
			out.close();

			System.out.println("waitng...");
			((HttpURLConnection) connection).getResponseCode(); // attention
			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String inputLine;
			String inn = "";
			while ((inputLine = in.readLine()) != null) {
				inn = inn + inputLine;
				// System.out.println("Yout test : "+inputLine);
			}
			in.close();
			this.getThreadLocalRequest().getSession()
					.setAttribute("uoCode", uoCode);
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	

	public String updateListRecord(Generic_Wrapper meta) throws MyExceptions {
		Session session = HibernateUtil.currentSession();
		Statement stmt = null;
		Connection con = null;
		try {
			
			boolean bool=true;
			if(meta.getInDate()!=null && meta.getOutDate()!=null && meta.getInOutDate()!=null)
			{
				bool=ServerValidation.getInstance().hotelInOut(meta.getInDate(), meta.getOutDate(), meta.getInOutDate());
			}
			if(bool)
			{
				session.beginTransaction();
				con = session.connection();
				stmt = con.createStatement();
				List lst = meta.getLst();
				Iterator iter = lst.listIterator();
				while (iter.hasNext()) {
					String str = (String) iter.next();
					stmt.executeUpdate(str);
	
				}
				session.getTransaction().commit();
				stmt.close();
				con.close();
			}
			return "SUCCESS";
		} catch (Throwable thr) {
			System.out.println("generic error :" + thr.getMessage());
			log.error("updateRecord", thr);
			MyExceptions my = MyExceptions.getInstance();
			String message = excep.getErrorMessage(thr);
			my.setMessage(message);
			throw my;
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (Exception e) {

			}
		}
	}

	public String updateRecord(Generic_Wrapper meta) throws MyExceptions {
		Session session = HibernateUtil.currentSession();
		Statement stmt = null;
		Connection con = null;
		try {
			session.beginTransaction();
			con = session.connection();
			stmt = con.createStatement();
			if (meta.getStr() != null && meta.getId() != null) {
				String pass = meta.getStr();
				String userId = meta.getId();
				String query = "Update User_Prv set user_pass ='"
						//+ ServerValidation.encrypt(pass)
						+pass
						+ "' where user_id =" + userId + " ";
				stmt.executeUpdate(query);
			} else {
				// System.out.println(meta.getQuery());
				stmt.executeUpdate(meta.getQuery());
			}
			session.getTransaction().commit();

			stmt.close();
			con.close();

			return "SUCCESS";
		} catch (Throwable thr) {
			log.error("updateRecord", thr);
			MyExceptions my = MyExceptions.getInstance();
			String message = excep.getErrorMessage(thr);
			my.setMessage(message);
			throw my;
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (Exception e) {
			}
		}
	}

	
	public String executeFunction(Generic_Wrapper meta) throws MyExceptions {
		Session session = HibernateUtil.currentSession();
		Statement stmt = null;
		Connection con = null;
		String str = "0";
		try {
			session.beginTransaction();
			con = session.connection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select " + meta.getId()
					+ " from dual");
			if (rs.next()) {
				str = rs.getString(1);
			}
			rs.close();
			stmt.close();
			con.close();
			session.getTransaction().commit();

			return str;
		} catch (Throwable thr) {
			log.error("executeFunction", thr);
			MyExceptions my = MyExceptions.getInstance();
			String message = excep.getErrorMessage(thr);
			my.setMessage(message);
			throw my;
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (Exception e) {
			}
		}
	}

	public String getCheckOutDate(String inDate,int days)throws MyExceptions
	{
		try
		{
			//System.out.println(inDate);
			//inDate=inDate.replace("-", "/");
			//SimpleDateFormat smp=new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat smp=new SimpleDateFormat("dd-MM-yyyy");
			Date dt=smp.parse(inDate);
			Calendar c=Calendar.getInstance();
			c.setTime(dt);
			c.add(c.DATE,days);
			Date d=c.getTime();
			String outDate=smp.format(d);
			
			return outDate;
		}
		catch(Exception ex)
		{ 
			MyExceptions my=MyExceptions.getInstance();
			String message=excep.getErrorMessage(ex);
			my.setMessage(message);	
			throw my;
		}
	}
	
	public String getDuration(String firstDt,String secondDt) throws MyExceptions {
		try {
			if (firstDt!= null) {
				firstDt = firstDt.replace("-", "/");
				SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");
				Calendar c = Calendar.getInstance();
				c.setTime(smp.parse(firstDt));
				java.util.Date firstDate = c.getTime();
				
				secondDt = secondDt.replace("-", "/");
				Calendar c2 = Calendar.getInstance();
				c2.setTime(smp.parse(secondDt));
				java.util.Date secondDate = c2.getTime();
				
				long days = secondDate.getTime() - firstDate.getTime();
				days = days / (60*60*24*1000);
				
				return String.valueOf(days);
			}
			return String.valueOf(0);
		} catch (Throwable ex) {
			log.error("ERROR: Get Age:", ex);
			MyExceptions my = MyExceptions.getInstance();
			String message = excep.getErrorMessage(ex);
			my.setMessage(message);
			throw my;
		}

	}

	public String session(String param)throws MyExceptions
	{
		try {
			
			Utils.getInstance().setQuery(param);
			
			return null;
			
		} catch (Exception ex) {
			// TODO: handle exception
			log.error("ERROR: Get Age:", ex);
			MyExceptions my = MyExceptions.getInstance();
			String message = excep.getErrorMessage(ex);
			my.setMessage(message);
			throw my;
		}
	}
	
	
	
	public String getSequence(Generic_Wrapper meta) throws MyExceptions {
	 
		String seq=null;
  		Session session=HibernateUtil.currentSession();
	 	Statement stmt=null;
	 	Connection con=null;		
		try 
		{
	 		session.beginTransaction();
			con=session.connection();
			stmt=con.createStatement();
			
		 	ResultSet rs=stmt.executeQuery("select "+meta.getSequence()+".nextval  from dual ");
		 	if(rs.next())
			{
		 		seq=rs.getString("nextval");
		 	}	  
			rs.close();	 
			stmt.close();
			con.close();
			session.getTransaction().commit();
		 	return seq;
	 	} 
		catch (Throwable thr) {
			session.getTransaction().rollback();
			log.error("updateQuery", thr);
			MyExceptions my = MyExceptions.getInstance();
			String message = excep.getErrorMessage(thr);
			my.setMessage(message);
			throw my;
		}
		finally
		{
			try
			{ 
				stmt.close();
				con.close();
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
	public String email(Generic_Wrapper meta)throws MyExceptions
	{
		try 
		{
				
			
			return "OK";
		} catch (Exception thr) {
			// TODO: handle exception
			log.error("updateQuery", thr);
			MyExceptions my = MyExceptions.getInstance();
			String message = excep.getErrorMessage(thr);
			my.setMessage(message);
			throw my;
		}
	}
	
	public String resetIdentities_LoginBy()throws MyExceptions
	{
		try {

			 	HttpSession session = getThreadLocalRequest().getSession();
			 	session.setAttribute("uoCode", null);			   
			 	session.setAttribute("lang", null);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "OK";
	}
}
