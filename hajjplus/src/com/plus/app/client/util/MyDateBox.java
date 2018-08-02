package com.plus.app.client.util;

import java.util.Date;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

public class MyDateBox extends Composite{
	
	public DateBox		date;
	private boolean		hideDatePicker = false;
	
	public MyDateBox(int width,String name)
	{
		date = new DateBox();
		date.addStyleName("dateBox");
		date.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("dd-MM-yyyy")));
		date.setWidth(width+"px");
		initWidget(date);
		
		date.getTextBox().addKeyPressHandler(new KeyPressHandler()
		{
			public void onKeyPress(KeyPressEvent event)
			{
				/*
				if ((!Character.isDigit(event.getCharCode())) 
						&& (event.getNativeEvent().getKeyCode()!=8) 
						&& (event.getNativeEvent().getKeyCode()!=9)
						&& (event.getNativeEvent().getKeyCode()!=13)
						&& (event.getNativeEvent().getKeyCode()!=35)
						&& (event.getNativeEvent().getKeyCode()!=36)
						&& (event.getNativeEvent().getKeyCode()!=37)
						&& (event.getNativeEvent().getKeyCode()!=38)
						&& (event.getNativeEvent().getKeyCode()!=39)
						&& (event.getNativeEvent().getKeyCode()!=40)
						&& (event.getNativeEvent().getKeyCode()!=46)
						&& (event.getNativeEvent().getCharCode()!='-')
					) 
					{
						((TextBox) event.getSource()).cancelKey();
					}
					
				*/
				
				//((TextBox) event.getSource()).cancelKey();
				if(event.getNativeEvent().getKeyCode()==8)
					  ((TextBox) event.getSource()).setText("");
				  else
				     ((TextBox) event.getSource()).cancelKey();
			}
		});
		
		setNameValue(name);
				
	}
	
	public void addBlurHandler(BlurHandler blur)
	{
		date.getTextBox().addBlurHandler(blur);
	}

	public Date getDateObject()
	{
		//return Util.getDateObject(date.getTextBox().getText());
		return date.getValue();
	}
	
	public void setDateObject(Date dt)
	{
		date.getTextBox().setText(Util.getConvertDate(dt));
	}
	public void clear()
	{
		date.removeStyleName("backColorAlert");
		date.setValue(new Date());
		if(!hideDatePicker)
		date.getTextBox().setText("");
		else
		{
			 
		hideDatePicker(true);
		}
	}
	
	public void setText(String text)
	{
		date.getTextBox().setText(text);
		date.removeStyleName("backColorAlert");
	}
	public String getText()
	{
		return date.getTextBox().getText();
	}
	
	private String dbColumnName;


	public String getDbColumnName() {
		return dbColumnName;
	}


	public void setDbColumnName(String dbColumnName) {
		this.dbColumnName = dbColumnName;
	}
	
	public void addValueChangeHandler(ValueChangeHandler handler)
	{
		date.addValueChangeHandler(handler);
	}
	public void setDisable(boolean value)
	{
		date.setEnabled(!value);
	}
	public void setFocus(boolean focused)
	{
		date.setFocus(focused);
	}
	public void hideDatePicker(boolean status)
	{
		if(status)
		{
			hideDatePicker = status;
			date.getTextBox().setText("dd-MM-yyyy");
			date.getTextBox().addStyleName("f12Date");
			date.getTextBox().addFocusHandler(new FocusHandler()
			{
				public void onFocus(FocusEvent e)
				{
					if(date.getTextBox().getText().equals("dd-MM-yyyy"))
					date.getTextBox().setText("");
				}
			});
			date.getTextBox().addBlurHandler(new BlurHandler()
			{
				public void onBlur(BlurEvent e)
				{
					if(date.getTextBox().getText().length()==0)
						date.getTextBox().setText("dd-MM-yyyy");
				}
			});
			date.getDatePicker().setVisible(!status);
		}
		else
		{
			hideDatePicker = false;
		}
	}
	
	private String nameValue;

	public String getNameValue() {
		return nameValue;
	}

	public void setNameValue(String nameValue) {
		this.nameValue = nameValue;
	}
	public void setCurrentDate()
	{
		date.setValue(new Date());
	}
	
}
