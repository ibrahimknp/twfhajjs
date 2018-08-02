package com.plus.app.client.util;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;

public class MyWidget extends Composite {

	MyVerticalPanel			vMain;
	MyHTML				hyper;

	/**
	 *
	 * @param str  label name
	 * @param icon image file name without path i.e. booking.png
	 */
	public MyWidget(String str,String icon)
	{
		vMain = new MyVerticalPanel();
		vMain.setSize("200px", "200px");
		vMain.addStyleName("flowLeft");
		vMain.addStyleName("shortcutFlex");


		Image img =new Image("images/icons/"+icon);
		hyper = new MyHTML(str);
		hyper.setText(str);
		hyper.setStyleName("shortCutFlex-font");

		vMain.addWidget(img, 1, 1);
		vMain.addWidget(hyper, 1, 1);

		initWidget(vMain);
	}
	public void addClickHandler(ClickHandler handler)
	{
		vMain.addDomHandler(handler, ClickEvent.getType());
	}
}
