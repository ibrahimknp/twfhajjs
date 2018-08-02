package com.plus.app.client.util;

import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MyVerticalPanel extends Composite{

	VerticalPanel		vMain;
	String				WIDTH;

	public MyVerticalPanel()
	{
		vMain = new VerticalPanel();
		initWidget(vMain);
	}
	public MyVerticalPanel(boolean width)
	{
		vMain = new VerticalPanel();
		if(width)
			vMain.setWidth("100%");

		initWidget(vMain);
	}
	/*
	 * 	if null then white background
	 */
	public MyVerticalPanel(String width)
	{
		vMain = new VerticalPanel();
		vMain.setWidth(width);
		//if(backgroundStyle==null)
		//vMain.addStyleName("verticalBack");
		//else
			//vMain.addStyleName(backgroundStyle);
		initWidget(vMain);
	}
	public void setBackgroundColor(String colorName)
	{
		DOM.setStyleAttribute(vMain.getElement(), "backgroundColor",colorName);
		//DOM.setStyleAttribute(horiImg.getElement(), "backgroundColor", "#7E9D35");
	}
	public void addWidgetHoriCenter(Widget w)
	{
		vMain.add(w);
		vMain.setCellHorizontalAlignment(w, HasHorizontalAlignment.ALIGN_CENTER);
	}
	public void addWidgetTop(Widget w)
	{
		vMain.add(w);
		vMain.setCellVerticalAlignment(w, HasVerticalAlignment.ALIGN_TOP);
	}
	public void addWidgetTop(Widget w,String menuId,int pos)
	{
		vMain.add(w);
		vMain.setCellVerticalAlignment(w, HasVerticalAlignment.ALIGN_TOP);

		String prevs=Util.getPrivilege(menuId);
		w.setVisible(Util.setPrviliage(prevs,this,pos));
	}


	/**
	 *
	 * @param w pass the widget
	 * @param align pass the horizontal alignment 0= left , 1 = center , 2 = right
	 */
	public void addWidget(Widget w,int align)
	{
		vMain.add(w);
		if(align==0)
		{
			if(LocaleInfo.getCurrentLocale().isRTL())
			vMain.setCellHorizontalAlignment(w, HasAlignment.ALIGN_RIGHT);
			else
				vMain.setCellHorizontalAlignment(w, HasAlignment.ALIGN_LEFT);
		}
		else if(align==1)
		{
				vMain.setCellHorizontalAlignment(w, HasAlignment.ALIGN_CENTER);
		}
		else if(align==2)
		{
			if(LocaleInfo.getCurrentLocale().isRTL())
				vMain.setCellHorizontalAlignment(w, HasAlignment.ALIGN_LEFT);
				else
					vMain.setCellHorizontalAlignment(w, HasAlignment.ALIGN_RIGHT);
		}

	}
	/**
	 *
	 * @param w pass the widget
	 * @param align pass the horizontal alignment 0= left , 1 = center , 2 = right\
	 * @param align pass the vertical alignment 0= top , 1 = middle , 2 = bottom
	 */
	public void addWidget(Widget w,int hAlign,int vAlign)
	{
		vMain.add(w);
		if(hAlign==0)
		{
			if(LocaleInfo.getCurrentLocale().isRTL())
			vMain.setCellHorizontalAlignment(w, HasAlignment.ALIGN_RIGHT);
			else
				vMain.setCellHorizontalAlignment(w, HasAlignment.ALIGN_LEFT);
		}
		else if(hAlign==1)
		{
				vMain.setCellHorizontalAlignment(w, HasAlignment.ALIGN_CENTER);
		}
		else if(hAlign==2)
		{
			if(LocaleInfo.getCurrentLocale().isRTL())
				vMain.setCellHorizontalAlignment(w, HasAlignment.ALIGN_LEFT);
				else
					vMain.setCellHorizontalAlignment(w, HasAlignment.ALIGN_RIGHT);
		}

		if(vAlign==0)
			vMain.setCellVerticalAlignment(w, HasVerticalAlignment.ALIGN_TOP);
		else if(vAlign==1)
			vMain.setCellVerticalAlignment(w, HasVerticalAlignment.ALIGN_MIDDLE);
		else if(vAlign==2)
			vMain.setCellVerticalAlignment(w, HasVerticalAlignment.ALIGN_BOTTOM);

	}


	public void setSize(int width,int height)
	{
		vMain.setSize(width+"px", height+"px");
	}

	public void setWidth(String width)
	{
		WIDTH =width;
		vMain.setWidth(width);
	}
	public String getWidth()
	{
		return WIDTH;
	}
	public Integer getHeight()
	{
		System.out.println("hh:"+vMain.getOffsetHeight());

		return vMain.getOffsetHeight();
	}
	public void setWhiteBackground()
	{
		vMain.addStyleName("verticalBack");
	}

	public void setTitle(String title)
	{
		HTML ht = new HTML(title);
		ht.addStyleName("frameTitle");
		vMain.add(ht);
	}
	public void setHeaderTitle(String title)
	{
		HTML ht = new HTML(title);
		ht.addStyleName("headerTitle");
		vMain.add(ht);
	}
	public void setHeaderWidgetTitle(String title,Widget widget,Integer align)
	{
		MyFlexTable hori = new MyFlexTable();
		hori.setWidth("100%");
		hori.addStyleName("headerWidgetTitle");
		HTML ht = new HTML(title);
		if(align==0)
		  hori.setWidget(0, 0, new MySearchWidget(new Widget[]{ht,widget}), 0);
		else if(align==2)
		{
			hori.setWidget(0, 0,  ht, 0);
			hori.setWidget(0, 1, widget, 2);
		}

		vMain.add(hori);
	}
	public void setScrollTitle(String title)
	{
		HTML ht = new HTML(title);
		ht.addStyleName("scrollTitle");
		vMain.add(ht);

	}

	public void setBorder()
	{
		vMain.addStyleName("browsePanel");
	}
	public void setToolTip(String tip)
	{
		vMain.setTitle(tip);
	}
	public void setBackground(String backgroundColor)
	{
		DOM.setStyleAttribute(vMain.getElement(), "backgroundColor", backgroundColor);
	}

	public void setSpacing(int space)
	{
		vMain.setSpacing(space);
	}
	public void remove(int index)
	{
		vMain.remove(index);

	}
	public void insert(int index,Widget w)
	{
		vMain.insert(w, index);
	}
	private int alignment=1;

	public int getAlignment() {
		return alignment;
	}
	public void setAlignment(int alignment) {
		this.alignment = alignment;
	}
	public void clear()
	{
		vMain.clear();
	}
	public void addVertiAlignTop(Widget w)
	{
		vMain.add(w);
		vMain.setCellVerticalAlignment(w,VerticalPanel.ALIGN_TOP);

	}

	private String id;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public void setCellHeight(Widget w,String height)
	{
		vMain.setCellHeight(w, height);
	}
}
