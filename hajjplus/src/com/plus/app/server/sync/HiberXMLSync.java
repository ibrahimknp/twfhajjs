package com.plus.app.server.sync;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;

public class HiberXMLSync {


	public void createMapping(String table)
	{
		try
		{
				String replace="\t<mapping resource=\"com/plus/app/shared/hiber/"+table+".hbm.xml\" /> \n"+
							   "\t<!--<mapping>-->";

				File file=new File("C:/workspace/hajjplus/src/hibernate.cfg.xml");
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
				original = original.replaceAll("<!--<mapping>-->",replace);

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
			new HiberXMLSync().createMapping("V_Trip_Groups");

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
