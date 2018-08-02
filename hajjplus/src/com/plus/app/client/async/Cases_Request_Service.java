package com.plus.app.client.async;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.plus.app.shared.MyExceptions;
import com.plus.app.shared.wrapper.Cases_Request_Wrapper;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("Cases_Request")
public interface Cases_Request_Service extends RemoteService
{
	public Cases_Request_Wrapper getListData(Cases_Request_Wrapper meta)throws MyExceptions;
	public Cases_Request_Wrapper getTableData(Cases_Request_Wrapper meta)throws MyExceptions;
	public String save(Cases_Request_Wrapper meta)throws MyExceptions;
	public Cases_Request_Wrapper save_return(Cases_Request_Wrapper meta)throws MyExceptions;
	public String update(Cases_Request_Wrapper meta)throws MyExceptions;
	public Cases_Request_Wrapper update_return(Cases_Request_Wrapper meta)throws MyExceptions;
	public Cases_Request_Wrapper deleteSave(Cases_Request_Wrapper meta)throws MyExceptions;
	
}



