package com.plus.app.client.util;

 
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.plus.app.client.lang.Languages;

public class MySearchingIcons extends Composite{
	
	MyHorizontalPanel 	hTitle;
	
	public MySearchingIcons()
	{
		hTitle = new MyHorizontalPanel();
		HTML ht = new HTML(Languages.constants.moreSearchOptions());
		hTitle.addStyleName("searchingOptions");
		hTitle.addWidget(ht,0,1);
		 	
		
		initWidget(hTitle);
	}
	public MySearchingIcons(String title)
	{
		hTitle = new MyHorizontalPanel();
		HTML ht = new HTML(title);
		hTitle.addStyleName("searchingOptions");
		hTitle.addWidget(ht,0,1);
		hTitle.setWidth("100%");
		 	
		
		initWidget(hTitle);
	}
	public MySearchingIcons(String title,Widget w)
	{
		hTitle = new MyHorizontalPanel();
		hTitle.setWidth("100%");
		HTML ht = new HTML(title);
		hTitle.addStyleName("searchingOptions");
		hTitle.addWidget(ht,0,0);
		hTitle.addWidget(w,2,1);
		
		 	
		
		initWidget(hTitle);
	}
	public void addIcons(Widget w)
	{
		hTitle.addWidget(w,0);
	}

}
