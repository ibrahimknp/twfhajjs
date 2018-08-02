package com.plus.app.client;

import com.google.gwt.user.client.ui.Widget;
import com.plus.app.client.impl.PopupMain;

public class PopupAction {

	Widget 			widget;
	private static PopupAction instance;
	public static PopupAction getInstance()
	{
		if(instance == null)
			instance = new PopupAction();
		
		return instance;
	}
	
	public void show(Widget wid)
	{
		PopupMain m=(PopupMain)wid;
		m.setPrevs(null);
		m.load();
		m.clear();
		//m.menuItemId(itemId);
		//m.destroy();
		m.show();
	}
	public void edit(Widget wid)
	{
		PopupMain m=(PopupMain)wid;
		m.setPrevs(null);		
		m.clear();
		m.show();
	}
}
