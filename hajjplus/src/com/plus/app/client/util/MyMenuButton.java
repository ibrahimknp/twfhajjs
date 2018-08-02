package com.plus.app.client.util;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;

public class MyMenuButton extends Composite{


	Hyperlink		lbl;
	
	public MyMenuButton(String text)
	{
		MyVerticalPanel v = new MyVerticalPanel();
		
		lbl = new Hyperlink();
		lbl.setText(text);
		lbl.addStyleName("menu-item");
		
		v.addWidget(lbl, 0);
		initWidget(v);
	}
	
	public void addClickHandler(ClickHandler handler)
	{
		lbl.addClickHandler(handler);
	}
	
}
