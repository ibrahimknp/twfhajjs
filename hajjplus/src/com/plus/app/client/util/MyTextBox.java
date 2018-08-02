package com.plus.app.client.util;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.KeyboardListenerAdapter;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;

public class MyTextBox extends Composite{

	private TextBox			txt;
	private String			nameValue,id;
		boolean					digit;
		public String 		EXAMPLE="";

	/**
	 *
	 * @param width if pass 0 then width will not set.. it will take default width
	 * @param maxLength maximum length
	 * @param label this parameter is to show in the label
	 * @param digit if true then it will become digit only
	 */
	public MyTextBox(int width,int maxLength,String label,boolean digit)
	{
		txt = new TextBox();
		if(width!=0)
		txt.setWidth(width+"px");
		txt.setMaxLength(maxLength);
		setNameValue(label);
		initWidget(txt);

		if(digit)
		{
			txt.addKeyPressHandler(new KeyPressHandler()
			{
				public void onKeyPress(KeyPressEvent event)
				{
					 // System.out.println("aa "+event.getNativeEvent().getCharCode()+" : "+event.getCharCode());
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
								&& (event.getNativeEvent().getCharCode()!=46)

							)
							{
								((TextBox) event.getSource()).cancelKey();
								//((TextBox) event.getSource()).setKey(event.getCharCode());
							}
				}
			});
		}

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

	public boolean isDigit()
	{
		return digit;
	}


	public void setDisabled(boolean val)
	{
		txt.setEnabled(!val);
		if(val)
			txt.addStyleName("backDisabled");
		else
			txt.removeStyleName("backDisabled");


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
	public String getTexts()
	{
		String val=txt.getText();
		if(val.equals(EXAMPLE))
			return "";
		else
		return val.trim();
	}
	public Integer getIntegerText()
	{
		String val=txt.getText();
		return Util.checkNullInt(val);
	}
	public Long getLongText()
	{
		String val=txt.getText();
		return com.plus.app.shared.Util.checkNullLong(val);
	}
	public Double getDoubleText()
	{
		String val=txt.getText();
		return com.plus.app.shared.Util.checkNullDouble(val);
	}
	public void clear()
	{
		txt.setText("");
		txt.removeStyleName("backColorAlert");
	}
	public void clears()
	{
		if(EXAMPLE.length()!=0)
		{
			setText(EXAMPLE);
			addStyleName("f12gainsboro");
		}
		else
		setText("");
		removeStyleName("backColorAlert");
	}

	public void setFocus(boolean focus)
	{
		txt.selectAll();
		txt.setFocus(true);
	}
	public void setTextAlignment(int align)
	{
		if(align==0)
		txt.setTextAlignment(TextBoxBase.ALIGN_LEFT);
		else if(align==1)
			txt.setTextAlignment(TextBoxBase.ALIGN_CENTER);
		else if(align==2)
			txt.setTextAlignment(TextBoxBase.ALIGN_RIGHT);
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void addKeyboardListener(KeyboardListenerAdapter adapter)
	{
		txt.addKeyboardListener(adapter);
	}
	public void addBlurHandler(BlurHandler handler)
	{
		txt.addBlurHandler(handler);
	}

	public void addFocusHandler(FocusHandler handler)
	{
		txt.addFocusHandler(handler);
	}
	public String getNameValue() {
		return nameValue;
	}

	public void setNameValue(String nameValue) {
		this.nameValue = nameValue;
	}
	public void addClickHandler(ClickHandler handler)
	{
		txt.addClickHandler(handler);
	}
	public void setEditable(boolean status)
	{
		txt.setEnabled(!status);
	}

	public void addKeyUpHandler(KeyUpHandler handler)
	{
		txt.addKeyUpHandler(handler);
	}

	public void addKeyPressHandler(KeyPressHandler handler)
	{
		txt.addKeyPressHandler(handler);
	}
	public void addChangeHandler(ChangeHandler handler)
	{
		txt.addChangeHandler(handler);
	}
	public int getCursorPos()
	{
		return txt.getCursorPos();
	}

	public void setExamples(final String label)
	{
		EXAMPLE = label;
		txt.setText(label);
		txt.addStyleName("f12gainsboro");
		txt.addFocusHandler(new FocusHandler()
		{
			public void onFocus(FocusEvent e)
			{
				if(txt.getText().equals(label))
				{
					clear();
				}
			}
		});

		txt.addBlurHandler(new BlurHandler()
		{
			public void onBlur(BlurEvent arg0)
			{
				if(txt.getText().length()==0)
				{
					txt.addStyleName("f12gainsboro");
					txt.setText(label);
				}
				else
				{
					txt.removeStyleName("f12gainsboro");
				}
			}
		});

	}
	public void setPlaceHolder(String text)
	{
		txt.getElement().setAttribute("placeholder", text);
	}
}
