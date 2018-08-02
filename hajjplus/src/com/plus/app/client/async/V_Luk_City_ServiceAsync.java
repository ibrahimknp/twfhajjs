package com.plus.app.client.async;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.plus.app.shared.wrapper.V_Luk_City_Wrapper;

public interface V_Luk_City_ServiceAsync {
	
	public void getListData(V_Luk_City_Wrapper meta,AsyncCallback<V_Luk_City_Wrapper> call);
	public void getTableData(V_Luk_City_Wrapper meta, AsyncCallback<V_Luk_City_Wrapper> call);
	public void save(V_Luk_City_Wrapper meta,AsyncCallback<String> call);
	public void save_return(V_Luk_City_Wrapper meta,AsyncCallback<V_Luk_City_Wrapper> call);
	public void update(V_Luk_City_Wrapper meta,AsyncCallback<String> call);
	public void update_return(V_Luk_City_Wrapper meta,AsyncCallback<V_Luk_City_Wrapper> call);
	public void deleteSave(V_Luk_City_Wrapper meta,AsyncCallback<V_Luk_City_Wrapper> call);
	
}



