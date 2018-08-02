package com.plus.app.client.async;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.plus.app.shared.MyExceptions;
import com.plus.app.shared.wrapper.V_Luk_City_Wrapper;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("V_Luk_City")
public interface V_Luk_City_Service extends RemoteService
{
	public V_Luk_City_Wrapper getListData(V_Luk_City_Wrapper meta)throws MyExceptions;
	public V_Luk_City_Wrapper getTableData(V_Luk_City_Wrapper meta)throws MyExceptions;
	public String save(V_Luk_City_Wrapper meta)throws MyExceptions;
	public V_Luk_City_Wrapper save_return(V_Luk_City_Wrapper meta)throws MyExceptions;
	public String update(V_Luk_City_Wrapper meta)throws MyExceptions;
	public V_Luk_City_Wrapper update_return(V_Luk_City_Wrapper meta)throws MyExceptions;
	public V_Luk_City_Wrapper deleteSave(V_Luk_City_Wrapper meta)throws MyExceptions;
	
}



