package com.plus.app.client.util;

import java.util.Date;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;

public class MyCustomDate extends Composite{
	
	HorizontalPanel		hMain;
	MyTextBox			txtDD,txtMM,txtYYYY;
	
	
	public MyCustomDate(String name)
	{
		MyTextBox txtSep1 = new MyTextBox(5,1,"",false);
		MyTextBox txtSep2 = new MyTextBox(5,1,"",false);
		hMain = new HorizontalPanel();
		txtDD = new MyTextBox(22,2,"DD",true);
		txtMM = new MyTextBox(22,2,"MM",true);
		txtYYYY = new MyTextBox(45,4,"YYYY",true);
		
		txtDD.setTitle("dd");
		txtMM.setTitle("mm");
		txtYYYY.setTitle("yyyy");
		txtDD.addStyleName("f12Date");
		txtMM.addStyleName("f12Date");
		txtYYYY.addStyleName("f12Date");
		txtSep1.addStyleName("f12Date");
		txtSep2.addStyleName("f12Date");
		
		clear();
		
		txtDD.addFocusHandler(new MyFocus());
		txtDD.addBlurHandler(new MyFocus());
		txtMM.addFocusHandler(new MyFocus());
		txtMM.addBlurHandler(new MyFocus());
		txtYYYY.addFocusHandler(new MyFocus());
		txtYYYY.addBlurHandler(new MyFocus());
		
		txtSep1.setDisabled(true);
		txtSep2.setDisabled(true);
		
		
		txtSep1.setText("-");
		txtSep2.setText("-");
		//DOM.setStyleAttribute(txtSep1.getElement(),"fontSize","16px");
		//DOM.setStyleAttribute(txtSep2.getElement(),"fontSize","16px");
		//DOM.setStyleAttribute(txtSep1.getElement(),"height","20px");
		//DOM.setStyleAttribute(txtSep2.getElement(),"height","20px");
		DOM.setStyleAttribute(txtSep1.getElement(),"backgroundColor","white");
		DOM.setStyleAttribute(txtSep2.getElement(),"backgroundColor","white");
		
		
		DOM.setStyleAttribute(txtDD.getElement(), "borderLeft", "1px solid gray");
		DOM.setStyleAttribute(txtDD.getElement(), "borderRight", "0px solid gray");
		DOM.setStyleAttribute(txtDD.getElement(), "borderTop", "1px solid gray");
		DOM.setStyleAttribute(txtDD.getElement(), "borderBottom", "1px solid gray");
		
		DOM.setStyleAttribute(txtSep1.getElement(), "borderLeft", "0px solid gray");
		DOM.setStyleAttribute(txtSep1.getElement(), "borderRight", "0px solid gray");
		DOM.setStyleAttribute(txtSep1.getElement(), "borderTop", "1px solid gray");
		DOM.setStyleAttribute(txtSep1.getElement(), "borderBottom", "1px solid gray");
		//DOM.setStyleAttribute(txtSep1.getElement(), "marginTop", "2px");
		
		DOM.setStyleAttribute(txtMM.getElement(), "borderLeft", "0px solid gray");
		DOM.setStyleAttribute(txtMM.getElement(), "borderRight", "0px solid gray");
		DOM.setStyleAttribute(txtMM.getElement(), "borderTop", "1px solid gray");
		DOM.setStyleAttribute(txtMM.getElement(), "borderBottom", "1px solid gray");
		
		DOM.setStyleAttribute(txtSep2.getElement(), "borderLeft", "0px solid gray");
		DOM.setStyleAttribute(txtSep2.getElement(), "borderRight", "0px solid gray");
		DOM.setStyleAttribute(txtSep2.getElement(), "borderTop", "1px solid gray");
		DOM.setStyleAttribute(txtSep2.getElement(), "borderBottom", "1px solid gray");
		//DOM.setStyleAttribute(txtSep2.getElement(), "marginTop", "2px");
		
		DOM.setStyleAttribute(txtYYYY.getElement(), "borderLeft", "0px solid gray");
		DOM.setStyleAttribute(txtYYYY.getElement(), "borderRight", "1px solid gray");
		DOM.setStyleAttribute(txtYYYY.getElement(), "borderTop", "1px solid gray");
		DOM.setStyleAttribute(txtYYYY.getElement(), "borderBottom", "1px solid gray");
		
		hMain.add(txtDD);
		hMain.add(txtSep1);
		hMain.add(txtMM);
		hMain.add(txtSep2);
		hMain.add(txtYYYY);
		
		txtDD.setTextAlignment(1);
		txtMM.setTextAlignment(1);
		txtYYYY.setTextAlignment(1);
		
		initWidget(hMain);
		
		txtDD.addBlurHandler(new BlurHandler()
		{
			public void onBlur(BlurEvent e)
			{
				if(txtDD.getText().length()==1)
					txtDD.setText("0"+txtDD.getText());
			}
		});
		txtMM.addBlurHandler(new BlurHandler()
		{
			public void onBlur(BlurEvent e)
			{
				if(txtMM.getText().length()==1)
					txtMM.setText("0"+txtMM.getText());
			}
		});
		
		txtDD.addKeyUpHandler(new KeyUpHandler()
		{
			public void onKeyUp(KeyUpEvent e)
			{
				TextBox txt = (TextBox)e.getSource();
				if(txt.getText().length()!=0)
				{
					int dd = Integer.valueOf(txt.getText());
					if(e.getNativeEvent().getKeyCode()==38)
					{
						if(dd>0 && dd<31)
						txt.setText(""+(Integer.valueOf(txt.getText())-1));
					}
					if(e.getNativeEvent().getKeyCode()==40)
					{
						if(dd>0 && dd<31)
						txt.setText(""+(Integer.valueOf(txt.getText())+1));
					}
					
					if(txt.getText().length()==2)
					{
						//txtMM.setFocus(true);
					}
				}
				 hMain.removeStyleName("backColorAlert");
			}
		});
		txtMM.addKeyUpHandler(new KeyUpHandler()
		{
			public void onKeyUp(KeyUpEvent e)
			{
				TextBox txt = (TextBox)e.getSource();
				if(txt.getText().length()!=0)
				{
					int dd = Integer.valueOf(txt.getText());
					if(e.getNativeEvent().getKeyCode()==38)
					{
						if(dd>0 && dd<12)
						txt.setText(""+(Integer.valueOf(txt.getText())-1));
					}
					if(e.getNativeEvent().getKeyCode()==40)
					{
						if(dd>0 && dd<12)
						txt.setText(""+(Integer.valueOf(txt.getText())+1));
					}
					
					if(txt.getText().length()==2)
					{
						//txtYYYY.setFocus(true);
					}
				}
				 hMain.removeStyleName("backColorAlert");
			}
		});
		
		setNameValue(name);
	}
	
	
	public boolean checkDateValidation()
	{
		try 
		{
			if(txtDD.getIntegerText()>31 || txtDD.getIntegerText()<0)
			{
				MyErrorBox.alert("Please check the Date (dd/MM/yyyy)");
				return false;
			}
			
			if(txtMM.getIntegerText()>12 || txtMM.getIntegerText()<0)
			{
				MyErrorBox.alert("Please check the Month (dd/MM/yyyy)");
				return false;
			}
			
			if(txtYYYY.getIntegerText()>2032 || txtYYYY.getIntegerText()<1860)
			{
				MyErrorBox.alert("Please check the Year (dd/MM/yyyy)");
				return false;
			}
				
			int days = getDaysInMonth(txtYYYY.getIntegerText()-1900, txtMM.getIntegerText()-1);
			
			if(txtDD.getIntegerText()>days)
			{
				MyErrorBox.alert("Day can not be more than "+days);
				return false;
			}
		
		} catch (NumberFormatException ne) 
		{
			//MyErrorBox.alert("Please check the correct date format (dd/MM/yyyy)");
			return false;
		}
	
		
		return true;
	}
	
	public String getText()
	{
		String date = txtDD.getText()+"-"+txtMM.getText()+"-"+txtYYYY.getText();
		return date;
	}
	public Date getDateObject()
	{
		try 
		{
			Date date = new Date();
			date.setTime(date.UTC(txtYYYY.getIntegerText()-1900, txtMM.getIntegerText()-1, txtDD.getIntegerText(), 0, 0, 0));
			return date;	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public void setText(String str)
	{
		if(str!=null)
		{
			String val [] =str.split("-");
			txtDD.setText(val[0]);
			txtMM.setText(val[1]);
			txtYYYY.setText(val[2]);
		}
		else
		{
			clear();
		}
	}
	
	public void setDateObject(Date date)
	{
		if(date!=null)
		{
			Date dt=date;
			int dd=dt.getDate();
			int mm=dt.getMonth()+1;
			int yy=dt.getYear()+1900;
			
			
			txtDD.setText(Util.getTimeLength(dd));
			txtMM.setText(Util.getTimeLength(mm));
			txtYYYY.setText(yy);
		}
		
	}
	
	 public int getDaysInMonth(int year, int month) 
	 {
		    switch (month) {
		      case 1:
		        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
		          return 29; 
		        else
		          return 28;
		      case 3:
		        return 30;
		      case 5:
		        return 30;
		      case 8:
		        return 30;
		      case 10:
		        return 30;
		      default:
		        return 31;
		    }
	  }
	 
	 
	 class MyFocus implements FocusHandler , BlurHandler
	 {
		 public void onFocus(FocusEvent e)
		 {
			 TextBox txt = (TextBox)e.getSource();
			 if(txt.getTitle().equals("dd"))
			 {
				 if(txt.getText().equals("dd"))
					 txt.setText("");
			 }
			 else if(txt.getTitle().equals("mm"))
			 {
				 if(txt.getText().equals("MM"))
					 txt.setText("");
			 }
			 else if(txt.getTitle().equals("yyyy"))
			 {
				 if(txt.getText().equals("yyyy"))
					 txt.setText("");
			 }
			 txt.setCursorPos(0);
			 txt.setFocus(true);
			 txt.selectAll();
			
		 }
		 
		 	public void onBlur(BlurEvent e)
			{
		 		TextBox txt = (TextBox)e.getSource();
		 		 if(txt.getTitle().equals("dd"))
				 {
		 			if(txt.getText().length()==0)
		 				txt.setText("dd");
				 }
		 		 else if(txt.getTitle().equals("mm"))
				 {
		 			if(txt.getText().length()==0)
		 				txt.setText("MM");
				 }
		 		 else if(txt.getTitle().equals("yyyy"))
				 {
		 			if(txt.getText().length()==0)
		 				txt.setText("yyyy");
				 }
			}
	 }
	 
	 public void addValueChangeHandler(BlurHandler handler)
	 {
		 txtDD.addBlurHandler(handler);
		 txtMM.addBlurHandler(handler);
		 txtYYYY.addBlurHandler(handler);
	 }
	 
	 public void clear()
	 {
		 txtDD.setText("dd");
		 txtMM.setText("MM");
		 txtYYYY.setText("yyyy");
		 hMain.removeStyleName("backColorAlert");
	 }
	 public String getValidDate()
	 {
		 	try 
			{
					String date = txtDD.getIntegerText()+"-"+txtMM.getIntegerText()+"-"+txtYYYY.getIntegerText();
					return date;
			
			} catch (NumberFormatException ne) 
			{
				return "";
			}
		 
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
	
	public void setDisabled(boolean val)
	{
		txtDD.setDisabled(val);
		txtMM.setDisabled(val);
		txtYYYY.setDisabled(val);
	}
}
