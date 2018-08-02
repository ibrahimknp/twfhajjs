package com.plus.app.client.util;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class MySearchWidget extends Composite{
	
	
	public MySearchWidget (Widget wid[])
	{
		HorizontalPanel hori = new HorizontalPanel();
		//hori.addStyleName("searchWidget");
		//hori.setSpacing(5);
		for(int a=0;a<wid.length;a++)
		{
			hori.add(wid[a]);			
			hori.getWidget(a).addStyleName("searchWidget");
			hori.setCellVerticalAlignment(wid[a], HasVerticalAlignment.ALIGN_MIDDLE);			
		}
		
		initWidget(hori);
	}
	
	public MySearchWidget (Widget wid[],int spacing)
	{
		HorizontalPanel hori = new HorizontalPanel();
		hori.setSpacing(spacing);
		for(int a=0;a<wid.length;a++)
		{
			Widget w = wid[a];
			hori.add(w);
			
			hori.setCellVerticalAlignment(w, HasVerticalAlignment.ALIGN_MIDDLE);
						
		}
		
		initWidget(hori);
	}
	public MySearchWidget (Widget wid[],int spacing,String style)
	{
		HorizontalPanel hori = new HorizontalPanel();
		for(int a=0;a<wid.length;a++)
		{
			Widget w = wid[a];
			hori.add(w);
			hori.setCellWidth(w, spacing+"px");
			//w.addStyleName("MySearchWidget");
			hori.setCellVerticalAlignment(w, HasVerticalAlignment.ALIGN_MIDDLE);
			
			
			
		}
		
		if(style!=null)
			hori.addStyleName(style);
		
		initWidget(hori);
	}
	public MySearchWidget (String wid[])
	{
		HorizontalPanel hori = new HorizontalPanel();
		hori.setSpacing(5);
		for(int a=0;a<wid.length;a++)
		{
			Label lbl=new Label();
			lbl.addStyleName("flexFont");
			lbl.setText(wid[a]);
			hori.add(lbl);
			hori.setCellVerticalAlignment(lbl, HasVerticalAlignment.ALIGN_MIDDLE);
		}
		
		initWidget(hori);
	}

}
