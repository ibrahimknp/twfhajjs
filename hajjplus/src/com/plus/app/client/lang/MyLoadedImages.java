package com.plus.app.client.lang;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Image;


public class MyLoadedImages extends Image{

	public static final ImagesLoader images = (ImagesLoader) GWT.create(ImagesLoader.class);
 
	
	public static Image controlPanel(String toolTop,String altText,boolean cursor)
	{
		Image img=images.controlPanel().createImage();
		if(cursor)
		img.addStyleName("hyper");
		img.setAltText(altText);
		img.setTitle(toolTop);
		return img;
	}
	public static Image arrow_left(String toolTop,String altText,boolean cursor)
	{
		Image img=images.arrow_left().createImage();
		if(cursor)
		img.addStyleName("hyper");
		img.setAltText(altText);
		img.setTitle(toolTop);
		return img;
	}
	public static Image arrow_right(String toolTop,String altText,boolean cursor)
	{
		Image img=images.arrow_right().createImage();
		if(cursor)
		img.addStyleName("hyper");
		img.setAltText(altText);
		img.setTitle(toolTop);
		return img;
	}
	public static Image next()
	{
		Image img=images.next().createImage();
		img.addStyleName("hand");
		img.setAltText("Next");
		return img;
	}
	public static Image prev()
	{
		Image img=images.prev().createImage();
		img.addStyleName("hand");
		img.setAltText("Prev");
		return img;
	}
	public static Image add(String toolTop,String altText,boolean cursor)
	{
		Image img=images.add().createImage();
		if(cursor)
		img.addStyleName("hyper");
		img.setAltText(altText);
		img.setTitle(toolTop);
		return img;
	}
	public static Image delete(String toolTop,String altText,boolean cursor)
	{
		Image img=images.delete().createImage();
		if(cursor)
		img.addStyleName("hyper");
		img.setAltText(altText);
		img.setTitle(toolTop);
		return img;
	}
	public static Image refresh(String toolTop,String altText,boolean cursor)
	{
		Image img=images.refresh().createImage();
		if(cursor)
		img.addStyleName("hyper");
		img.setAltText(altText);
		img.setTitle(toolTop);
		return img;
	}
	public static Image attach(String toolTop,String altText,boolean cursor)
	{
		Image img=images.attach().createImage();
		if(cursor)
		img.addStyleName("hyper");
		img.setAltText(altText);
		img.setTitle(toolTop);
		return img;
	}
	public static Image empty(String toolTop,String altText,boolean cursor)
	{
		Image img=images.empty().createImage();
		if(cursor)
		img.addStyleName("hyper");
		img.setAltText(altText);
		img.setTitle(toolTop);
		return img;
	}
	public static Image img(String toolTop,String altText,boolean cursor)
	{
		Image img=images.img().createImage();
		if(cursor)
		img.addStyleName("hyper");
		img.setAltText(altText);
		img.setTitle(toolTop);
		return img;
	}
	public static Image sharing(String toolTop,String altText,boolean cursor)
	{
		Image img=images.sharing().createImage();
		if(cursor)
		img.addStyleName("hyper");
		img.setAltText(altText);
		img.setTitle(toolTop);
		return img;
	}
	public static Image mail(String toolTop,String altText,boolean cursor)
	{
		Image img=images.mail().createImage();
		if(cursor)
		img.addStyleName("hyper");
		img.setAltText(altText);
		img.setTitle(toolTop);
		return img;
	}
	public static Image inbox(String toolTop,String altText,boolean cursor)
	{
		Image img=images.inbox().createImage();
		if(cursor)
		img.addStyleName("hyper");
		img.setAltText(altText);
		img.setTitle(toolTop);
		return img;
	}
	public static Image write(String toolTop,String altText,boolean cursor)
	{
		Image img=images.write().createImage();
		if(cursor)
		img.addStyleName("hyper");
		img.setAltText(altText);
		img.setTitle(toolTop);
		return img;
	}
	public static Image sent(String toolTop,String altText,boolean cursor)
	{
		Image img=images.sent().createImage();
		if(cursor)
		img.addStyleName("hyper");
		img.setAltText(altText);
		img.setTitle(toolTop);
		return img;
	}
	public static Image nonsharing(String toolTop,String altText,boolean cursor)
	{
		Image img=images.nonsharing().createImage();
		if(cursor)
		img.addStyleName("hyper");
		img.setAltText(altText);
		img.setTitle(toolTop);
		return img;
	}
	public static Image mailBox(String toolTop,String altText,boolean cursor)
	{
		Image img=images.mailBox().createImage();
		if(cursor)
		img.addStyleName("hyper");
		img.setAltText(altText);
		img.setTitle(toolTop);
		return img;
	}
	public static Image newMail(String toolTop,String altText,boolean cursor)
	{
		Image img=images.newMail().createImage();
		if(cursor)
		img.addStyleName("hyper");
		img.setAltText(altText);
		img.setTitle(toolTop);
		return img;
	}
	public static Image close(String toolTop,String altText,boolean cursor)
	{
		Image img=images.close().createImage();
		if(cursor)
		img.addStyleName("hyper");
		img.setAltText(altText);
		img.setTitle(toolTop);
		return img;
	}
	public static Image on_small()
	{
		Image img=images.on_small().createImage();
		return img;
	}
	public static Image off_small()
	{
		Image img=images.off_small().createImage();
		return img;
	}
}
