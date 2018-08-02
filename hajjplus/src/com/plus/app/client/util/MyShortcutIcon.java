package com.plus.app.client.util;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;

public class MyShortcutIcon extends Composite{

	Image			image;
	MyHTML			htCount;

	public MyShortcutIcon(Image img,String iconName)
	{
		image = img;
		image.addStyleName("hand");

		MyVerticalPanel vMain = new MyVerticalPanel();

		vMain.addWidgetHoriCenter(image);
		vMain.addWidgetHoriCenter(Util.getHTMLLabel(iconName,"shortcutIcon"));

		vMain.addStyleName("paddingBothSide");

		initWidget(vMain);
	}
	public MyShortcutIcon(Image img,String iconName,boolean baloon)
	{
		image = img;
		image.addStyleName("hand");

		htCount = new MyHTML();


		MyVerticalPanel vMain = new MyVerticalPanel();

		vMain.addWidgetHoriCenter(htCount);
		vMain.addWidgetHoriCenter(image);
		vMain.addWidgetHoriCenter(Util.getHTMLLabel(iconName,"shortcutIcon"));


		vMain.addStyleName("paddingBothSide");

		initWidget(vMain);
	}
	public void addClickHandler(ClickHandler handler)
	{
		image.addClickHandler(handler);
	}

	public void setBaloonText(Object val)
	{
		if(val!=null)
		{
			htCount.setText(val.toString());
			htCount.addStyleName("chatCount");
		}
	}
	public void clearBaloon()
	{
		htCount.setText("");
		htCount.removeStyleName("chatCount");
	}

}
