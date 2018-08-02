package com.plus.app.client.util;

import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MyHorizontalPanel extends Composite{

	HorizontalPanel			hori;

	public MyHorizontalPanel()
	{
		hori = new HorizontalPanel();
		initWidget(hori);
	}
	public MyHorizontalPanel(String width)
	{
		hori = new HorizontalPanel();
		hori.setWidth(width);
		initWidget(hori);
	}
	public MyHorizontalPanel(boolean width)
	{
		hori = new HorizontalPanel();
		if(width)
			hori.setWidth("100%");
		initWidget(hori);

	}
	/**
	 *
	 * @param wid 	pass widget as an array
	 * @param spacing if -1 then default 5px
	 */
	public MyHorizontalPanel (Widget wid[],int spacing)
	{
		HorizontalPanel hori = new HorizontalPanel();
		for(int a=0;a<wid.length;a++)
		{
			Widget w = wid[a];
			hori.add(w);
			hori.setCellWidth(w, spacing+"px");
			//w.addStyleName("MySearchWidget");
			hori.setCellVerticalAlignment(w, HasVerticalAlignment.ALIGN_MIDDLE);

			if((wid.length-1)==a)
			{
				hori.setCellWidth(w, "5px");
			}
		}

		initWidget(hori);
	}

	/**
	 *
	 * @param w pass the widget
	 * @param align pass the horizontal alignment 0= left , 1 = center , 2 = right
	 */
	public void addWidget(Widget w,int align)
	{
		hori.add(w);
		if(align==0)
		{
			if(LocaleInfo.getCurrentLocale().isRTL())
			hori.setCellHorizontalAlignment(w, HasAlignment.ALIGN_RIGHT);
			else
				hori.setCellHorizontalAlignment(w, HasAlignment.ALIGN_LEFT);
		}
		else if(align==1)
		{
				hori.setCellHorizontalAlignment(w, HasAlignment.ALIGN_CENTER);
		}
		else if(align==2)
		{
			if(LocaleInfo.getCurrentLocale().isRTL())
				hori.setCellHorizontalAlignment(w, HasAlignment.ALIGN_LEFT);
				else
					hori.setCellHorizontalAlignment(w, HasAlignment.ALIGN_RIGHT);
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
		hori.add(w);
		if(hAlign==0)
		{
			if(LocaleInfo.getCurrentLocale().isRTL())
			hori.setCellHorizontalAlignment(w, HasAlignment.ALIGN_RIGHT);
			else
				hori.setCellHorizontalAlignment(w, HasAlignment.ALIGN_LEFT);
		}
		else if(hAlign==1)
		{
				hori.setCellHorizontalAlignment(w, HasAlignment.ALIGN_CENTER);
		}
		else if(hAlign==2)
		{
			if(LocaleInfo.getCurrentLocale().isRTL())
				hori.setCellHorizontalAlignment(w, HasAlignment.ALIGN_LEFT);
				else
					hori.setCellHorizontalAlignment(w, HasAlignment.ALIGN_RIGHT);
		}

		if(vAlign==0)
			hori.setCellVerticalAlignment(w, HasVerticalAlignment.ALIGN_TOP);
		else if(vAlign==1)
			hori.setCellVerticalAlignment(w, HasVerticalAlignment.ALIGN_MIDDLE);
		else if(vAlign==2)
			hori.setCellVerticalAlignment(w, HasVerticalAlignment.ALIGN_BOTTOM);

	}


	public void setSize(int width,int height)
	{
		hori.setSize(width+"px", height+"px");
	}

	public void setWidth(String width)
	{
		hori.setWidth(width);
	}
	public void setSpacing(int space)
	{
		hori.setSpacing(space);
	}
	public void setCellWidth(Widget w, int width)
	{
		hori.setCellWidth(w, width+"px");
	}
	/**
	 *
	 * @param w pass widget
	 * @param widthPer pass with percentage (ex 95%)
	 */
	public void setCellWidth(Widget w, String widthPer)
	{
		hori.setCellWidth(w, widthPer);
	}
	public void addHoriAlignRight(Widget w)
	{
		hori.add(w);
		if(LocaleInfo.getCurrentLocale().isRTL())
			hori.setCellHorizontalAlignment(w,HorizontalPanel.ALIGN_LEFT);
		else
		{
			hori.setCellHorizontalAlignment(w,HorizontalPanel.ALIGN_RIGHT);
		}
	}
	public void addHoriAlignLeft(Widget w)
	{
		hori.add(w);
		if(LocaleInfo.getCurrentLocale().isRTL())
			hori.setCellHorizontalAlignment(w,HorizontalPanel.ALIGN_RIGHT);
		else
			hori.setCellHorizontalAlignment(w,HorizontalPanel.ALIGN_LEFT);

	}
	 public void setBackground()
	 {
		 hori.addStyleName("chatSelectedUser");
	 }
	 public void removeBackground()
	 {
		 hori.removeStyleName("chatSelectedUser");
	 }

	 public void clear()
		{
			hori.clear();
		}
}
