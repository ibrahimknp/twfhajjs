package com.plus.app.client.RPCConnection;

import com.google.gwt.core.client.GWT;
import com.plus.app.client.async.V_Luk_City_Service;
import com.plus.app.client.async.V_Luk_City_ServiceAsync;

public class V_Luk_City_Connection{

	private static V_Luk_City_ServiceAsync  remote;
	
	public static V_Luk_City_ServiceAsync getRpcConnection()
	{
		if(remote ==null)
		{
			remote=GWT.create(V_Luk_City_Service.class);
		}
		
		return remote;
	}


}

