package com.plus.app.server.sync;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;

public class CreateSync {

	String FILE="C:/workspace/hajjplus/src";
	String WRAPPER_PKG="com.plus.app.shared.wrapper";
	String RPC="com.plus.app.client.RPCConnection";
	String CLIENT_ASYNC="com.plus.app.client.async";
	String SERVICE_SYNC="com.plus.app.server.async";


	public void createWrapper(String table)
	{

		try
		{
				String original="Dummy";
				File file=new File(FILE);
				String st=file.getAbsolutePath();
				String pkg=WRAPPER_PKG.replace('.', '/');
				st=st+"/"+pkg;
				st=st.replace((char)92, '/');

				InputStream in=new FileInputStream(st+"/"+original+"_Wrapper.java");

				int a=0,x=0;
				byte b[]=new byte[in.available()];
				while( (a = in.read())!=-1)
				{
					byte c=(byte)a;
					b[x]=c;
					x++;
				}

				String modify=new String(b);
				modify=modify.replaceAll(original,table);

				writeFile(st+"/"+table+"_Wrapper.java",modify);

				System.out.println(st+"/"+table+"_Wrapper.java");
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
	public void createRPCConnection(String table)
	{

		try
		{
				String original="Dummy";
				File file=new File(FILE);
				String st=file.getAbsolutePath();
				String pkg=RPC.replace('.', '/');
				st=st+"/"+pkg;
				st=st.replace((char)92, '/');

				InputStream in=new FileInputStream(st+"/"+original+"_Connection.java");

				int a=0,x=0;
				byte b[]=new byte[in.available()];
				while( (a = in.read())!=-1)
				{
					byte c=(byte)a;
					b[x]=c;
					x++;
				}

				String modify=new String(b);
				modify=modify.replaceAll(original,table);

				writeFile(st+"/"+table+"_Connection.java",modify);

				System.out.println(st+"/"+table+"_Connection.java");
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
	public void createServiceImpl(String table)
	{

		try
		{
				String original="Dummy";
				File file=new File(FILE);
				String st=file.getAbsolutePath();
				String pkg=SERVICE_SYNC.replace('.', '/');
				st=st+"/"+pkg;
				st=st.replace((char)92, '/');


				InputStream in=new FileInputStream(st+"/"+original+"_ServiceImpl.java");
				int a=0,x=0;
				byte b[]=new byte[in.available()];
				while( (a = in.read())!=-1)
				{
					byte c=(byte)a;
					b[x]=c;
					x++;
				}

				String modify=new String(b);
				modify=modify.replaceAll(original,table);

				writeFile(st+"/"+table+"_ServiceImpl.java",modify);

				System.out.println(st+"/"+table+"_ServiceImpl.java");
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

	public void createService(String table)
	{

		try
		{
				String original="Dummy";
				File file=new File(FILE);
				String st=file.getAbsolutePath();
				String pkg=CLIENT_ASYNC.replace('.', '/');
				st=st+"/"+pkg;
				st=st.replace((char)92, '/');


				InputStream in=new FileInputStream(st+"/"+original+"_Service.java");
				int a=0,x=0;
				byte b[]=new byte[in.available()];
				while( (a = in.read())!=-1)
				{
					byte c=(byte)a;
					b[x]=c;
					x++;
				}

				String modify=new String(b);
				modify=modify.replaceAll(original,table);

				writeFile(st+"/"+table+"_Service.java",modify);

				System.out.println(st+"/"+table+"_Service.java");
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
	public void createSync(String table)
	{

		try
		{
				String original="Dummy";
				File file=new File(FILE);
				String st=file.getAbsolutePath();
				String pkg=CLIENT_ASYNC.replace('.', '/');
				st=st+"/"+pkg;
				st=st.replace((char)92, '/');


				InputStream in=new FileInputStream(st+"/"+original+"_ServiceAsync.java");
				int a=0,x=0;
				byte b[]=new byte[in.available()];
				while( (a = in.read())!=-1)
				{
					byte c=(byte)a;
					b[x]=c;
					x++;
				}

				String modify=new String(b);
				modify=modify.replaceAll(original,table);

				writeFile(st+"/"+table+"_ServiceAsync.java",modify);

				System.out.println(st+"/"+table+"_ServiceAsync.java");

		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

	public void writeFile(String fileName,String contents)
	{
		try
		{
			FileWriter fileJava=new FileWriter(fileName);
			PrintWriter prnJava=new PrintWriter(fileJava,true);
			prnJava.println(contents);
			prnJava.close();
			fileJava.close();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
	public void go(String table)
	{
		createSync(table);
		createService(table);
		createServiceImpl(table);
		createWrapper(table);
		createRPCConnection(table);
	}
	public static void main(String args[])
	{
		new CreateSync().go("Abc");
	}
}
