package com.plus.app.shared.dao;
import java.util.Date;
import java.io.Serializable;

public class V_Cases_Types implements Serializable 
{
	public V_Cases_Types(){}
	private static final long	serialVersionUID	= -8480133366196663439L;
	private Integer id;
	public Integer getId()
	{
		 return id;
	}
	public void setId(Integer id)
	{
		 this.id=id;
	}
	

	private String cst_name_ar;
	public String getCst_name_ar()
	{
		 return cst_name_ar;
	}
	public void setCst_name_ar(String cst_name_ar)
	{
		 this.cst_name_ar=cst_name_ar;
	}
	

	private String cst_name_la;
	public String getCst_name_la()
	{
		 return cst_name_la;
	}
	public void setCst_name_la(String cst_name_la)
	{
		 this.cst_name_la=cst_name_la;
	}
	

	private Integer cst_status;
	public Integer getCst_status()
	{
		 return cst_status;
	}
	public void setCst_status(Integer cst_status)
	{
		 this.cst_status=cst_status;
	}
	

	public V_Cases_Types(Integer id,String cst_name_ar,String cst_name_la,Integer cst_status)
	{
		this. id =  id;
		this. cst_name_ar =  cst_name_ar;
		this. cst_name_la =  cst_name_la;
		this. cst_status =  cst_status;
	}
}
