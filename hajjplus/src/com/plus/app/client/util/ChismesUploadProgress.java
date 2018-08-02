package com.plus.app.client.util;


import gwtupload.client.BaseUploadStatus;
import gwtupload.client.IUploadStatus;

import com.google.code.p.gwtchismes.client.GWTCAlert;
import com.google.code.p.gwtchismes.client.GWTCProgress;
import com.google.gwt.user.client.ui.Widget;

public class ChismesUploadProgress extends BaseUploadStatus 
{      
	public int prgBarElements = 40;    
	
	public int prgBarOption = GWTCProgress.SHOW_NUMBERS | GWTCProgress.SHOW_TEXT;    
	private String prgBarText = "{0}% {1}/{2} KB. ({3} KB/s)";      
	GWTCAlert alert = new GWTCAlert();      
	boolean asDialog = false;    
	GWTCProgress prg;      
	public ChismesUploadProgress(boolean asDialog) 
	{      
		this.asDialog = asDialog;      
		prg = new GWTCProgress(asDialog ? 60 : 20, asDialog ? GWTCProgress.SHOW_AS_DIALOG | GWTCProgress.SHOW_TIME_REMAINING | prgBarOption : prgBarOption);      
		setProgressWidget(prg);      
		prg.setVisible(true);      
		setPercentMessage(prgBarText);    
	}        
	public void setHoursMessage(String message) 
	{      
		if (message != null)        
			prg.setHoursMessage(message);    
	}        
	public void setMinutesMessage (String message) 
	{      
		if (message != null)        
			prg.setMinutesMessage(message);    
	}        
	public void setSecondsMessage (String message) 
	{      
		if (message != null)        
			prg.setSecondsMessage(message);    
	}        
	public void setPercentMessage (String message) 
	{      
		if (message != null) 
		{        
			prg.setPercentMessage(message);        
			prg.setTotalMessage(message);      
		}    
	}      
	 
	@Override    
	public void setError(String error) 
	{      
		setStatus(IUploadStatus.Status.ERROR);      
		if (error != null && error.length() > 0)        
			alert.alert(error);    
	}      
	@Override    
	public void setVisible(boolean v) 
	{      
		if (asDialog) 
		{        
			if (v)          
				prg.show();        
			else          
				prg.hide();      
		} 
		else 
		{        
			super.setVisible(v);      
		}    
	}      
	  
	@Override    
	public IUploadStatus newInstance() 
	{      
		return new ChismesUploadProgress(asDialog);    
	}    
	
	
}  