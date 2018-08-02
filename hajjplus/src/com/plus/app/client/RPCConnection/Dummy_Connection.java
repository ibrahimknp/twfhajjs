package com.plus.app.client.RPCConnection;

import com.google.gwt.core.client.GWT;
import com.plus.app.client.async.Dummy_Service;
import com.plus.app.client.async.Dummy_ServiceAsync;

public class Dummy_Connection{

	private static Dummy_ServiceAsync  remote;
	
	public static Dummy_ServiceAsync getRpcConnection()
	{
		if(remote ==null)
		{
			remote=GWT.create(Dummy_Service.class);
		}
		
		return remote;
	}


}
