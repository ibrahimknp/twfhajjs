package com.plus.app.shared.wrapper;

import java.io.Serializable;
import java.util.List;

import com.google.gwt.i18n.client.LocaleInfo;
import com.plus.app.shared.dao.V_Luk_Area;

public class V_Luk_Area_Wrapper implements Serializable{

	private static final long	serialVersionUID	= -8480133366196663439L;
	private List<V_Luk_Area> 			   listV_Luk_Area;
	private V_Luk_Area					   V_Luk_Area;
	private String		   			   query;
	private String		   			   return_query;	
	

	private String					   id;
	private int						   startRow=0;
	private int						   maxRow=50;
	
	public V_Luk_Area_Wrapper()
	{
		
	}
	
	public List<V_Luk_Area> getListV_Luk_Area() {
		return listV_Luk_Area;
	}

	public void setListV_Luk_Area(List<V_Luk_Area> listV_Luk_Area) {
		this.listV_Luk_Area = listV_Luk_Area;
	}

	public V_Luk_Area getV_Luk_Area() {
		return V_Luk_Area;
	}

	public void setV_Luk_Area(V_Luk_Area V_Luk_Area) {
		this.V_Luk_Area = V_Luk_Area;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getMaxRow() {
		return maxRow;
	}

	public void setMaxRow(int maxRow) {
		this.maxRow = maxRow;
	}
	
 	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getReturn_query() {
		return return_query;
	}

	public void setReturn_query(String return_query) {
		this.return_query = return_query;
	}
	
	
	private String reportName;
	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	
	private String headers[];	
	public String[] getHeaders() {
		return headers;	}
	public void setHeaders(String[] headers) {
		this.headers = headers;
	}	
	
	private boolean locale = false;
	public boolean isArabicLocale() {
		return locale;
	}
	public void setLocale()
	{
		if(LocaleInfo.getCurrentLocale().isRTL())
		this.locale = true;
		else
			this.locale = false;
	}
}



