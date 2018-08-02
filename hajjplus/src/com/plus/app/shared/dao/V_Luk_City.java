package com.plus.app.shared.dao;
import java.util.Date;
import java.io.Serializable;

public class V_Luk_City implements Serializable 
{
	public V_Luk_City(){}
	private static final long	serialVersionUID	= -8480133366196663439L;
	private Long id;
	public Long getId()
	{
		 return id;
	}
	public void setId(Long id)
	{
		 this.id=id;
	}
	

	private String lct_name_ar;
	public String getLct_name_ar()
	{
		 return lct_name_ar;
	}
	public void setLct_name_ar(String lct_name_ar)
	{
		 this.lct_name_ar=lct_name_ar;
	}
	

	private String lct_name_la;
	public String getLct_name_la()
	{
		 return lct_name_la;
	}
	public void setLct_name_la(String lct_name_la)
	{
		 this.lct_name_la=lct_name_la;
	}
	

	private Integer lct_status;
	public Integer getLct_status()
	{
		 return lct_status;
	}
	public void setLct_status(Integer lct_status)
	{
		 this.lct_status=lct_status;
	}
	

	private Date udate;
	public Date getUdate()
	{
		 return udate;
	}
	public void setUdate(Date udate)
	{
		 this.udate=udate;
	}
	

	public V_Luk_City(Long id,String lct_name_ar,String lct_name_la,Integer lct_status,Date udate)
	{
		this. id =  id;
		this. lct_name_ar =  lct_name_ar;
		this. lct_name_la =  lct_name_la;
		this. lct_status =  lct_status;
		this. udate =  udate;
	}
}
