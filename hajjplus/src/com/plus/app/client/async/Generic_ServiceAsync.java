package com.plus.app.client.async;

import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.plus.app.shared.dao.Generic_Wrapper;

/**
 * The client side stub for the RPC service.
 */
public interface Generic_ServiceAsync
{
	public void	getSqlData(Generic_Wrapper meta, AsyncCallback<Generic_Wrapper> callback);
	public void updateQuery(Generic_Wrapper meta, AsyncCallback<String> callback);
	public void updateListQuery(Generic_Wrapper meta, AsyncCallback<String> callback);
	public void getNoOfRecords(Generic_Wrapper meta, AsyncCallback<String> callback);
	public void callProcedure(Generic_Wrapper meta, AsyncCallback<String> callback);
	public void sqlQuery(String query, AsyncCallback<List<HashMap<String,String>>> callback);
	public void getAlertMessage(String userId, AsyncCallback<String> callback);
	public void setAlertMessage(String userId,String msg, AsyncCallback<Void> callback);
	public void getAge(String date, AsyncCallback<String> callback);
	public void uploadFile(String uoCode, AsyncCallback<Void> callback);
	public void updateRecord(Generic_Wrapper meta, AsyncCallback<String> callback);
	public void updateListRecord(Generic_Wrapper meta, AsyncCallback<String> callback);
	public void executeFunction(Generic_Wrapper meta, AsyncCallback<String> callback);
	public void getCheckOutDate(String inDate,int days,AsyncCallback<String> callback);
	public void getDuration(String firstDate,String secondDt,AsyncCallback<String> callback);
	public void session(String param,AsyncCallback<String> callback);
	public void getSequence(Generic_Wrapper meta, AsyncCallback<String> callback);
	public void email(Generic_Wrapper meta, AsyncCallback<String> callback);
	public void resetIdentities_LoginBy(AsyncCallback<String> callback);
}
