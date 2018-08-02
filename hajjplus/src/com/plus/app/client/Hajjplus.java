package com.plus.app.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;
import com.plus.app.client.util.MyFlexTable;
import com.plus.app.client.util.Util;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Hajjplus implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() 
	{
		final Login_Screen log=new Login_Screen();
		RootPanel.get("main").add(log);
		RootPanel.get("main").setStyleName("mainPanelA");
		//RootPanel.get("frame").setStyleName("frameSize1024");
		log.getTxtUserName().setFocus(true);

		MyFlexTable f = new MyFlexTable();
		f.setWidget(0, 1, Util.getHTMLLabel("Enviornmental System", "umraOperation"), 0);

		//RootPanel.get("title").add(f);
		RootPanel.get("main").setStyleName("mainPanelAN");
		
		DOM.setStyleAttribute(DOM.getElementById("loading"),"display","none");
	}
}
