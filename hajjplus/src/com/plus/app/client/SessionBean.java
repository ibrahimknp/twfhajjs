package com.plus.app.client;

import java.util.Date;
import java.util.HashMap;

public class SessionBean {

	private static SessionBean instance;
	public static SessionBean getInstance()
	{
		if(instance == null)
			instance = new SessionBean();

		return instance;
	}

	private Date 	lastAccessedTimes = new Date();

	public Date getLastAccessedTime() {
		return lastAccessedTimes;
	}

	public void setLastAccessedTime(Date lastAccessedTime) {
		lastAccessedTimes = lastAccessedTime;
	}


	private HashMap hashMenuPrevs;
	public HashMap getHashMenuPrevs() {
		return hashMenuPrevs;
	}

	public void setHashMenuPrevs(HashMap hashMenuPrevs) {
		this.hashMenuPrevs = hashMenuPrevs;
	}

	private HashMap hashMenuGroupsPrevs;


	public HashMap getHashMenuGroupsPrevs() {
		return hashMenuGroupsPrevs;
	}

	public void setHashMenuGroupsPrevs(HashMap hashMenuGroupsPrevs) {
		this.hashMenuGroupsPrevs = hashMenuGroupsPrevs;
	}

	
	private String downloadPath;
	public String getDownloadPath() {
		return downloadPath;
	}

	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}
	


}
