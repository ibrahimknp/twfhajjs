package com.plus.app.shared.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Generic_Wrapper implements Serializable{

	public static String INT_TRIP = "INT_TRIP";
	
	private static final long	serialVersionUID	= -8480133366196663439L;
	private List<String>			   lst;
	private String		   			   query;
	private String					   id;
	private String 					   str;
	private String					   procedure;
	private List<String>			   params; 
	private HashMap<String,String>	   hash;
	
	public Generic_Wrapper()
	{
		//if(SessionBean.getSession().getUserPrevs()!=null)
			//this.userId = SessionBean.getSession().getUserPrevs().getLogin_historyId();
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
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	
	public HashMap<String,String> getHash() {
		return hash;
	}

	public void setHash(HashMap<String,String> hash) {
		this.hash = hash;
	}
 
	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}
 
	public List<String> getLst() {
		return lst;
	}

	public void setLst(List<String> lst) {
		this.lst = lst;
	}
	
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	private String inDate;
	private String outDate;
	private String inOutDate;

	public String getInOutDate() {
		return inOutDate;
	}

	public void setInOutDate(String inOutDate) {
		this.inOutDate = inOutDate;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	 
	private String sequence;

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	
	private String code="--";
	private String emailTo;
	private String subject;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
