package com.plus.app.client.util;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;

public class LanguageRepeater extends Composite{
	
	
	MyVerticalPanel			vert; 
	MyRadioButton			rbEng,rbArabic;
	
	public LanguageRepeater(final MyTextBox txtEng,final MyTextBox txtArab)
	{
		
		vert = new MyVerticalPanel();
		
		rbArabic = new MyRadioButton("lang", "Arabic");
		rbEng = new MyRadioButton("lang", "Eng.");
		
		MyFlexTable flex = new MyFlexTable();
		flex.setWidget(0, 0, "Copy as", 0,2);
		flex.setWidget(0, 1, rbEng, 0);
		flex.setWidget(0, 2, rbArabic, 0);
		
		vert.addWidgetTop(flex);
		
		initWidget(vert);
		
		rbEng.addClickHandler(new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0) 
			{
				txtArab.setText(txtEng.getText());
			}
		});
		
		rbArabic.addClickHandler(new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0) 
			{
				txtEng.setText(txtArab.getText());
			}
		});
	}
	public LanguageRepeater(final MySuggestBox txtEng,final MySuggestBox txtArab)
	{
		
		vert = new MyVerticalPanel();
		
		rbArabic = new MyRadioButton("lang", "Arabic");
		rbEng = new MyRadioButton("lang", "Eng.");
		
		MyFlexTable flex = new MyFlexTable();
		flex.setWidget(0, 0, "Copy as", 0,2);
		flex.setWidget(0, 1, rbEng, 0);
		flex.setWidget(0, 2, rbArabic, 0);
		
		vert.addWidgetTop(flex);
		
		initWidget(vert);
		
		rbEng.addClickHandler(new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0) 
			{
				txtArab.setText(txtEng.getText());
			}
		});
		
		rbArabic.addClickHandler(new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0) 
			{
				txtEng.setText(txtArab.getText());
			}
		});
	}
	
	public void clear()
	{
		rbEng.setChecked(false);
		rbArabic.setChecked(false);
	}
	

}
