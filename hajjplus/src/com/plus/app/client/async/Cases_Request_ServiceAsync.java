package com.plus.app.client.async;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.plus.app.shared.wrapper.Cases_Request_Wrapper;

public interface Cases_Request_ServiceAsync {
	
	public void getListData(Cases_Request_Wrapper meta,AsyncCallback<Cases_Request_Wrapper> call);
	public void getTableData(Cases_Request_Wrapper meta, AsyncCallback<Cases_Request_Wrapper> call);
	public void save(Cases_Request_Wrapper meta,AsyncCallback<String> call);
	public void save_return(Cases_Request_Wrapper meta,AsyncCallback<Cases_Request_Wrapper> call);
	public void update(Cases_Request_Wrapper meta,AsyncCallback<String> call);
	public void update_return(Cases_Request_Wrapper meta,AsyncCallback<Cases_Request_Wrapper> call);
	public void deleteSave(Cases_Request_Wrapper meta,AsyncCallback<Cases_Request_Wrapper> call);
	
}



