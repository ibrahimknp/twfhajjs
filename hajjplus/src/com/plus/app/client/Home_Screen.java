package com.plus.app.client;

import com.google.gwt.user.client.ui.Composite;
import com.googlecode.gwt.charts.client.corechart.BarChart;
import com.plus.app.client.impl.Main;
import com.plus.app.client.util.MyVerticalPanel;

public class Home_Screen extends Composite implements Main{
	
	private MyVerticalPanel			vMain;
	private BarChart				chart;
	
	private static Home_Screen	instance;
	public static Home_Screen	getInstance()
	{
		if(instance==null)
			instance = new Home_Screen();
		
		return instance;
	}
	
	public Home_Screen() {
		// TODO Auto-generated constructor stub
				
		vMain = new MyVerticalPanel();
		
		
		initWidget(vMain);
	}

		@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPrevs(String prevs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SessionBean getSession() {
		// TODO Auto-generated method stub
		return SessionBean.getInstance();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
	

}
