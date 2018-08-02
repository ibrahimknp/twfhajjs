package com.plus.app.client.util;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.event.logical.shared.BeforeSelectionHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.TabListener;
import com.google.gwt.user.client.ui.Widget;
import com.plus.app.client.SessionBean;

public class MyTabPanel extends Composite{
	
	DecoratedTabPanel		tabPanel;
	
	public MyTabPanel()
	{
		tabPanel = new DecoratedTabPanel();
	    tabPanel.setWidth("100%");
	    tabPanel.setAnimationEnabled(true);
	    
	    initWidget(tabPanel);
	    
	}
	
	public void addWidget(Widget w)
	{
		tabPanel.add(w);
	}
	public void addWidget(Widget w,String title)
	{
		tabPanel.add(w, title);
	}
	public void addWidget(Widget w,String title,boolean html)
	{
		tabPanel.add(w, title , html);
	}
	public void addTabWidget(Widget w,Widget title)
	{
		tabPanel.add(w, title);
		tabPanel.addStyleName("hand");
	}
	public void clear()
	{
		tabPanel.clear();
	}
	public SessionBean getSession()
	{
		return com.plus.app.client.SessionBean.getInstance();
	}
	
	public boolean getPrivilege(String itemId,String menuId[])
	{
		if(getSession().getHashMenuPrevs().containsKey(itemId))
		{
			Map hash =(HashMap) getSession().getHashMenuPrevs().get(itemId);
			for(int a=0;a<menuId.length;a++)
			{
				if(hash.containsKey(menuId[a]))
				{
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	public void setSelectedTab(int index)
	{
		tabPanel.selectTab(index);
	 }
	 
	public void setSelectedTab(int index,boolean fireevent)
	{
		tabPanel.selectTab(index,fireevent);
	}

	public void addTabListener(TabListener listener)
	{
		tabPanel.addTabListener(listener);
	}

	public DecoratedTabPanel getTabPanel() {
		return tabPanel;
	}

	public void setTabPanel(DecoratedTabPanel tabPanel) {
		this.tabPanel = tabPanel;
	}
	
	public int getSelectedTab()
	{
		return tabPanel.getTabBar().getSelectedTab();
	}
	public Widget getWidget(int index)
	{
		try {
			return tabPanel.getWidget(index);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public void addBeforeSelectionHandler(BeforeSelectionHandler handler)
	{
		tabPanel.addBeforeSelectionHandler(handler);
	}
	public void setTabText(int index,String val)
	{
		tabPanel.getTabBar().setTabHTML(index, "<span style='color:gainsboro;font-weight:bold;font-size:15px'>"+val+"</span>");
	}
}
