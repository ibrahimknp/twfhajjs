package com.plus.app.client.util;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

public class MyLabel extends Composite{
	Label	lbl;
	
	public MyLabel(String label)
	{
		lbl = new Label(label);
		lbl.addStyleName("f12");
		initWidget(lbl);
	}
	public MyLabel(String label,Object id)
	{
		lbl = new Label(label);
		lbl.addStyleName("f12");
		setId(""+id);
		initWidget(lbl);
	}
	/*public MyLabel(String label, String style)
	{
		lbl = new Label(label);
		lbl.addStyleName(style);
		initWidget(lbl);
	}
	*/
	public void setText(String text)
	{
		lbl.setText(text);
	}
	public void setText(Object text)
	{
		if(text!=null)
		lbl.setText(text.toString());
	}
	
	public Integer getIntegerText()
	{
		return Util.checkNullInt(lbl.getText());
	}
	public String getText()
	{
		return lbl.getText();
	}
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		lbl.setTitle(id);
		this.id = id;
	}
	
	public void clear()
	{
		lbl.setText("");
	}
	public void addClickHandler(ClickHandler handler)
	{
		lbl.addClickHandler(handler);
		
	}
	public void setWordWrap(boolean wrap)
	{
		lbl.setWordWrap(wrap);
	}
	
	private int alignment=0;

	public int getAlignment() {
		return alignment;
	}
	public void setAlignment(int alignment) {
		this.alignment = alignment;
	}
	
	
	private Long code;

	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}

	
	
}
