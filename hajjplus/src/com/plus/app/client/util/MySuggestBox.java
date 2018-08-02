package com.plus.app.client.util;

import java.util.HashMap;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;

public class MySuggestBox extends Composite{
	
	MultiWordSuggestOracle 			multi;
	public SuggestBox				suggest;
	private String					nameValue;
	private HashMap					HASH = new HashMap();
	
	public HashMap getHASH() {
		return HASH;
	}

	public void setHASH(HashMap hASH) {
		HASH = hASH;
	}

	public MySuggestBox(int width,String name)
	{
		multi = new MultiWordSuggestOracle();
		suggest = new SuggestBox(multi);
		suggest.setWidth(width+"px");
		setNameValue(name);		
		
		initWidget(suggest);
		
	}

	public String getNameValue() {
		return nameValue;
	}

	public void setNameValue(String nameValue) {
		this.nameValue = nameValue;
	}
	
	public void clear()
	{
		suggest.setText("");
	}
	public void clearData()
	{
		multi.clear();
	}
	
	public void add(String name,HashMap hash)
	{
		HASH = hash;
		multi.add(name);
	}
	
	public String getText()
	{
		return suggest.getText();
	}
	
	public Object getAccounts() throws Exception 
	{
		String  accName = suggest.getText();
		if(HASH.containsKey(accName))
		{
			Object obj = HASH.get(accName);
			return obj;
		}
		else
			throw new NullPointerException("Invalid Account");		
		
	}
	public boolean containAccounts() 
	{
		String  accName = suggest.getText();
		if(HASH.containsKey(accName))
		{
			return true;
		}
		else
			return false;		
		
	}
	public void setFocus(boolean focus)
	{
		suggest.setFocus(focus);
	}
	public void setText(String text)
	{
		suggest.setText(text);
	}
}
