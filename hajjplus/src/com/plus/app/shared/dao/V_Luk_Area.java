package com.plus.app.shared.dao;
import java.util.Date;
import java.io.Serializable;

public class V_Luk_Area implements Serializable 
{
	public V_Luk_Area(){}
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
	

	private String lar_area_name_ar;
	public String getLar_area_name_ar()
	{
		 return lar_area_name_ar;
	}
	public void setLar_area_name_ar(String lar_area_name_ar)
	{
		 this.lar_area_name_ar=lar_area_name_ar;
	}
	

	private String lar_area_name_la;
	public String getLar_area_name_la()
	{
		 return lar_area_name_la;
	}
	public void setLar_area_name_la(String lar_area_name_la)
	{
		 this.lar_area_name_la=lar_area_name_la;
	}
	

	private Long lar_city_id;
	public Long getLar_city_id()
	{
		 return lar_city_id;
	}
	public void setLar_city_id(Long lar_city_id)
	{
		 this.lar_city_id=lar_city_id;
	}
	

	private Integer lar_status;
	public Integer getLar_status()
	{
		 return lar_status;
	}
	public void setLar_status(Integer lar_status)
	{
		 this.lar_status=lar_status;
	}
	

	private String lar_res_name;
	public String getLar_res_name()
	{
		 return lar_res_name;
	}
	public void setLar_res_name(String lar_res_name)
	{
		 this.lar_res_name=lar_res_name;
	}
	

	private String lar_res_phone;
	public String getLar_res_phone()
	{
		 return lar_res_phone;
	}
	public void setLar_res_phone(String lar_res_phone)
	{
		 this.lar_res_phone=lar_res_phone;
	}
	

	private String lar_res_mobile;
	public String getLar_res_mobile()
	{
		 return lar_res_mobile;
	}
	public void setLar_res_mobile(String lar_res_mobile)
	{
		 this.lar_res_mobile=lar_res_mobile;
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
	

	public V_Luk_Area(Long id,String lar_area_name_ar,String lar_area_name_la,Long lar_city_id,Integer lar_status,String lar_res_name,String lar_res_phone,String lar_res_mobile,Date udate)
	{
		this. id =  id;
		this. lar_area_name_ar =  lar_area_name_ar;
		this. lar_area_name_la =  lar_area_name_la;
		this. lar_city_id =  lar_city_id;
		this. lar_status =  lar_status;
		this. lar_res_name =  lar_res_name;
		this. lar_res_phone =  lar_res_phone;
		this. lar_res_mobile =  lar_res_mobile;
		this. udate =  udate;
	}
}
