package com.plus.app.client.util;

import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment.VerticalAlignmentConstant;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MyDecoratorPanel extends DecoratorPanel {
	
	VerticalPanel	vMain;
	
	public MyDecoratorPanel()
	{
		super();
		vMain = new VerticalPanel();
		add(vMain);	
	}
	
	public void setSize(int width,int height)
	{
		vMain.setSize(width+"px", height+"px");
	}
	public void addWidget(Widget w)
	{
		vMain.add(w);
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
}
