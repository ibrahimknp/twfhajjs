package com.plus.app.client.util;


import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MyCaptionPanel extends Composite {
	
	CaptionPanel capPan=null;
	public MyCaptionPanel(String name)
	{
		capPan=new CaptionPanel();
		capPan.setCaptionText(name);
	 	capPan.addStyleName("f12");
		initWidget(capPan);
	}
	public MyCaptionPanel(String name,int width)
	{
		capPan=new CaptionPanel();
		capPan.setCaptionText(name);
	 	capPan.addStyleName("f12");
	 	capPan.setWidth(width+"px");
		initWidget(capPan);
	}
	public MyCaptionPanel(String name,int width,int height)
	{
		capPan=new CaptionPanel();
		capPan.setCaptionText(name);
	 	capPan.addStyleName("f12");
	 	capPan.setWidth(width+"px");
	 	capPan.setHeight(height+"px");
		initWidget(capPan);
	}
	public void addWidget(Widget w)
	{
		capPan.add(w);
	}

}
