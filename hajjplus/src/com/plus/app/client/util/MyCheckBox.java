package com.plus.app.client.util;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;

public class MyCheckBox extends Composite{
	
	private CheckBox			chk;
	boolean	PREV = true;
	
	public MyCheckBox()
	{
		chk = new CheckBox();
		
		initWidget(chk);
	}
	
	public MyCheckBox(String label)
	{
		chk= new CheckBox(label);
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
		if(PREV)
			chk.setVisible(true);
			else
				chk.setVisible(false);
		
	}
	/*
	 * 	if 0 will be passed then it will un-checked
	 * if 1 will be passed then it will checked.
	 */
	public void setSelected(int val)
	{
		if(val!=1)
		chk.setChecked(false);
		else
			chk.setChecked(true);
	}
	public void setSelectedWithName(int val,String name)
	{
		if(val!=1)
		chk.setChecked(false);
		else
			chk.setChecked(true);
		
		chk.setText(name);
	}
	public void setEnabled(boolean val)
	{
		chk.setEnabled(val);
		
	}
	
	public void setDisabled(boolean val)
	{
		chk.setEnabled(!val);
	}
	public boolean isEnabled()
	{
		return chk.isEnabled();
		 
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

	public int getSelected()
	{
		if(chk.isChecked())
			return 1;
		else
			return 0;
	}
	
	public void clear()
	{
		chk.setChecked(false);
	}
	
	public void setVisible(boolean visible)
	{
		if(visible==false)
		{
			chk.setChecked(false);			
		}
		if(PREV)
		chk.setVisible(visible);
		else
			chk.setVisible(false);
	}

	private Object object;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	

	private int alignment=1;

	public int getAlignment() {
		return alignment;
	}
	public void setAlignment(int alignment) {
		this.alignment = alignment;
	}
	
	public void setPrevs(String menuId,int pos)
	{
		String prevs=Util.getPrivilege(menuId);
		PREV = Util.setPrviliage(prevs,this,pos);
		chk.setVisible(PREV);
		//System.out.println(prevs+" : "+PREV);
	}
}
