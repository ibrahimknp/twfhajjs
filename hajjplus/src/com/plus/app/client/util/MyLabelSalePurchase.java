package com.plus.app.client.util;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

public class MyLabelSalePurchase extends Composite{
	Label	lbl;
	
	private double	sale,purchase;
	
	
	public MyLabelSalePurchase(Double sale,Double purchase)
	{
		lbl = new Label(""+sale);
		lbl.addStyleName("f12");
		setSale(sale);
		setPurchase(purchase);
		initWidget(lbl);
	}
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
	
	public double getSale() {
		return sale;
	}
	public void setSale(double sale) {
		this.sale = sale;
	}
	public double getPurchase() {
		return purchase;
	}
	public void setPurchase(double purchase) {
		this.purchase = purchase;
	}
	
	
}
