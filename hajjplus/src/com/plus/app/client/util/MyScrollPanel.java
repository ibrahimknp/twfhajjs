package com.plus.app.client.util;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class MyScrollPanel extends Composite{

	ScrollPanel			panel;


	public MyScrollPanel(Widget child,int height)
	{
		panel = new ScrollPanel(child);
		panel.setHeight(height+"px");
		panel.addStyleName("browsePanel");

		initWidget(panel);
	}
	public MyScrollPanel(Widget child,int width,int height)
	{
		panel = new ScrollPanel(child);
		//panel.setWidth(width+"px");
		panel.setHeight(height+"px");
		//panel.addStyleName("browsePanel");
		panel.addStyleName("scroll");
		DOM.setStyleAttribute(panel.getElement(), "minWidth", width+"px");

		initWidget(panel);
	}
	public MyScrollPanel(Widget child,int height,boolean border)
	{
		panel = new ScrollPanel(child);
		panel.setHeight(height+"px");
		if(border)
		panel.addStyleName("browsePanel");		

		initWidget(panel);
	}
	public MyScrollPanel(String header,Widget child,int height)
	{
		MyVerticalPanel vMain = new MyVerticalPanel();
		vMain.setScrollTitle(header);

		panel = new ScrollPanel(child);
		panel.setHeight(height+"px");
		panel.addStyleName("browsePanel");

		vMain.addWidgetTop(panel);

		initWidget(vMain);
	}

	public void scrollBottom()
	{
		panel.scrollToBottom();
	}

	public void showScrollAlways()
	{
		panel.setAlwaysShowScrollBars(true);
	}
}
