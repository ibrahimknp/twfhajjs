package com.plus.app.client.util;

import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.plus.app.client.lang.MyLoadedImages;

public class MyListBox extends Composite{

	ListBox				lst;
	private String		nameValue;

	private Image			img,img2;


	public Image getImg2() {
		return img2;
	}
	public MyListBox()
	{
		lst = new ListBox();
		initWidget(lst);

	}
	public MyListBox(boolean multile)
	{
		lst = new ListBox(multile);
		initWidget(lst);
	}

	/**
	 *
	 * @param width
	 * @param nameValue
	 * @param MODE if pass zero then no Image and if pass 1 then popup else refresh
	 */
	public MyListBox(int width,String nameValue,int MODE)
	{
		lst = new ListBox();
		lst.setWidth(width+"px");
		setNameValue(nameValue);

		MyHorizontalPanel hori = new MyHorizontalPanel();

		if(MODE!=0)
		{
			if(MODE==1)
			{
				img = MyLoadedImages.add("Click here to add in Master", "add", true);
				lst.setWidth((width-20)+"px");
				hori.addWidget(lst, 1,1);
				hori.addWidget(img, 1,1);
				hori.setCellWidth(img, 23);
			}
			else if(MODE==2)
			{
				img = MyLoadedImages.refresh("Click here to refresh", "refresh", true);
				lst.setWidth((width-20)+"px");
				hori.addWidget(lst, 1,1);
				hori.addWidget(img, 1,1);
				hori.setCellWidth(img, 23);
			}
			else if(MODE==3)
			{
				img = MyLoadedImages.add("Click here to add in Master", "add", true);
				img2 = MyLoadedImages.refresh("Click here to refresh", "refresh", true);
				lst.setWidth((width-40)+"px");
				hori.addWidget(lst, 1,1);
				//hori.addWidget(new MySearchWidget(new Widget[]{img,img2}), 1,1);
				hori.addWidget(img,1,1);
				hori.addWidget(img2,1,1);
				hori.setCellWidth(img, 23);
				hori.setCellWidth(img2, 23);
			}

			
		}
		else
		{
			hori.addWidget(lst, 1);
		}

		initWidget(hori);


	}


	public void addItem(String item,String value)
	{
		lst.addItem(item,value);
	}

	public void addChangeHandler(ChangeHandler handler)
	{
		lst.addChangeHandler(handler);
	}
	public void addClickHandler(ClickHandler handler)
	{
		lst.addClickHandler(handler);
	}
	public Integer getComboValueInteger()
	{
		if(lst.getItemCount()!=0)
		{
			String val=lst.getValue(lst.getSelectedIndex());
			if(val.length()!=0)
			return Integer.valueOf(val);
			else
				return 0;
		}
		return 0;

	}
	public Integer getComboValueIntegerNull()
	{
		if(lst.getItemCount()!=0)
		{
			String val=lst.getValue(lst.getSelectedIndex());
			if(val.length()!=0)
			return Integer.valueOf(val);
			else
				return null;
		}
		return null;

	}
	public Long getComboValueLongNull()
	{
		if(lst.getItemCount()!=0)
		{
			String val=lst.getValue(lst.getSelectedIndex());
			if(val.length()!=0)
			return Long.valueOf(val);
			else
				return null;
		}
		return null;

	}
	public Long getComboValueLong()
	{
		if(lst.getItemCount()!=0)
		{
			String val=lst.getValue(lst.getSelectedIndex());
			return Long.valueOf(val);
		}
		return Long.valueOf("0");

	}
	public String getComboItem()
	{
		if(lst.getItemCount()!=0)
		{
			String val=lst.getItemText(lst.getSelectedIndex());
			return val;
		}
		return "";

	}
	public String getComboValue()
	{
		if(lst.getItemCount()!=0)
		{
			String val=lst.getValue(lst.getSelectedIndex());
			if(val.trim().length()!=0)
			return val;
			else
				return "0";
		}
		return "0";

	}
	public int getItemCount()
	{
		return lst.getItemCount();
	}
	public int getSelectedIndex()
	{
		return lst.getSelectedIndex();
	}
	public String getValue(int index)
	{
		return lst.getValue(index);
	}
	public void setFocus(boolean focus)
	{
		lst.setFocus(focus);
	}

	public void setComboValue(String val)
	{
		lst.setSelectedIndex(Util.getComboIndex(val, lst));
	}
	public void setSelectedIndex(int index)
	{
		lst.setSelectedIndex(index);
	}
	public void setComboValueInteger(Integer val)
	{

		if(val!=null)
		lst.setSelectedIndex(Util.getComboIndex(val.toString(), lst));
		else
			lst.setSelectedIndex(0);
	}
	public void setComboValueLong(Long val)
	{

		if(val!=null)
		lst.setSelectedIndex(Util.getComboIndex(val.toString(), lst));
		else
			lst.setSelectedIndex(0);
	}
	public void clearSelected()
	{
		int length=lst.getItemCount();
		for(int a=0;a<length;a++)
		{
			if(lst.isItemSelected(a))
			lst.setItemSelected(lst.getSelectedIndex(), false);
		}

	}

	public void reset()
	{
		lst.setSelectedIndex(0);
	}

	public Image getImg() {
		return img;
	}

	public String getNameValue() {
		return nameValue;
	}

	public void setNameValue(String nameValue) {
		this.nameValue = nameValue;
	}

	public void clear()
	{
		lst.clear();
	}
	public void addSelectHere()
	{
		lst.addItem("Select Here", "999");
	}
	public void addBlankHere()
	{
		lst.addItem("", "999");
	}

	public void setItemValue(Object id,Object value)
	{
		lst.clear();
		lst.addItem(value.toString(), id.toString());
		lst.addItem("<----refresh list--->", "999");

	}

	public void setDisabled(boolean disable)
	{
		lst.setEnabled(!disable);
	}

	public MyLabel getIdValue()
	{
		String id = getComboValue();
		String name = getComboItem();
		MyLabel city = new MyLabel(name);
		city.setId(id);

		return city;
	}

	public void hideImage()
	{
		img.setVisible(false);
		if(img2!=null)
		img2.setVisible(false);
	}
	public void showImage()
	{
		img.setVisible(true);
	}

	public void setMultiSelect(boolean bool)
	{
		lst.setMultipleSelect(bool);
	}
	public String getMultipleSelected()
	{
		String val="";
 		int length=lst.getItemCount();
 		for(int a=0;a<length;a++)
		{
	 		if(lst.isItemSelected(a))
			{
		 		String sel=lst.getValue(a);
		 		val=val+sel+",";
			}
	  	}
 		if(val.length()>0)
		  val=val.substring(0,val.length()-1);

		return val;

	}
	public void setMultipleSelected(String str)
	{
		 String val[]=str.split(",");
	 	 int len=val.length;
		  for(int i=0;i<len;i++)
	      {
	    	  String setVal=val[i];
	    	  lst.setSelectedIndex(Util.getComboIndex(setVal, lst));
	      }

	}
	public void setHeight(Integer height)
	{
		lst.setHeight(""+height+"px");
	}

	public void loading(boolean value)
	{
		if(value)
		{
			lst.addItem("Loading...", "99999");
			lst.setEnabled(!value);
		}
		else
		{
			lst.removeItem(0);
			lst.setEnabled(!value);
		}
	}

}
