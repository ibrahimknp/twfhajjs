package com.plus.app.client.async;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.plus.app.shared.wrapper.V_Cases_Request_Wrapper;

public interface V_Cases_Request_ServiceAsync {
	
	public void getListData(V_Cases_Request_Wrapper meta,AsyncCallback<V_Cases_Request_Wrapper> call);
	public void getTableData(V_Cases_Request_Wrapper meta, AsyncCallback<V_Cases_Request_Wrapper> call);
	public void save(V_Cases_Request_Wrapper meta,AsyncCallback<String> call);
	public void save_return(V_Cases_Request_Wrapper meta,AsyncCallback<V_Cases_Request_Wrapper> call);
	public void update(V_Cases_Request_Wrapper meta,AsyncCallback<String> call);
	public void update_return(V_Cases_Request_Wrapper meta,AsyncCallback<V_Cases_Request_Wrapper> call);
	public void deleteSave(V_Cases_Request_Wrapper meta,AsyncCallback<V_Cases_Request_Wrapper> call);
	
}



