package com.plus.app.client.async;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.plus.app.shared.wrapper.Dummy_Wrapper;

public interface Dummy_ServiceAsync {
	
	public void getListData(Dummy_Wrapper meta,AsyncCallback<Dummy_Wrapper> call);
	public void getTableData(Dummy_Wrapper meta, AsyncCallback<Dummy_Wrapper> call);
	public void save(Dummy_Wrapper meta,AsyncCallback<String> call);
	public void save_return(Dummy_Wrapper meta,AsyncCallback<Dummy_Wrapper> call);
	public void update(Dummy_Wrapper meta,AsyncCallback<String> call);
	public void update_return(Dummy_Wrapper meta,AsyncCallback<Dummy_Wrapper> call);
	public void deleteSave(Dummy_Wrapper meta,AsyncCallback<Dummy_Wrapper> call);
	
}


