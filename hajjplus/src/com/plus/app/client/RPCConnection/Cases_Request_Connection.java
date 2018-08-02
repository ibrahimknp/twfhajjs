package com.plus.app.client.RPCConnection;

import com.google.gwt.core.client.GWT;
import com.plus.app.client.async.Cases_Request_Service;
import com.plus.app.client.async.Cases_Request_ServiceAsync;

public class Cases_Request_Connection{

	private static Cases_Request_ServiceAsync  remote;
	
	public static Cases_Request_ServiceAsync getRpcConnection()
	{
		if(remote ==null)
		{
			remote=GWT.create(Cases_Request_Service.class);
		}
		
		return remote;
	}


}

