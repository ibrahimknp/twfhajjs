package com.plus.app.client.RPCConnection;

import com.google.gwt.core.client.GWT;
import com.plus.app.client.async.V_Luk_Area_Service;
import com.plus.app.client.async.V_Luk_Area_ServiceAsync;

public class V_Luk_Area_Connection{

	private static V_Luk_Area_ServiceAsync  remote;
	
	public static V_Luk_Area_ServiceAsync getRpcConnection()
	{
		if(remote ==null)
		{
			remote=GWT.create(V_Luk_Area_Service.class);
		}
		
		return remote;
	}


}

