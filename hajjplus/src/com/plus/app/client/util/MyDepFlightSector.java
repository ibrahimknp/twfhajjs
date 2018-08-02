package com.plus.app.client.util;
 


import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.plus.app.client.SessionBean;

public class MyDepFlightSector extends Composite{
	
	HorizontalPanel		hMain;
	TextBox				txtSecond;
	MyListBox			lstCity;
	public String 		EXAMPLE="";
	
	public MyDepFlightSector(String name)
	{
		TextBox txtSep1 = new TextBox();
	 	hMain = new HorizontalPanel();
		txtSecond = new TextBox();
		txtSecond.setMaxLength(3);
		txtSecond.setWidth("30px");
		txtSecond.setStyleName("f12gray");
		clear();
		txtSep1.setEnabled(true);
    	txtSep1.setText("-");
    	txtSep1.addStyleName("f12gray");
    	
    	lstCity = new MyListBox(50, "City" , 0);
    	cityLoad();
    	
		//DOM.setStyleAttribute(txtSep1.getElement(),"fontSize","16px");
	 	//DOM.setStyleAttribute(txtSep1.getElement(),"height","19px");
	 	DOM.setStyleAttribute(txtSep1.getElement(),"backgroundColor","white");
		 
		
		DOM.setStyleAttribute(txtSep1.getElement(), "borderLeft", "0px solid #B5BCC7");
		DOM.setStyleAttribute(txtSep1.getElement(), "borderRight", "0px solid #B5BCC7");
		DOM.setStyleAttribute(txtSep1.getElement(), "borderTop", "1px solid #B5BCC7");
		DOM.setStyleAttribute(txtSep1.getElement(), "borderBottom", "1px solid #B5BCC7");
		 
		DOM.setStyleAttribute(txtSecond.getElement(), "borderLeft", "0px solid #B5BCC7");
		DOM.setStyleAttribute(txtSecond.getElement(), "borderRight", "1px solid #B5BCC7");
		DOM.setStyleAttribute(txtSecond.getElement(), "borderTop", "1px solid #B5BCC7");
		DOM.setStyleAttribute(txtSecond.getElement(), "borderBottom", "1px solid #B5BCC7");
		
		hMain.add(lstCity);
		//hMain.add(txtSep1);	 
		hMain.add(txtSecond);
		
		//txtSecond.setTextAlignment(1);
		
		initWidget(hMain);
		 
		setNameValue(name);
	}
	 
	
	public String getTextInput()
	{
		String city = txtSecond.getText();
		if(city.equals(EXAMPLE))
			return "";
		else
		return city;
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
			txtSecond.setText(str);
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
		 txtSecond.addBlurHandler(handler);
	 }
	 
	 public void clear()
	 {
		 txtSecond.setText("");
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
	public void setExamples(final String label)
	{
		EXAMPLE = label;
		txtSecond.setText(label);
		txtSecond.addStyleName("f12gainsboro");
		txtSecond.addFocusHandler(new FocusHandler()
		{
			public void onFocus(FocusEvent e)
			{
				if(txtSecond.getText().equals(label))
				{
					clear();
				}
			}
		});
		
		txtSecond.addBlurHandler(new BlurHandler()
		{
			public void onBlur(BlurEvent arg0) 
			{
				if(txtSecond.getText().length()==0)
				{
					txtSecond.addStyleName("f12gainsboro");
					txtSecond.setText(label);
				}
				else
				{
					txtSecond.removeStyleName("f12gainsboro");
				}
			}
		});
		
	}
	public Integer getComboValueInteger()
	{
		return lstCity.getComboValueInteger();
	}
}
