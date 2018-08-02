package com.plus.app.client.util;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;

public class MyTextArea extends Composite{
	
	private TextArea		text;
	private String			nameValue;
	
	
	public MyTextArea(int width,int height,String nameValue)
	{
		text = new TextArea();
		text.setHeight(height+"px");
		text.setWidth(width+"px");
		setNameValue(nameValue);
		
		initWidget(text);
	}

	public String getNameValue() {
		return nameValue;
	}

	public void setNameValue(String nameValue) {
		this.nameValue = nameValue;
	}
	
	public String getText()
	{
		return text.getText().trim();
	}
	public void setFocus(boolean focus)
	{
		text.setFocus(focus);
	}
	
	public void clear()
	{
		text.setText("");
	}
	public void setText(String txt)
	{
		text.setText(txt);
	}
	public void setDisable(boolean bool)
	{
		text.setEnabled(!bool);
	}

}
