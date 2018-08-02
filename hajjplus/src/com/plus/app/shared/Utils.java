package com.plus.app.shared;

import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.plus.app.server.ServerValidation;

public class Utils {
	
	private static Utils	instance;
	public static Utils getInstance()
	{
		if(instance == null )
		{
			instance = new Utils();
		}
		return instance;
	}
	public static String checkNull(Object obj)
	{
		if(obj!=null)
			return obj.toString();
		else
			return "";
		
	}
	
	public static Integer checkNullInt(Object val)
	{
		if(val!=null && val.toString().trim().length()!=0)
			return Integer.valueOf(val.toString());
		
		return 0;
	}
	public static Long checkNullLong(Object val)
	{
		if(val!=null && val.toString().trim().length()!=0)
			return Long.valueOf(val.toString());
		
		return 0L;
	}
	public static Double checkNullDouble(Object val)
	{
		if(val!=null && val.toString().trim().length()!=0)
			return Double.valueOf(val.toString());
		
		return 0.0;
	}
	
	public static String getHeaderString(String text, ImageResource image) 
	{
	    // Add the image and text to a horizontal panel
	    HorizontalPanel hPanel = new HorizontalPanel();
	    hPanel.setWidth("100%");
	    hPanel.addStyleName("menu-item");
	    hPanel.setSpacing(0);
	    hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	    
	    Image img = new Image(image);
	    hPanel.add(img);
	    hPanel.setCellVerticalAlignment(img, HasVerticalAlignment.ALIGN_TOP);
	    HTML headerText = new HTML(text);
	    headerText.setStyleName("cw-StackPanelHeader");
	    hPanel.add(headerText);
	    hPanel.setCellWidth(img, "20px");//// added
	    hPanel.setCellVerticalAlignment(headerText, HasVerticalAlignment.ALIGN_TOP);
	    if(LocaleInfo.getCurrentLocale().isRTL())
	    	hPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
	    else
	    	hPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

	    // Return the HTML string for the panel
	    return hPanel.getElement().getString();
	 }
	public static String getSubHeaderString(String text, ImageResource image) 
	{
	    // Add the image and text to a horizontal panel
	    HorizontalPanel hPanel = new HorizontalPanel();
	    hPanel.setWidth("100%");
	    hPanel.addStyleName("sub-menu-item");
	    hPanel.setSpacing(0);
	    hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	   // hPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
	    Image img = new Image(image);
	    hPanel.add(img);
	    hPanel.setCellVerticalAlignment(img, HasVerticalAlignment.ALIGN_TOP);
	    HTML headerText = new HTML(text);
	    headerText.setStyleName("cw-StackPanelHeader");
	    hPanel.add(headerText);
	    hPanel.setCellWidth(img, "20px");//// added
	    hPanel.setCellVerticalAlignment(headerText, HasVerticalAlignment.ALIGN_TOP);

	    if(LocaleInfo.getCurrentLocale().isRTL())
	    	hPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
	    else
	    	hPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
	    
	    // Return the HTML string for the panel
	    return hPanel.getElement().getString();
	 }
	public static String getMenuString(String text, ImageResource image) 
	{
	    // Add the image and text to a horizontal panel
	    HorizontalPanel hPanel = new HorizontalPanel();
	    hPanel.setWidth("100%");
	   // hPanel.addStyleName("menu-item");
	    hPanel.setSpacing(0);
	    hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	    hPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
	    Image img = new Image(image);
	    hPanel.add(img);
	    HTML headerText = new HTML(text);
	    headerText.setStyleName("cw-MenuHeader");
	    hPanel.add(headerText);
	    hPanel.setCellWidth(img, "20px");
	    
	    if(LocaleInfo.getCurrentLocale().isRTL())
	    	hPanel.setCellHorizontalAlignment(headerText, HasHorizontalAlignment.ALIGN_RIGHT);
	    else
	    	hPanel.setCellHorizontalAlignment(headerText, HasHorizontalAlignment.ALIGN_LEFT);
	    
	    

	    // Return the HTML string for the panel
	    return hPanel.getElement().getString();
	 }

	private String query;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
}
