package com.plus.app.client.impl;

public interface MyPagination_Impl {
	
	public void resizeRows(int noOfRows);
	/**
	 * 
	 * @param startRow	starting row
	 * @param maxRow	maximum record
	 * @param query		query
	 */
	public void load(int startRow,final Integer maxRow,String query);

}
