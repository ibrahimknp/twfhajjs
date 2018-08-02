package com.plus.app.client.util;

import java.util.HashMap;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.Widget;
import com.plus.app.client.SessionBean;

public class MyDecoratedStackPanel extends Composite{

	DecoratedStackPanel		panel ;
	
	public MyDecoratedStackPanel()
	{
		panel = new DecoratedStackPanel();
		panel.ensureDebugId("cwStackPanel");
		panel.addStyleName("cwStackPanel");
		initWidget(panel);
		
	}
	
	
	
	public void setWidth(String px)
	{
		panel.setWidth(px);
		
		
	}
	
	public void addWidget(Widget w,String header,boolean html)
	{
		panel.add(w, header, html);
	}
	public void addWidget(Widget w,String header,ImageResource img,boolean html)
	{
			
		panel.add(w, com.plus.app.shared.Utils.getHeaderString(header,img), html);
			
	}
	
	
}
