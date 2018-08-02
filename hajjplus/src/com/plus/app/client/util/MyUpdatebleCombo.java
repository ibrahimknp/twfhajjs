package com.plus.app.client.util;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.plus.app.client.SessionBean;


public class MyUpdatebleCombo extends Composite{
	
	private MyListBox		lstBox;
	private MyTextBox		txtBox;
	private HorizontalPanel	hori;
	private boolean			CHECKBOX;
	MyClickHandler			myClick;
	
	
	/**
	 * 
	 * @param width
	 * @param nameValue
	 * @param MODE if pass zero then no Image and if pass 1 then popup else refresh
	 */
	public MyUpdatebleCombo(int width ,String name, int mode)
	{
		myClick = new MyClickHandler();
		
		lstBox = new MyListBox(width,name,mode);
		txtBox = new MyTextBox((width),20,name,false);
		txtBox.addClickHandler(myClick);
		txtBox.setEditable(false);
		//txtBox.setTitle(Language.constants.listOfValues());
		
		
		hori = new HorizontalPanel();
		hori.add(txtBox);
		hori.add(lstBox);
		
		lstBox.setVisible(false);
		initWidget(hori);
		
		setNameValue(name);
	}
	
	class MyClickHandler implements ClickHandler
	{
		public void onClick(ClickEvent e)
		{
			setDisable(false);
			showTextBox(false);			
		}
	}
	public MyListBox getLstBox() {
		return lstBox;
	}

	public void setLstBox(MyListBox lstBox) {
		this.lstBox = lstBox;
	}

	public MyTextBox getTxtBox() {
		return txtBox;
	}

	public void setTxtBox(MyTextBox txtBox) {
		this.txtBox = txtBox;
	}
	public void setDisable(boolean bool)
	{
		lstBox.setDisabled(bool);
		txtBox.setDisabled(bool);
	}
	
	public void setText(String item,Object value)
	{
		txtBox.setText(item);
		lstBox.clear();
		lstBox.addItem(item, Util.checkNull(value));
		showTextBox(true);		
	}
	
	public void showTextBox(boolean status)
	{
		txtBox.setVisible(status);
		lstBox.setVisible(!status);
	}
	public void clear()
	{
		txtBox.setDisabled(false);
		showTextBox(true);
		txtBox.clear();
		lstBox.clear();
		
	}
	
	private String nameValue;
	public String getNameValue() {
		return nameValue;
	}
	public void setNameValue(String nameValue) {
		this.nameValue = nameValue;
	}
	
	public Image getImg() {
		return lstBox.getImg();
	}
	public Image getImg2() {
		return lstBox.getImg2();
	}
	public MyLabel getIdValue()
	{
		String id = lstBox.getComboValue();
		String name = lstBox.getComboItem();
		MyLabel city = new MyLabel(name);
		city.setId(id);
		
		return city;
	}
	
	
	
	public void hideImage()
	{
		lstBox.hideImage();
	}
	public void showImage()
	{
		lstBox.showImage();
	}
	
	public Long getComboValueLong()
	{
		return lstBox.getComboValueLongNull();
	}
	
	public void setFocus()
	{
		lstBox.setFocus(true);
		txtBox.setFocus(true);
	}
	
	public boolean isDataValue()
	{
		if(lstBox.getComboValueInteger()==0 || lstBox.getComboValueInteger()==100 ||  lstBox.getComboValueInteger()==101 )
			return false;
		else
			return true;
		
	}
	private Long code;

	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
}
