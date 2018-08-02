package com.plus.app.client.util;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.MenuItem;
import com.plus.app.client.util.right.AdvMouseAdapter;

public class MyMenuItem extends MenuItem{

	AdvMouseAdapter		click = null , mouse = null;
	private String	id;
	
	
	public MyMenuItem(String text,ImageResource img,Command cmd)
	{
		super(Util.getMenuString(text,img),true, cmd);
	}
	
	public void addClickListener(AdvMouseAdapter listener) 
	{
		this.click = listener;
	}
	public void addMouseListener(AdvMouseAdapter listener) 
	{
		this.mouse = listener;
	}
	public void setCommand(Command cmd)
	{
		super.setCommand(cmd);
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getText() {
		return super.getText();
	}
	public void setText(String text,ImageResource img) 
	{
		setHTML(Util.getMenuString(text,img));
	}
}
