package com.plus.app.client.util;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RadioButton;

public class MyRadioButton extends Composite{
	
	RadioButton	chk  = null;
	
	
	public MyRadioButton(String name,String label)
	{
		chk= new RadioButton(name,label);
		chk.addStyleName("f12");
		setNameValue(label);
		initWidget(chk);
	}
	
	private String nameValue;
	
	public String getNameValue() {
		return nameValue;
	}
	public void setNameValue(String nameValue) {
		this.nameValue = nameValue;
	}

	private String id;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public boolean isChecked()
	{
		return chk.isChecked();
	}
	public void setChecked(boolean val)
	{
		chk.setChecked(val);
	}
	/*
	 * 	if 0 will be passed then it will un-checked
	 * if 1 will be passed then it will checked.
	 */
	public void setSelected(int val)
	{
		if(val==0)
		chk.setChecked(false);
		else
			chk.setChecked(true);
	}
	
	
	public void setDisabled(boolean val)
	{
		chk.setEnabled(!val);
	}
	
	public void addClickHandler(ClickHandler click)
	{
		chk.addClickHandler(click);
	}
	
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private Object obj;

	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
}
