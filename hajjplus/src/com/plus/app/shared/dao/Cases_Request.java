package com.plus.app.shared.dao;
import java.util.Date;
import java.io.Serializable;

public class Cases_Request implements Serializable 
{
	public Cases_Request(){}
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
	

	private Long cr_city_id;
	public Long getCr_city_id()
	{
		 return cr_city_id;
	}
	public void setCr_city_id(Long cr_city_id)
	{
		 this.cr_city_id=cr_city_id;
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
	

	private String cr_location;
	public String getCr_location()
	{
		 return cr_location;
	}
	public void setCr_location(String cr_location)
	{
		 this.cr_location=cr_location;
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
	

	private Date cr_udate;
	public Date getCr_udate()
	{
		 return cr_udate;
	}
	public void setCr_udate(Date cr_udate)
	{
		 this.cr_udate=cr_udate;
	}
	

	private Integer cr_team;
	public Integer getCr_team()
	{
		 return cr_team;
	}
	public void setCr_team(Integer cr_team)
	{
		 this.cr_team=cr_team;
	}
	

	private Integer cr_user;
	public Integer getCr_user()
	{
		 return cr_user;
	}
	public void setCr_user(Integer cr_user)
	{
		 this.cr_user=cr_user;
	}
	

	public Cases_Request(Long id,Integer cr_type,String cr_desc,String cr_in_id,String cr_inf_name,String cr_inf_contact,Long cr_city_id,Long cr_area_id,String cr_location,Date cr_date_reg,Integer cr_status,Date cr_udate,Integer cr_team,Integer cr_user)
	{
		this. id =  id;
		this. cr_type =  cr_type;
		this. cr_desc =  cr_desc;
		this. cr_in_id =  cr_in_id;
		this. cr_inf_name =  cr_inf_name;
		this. cr_inf_contact =  cr_inf_contact;
		this. cr_city_id =  cr_city_id;
		this. cr_area_id =  cr_area_id;
		this. cr_location =  cr_location;
		this. cr_date_reg =  cr_date_reg;
		this. cr_status =  cr_status;
		this. cr_udate =  cr_udate;
		this. cr_team =  cr_team;
		this. cr_user =  cr_user;
	}
}
