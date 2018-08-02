package com.plus.app.client.async;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.plus.app.shared.MyExceptions;
import com.plus.app.shared.wrapper.Dummy_Wrapper;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("Dummy")
public interface Dummy_Service extends RemoteService
{
	public Dummy_Wrapper getListData(Dummy_Wrapper meta)throws MyExceptions;
	public Dummy_Wrapper getTableData(Dummy_Wrapper meta)throws MyExceptions;
	public String save(Dummy_Wrapper meta)throws MyExceptions;
	public Dummy_Wrapper save_return(Dummy_Wrapper meta)throws MyExceptions;
	public String update(Dummy_Wrapper meta)throws MyExceptions;
	public Dummy_Wrapper update_return(Dummy_Wrapper meta)throws MyExceptions;
	public Dummy_Wrapper deleteSave(Dummy_Wrapper meta)throws MyExceptions;
	
}


