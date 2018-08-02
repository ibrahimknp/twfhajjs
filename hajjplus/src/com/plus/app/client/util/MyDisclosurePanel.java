package com.plus.app.client.util;

import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;


public class MyDisclosurePanel extends Composite{
	
	public boolean DIS_OPEN_CLOSE = false;
	DisclosurePanel		dis ;
	
	public MyDisclosurePanel(String header,Widget content,boolean isOpen)
	{
		dis = new DisclosurePanel(header,isOpen);
		dis.setWidth("100%");
		dis.setContent(content);
		dis.setAnimationEnabled(true);
		initWidget(dis);
		
		dis.addCloseHandler(new CloseHandler<DisclosurePanel>()
		{
			public void onClose(CloseEvent e)
			{
				setOpen(false);
			}
		});
		dis.addOpenHandler(new OpenHandler<DisclosurePanel>()
				{
					public void onOpen(OpenEvent e)
					{
						setOpen(true);
					}
				});
	}
	 
	public MyDisclosurePanel(Widget header,Widget content,boolean isOpen)
	{
		dis = new DisclosurePanel(header,isOpen);
		dis.setWidth("100%");
		dis.setContent(content);
		dis.setAnimationEnabled(true);
		initWidget(dis);
		
		dis.addCloseHandler(new CloseHandler<DisclosurePanel>()
		{
			public void onClose(CloseEvent e)
			{
				setOpen(false);
			}
		});
		dis.addOpenHandler(new OpenHandler<DisclosurePanel>()
				{
					public void onOpen(OpenEvent e)
					{
						setOpen(true);
					}
				});
	}
	public MyDisclosurePanel(String header,Widget content)
	{
		dis = new DisclosurePanel(header);
		dis.setWidth("100%");
		dis.setContent(content); 
		dis.setAnimationEnabled(true);
		initWidget(dis);
		
		dis.addCloseHandler(new CloseHandler<DisclosurePanel>()
		{
			public void onClose(CloseEvent e)
			{
				setOpen(false);
			}
		});
		dis.addOpenHandler(new OpenHandler<DisclosurePanel>()
				{
					public void onOpen(OpenEvent e)
					{
						setOpen(true);
					}
				});
	}
	public MyDisclosurePanel(String header)
	{
		dis = new DisclosurePanel(header);
		dis.setWidth("100%");
		dis.setAnimationEnabled(true);
		initWidget(dis);
		
		dis.addCloseHandler(new CloseHandler<DisclosurePanel>()
		{
			public void onClose(CloseEvent e)
			{
				setOpen(false);
			}
		});
		dis.addOpenHandler(new OpenHandler<DisclosurePanel>()
				{
					public void onOpen(OpenEvent e)
					{
						setOpen(true);
					}
				});
	}
	public void add(Widget w)
	{
		dis.setContent(w);
	}
	
	public void setOpen(boolean isOpen)
	{
		DIS_OPEN_CLOSE = isOpen;
		dis.setOpen(isOpen);
	}
	
	public void addOpenHandler(OpenHandler handler)
	{
		dis.addOpenHandler(handler);
	}

	public void setHeader(String header)
	{
		//dis.setHeader(Util.makeHTML(MyLoadedImages.next()+" "+header));
	}
	public void setHeader(String header,Image img)
	{
		//dis.setHeader(Util.makeHTML(img+" "+header));
	}
	
	/*
	public String setPrivilege(String itemId,String menuId)
	{
		if(getSession().getHashMenuPrevs().containsKey(itemId))
		{
			Map hash =(HashMap) getSession().getHashMenuPrevs().get(itemId);
			if(hash.containsKey(menuId))
			{
				dis.setVisible(true);
				Prevs_Menu_Names pm=(Prevs_Menu_Names)hash.get(menuId);
				return pm.getPrevs();
				
			}
			dis.setVisible(false);			
			return "0-0-0-0";
		}
		dis.setVisible(false);
		return "0-0-0-0";
	}
	
	public SessionBean getSession()
	{
		return SessionBean.getSession();
	}
	*/	
}
