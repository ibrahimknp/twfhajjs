package com.plus.app.client.async;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.plus.app.shared.MyExceptions;
import com.plus.app.shared.wrapper.V_Cases_Request_Wrapper;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("V_Cases_Request")
public interface V_Cases_Request_Service extends RemoteService
{
	public V_Cases_Request_Wrapper getListData(V_Cases_Request_Wrapper meta)throws MyExceptions;
	public V_Cases_Request_Wrapper getTableData(V_Cases_Request_Wrapper meta)throws MyExceptions;
	public String save(V_Cases_Request_Wrapper meta)throws MyExceptions;
	public V_Cases_Request_Wrapper save_return(V_Cases_Request_Wrapper meta)throws MyExceptions;
	public String update(V_Cases_Request_Wrapper meta)throws MyExceptions;
	public V_Cases_Request_Wrapper update_return(V_Cases_Request_Wrapper meta)throws MyExceptions;
	public V_Cases_Request_Wrapper deleteSave(V_Cases_Request_Wrapper meta)throws MyExceptions;
	
}



