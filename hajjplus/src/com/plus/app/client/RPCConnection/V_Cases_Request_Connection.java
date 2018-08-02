package com.plus.app.client.RPCConnection;

import com.google.gwt.core.client.GWT;
import com.plus.app.client.async.V_Cases_Request_Service;
import com.plus.app.client.async.V_Cases_Request_ServiceAsync;

public class V_Cases_Request_Connection{

	private static V_Cases_Request_ServiceAsync  remote;
	
	public static V_Cases_Request_ServiceAsync getRpcConnection()
	{
		if(remote ==null)
		{
			remote=GWT.create(V_Cases_Request_Service.class);
		}
		
		return remote;
	}


}

