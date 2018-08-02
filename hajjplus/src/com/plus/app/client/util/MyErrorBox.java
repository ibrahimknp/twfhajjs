package com.plus.app.client.util;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;

public class MyErrorBox extends Composite{
	
	static Window		window;
	
	public static void alert(String alert)
	{
		if(alert!=null)
		{
			if(alert.equals("TIMEOUT.."))
			{
				//window.alert("Your session is expired...");
				String URL = GWT.getHostPageBaseURL();
				if(URL.indexOf("127.0.0.1:8888")!=-1)
				window.open(URL+"Oam36.html?gwt.codesvr=127.0.0.1:9997", "_self", "scrollable=yes height=100% width=100%");
				else
				window.open(URL+"Oam36.html", "_self", "scrollable=yes height=100% width=100%");
			}
			else
			{
				window.alert(alert);
			}
		}
		else
		{
			window.alert(alert);
			
		}
	}
	
	public static boolean confirm(String message)
	{
		return window.confirm(message);
	}
	
	

}

