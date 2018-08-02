package com.plus.app.client.util;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class MyFramePanel extends Composite{
	
	MyVerticalPanel		vMain;
	MyButton			hyper;
	MyHorizontalPanel	hori = new MyHorizontalPanel();
	

	public MyFramePanel(String title,String className)
	{
		hori.setWidth("100%");
		vMain = new MyVerticalPanel(true);
		HTML ht = new HTML(title);
		ht.addStyleName("bigTitle");
		vMain.setToolTip(className);
		vMain.addStyleName("frame");	
		
		hori.addWidget(ht,0);
		
		vMain.addWidgetTop(hori);
		
		initWidget(vMain);
		
	}
	public MyFramePanel(String title,String className,Widget panel)
	{
		vMain = new MyVerticalPanel(true);
		HTML ht = new HTML(title);
		ht.addStyleName("bigTitle");
		vMain.setToolTip(className);
		vMain.addStyleName("frame");	
		hori.setWidth("100%");
		hori.addWidget(ht,0);
		hori.addWidget(panel,2);
		
		vMain.addWidgetTop(hori);
		
		initWidget(vMain);
		
	}
	
	
	public void addWidgetTop(Widget w)
	{
		vMain.addWidget(w,0,0);
		//vMain.add(w, HasVerticalAlignment.ALIGN_TOP);
	}
	
	
	
	public void setSize(int width,int height)
	{
		vMain.setSize(width+"px", height+"px");
	}
	
	public void setWidth(String width)
	{
		vMain.setWidth(width);
	}
	
	public void setWhiteBackground()
	{
		vMain.addStyleName("verticalBack");
	}
	
	
	public void addCreateLink(String label,String width)
	{
		//cmdTripUpdate = new MyButton("Update Trip Request", false, null);
		//cmdTripUpdate.colorButton();
		
		hyper = new MyButton("Update Trip Request",false,null);
		hyper.setText(label);
		hyper.setStyleName("createLink");
		hori.addWidget(hyper, 2);		
		//System.out.println(width);
		hori.setWidth(width);
				
	}
	public void addCreateLink(Widget w)
	{
		hori.addWidget(w, 2, 1);
	}

	public MyButton getHyper() {
		return hyper;
	}
	 
}
