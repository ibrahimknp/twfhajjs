package com.plus.app.client.RPCConnection;

import com.google.gwt.core.client.GWT;
import com.plus.app.client.async.Generic_Service;
import com.plus.app.client.async.Generic_ServiceAsync;

public class Generic_Connection{

	private static Generic_ServiceAsync  remote;
	
	public static Generic_ServiceAsync getRpcConnection()
	{
		if(remote ==null)
		{
			remote=GWT.create(Generic_Service.class);
		}
		
		return remote;
	}


}
