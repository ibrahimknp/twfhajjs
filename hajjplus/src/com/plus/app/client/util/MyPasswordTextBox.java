package com.plus.app.client.util;

import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.KeyboardListenerAdapter;
import com.google.gwt.user.client.ui.PasswordTextBox;

public class MyPasswordTextBox extends Composite{
	
	private PasswordTextBox			txt;
	private String					nameValue;
	
	
	public MyPasswordTextBox(int width,int maxLength,String label)
	{
		txt = new PasswordTextBox();
		if(width!=0)
			txt.setWidth(width+"px");
			txt.setMaxLength(maxLength);
			setNameValue(label);
			initWidget(txt);
			
			txt.addFocusHandler(new FocusHandler()
			{
				public void onFocus(FocusEvent e)
				{
					txt.selectAll();
				}
			});
	}
	
	public boolean isEnable() {
		return txt.isEnabled();
	}
	
	public void setDisabled(boolean val)
	{
		txt.setEnabled(!val);
		if(val)
			addStyleName("backDisabled");
		else
			removeStyleName("backDisabled");
		
		
	}
	
	public void setText(Object val)
	{
		txt.setText(Util.checkNull(val));
	}
	public String getText()
	{
		String val=txt.getText();
		return val.trim();
	}
	public void clear()
	{
		txt.setText("");
		txt.removeStyleName("backColorAlert");
	}
	public void setFocus(boolean focus)
	{
		txt.selectAll();
		txt.setFocus(true);
	}
	
	public String getNameValue() {
		return nameValue;
	}

	public void setNameValue(String nameValue) {
		this.nameValue = nameValue;
	}


	public void addKeyboardListener(KeyboardListenerAdapter adapter)
	{
		txt.addKeyboardListener(adapter);
	}
	public void setPlaceHolder(String text)
	{
		txt.getElement().setAttribute("placeholder", text);
	}
}

