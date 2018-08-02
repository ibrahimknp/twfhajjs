package com.plus.app.client.util;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class Validation{
	
	public static Validation instance;
	
	public static Validation getInstance()
	{
		if(instance==null)
			instance=new Validation();
		
		return instance;
	}

	
	
	public boolean setValidation(Widget widget[])
	{
	 	for(int a=0;a<widget.length;a++)
		{
			if(widget[a] instanceof MyTextBox)
			{
				MyTextBox txt=(MyTextBox)widget[a];
				if(txt.getText()==null || txt.getText().trim().length()==0 || txt.getText().equals(txt.EXAMPLE))
				{
					MyErrorBox.alert(txt.getNameValue()+" is required");
					txt.setFocus(true);
					txt.addStyleName("backColorAlert");
					return false;
				}
			}
			else if(widget[a] instanceof MyPasswordTextBox)
			{
				MyPasswordTextBox txt=(MyPasswordTextBox)widget[a];
				if(txt.getText()==null || txt.getText().trim().length()==0)
				{
					MyErrorBox.alert(txt.getNameValue()+" is required");
					txt.setFocus(true);
					txt.addStyleName("backColorAlert");
					return false;
				}
			}
			else if(widget[a] instanceof MyListBox)
			{
				MyListBox lst=(MyListBox)widget[a];
				if(lst.getItemCount()==0 || lst.getValue(lst.getSelectedIndex()).equals("999"))
				{
					lst.setFocus(true);
					lst.addStyleName("backColorAlert");
					MyErrorBox.alert(lst.getNameValue()+" is required");
					return false;
				}
			}
			else if(widget[a] instanceof MyUpdatebleCombo)
			{
				MyUpdatebleCombo lst=(MyUpdatebleCombo)widget[a];
				if(lst.isVisible())
				{
					if(lst.getLstBox().getItemCount()==0 || lst.getLstBox().getValue(lst.getLstBox().getSelectedIndex()).equals("100") || lst.getLstBox().getValue(lst.getLstBox().getSelectedIndex()).equals("0") || lst.getLstBox().getValue(lst.getLstBox().getSelectedIndex()).equals("101"))
					{
						lst.getLstBox().setFocus(true);
						lst.addStyleName("backColorAlert");
						MyErrorBox.alert(lst.getNameValue()+" is required");
						return false;
					}
				}
			}
			else if(widget[a] instanceof TextBox)
			{
				TextBox txt=(TextBox)widget[a];
				if(txt.getText()==null || txt.getText().trim().length()==0)
				{
					MyErrorBox.alert("Value is required");
					txt.setFocus(true);
					txt.addStyleName("backColorAlert");
					return false;
				}
			}
			else if(widget[a] instanceof MyTextArea)
			{
				MyTextArea txt=(MyTextArea)widget[a];
				if(txt.getText()==null || txt.getText().trim().length()==0)
				{
					MyErrorBox.alert(txt.getNameValue()+" is required");
					txt.setFocus(true);
					txt.addStyleName("backColorAlert");
					return false;
				}
			}
			else if(widget[a] instanceof MyDateBox)
			{
				MyDateBox txt=(MyDateBox)widget[a];
				if(txt.getText()==null || txt.getText().trim().length()==0 || txt.getText().equals("dd-MM-yyyy"))
				{
					MyErrorBox.alert(txt.getNameValue()+" is required");
					txt.addStyleName("backColorAlert");
					return false;
				}
			}
			else if(widget[a] instanceof MyArrFlightSector)
			{
				MyArrFlightSector txt=(MyArrFlightSector)widget[a];
				if(txt.getTextInput()==null || txt.getTextInput().trim().length()==0 || txt.getTextInput().equals(txt.EXAMPLE))
				{
					MyErrorBox.alert(txt.getNameValue()+" is required");
					txt.addStyleName("backColorAlert");
					return false;
				}
			}
			else if(widget[a] instanceof MyDepFlightSector)
			{
				MyDepFlightSector txt=(MyDepFlightSector)widget[a];
				if(txt.getTextInput()==null || txt.getTextInput().trim().length()==0 || txt.getTextInput().equals(txt.EXAMPLE))
				{
					MyErrorBox.alert(txt.getNameValue()+" is required");
					txt.addStyleName("backColorAlert");
					return false;
				}
			}
			
		}
		return true;
	}
	
	public boolean validateZeroValue(Widget widget[])
	{
		for(int a=0;a<widget.length;a++)
		{
			if(widget[a] instanceof MyTextBox)
			{
				MyTextBox txt=(MyTextBox)widget[a];
				if(txt.getText()!=null && txt.getText().toString().equals("0"))
				{
					//MyErrorBox.alert(Language.message.valueRequired(txt.getNameValue()));
					txt.setFocus(true);
					txt.addStyleName("backColorAlert");
					return false;
				}
			}
		}
		return true;
	}
	
}
