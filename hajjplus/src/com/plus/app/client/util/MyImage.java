package com.plus.app.client.util;
 

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;

public class MyImage extends Composite{

	Image	img;
	boolean		PREV=true;
	private String id;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MyImage()
	{
		img = new Image();
		initWidget(img);
	}
	public MyImage(Image image,String menuId,int id)
	{
		img = image;
		//PREV = Util.getPrivileges(menuId,id);
		initWidget(img);
		//System.out.println("PREV:"+PREV);
		img.setVisible(PREV);
	}
	public MyImage(Image image)
	{
		img = image;
		initWidget(img);
	}

	public MyImage(String imageName)
	{
		img = new Image(imageName);
		initWidget(img);

	}
	public MyImage(String imageName,boolean link)
	{
		img = new Image(imageName);
		if(link)
		{
			img.addStyleName("hand");
		}
		initWidget(img);
	}

	public MyImage(String imageName,boolean link,String title)
	{
		img = new Image(imageName);
		if(link)
		{
			img.addStyleName("hand");

		}
		img.setTitle(title);
		initWidget(img);
	}
	public void setBackground(String imageStyleName)
	{
		img.addStyleName(imageStyleName);
	}

	public void addClickHandler(ClickHandler click)
	{
		img.addClickHandler(click);
	}
	public void setUrl(String str)
	{
		img.setUrl(str);
	}
	public String getUrl()
	{
		return img.getUrl();
	}
	public void setVisible(boolean vis)
	{
		if(PREV)
			img.setVisible(vis);
		else
			img.setVisible(false);
	}
	public void setAltText(String txt)
	{
		img.setAltText(txt);
	}

}
