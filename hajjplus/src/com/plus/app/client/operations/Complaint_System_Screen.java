package com.plus.app.client.operations;

import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.plus.app.client.SessionBean;
import com.plus.app.client.RPCConnection.Cases_Request_Connection;
import com.plus.app.client.RPCConnection.V_Cases_Types_Connection;
import com.plus.app.client.RPCConnection.V_Luk_Area_Connection;
import com.plus.app.client.RPCConnection.V_Luk_City_Connection;
import com.plus.app.client.impl.MyRefresh_Impl;
import com.plus.app.client.impl.PopupMain;
import com.plus.app.client.util.MyButtonPanel;
import com.plus.app.client.util.MyDialogBox;
import com.plus.app.client.util.MyFlexTable;
import com.plus.app.client.util.MyListBox;
import com.plus.app.client.util.MyTextArea;
import com.plus.app.client.util.MyTextBox;
import com.plus.app.client.util.MyVerticalPanel;
import com.plus.app.client.util.Validation;
import com.plus.app.shared.dao.Cases_Request;
import com.plus.app.shared.dao.V_Cases_Types;
import com.plus.app.shared.dao.V_Luk_Area;
import com.plus.app.shared.dao.V_Luk_City;
import com.plus.app.shared.wrapper.Cases_Request_Wrapper;
import com.plus.app.shared.wrapper.V_Cases_Types_Wrapper;
import com.plus.app.shared.wrapper.V_Luk_Area_Wrapper;
import com.plus.app.shared.wrapper.V_Luk_City_Wrapper;

public class Complaint_System_Screen extends Composite implements PopupMain,MyRefresh_Impl{
	
	MyButtonPanel				cmdButtons;
	private MyDialogBox			dialog;
	private MyRefresh_Impl		impl;
	private MyListBox			lstArea,lstCity,lstCaseType;
	private MyTextBox			txtName,txtContact,txtLocation;
	private MyTextArea			textDescription;	
	MyRefresh_Impl 				IMPL;
	
	
	private static Complaint_System_Screen instance;
	public static Complaint_System_Screen getInstance()
	{
		if(instance == null)
			instance = new Complaint_System_Screen();
		
		return instance;
	}
	
	public Complaint_System_Screen() {
		// TODO Auto-generated constructor stub
		dialog = new MyDialogBox("Add Complaints","Complaint_System_Screen");
		dialog.registerDestroy(this);
		MyVerticalPanel vMain = new MyVerticalPanel();
		vMain.setSize(670, 150);
		
		
		lstArea = new MyListBox(200, "Area", 0);
		lstCity = new MyListBox(200, "City", 0);
		lstCaseType = new MyListBox(150, "Case Type", 0);
		
		txtName = new MyTextBox(350, 50, "Name", false);
		txtContact = new MyTextBox(350, 50, "Contact", false);
		txtLocation = new MyTextBox(350, 50, "Location", false);
		
		textDescription = new MyTextArea(350, 100, "Description");
		
		
		cmdButtons = new MyButtonPanel();
		
		
		
		MyFlexTable flex = new MyFlexTable();
		flex.setCellPadding(3);
		flex.setColumnWidth(0, 150);
		
		flex.setWidget(0, 0, lstCaseType.getNameValue(), 0);
		flex.setWidget(0, 1, lstCaseType, 0);
		flex.setWidget(1, 0, lstCity.getNameValue(), 0);
		flex.setWidget(1, 1, lstCity, 0);
		flex.setWidget(2, 0, lstArea.getNameValue(), 0);
		flex.setWidget(2, 1, lstArea, 0);
		flex.setWidget(3, 0, txtLocation.getNameValue(), 0);
		flex.setWidget(3, 1, txtLocation, 0);
		flex.setWidget(4, 0, txtName.getNameValue(), 0);
		flex.setWidget(4, 1, txtName, 0);
		flex.setWidget(5, 0, txtContact.getNameValue(), 0);
		flex.setWidget(5, 1, txtContact, 0);
		flex.setWidget(6, 0, textDescription.getNameValue(), 0);
		flex.setWidget(6, 1, textDescription, 0);
		flex.setWidget(7, 1, cmdButtons, 0);
		
		vMain.addWidgetTop(flex);
		
		
		dialog.add(vMain);
		
		lstCity.addChangeHandler(new ChangeHandler()
		{
			@Override
			public void onChange(ChangeEvent arg0) 
			{
				loadArea();
			}
		});
		
		cmdButtons.getCmdSave().addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent arg0) 
			{
				Widget widget[] = new Widget[]{lstCaseType,lstCity,lstArea,txtLocation,txtName,txtContact,textDescription};
				boolean check = Validation.getInstance().setValidation(widget);
				if(check)
				{
					Cases_Request cr = getCases_Request();
					Cases_Request_Wrapper meta = new Cases_Request_Wrapper();
					meta.setCases_Request(cr);
					Cases_Request_Connection.getRpcConnection().save(meta, new AsyncCallback<String>()
					{
						@Override
						public void onSuccess(String arg0) 
						{
							if(arg0!=null)
							{
								Window.alert("Record saved successfully");
								clear();
								if(IMPL!=null)
								{
									IMPL.refresh("", "");
								}
								cmdButtons.getCmdSave().reset();
							}
						}
						@Override
						public void onFailure(Throwable arg0) {
							// TODO Auto-generated method stub
							Window.alert(arg0.getMessage());
							cmdButtons.getCmdSave().reset();
							
						}
					});
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
		
		txtName.clear();
		txtContact.clear();
		txtLocation.clear();
		textDescription.clear();
		lstArea.reset();
		lstCaseType.reset();
		lstCity.reset();
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
		loadCaseType();
		loadCity();
	}
	public void loadCaseType()
	{
		lstCaseType.clear();
		lstCaseType.addBlankHere();
		V_Cases_Types_Wrapper meta = new V_Cases_Types_Wrapper();
		meta.setQuery("from V_Cases_Types");
		V_Cases_Types_Connection.getRpcConnection().getListData(meta, new AsyncCallback<V_Cases_Types_Wrapper>()
		{
			@Override
			public void onSuccess(V_Cases_Types_Wrapper arg0) 
			{
				if(arg0!=null)
				{
					List<V_Cases_Types> lst = arg0.getListV_Cases_Types();
					for(V_Cases_Types vc : lst)
					{
						String id = vc.getId().toString();
						lstCaseType.addItem(vc.getCst_name_la(), id);
					}
				}
			}
			
			@Override
			public void onFailure(Throwable arg0) 
			{
				
			}
		});
	}
	
	public void loadCity()
	{
		lstCity.clear();
		lstCity.addBlankHere();
		V_Luk_City_Wrapper meta = new V_Luk_City_Wrapper();
		meta.setQuery("from V_Luk_City");
		V_Luk_City_Connection.getRpcConnection().getListData(meta, new AsyncCallback<V_Luk_City_Wrapper>()
		{
			@Override
			public void onSuccess(V_Luk_City_Wrapper arg0) 
			{
				if(arg0!=null)
				{
					List<V_Luk_City> lst = arg0.getListV_Luk_City();
					for(V_Luk_City vc : lst)
					{
						String id = vc.getId().toString();
						lstCity.addItem(vc.getLct_name_la(), id);
					}
				}
			}
			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public void loadArea()
	{
		lstArea.clear();
		lstArea.addBlankHere();
		V_Luk_Area_Wrapper meta = new V_Luk_Area_Wrapper();
		meta.setQuery("from V_Luk_Area where lar_city_id="+lstCity.getComboValueInteger());
		V_Luk_Area_Connection.getRpcConnection().getListData(meta, new AsyncCallback<V_Luk_Area_Wrapper>()
		{
			@Override
			public void onSuccess(V_Luk_Area_Wrapper arg0) 
			{
				if(arg0!=null)
				{
					List<V_Luk_Area> lst = arg0.getListV_Luk_Area();
					for(V_Luk_Area vc : lst)
					{
						String id = vc.getId().toString();
						lstArea.addItem(vc.getLar_area_name_la(), id);
					}
				}
			}
			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public Cases_Request getCases_Request()
	{
		Cases_Request cr = new Cases_Request();
		cr.setCr_area_id(lstArea.getComboValueLong());
		cr.setCr_city_id(lstCity.getComboValueLong());
		cr.setCr_desc(textDescription.getText());
		cr.setCr_inf_contact(txtContact.getText());
		cr.setCr_inf_name(txtName.getText());
		cr.setCr_location(txtLocation.getText());
		cr.setCr_status(1);
		cr.setCr_type(lstCaseType.getComboValueInteger());
		
		return cr;
	}
	public void registerRefresh(MyRefresh_Impl impl)
	{
		IMPL = impl;
	}
}
