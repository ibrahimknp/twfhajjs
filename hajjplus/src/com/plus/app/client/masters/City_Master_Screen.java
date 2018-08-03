package com.plus.app.client.masters;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.plus.app.client.SessionBean;
import com.plus.app.client.impl.MyRefresh_Impl;
import com.plus.app.client.impl.PopupMain;
import com.plus.app.client.util.MyButtonPanel;
import com.plus.app.client.util.MyDialogBox;
import com.plus.app.client.util.MyFlexTable;
import com.plus.app.client.util.MyTextBox;
import com.plus.app.client.util.MyVerticalPanel;
import com.plus.app.client.util.Validation;

public class City_Master_Screen extends Composite implements PopupMain,MyRefresh_Impl{
	
	MyButtonPanel				cmdButtons;
	private MyDialogBox			dialog;
	private MyRefresh_Impl		impl;
	private MyTextBox			txtNameLa,txtNameAr;
	MyRefresh_Impl 				IMPL;
	
	
	private static City_Master_Screen instance;
	public static City_Master_Screen getInstance()
	{
		if(instance == null)
			instance = new City_Master_Screen();
		
		return instance;
	}
	
	public City_Master_Screen() {
		// TODO Auto-generated constructor stub
		dialog = new MyDialogBox("City Master","City_Master_Screen");
		dialog.registerDestroy(this);
		MyVerticalPanel vMain = new MyVerticalPanel();
		vMain.setSize(670, 150);
		
		
		txtNameLa = new MyTextBox(350, 50, "City Name (LA)", false);
		txtNameAr = new MyTextBox(350, 50, "City Name (AR)", false);
		
		cmdButtons = new MyButtonPanel();
		
		
		
		MyFlexTable flex = new MyFlexTable();
		flex.setCellPadding(3);
		flex.setColumnWidth(0, 150);
		
		flex.setWidget(1, 0, txtNameLa.getNameValue(), 0);
		flex.setWidget(1, 1, txtNameLa, 0);
		flex.setWidget(2, 0, txtNameAr.getNameValue(), 0);
		flex.setWidget(2, 1, txtNameAr, 0);
		flex.setWidget(3, 1, cmdButtons, 0);
		
		vMain.addWidgetTop(flex);
		
		
		dialog.add(vMain);
		
		
		cmdButtons.getCmdSave().addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent arg0) 
			{
				Widget widget[] = new Widget[]{txtNameLa,txtNameAr};
				boolean check = Validation.getInstance().setValidation(widget);
				if(check)
				{
					
				}
				else
				{
					cmdButtons.getCmdSave().reset();
				}
			}
		});
		cmdButtons.getCmdReset().addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent arg0) 
			{
				clear();
			}
		});
		
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
		txtNameLa.clear();
		txtNameAr.clear();
		cmdButtons.updateEnable(false);
	}

	@Override
	public void setPrevs(String menuId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SessionBean getSession() {
		// TODO Auto-generated method stub
		return SessionBean.getInstance();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		dialog.show();
	}

	@Override
	public void refresh(String item, String value) {
		// TODO Auto-generated method stub
		
	}
	
	public void init()
	{
		
	}
	
	
	

	
	public void registerRefresh(MyRefresh_Impl impl)
	{
		IMPL = impl;
	}
}
