package com.plus.app.client.masters;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.plus.app.client.PopupAction;
import com.plus.app.client.SessionBean;
import com.plus.app.client.RPCConnection.V_Luk_Area_Connection;
import com.plus.app.client.impl.Main;
import com.plus.app.client.impl.MyRefresh_Impl;
import com.plus.app.client.util.MyDataTable;
import com.plus.app.client.util.MyFramePanel;
import com.plus.app.client.util.MyVerticalPanel;
import com.plus.app.shared.dao.V_Luk_Area;
import com.plus.app.shared.wrapper.V_Luk_Area_Wrapper;

public class Browse_Area_Screen extends Composite implements Main{
	private MyVerticalPanel 	vMain;
	private MyDataTable 		grid;
	
	
	private static Browse_Area_Screen	instance;
	public static Browse_Area_Screen getInstance()
	{
		if(instance == null )
		{
			instance = new Browse_Area_Screen();
		}
		return instance;
	}
	
	public Browse_Area_Screen() {
		// TODO Auto-generated constructor stub
		
		Areas_Master_Screen.getInstance().init();
		MyFramePanel frame = new MyFramePanel("List of Areas","Browse_Area_Screen");
		vMain = new MyVerticalPanel();
		vMain.setBorder();
		vMain.setWidth("100%");
		frame.addCreateLink("Add Areas",vMain.getWidth());
		
		
		grid = new MyDataTable(21, 5);
		grid.setHeader(new String[]{"","Code","City Name","Area Name La","Area Name Ar"});
		
		
		vMain.addWidgetTop(grid);
		
		frame.addWidgetTop(vMain);
		initWidget(frame);
		
		
		frame.getHyper().addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent arg0) 
			{
				Areas_Master_Screen co = Areas_Master_Screen.getInstance();
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
		V_Luk_Area_Wrapper meta = new V_Luk_Area_Wrapper();
		meta.setQuery("from V_Luk_Area where 1=1 ");
		V_Luk_Area_Connection.getRpcConnection().getListData(meta, new AsyncCallback<V_Luk_Area_Wrapper>()
		{
			
			@Override
			public void onSuccess(V_Luk_Area_Wrapper arg0) 
			{
				if(arg0!=null)
				{
					int row = 1;
					List<V_Luk_Area> lst = arg0.getListV_Luk_Area();
					//System.out.println(lst);
					grid.resizeRows(lst.size()+1);
					for(V_Luk_Area vc : lst)
					{
						String id = vc.getId().toString();
						Object obj[] = new Object[]{id,id,vc.getLar_city_id(),vc.getLar_area_name_la(),vc.getLar_area_name_ar()
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
