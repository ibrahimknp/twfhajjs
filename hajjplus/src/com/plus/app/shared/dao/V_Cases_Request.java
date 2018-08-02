package com.plus.app.shared.dao;
import java.util.Date;
import java.io.Serializable;

public class V_Cases_Request implements Serializable 
{
	public V_Cases_Request(){}
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
	

	private Integer cr_type;
	public Integer getCr_type()
	{
		 return cr_type;
	}
	public void setCr_type(Integer cr_type)
	{
		 this.cr_type=cr_type;
	}
	

	private Long cr_city_id;
	public Long getCr_city_id()
	{
		 return cr_city_id;
	}
	public void setCr_city_id(Long cr_city_id)
	{
		 this.cr_city_id=cr_city_id;
	}
	

	private String cr_city_name_ar;
	public String getCr_city_name_ar()
	{
		 return cr_city_name_ar;
	}
	public void setCr_city_name_ar(String cr_city_name_ar)
	{
		 this.cr_city_name_ar=cr_city_name_ar;
	}
	

	private String cr_city_name_la;
	public String getCr_city_name_la()
	{
		 return cr_city_name_la;
	}
	public void setCr_city_name_la(String cr_city_name_la)
	{
		 this.cr_city_name_la=cr_city_name_la;
	}
	

	private Long cr_area_id;
	public Long getCr_area_id()
	{
		 return cr_area_id;
	}
	public void setCr_area_id(Long cr_area_id)
	{
		 this.cr_area_id=cr_area_id;
	}
	

	private String cr_area_name_ar;
	public String getCr_area_name_ar()
	{
		 return cr_area_name_ar;
	}
	public void setCr_area_name_ar(String cr_area_name_ar)
	{
		 this.cr_area_name_ar=cr_area_name_ar;
	}
	

	private String cr_area_name_la;
	public String getCr_area_name_la()
	{
		 return cr_area_name_la;
	}
	public void setCr_area_name_la(String cr_area_name_la)
	{
		 this.cr_area_name_la=cr_area_name_la;
	}
	

	private String cr_location;
	public String getCr_location()
	{
		 return cr_location;
	}
	public void setCr_location(String cr_location)
	{
		 this.cr_location=cr_location;
	}
	

	private String cr_c;
	public String getCr_c()
	{
		 return cr_c;
	}
	public void setCr_c(String cr_c)
	{
		 this.cr_c=cr_c;
	}
	

	private String cr_desc;
	public String getCr_desc()
	{
		 return cr_desc;
	}
	public void setCr_desc(String cr_desc)
	{
		 this.cr_desc=cr_desc;
	}
	

	private String cr_in_id;
	public String getCr_in_id()
	{
		 return cr_in_id;
	}
	public void setCr_in_id(String cr_in_id)
	{
		 this.cr_in_id=cr_in_id;
	}
	

	private String cr_inf_name;
	public String getCr_inf_name()
	{
		 return cr_inf_name;
	}
	public void setCr_inf_name(String cr_inf_name)
	{
		 this.cr_inf_name=cr_inf_name;
	}
	

	private String cr_inf_contact;
	public String getCr_inf_contact()
	{
		 return cr_inf_contact;
	}
	public void setCr_inf_contact(String cr_inf_contact)
	{
		 this.cr_inf_contact=cr_inf_contact;
	}
	

	private Date cr_date_reg;
	public Date getCr_date_reg()
	{
		 return cr_date_reg;
	}
	public void setCr_date_reg(Date cr_date_reg)
	{
		 this.cr_date_reg=cr_date_reg;
	}
	

	private Integer cr_status;
	public Integer getCr_status()
	{
		 return cr_status;
	}
	public void setCr_status(Integer cr_status)
	{
		 this.cr_status=cr_status;
	}
	

	private String cr_status_ar;
	public String getCr_status_ar()
	{
		 return cr_status_ar;
	}
	public void setCr_status_ar(String cr_status_ar)
	{
		 this.cr_status_ar=cr_status_ar;
	}
	

	private String cr_status_la;
	public String getCr_status_la()
	{
		 return cr_status_la;
	}
	public void setCr_status_la(String cr_status_la)
	{
		 this.cr_status_la=cr_status_la;
	}
	

	private String cr_team;
	public String getCr_team()
	{
		 return cr_team;
	}
	public void setCr_team(String cr_team)
	{
		 this.cr_team=cr_team;
	}
	

	private String cr_reply;
	public String getCr_reply()
	{
		 return cr_reply;
	}
	public void setCr_reply(String cr_reply)
	{
		 this.cr_reply=cr_reply;
	}
	

	private Date cr_udate;
	public Date getCr_udate()
	{
		 return cr_udate;
	}
	public void setCr_udate(Date cr_udate)
	{
		 this.cr_udate=cr_udate;
	}
	

	private String cr_medcr_id;
	public String getCr_medcr_id()
	{
		 return cr_medcr_id;
	}
	public void setCr_medcr_id(String cr_medcr_id)
	{
		 this.cr_medcr_id=cr_medcr_id;
	}
	

	private String cr_medcr_name_ar;
	public String getCr_medcr_name_ar()
	{
		 return cr_medcr_name_ar;
	}
	public void setCr_medcr_name_ar(String cr_medcr_name_ar)
	{
		 this.cr_medcr_name_ar=cr_medcr_name_ar;
	}
	

	private String cr_medcr_name_la;
	public String getCr_medcr_name_la()
	{
		 return cr_medcr_name_la;
	}
	public void setCr_medcr_name_la(String cr_medcr_name_la)
	{
		 this.cr_medcr_name_la=cr_medcr_name_la;
	}
	

	private String cr_team_id;
	public String getCr_team_id()
	{
		 return cr_team_id;
	}
	public void setCr_team_id(String cr_team_id)
	{
		 this.cr_team_id=cr_team_id;
	}
	

	private String cr_team_name;
	public String getCr_team_name()
	{
		 return cr_team_name;
	}
	public void setCr_team_name(String cr_team_name)
	{
		 this.cr_team_name=cr_team_name;
	}
	

	private String cr_date_status;
	public String getCr_date_status()
	{
		 return cr_date_status;
	}
	public void setCr_date_status(String cr_date_status)
	{
		 this.cr_date_status=cr_date_status;
	}
	

	public V_Cases_Request(Long id,Integer cr_type,Long cr_city_id,String cr_city_name_ar,String cr_city_name_la,Long cr_area_id,String cr_area_name_ar,String cr_area_name_la,String cr_location,String cr_c,String cr_desc,String cr_in_id,String cr_inf_name,String cr_inf_contact,Date cr_date_reg,Integer cr_status,String cr_status_ar,String cr_status_la,String cr_team,String cr_reply,Date cr_udate,String cr_medcr_id,String cr_medcr_name_ar,String cr_medcr_name_la,String cr_team_id,String cr_team_name,String cr_date_status)
	{
		this. id =  id;
		this. cr_type =  cr_type;
		this. cr_city_id =  cr_city_id;
		this. cr_city_name_ar =  cr_city_name_ar;
		this. cr_city_name_la =  cr_city_name_la;
		this. cr_area_id =  cr_area_id;
		this. cr_area_name_ar =  cr_area_name_ar;
		this. cr_area_name_la =  cr_area_name_la;
		this. cr_location =  cr_location;
		this. cr_c =  cr_c;
		this. cr_desc =  cr_desc;
		this. cr_in_id =  cr_in_id;
		this. cr_inf_name =  cr_inf_name;
		this. cr_inf_contact =  cr_inf_contact;
		this. cr_date_reg =  cr_date_reg;
		this. cr_status =  cr_status;
		this. cr_status_ar =  cr_status_ar;
		this. cr_status_la =  cr_status_la;
		this. cr_team =  cr_team;
		this. cr_reply =  cr_reply;
		this. cr_udate =  cr_udate;
		this. cr_medcr_id =  cr_medcr_id;
		this. cr_medcr_name_ar =  cr_medcr_name_ar;
		this. cr_medcr_name_la =  cr_medcr_name_la;
		this. cr_team_id =  cr_team_id;
		this. cr_team_name =  cr_team_name;
		this. cr_date_status =  cr_date_status;
	}
}
