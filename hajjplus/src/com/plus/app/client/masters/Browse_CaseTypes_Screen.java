package com.plus.app.client.masters;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.plus.app.client.PopupAction;
import com.plus.app.client.SessionBean;
import com.plus.app.client.RPCConnection.V_Cases_Types_Connection;
import com.plus.app.client.impl.Main;
import com.plus.app.client.impl.MyRefresh_Impl;
import com.plus.app.client.util.MyDataTable;
import com.plus.app.client.util.MyFramePanel;
import com.plus.app.client.util.MyVerticalPanel;
import com.plus.app.shared.dao.V_Cases_Types;
import com.plus.app.shared.wrapper.V_Cases_Types_Wrapper;

public class Browse_CaseTypes_Screen extends Composite implements Main{
	private MyVerticalPanel 	vMain;
	private MyDataTable 		grid;
	
	
	private static Browse_CaseTypes_Screen	instance;
	public static Browse_CaseTypes_Screen getInstance()
	{
		if(instance == null )
		{
			instance = new Browse_CaseTypes_Screen();
		}
		return instance;
	}
	
	public Browse_CaseTypes_Screen() {
		// TODO Auto-generated constructor stub
		
		CaseTypes_Master_Screen.getInstance().init();
		MyFramePanel frame = new MyFramePanel("List of Case Types","Browse_CaseTypes_Screen");
		vMain = new MyVerticalPanel();
		vMain.setBorder();
		vMain.setWidth("100%");
		frame.addCreateLink("Add Case Types",vMain.getWidth());
		
		
		grid = new MyDataTable(21, 4);
		grid.setHeader(new String[]{"","Code","Type Name La","Type Name Ar"});
		
		
		vMain.addWidgetTop(grid);
		
		frame.addWidgetTop(vMain);
		initWidget(frame);
		
		
		frame.getHyper().addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent arg0) 
			{
				CaseTypes_Master_Screen co = CaseTypes_Master_Screen.getInstance();
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
		V_Cases_Types_Wrapper meta = new V_Cases_Types_Wrapper();
		meta.setQuery("from V_Cases_Types where 1=1 ");
		V_Cases_Types_Connection.getRpcConnection().getListData(meta, new AsyncCallback<V_Cases_Types_Wrapper>()
		{
			
			@Override
			public void onSuccess(V_Cases_Types_Wrapper arg0) 
			{
				if(arg0!=null)
				{
					int row = 1;
					List<V_Cases_Types> lst = arg0.getListV_Cases_Types();
					//System.out.println(lst);
					grid.resizeRows(lst.size()+1);
					for(V_Cases_Types vc : lst)
					{
						String id = vc.getId().toString();
						Object obj[] = new Object[]{id,id,vc.getCst_name_la(),vc.getCst_name_ar()
								};
						
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
