package com.plus.app.client.util;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Image;
import com.plus.app.client.SessionBean;

public class MyHotelImage extends Composite{
	
	Image					img;
	
	public MyHotelImage()
	{
		DecoratorPanel d = new DecoratorPanel();
		
		//MyFlexTable flex = new MyFlexTable();
		//flex.setCellPadding(0);
		//flex.setCellSpacing(0);
		//flex.addStyleName("hotelImageBack");
		img = new Image();
		//flex.setWidget(0, 0, img);
		d.add(img);
		initWidget(d);
	}
	public MyHotelImage(String imageName,boolean link)
	{
		MyFlexTable flex = new MyFlexTable();
		flex.setCellPadding(0);
		flex.setCellSpacing(0);
		flex.addStyleName("hotelImageBack");
		img = new Image(getDownloadPath()+imageName);
		img.setSize("60px", "46px");
		setId(imageName);
		if(link)
		{
			img.addStyleName("hand");			
		}
		
		flex.setWidget(0, 0, img,1);
		initWidget(flex);		
	}
	public MyHotelImage(String imageName,boolean link,String width,String height)
	{
		MyFlexTable flex = new MyFlexTable();
		flex.setCellPadding(0);
		flex.setCellSpacing(0);
		flex.addStyleName("hotelImageBack");
		img = new Image(getDownloadPath()+imageName);
		img.setSize(width, height);
		setId(imageName);
		if(link)
		{
			img.addStyleName("hand");			
		}		
		flex.setWidget(0, 0, img,1);
		initWidget(flex);		
	}
	public void addClickHandler(ClickHandler click)
	{
		img.addClickHandler(click);
	}
	public int getWidth()
	{
		return img.getWidth();
	}
	public void setVisible(boolean visible)
	{
		img.setVisible(visible);
	}
	public void setUrl(String url)
	{
		img.setUrl(getDownloadPath()+url);
		setId(url);
	}
	public void setId(String id)
	{
		//img.setAltText(id);
		img.setTitle(id);
	}
	public String getId()
	{
		//return img.getAltText();
		return img.getTitle();
	}
	public void clear()
	{
		img.setUrl(getDownloadPath()+"blank.jpg");
		setId("blank.jpg");
	}
	public void changeToLabel(boolean value)
	{
		if(value)
		{
			
		}
	}	
	public String getDownloadPath()
	{
		return "images/hotels/";
	}
	public void setSize(String width,String height)
	{
		img.setSize(width, height);
	}

}
