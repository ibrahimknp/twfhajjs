package com.plus.app.client.util;

import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.TextBox;

public class MyTextBoxEnAr extends TextBox {
	
	
	public MyTextBoxEnAr()
	{
		super();
	}
	public MyTextBoxEnAr(int size,int maxLength,String name,boolean digit)
	{
		super();
		setWidth(size+"px");
		setMaxLength(maxLength);
		setName(name);
		setNameValue(name);
		
		if(digit)
		{
			addKeyPressHandler(new KeyPressHandler()
			{
				public void onKeyPress(KeyPressEvent event)
				{
					  //System.out.println("aa "+event.getNativeEvent().getKeyCode());
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
								
							) 
							{
								((TextBox) event.getSource()).cancelKey();
							}
				}
			});
		}
	}

		private String nameValue;
		public void setNameValue(String val)
		{
			nameValue = val;
		}
		public String getNameValue()
		{
			return nameValue;
		}
		public String getText()
		{
			String val=super.getText();
			return val.trim();
		}

}
