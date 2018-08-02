package com.plus.app.client;

import java.util.Date;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.plus.app.client.impl.Main;
import com.plus.app.client.util.Utility;

public class MenuAction //implements Command
{

	String prev,screen;
	Widget 	widget;
	Integer	itemId;

	static		Main		main;

	public MenuAction(Integer itemId,String prev,Widget wid)
	{
		this.itemId = itemId;
		this.prev=prev;
		//this.screen=screen;
		this.widget = wid;

	}

	/*public void execute()
	{
				//System.out.println("execute script");

				Widget wOld = RootPanel.get("main").getWidget(0);
				if(wOld instanceof Main)
				{
					Main mOld=(Main) wOld;
					mOld.destroy();
				}

				RootPanel.get("main").remove(0);
				//Widget w=ScreenFactory.getInstance().getScreen(itemId);
				//System.out.println(w);
				RootPanel.get("main").add(widget);
				Main m=(Main)widget;
				main = m;
				m.setPrevs(prev);
				m.load();
				m.clear();
				//m.menuItemId(itemId);
				//m.destroy();


	}
	*/
	public void executeMenu()
	{
				//System.out.println("execute script");

				Utility.showLoading();

				Widget wOld = RootPanel.get("main").getWidget(0);
				if(wOld instanceof Main)
				{
					Main mOld=(Main) wOld;
					mOld.destroy();
				}

				RootPanel.get("main").remove(0);
				//Widget w=ScreenFactory.getInstance().getScreen(itemId);
				//System.out.println(w);
				RootPanel.get("main").add(widget);
				Main m=(Main)widget;
				main = m;
				m.setPrevs(prev);
				m.load();
				m.clear();
				//m.menuItemId(itemId);
				//m.destroy();

				SessionBean.getInstance().setLastAccessedTime(new Date());

				Utility.hideLoading();
	}

}
