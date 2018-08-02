package com.plus.app.client.async;

import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.plus.app.shared.MyExceptions;
import com.plus.app.shared.dao.Generic_Wrapper;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("Generic")
public interface Generic_Service extends RemoteService
{
	public Generic_Wrapper	getSqlData(Generic_Wrapper meta)throws MyExceptions;
	public String updateQuery(Generic_Wrapper meta)throws MyExceptions;
	public String updateListQuery(Generic_Wrapper meta)throws MyExceptions;
	public String getNoOfRecords(Generic_Wrapper meta)throws MyExceptions;
	public String callProcedure(Generic_Wrapper meta)throws MyExceptions;
	public List<HashMap<String,String>> sqlQuery(String query)throws MyExceptions;
	public String getAlertMessage(String userId)throws MyExceptions;
	public void setAlertMessage(String userId,String msg)throws MyExceptions;
	public String getAge(String date)throws MyExceptions;
	public void uploadFile(String uoCode)throws MyExceptions;
	public String updateRecord(Generic_Wrapper meta)throws MyExceptions;
	public String updateListRecord(Generic_Wrapper meta)throws MyExceptions;
	public String executeFunction(Generic_Wrapper meta)throws MyExceptions;
	public String getCheckOutDate(String inDate,int days)throws MyExceptions;
	public String getDuration(String firstDate,String secondDt)throws MyExceptions;
	public String session(String param)throws MyExceptions;
	public String getSequence(Generic_Wrapper meta)throws MyExceptions;
	public String email(Generic_Wrapper meta)throws MyExceptions;
	public String resetIdentities_LoginBy()throws MyExceptions;
}
