package com.plus.app.client.util;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;

public class MyHTML extends Composite{

	HTML			html;

	public MyHTML()
	{
		html = new HTML();
		initWidget(html);
	}
	public MyHTML(int width)
	{
		html = new HTML();
		html.setWidth(""+width);
		initWidget(html);
	}

	public MyHTML(String htm)
	{
		html = new HTML(htm);

		initWidget(html);
	}
	public MyHTML(String htm,String sharing)
	{
		html = new HTML(htm);
		html.addStyleName(sharing);
		initWidget(html);
	}
	public Integer getIntegerText()
	{
		return Util.checkNullInt(html.getText());
	}
	public void setHtml(String text)
	{
		html.setHTML(text);

	}
	public String getText()
	{
		return Util.checkNull(html.getText());
	}

	private String id="0";

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setText(Object text)
	{
		if(text!=null)
		html.setHTML(text.toString());
	}
	public void clear()
	{
		html.setText("");
	}

	private int alignment=0;

	public int getAlignment() {
		return alignment;
	}
	public void setAlignment(int alignment) {
		this.alignment = alignment;
	}
	public void addClickHandler(ClickHandler handler)
	{
		html.addClickHandler(handler);
	}

	public void setBaloonText(Object val)
	{
		if(val!=null)
		{
			html.setText(val.toString());
			html.addStyleName("chatCount2");
			DOM.setStyleAttribute(html.getElement(), "backgroundColor", "green");
		}
	}
	public void clearBaloon()
	{
		html.setText("0");
		DOM.setStyleAttribute(html.getElement(), "backgroundColor", "red");
	}
}
