package com.plus.app.client.util;
 


import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.plus.app.client.SessionBean;

public class MyArrFlightSector extends Composite{
	
	HorizontalPanel		hMain;
	TextBox			txtFirst;
	MyListBox			lstCity;
	public String 		EXAMPLE="";
	
	public MyArrFlightSector(String name)
	{
		TextBox txtSep1 = new TextBox();
		txtSep1.setMaxLength(1);
		txtSep1.setWidth("5px");
	 	hMain = new HorizontalPanel();
		txtFirst = new TextBox();
		txtFirst.setMaxLength(3);
		txtFirst.setWidth("30px");
		txtFirst.setStyleName("f12gray");
		clear();
		txtSep1.setEnabled(false);
    	txtSep1.setText("-");
    	txtSep1.addStyleName("f12gray");
    	
    	txtFirst.addKeyPressHandler(new KeyPressHandler()
		{
			public void onKeyPress(KeyPressEvent event)
			{
				//if(txtFirst.getCursorPos()==3)
					//lstCity.setFocus(true);
			}
		});
    	
    	lstCity = new MyListBox(50, "City", 0);
    	cityLoad();
    	
		//DOM.setStyleAttribute(txtSep1.getElement(),"fontSize","16px");
	 	//DOM.setStyleAttribute(txtSep1.getElement(),"height","19px");
	 	DOM.setStyleAttribute(txtSep1.getElement(),"backgroundColor","white");
		 
		
		DOM.setStyleAttribute(txtFirst.getElement(), "borderLeft", "1px solid #B5BCC7");
		DOM.setStyleAttribute(txtFirst.getElement(), "borderRight", "0px solid #B5BCC7");
		DOM.setStyleAttribute(txtFirst.getElement(), "borderTop", "1px solid #B5BCC7");
		DOM.setStyleAttribute(txtFirst.getElement(), "borderBottom", "1px solid #B5BCC7");
		
		DOM.setStyleAttribute(txtSep1.getElement(), "borderLeft", "0px solid #B5BCC7");
		DOM.setStyleAttribute(txtSep1.getElement(), "borderRight", "0px solid #B5BCC7");
		DOM.setStyleAttribute(txtSep1.getElement(), "borderTop", "1px solid #B5BCC7");
		DOM.setStyleAttribute(txtSep1.getElement(), "borderBottom", "1px solid #B5BCC7");
		 
			hMain.add(txtFirst);
			//hMain.add(txtSep1);	 
			hMain.add(lstCity);
		
			//txtFirst.setAlignment(TextAlignment.CENTER);
	 	
		initWidget(hMain);
		 
		setNameValue(name);
	}
	 
	
	public String getTextInput()
	{
		String city = txtFirst.getText();
		if(city.equals(EXAMPLE))
				return "";
		else
		return city.trim();
		
	}
	public Integer getListInput()
	{
		Integer city = lstCity.getComboValueInteger();
		return city;
	}
	
	public void setText(String str)
	{
		if(str!=null)
		{
			txtFirst.setText(str);
		}
		
	}
	public void setList(Integer id)
	{
		if(id!=null)
		{
			lstCity.setComboValueInteger(id);
		}
		
	}
	
	  
	 
	 public void addValueChangeHandler(BlurHandler handler)
	 {
		 txtFirst.addBlurHandler(handler);	 	 
	 }
	 
	 public void clear()
	 {
		 txtFirst.setText("");	 	 
		 hMain.removeStyleName("backColorAlert");
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
	 
	 private String nameValue;


	public String getNameValue() {
		return nameValue;
	}

	public void setNameValue(String nameValue) {
		this.nameValue = nameValue;
	}
	
	public void cityLoad()
	{
		lstCity.addItem("JED", "602");
		lstCity.addItem("MED", "605");
		//if(SessionBean.getInstance().getNotif_setup().getId().toString().equals("1"))
		lstCity.addItem("YNB", "607");
	}
	 
	public void addChangeHandler(ChangeHandler handler)
	{
		lstCity.addChangeHandler(handler);
	}
	
	public void addBlurHandler(BlurHandler handler)
	{
		txtFirst.addBlurHandler(handler);
	}
	public void setExamples(final String label)
	{
		EXAMPLE = label;
		txtFirst.setText(label);
		txtFirst.addStyleName("f12gainsboro");
		txtFirst.addFocusHandler(new FocusHandler()
		{
			public void onFocus(FocusEvent e)
			{
				if(txtFirst.getText().equals(label))
				{
					clear();
				}
			}
		});
		
		txtFirst.addBlurHandler(new BlurHandler()
		{
			public void onBlur(BlurEvent arg0) 
			{
				if(txtFirst.getText().length()==0)
				{
					txtFirst.addStyleName("f12gainsboro");
					txtFirst.setText(label);
				}
				else
				{
					txtFirst.removeStyleName("f12gainsboro");
				}
			}
		});
		
	}
public Integer getComboValueInteger()
{
	return lstCity.getComboValueInteger();
}
}
