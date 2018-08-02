package com.plus.app.server.sync;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;

public class WebXMLSync {


	public void createWebXml(String table)
	{
		try
		{
				String replace=" <servlet>\n"+
							   "\t<servlet-name>"+table+"</servlet-name>\n"+
							   "\t<servlet-class>com.plus.app.server.async."+table+"_ServiceImpl</servlet-class>\n"+
							   "  </servlet>\n  <!--ServletName-->\n";
				String mapping=" <servlet-mapping>\n"+
							   " \t<servlet-name>"+table+"</servlet-name>\n"+
							   " \t<url-pattern>/hajjplus/"+table+"</url-pattern>\n"+
							   "  </servlet-mapping>\n"+
							   "  <!--ServletMapping-->\n";
				File file=new File("C:/workspace/hajjplus/war/WEB-INF/web.xml");
				String st=file.getAbsolutePath();

				InputStream in=new FileInputStream(st);

				int a=0,x=0;
				byte b[]=new byte[in.available()];
				while( (a = in.read())!=-1)
				{
					byte c=(byte)a;
					b[x]=c;
					x++;
				}

				String original=new String(b);
				original = original.replaceAll("<!--ServletName-->",replace);
				original = original.replaceAll("<!--ServletMapping-->",mapping);

				writeFile(st,original);
				System.out.println(st+"\n"+original);
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try
		{
			new WebXMLSync().createWebXml("V_Trip_Groups");

		} catch (Exception e) {
			// TODO: handle exception
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
}
