package com.plus.app.client.impl;

import com.plus.app.client.SessionBean;



public interface PopupMain {
	
	int SAVE  = 1;
	int EDIT = 2;
	int DELETE = 3;
	int BRWOSE = 4;
	/**
	 *   this method is used to load the Data when page initialized or page refreshed
	 */
	public void load();
	
	
	/**
	 *  use this method to clear the text inputs.
	 */
	public void clear();
	
	/**
	 *  use this method to set the privilage.
	 *  buttonPanel.setPrviliage(prevs);
	 */
	public void setPrevs(String menuId);
	
	
	
	/**
	 * 
	 * @return method will SessionBean Object i.e. return SessionBean.getSession();
	 */
	public SessionBean getSession();
	

	public void destroy();
	
	public void show();
	
}
