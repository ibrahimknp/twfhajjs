package com.plus.app.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class MyExceptions extends Exception implements IsSerializable {
	
	final static long serialVersionUID=1L;
	
	public static MyExceptions instance=new MyExceptions();
	
	public MyExceptions()
	{
		super();
	}
	
	public MyExceptions(String str) {
		// TODO Auto-generated constructor stub
		super(str);
	}
	
	public static MyExceptions getInstance()
	{
		return instance;
	}
	
	
	
	private String message;
	
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message=message;
	}
	
}
