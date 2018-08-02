package com.plus.app.client.operations;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.plus.app.client.PopupAction;
import com.plus.app.client.SessionBean;
import com.plus.app.client.RPCConnection.V_Cases_Request_Connection;
import com.plus.app.client.impl.Main;
import com.plus.app.client.impl.MyRefresh_Impl;
import com.plus.app.client.util.MyDataTable;
import com.plus.app.client.util.MyFramePanel;
import com.plus.app.client.util.MyVerticalPanel;
import com.plus.app.shared.dao.V_Cases_Request;
import com.plus.app.shared.wrapper.V_Cases_Request_Wrapper;

public class Browse_Complaints_Screen extends Composite implements Main{
	private MyVerticalPanel 	vMain;
	private MyDataTable 		grid;
	
	
	private static Browse_Complaints_Screen	instance;
	public static Browse_Complaints_Screen getInstance()
	{
		if(instance == null )
		{
			instance = new Browse_Complaints_Screen();
		}
		return instance;
	}
	
	public Browse_Complaints_Screen() {
		// TODO Auto-generated constructor stub
		Complaint_System_Screen.getInstance().init();
		
		MyFramePanel frame = new MyFramePanel("List of Complaints","Browse_Complaints_Screen");
		vMain = new MyVerticalPanel();
		vMain.setBorder();
		vMain.setWidth("100%");
		frame.addCreateLink("Add Complaints",vMain.getWidth());
		
		
		grid = new MyDataTable(21, 9);
		grid.setHeader(new String[]{"","Code","City Name","Area Name","Loocation","Description","Name","Contact","Status"});
		
		
		vMain.addWidgetTop(grid);
		
		frame.addWidgetTop(vMain);
		initWidget(frame);
		
		
		frame.getHyper().addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent arg0) 
			{
				Complaint_System_Screen co = Complaint_System_Screen.getInstance();
				co.registerRefresh(new MyRefresh_Impl() {
					
					@Override
					public void refresh(String item, String value) 
					{
						executeQuery("");
					}
				});
				PopupAction.getInstance().show(co);
							
			}
		});
		
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		executeQuery("");
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPrevs(String prevs) {
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
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
	
	
	public void executeQuery(String andQuery)
	{
		grid.resizeRows(1);
		V_Cases_Request_Wrapper meta = new V_Cases_Request_Wrapper();
		meta.setQuery("from V_Cases_Request where 1=1 ");
		V_Cases_Request_Connection.getRpcConnection().getListData(meta, new AsyncCallback<V_Cases_Request_Wrapper>()
		{
			
			@Override
			public void onSuccess(V_Cases_Request_Wrapper arg0) 
			{
				if(arg0!=null)
				{
					int row = 1;
					List<V_Cases_Request> lst = arg0.getListV_Cases_Request();
					//System.out.println(lst);
					grid.resizeRows(lst.size()+1);
					for(V_Cases_Request vc : lst)
					{
						String id = vc.getId().toString();
						Object obj[] = new Object[]{id,id,vc.getCr_city_name_la(),vc.getCr_area_name_la(),vc.getCr_location(),vc.getCr_desc(),vc.getCr_inf_name(),vc.getCr_inf_contact(),vc.getCr_status_la()};
						
						grid.setRowNumData(obj, row, true, false);
						
						row++;
					}
				}
				
			}
			
			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				Window.alert(arg0.getMessage());
			}
		});
	}
	
}
