package com.plus.app.server.sync;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CreateConnection {

	public 		Connection connect;
	FileWriter  fileJava=null,fileHiber=null;
	PrintWriter prnJava=null,prnHiber=null;
	String 		packageName="com.plus.app.shared.dao";
	String 		packageNameHBM="com.plus.app.shared.hiber";

	String 		tableName = "Cases_Request";
	String 		SEQUENCE  = "Cases_Request_SEQ";
	boolean 	isWeb_XML = true;
	List 		lst;

	public void go()
	{
		try
		{
			lst = new ArrayList();
			File file=new File("C:/workspace/hajjplus/src");
			String st=file.getAbsolutePath();
			String pkg=packageName.replace('.', '/');
			st=st+"/"+pkg;
			st=st.replace((char)92, '/');

			fileJava=new FileWriter(st+"/"+tableName+".java");
			prnJava=new PrintWriter(fileJava,true);

			st=file.getAbsolutePath();
			String pkgHBM=packageNameHBM.replace('.', '/');
			st=st+"/"+pkgHBM;
			st=st.replace((char)92, '/');


			fileHiber=new FileWriter(st+"/"+tableName+".hbm.xml");
			prnHiber=new PrintWriter(fileHiber,true);


		//	javax.naming.Context ctx = new javax.naming.InitialContext() ;
		//	javax.sql.DataSource ds = (javax.sql.DataSource)ctx.lookup("java:comp/env/jdbc/tawaf" ) ;

			String users="twfhajj";
			String passwords="twfhajj";
			String connectionName="jdbc:inetora:10.0.12.74:1521?service=XE";
			//String connectionName="jdbc:inetora:46.166.173.25:1521?service=XE";
			//String connectionName="jdbc:inetora:192.168.1.72:1521?service=orcl";
			//String connectionName="jdbc:inetora:192.168.3.17:1521?service=orcl";
			//String connectionName="jdbc:inetora:localhost:1521?service=xe";
			System.out.println("connecting..");
			DriverManager.registerDriver(new com.inet.ora.OraDriver());
			connect= DriverManager.getConnection(connectionName,users,passwords);
			connect.setAutoCommit(false) ;

			setClassName(tableName);
			setHiber(tableName);

			PreparedStatement ps=connect.prepareStatement("select * FROM "+tableName);
			ResultSetMetaData rsmt=ps.getMetaData();
			for(int iCount=1;iCount<=rsmt.getColumnCount();iCount++)
			{
				String tempRow[]=new String [2];
				tempRow[0]=rsmt.getColumnName(iCount);
				tempRow[1]=rsmt.getColumnTypeName(iCount);

				System.out.println(iCount+" : "+tempRow[0]+" : "+tempRow[1]+":"+rsmt.getPrecision(iCount)+" : "+rsmt.getScale(iCount));
			    checkDataType(iCount,tempRow[0],tempRow[1],rsmt.getPrecision(iCount),rsmt.getScale(iCount));
			}

			createConstructor();

			prnJava.println("}");
			prnHiber.println("</class>");
			prnHiber.println("</hibernate-mapping>");


			prnJava.close();
			fileJava.close();
			System.out.println("Java created succesfully...");
			prnHiber.close();
			fileHiber.close();
			System.out.println("Hibernate created succesfully...");


			new CreateSync().go(tableName);
			if(isWeb_XML)
			{
				new HiberXMLSync().createMapping(tableName);
				new WebXMLSync().createWebXml(tableName);
			}

		}
		catch(Throwable thr)
		{
			thr.printStackTrace();
			System.out.println("Error in Connection : "+thr.getMessage());
		}
		finally
		{
			try
			{
				connect.close();
			}
			catch(Exception ee){}
		}
	}

	public static void main(String args[])
	{
		new CreateConnection().go();
	}

	public void checkDataType(int col,String colName,String dataType,int size,int scale)
	{
		if(col==1)
		{
			if(size>6 && size!=38)
			{
				makeIdMethod(colName,"Long");
				makeIdProperty(col,colName,"Long");
			}
			else
			{
				makeIdMethod(colName,"Integer");
				makeIdProperty(col,colName,"Integer");
			}
		}
		else if(dataType.equals("NUMBER"))
		{
			if(size>6 && size!=38)
			{
				if(scale==0)
				{
					makeMethod(colName,"Long");
					makeProperty(col,colName,"Long");
				}
				else
				{
					makeMethod(colName,"Double");
					makeProperty(col,colName,"Double");
				}
			}
			else
			{
				if(scale==0)
				{
					makeMethod(colName,"Integer");
					makeProperty(col,colName,"Integer");
				}
				else
				{
					makeMethod(colName,"Double");
					makeProperty(col,colName,"Double");
				}
			}
		}
		else if(dataType.equals("VARCHAR2") || dataType.equals("CHAR"))
		{
			makeMethod(colName,"String");
			makeProperty(col,colName,"String");
		}
		else if(dataType.equals("DATE"))
		{
			System.out.println(colName.contains("EDATE"));
			if(!(colName.contains("EDATE")))
			{
				makeMethod(colName,"Date");
				makeProperty(col,colName,"Date");
			}
		}
	}
	public void makeMethod(String col,String type)
	{
		String column=col.toLowerCase();
		char c=column.charAt(0);
		c=Character.toTitleCase(c);
		String str=c+""+column.substring(1);
		String get="\tprivate "+type+" "+column+";\n\tpublic "+type+" get"+str+"()\n\t{\n\t\t return "+column+";\n\t}";
		String set="\tpublic void set"+str+"("+type+" "+column+")\n\t{\n\t\t this."+column+"="+column+";\n\t}\n\t\n";
		prnJava.println(get);
		prnJava.println(set);

		lst.add(type+" "+column);
	}
	public void makeIdMethod(String col,String type)
	{
		String column=col.toLowerCase();
		char c=column.charAt(0);
		c=Character.toTitleCase(c);
		String str=c+""+column.substring(1);
		String get="\tprivate "+type+" id;\n\tpublic "+type+" getId()\n\t{\n\t\t return id;\n\t}";
		String set="\tpublic void setId("+type+" id)\n\t{\n\t\t this.id=id;\n\t}\n\t\n";
		prnJava.println(get);
		prnJava.println(set);

		lst.add(type+" id");
	}
	public void makeProperty(int cols,String col,String type)
	{
		String column=col.toLowerCase();
		if(type.equals("Date"))
		{
			String prop="<property name=^"+column+"^ type=^java.util."+type+"^ />";
			prop=prop.replace('^', '"');
			prnHiber.println(prop);
		}
		else
		{
			if(cols==1)
			{
				String prop="<id name=^"+column+"^ type=^java.lang."+type+"^ />";
				prop=prop.replace('^', '"');
				prnHiber.println(prop);
			}
			else
			{
				String prop="<property name=^"+column+"^ type=^java.lang."+type+"^ />";
				prop=prop.replace('^', '"');
				prnHiber.println(prop);
			}
		}
	}
	public void makeIdProperty(int cols,String col,String type)
	{
		String column=col.toLowerCase();
		if(cols==1)
		{
			if(SEQUENCE==null)
			{
				String prop="<id name=^id^ column=^"+column+"^ type=^java.lang."+type+"^ />";
				prop=prop.replace('^', '"');
				prnHiber.println(prop);
			}
			else
			{
				String prop="<id name=^id^ column=^"+column+"^ type=^java.lang."+type+"^ >\n" +
						"\t<generator class=^sequence^>\n" +
						"\t\t<param name=^sequence^>"+SEQUENCE+"</param>\n"+
						"\t</generator>\n"+
						"</id>";
				prop=prop.replace('^', '"');
				prnHiber.println(prop);
			}

		}

	}
	public void setHiber(String tableName)
	{
		String head="<?xml version=^1.0^ encoding=^UTF-8^?>\n"+
					"<!DOCTYPE hibernate-mapping PUBLIC	^-//Hibernate/Hibernate Mapping DTD 3.0//EN^ \n "+
					" ^http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd^> \n\n "+
					" <hibernate-mapping package=^"+packageName+"^>\n<class name=^"+tableName+"^ table=^"+tableName+"^>";
		head=head.replace('^', '"');
		prnHiber.println(head);
	}
	public void setClassName(String tableName)
	{
		String str="package "+packageName+";\nimport java.util.Date;\nimport java.io.Serializable;\n\npublic class "+tableName+" implements Serializable \n{";
		prnJava.println(str);
		prnJava.println("\tpublic "+tableName+"(){}");
		prnJava.println("\tprivate static final long	serialVersionUID	= -8480133366196663439L;");
	}
	public void createConstructor()
	{
		String cons="";
		prnJava.print("\tpublic "+tableName+"(");
		ListIterator iter=lst.listIterator();
		while(iter.hasNext())
		{
			cons=cons+(String)iter.next()+",";
		}
		cons=cons.substring(0,cons.length()-1);
		prnJava.println(cons+")");
		prnJava.println("\t{");

		iter=lst.listIterator();
		while(iter.hasNext())
		{
			String var = (String)iter.next();
			prnJava.println("\t\tthis."+var.substring(var.indexOf((char)32))+" = "+var.substring(var.indexOf((char)32))+";");
		}
		prnJava.println("\t}");

	}
}
