package com.plus.app.shared;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;

public class Util {
	
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
	    hPanel.setSpacing(0);
	    hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	    Image img = new Image(image);
	    hPanel.add(img);
	    hPanel.setCellVerticalAlignment(img, HasVerticalAlignment.ALIGN_TOP);
	    HTML headerText = new HTML(text);
	    headerText.setStyleName("cw-StackPanelHeader");
	    hPanel.add(headerText);
	    hPanel.setCellVerticalAlignment(headerText, HasVerticalAlignment.ALIGN_TOP);

	    // Return the HTML string for the panel
	    return hPanel.getElement().getString();
	 }
	public static String getMenuString(String text, ImageResource image) 
	{
	    // Add the image and text to a horizontal panel
	    HorizontalPanel hPanel = new HorizontalPanel();
	    hPanel.setSpacing(0);
	    hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	    hPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
	    Image img = new Image(image);
	    hPanel.add(img);
	    HTML headerText = new HTML(text);
	    headerText.setStyleName("cw-MenuHeader");
	    hPanel.add(headerText);
	    hPanel.setCellWidth(img, "20px");
	    hPanel.setCellHorizontalAlignment(headerText, HasHorizontalAlignment.ALIGN_LEFT);

	    // Return the HTML string for the panel
	    return hPanel.getElement().getString();
	 }

}
