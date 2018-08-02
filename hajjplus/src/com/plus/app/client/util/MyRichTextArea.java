package com.plus.app.client.util;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RichTextArea;
import com.plus.app.client.util.richText.RichTextToolbar;
 

public class MyRichTextArea extends Composite{
	
	RichTextArea textMessage;
	public MyRichTextArea(Integer width,Integer height,String name)
	{
		textMessage = new RichTextArea();
		textMessage.ensureDebugId("cwRichText-area");
		textMessage.setSize(""+width+"px", ""+height+"px");
		textMessage.addStyleName("enhanceGray");
		
		RichTextToolbar toolbar = new RichTextToolbar(textMessage);
		toolbar.ensureDebugId("cwRichText-toolbar");
	    toolbar.setWidth(""+width+"px");
	    
		Grid grid = new Grid(2, 1);
	    grid.setStyleName("cw-RichText");
	    grid.setWidget(0, 0, toolbar);
	    grid.setWidget(1, 0, textMessage);
	    setNameValue(name);
	    
	    initWidget(grid);
	}
	private String name;
	public void setNameValue(String name)
	{
		this.name=name;
		
	}
	public String getNameValue()
	{
		return this.name;
	}
	public void setText(String text)
	{
		textMessage.setText(text);
	}
	public String getText()
	{
		return textMessage.getText();
	}
	public void clear()
	{
		textMessage.setText("");
	}

	public String	getHtml()
	{
		return textMessage.getHTML();
	}
	public void setHtml(String html)
	{
		textMessage.setHTML(html);
	}
	  
}
