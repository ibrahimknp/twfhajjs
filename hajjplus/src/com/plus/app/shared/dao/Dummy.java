package com.plus.app.shared.dao;
import java.io.Serializable;
import java.util.Date;

public class Dummy implements Serializable 
{
	private static final long	serialVersionUID	= -8480133366196663439L;
	private Integer id;
	
	public Dummy(){}
	
	public Integer getId()
	{
		 return id;
	}
	public void setId(Integer id)
	{
		 this.id=id;
	}
	

	private String name;
	public String getName()
	{
		 return name;
	}
	public void setName(String name)
	{
		 this.name=name;
	}
	

	private String city;
	public String getCity()
	{
		 return city;
	}
	public void setCity(String city)
	{
		 this.city=city;
	}
	

	private Date edate;
	public Date getEdate()
	{
		 return edate;
	}
	public void setEdate(Date edate)
	{
		 this.edate=edate;
	}
	

	public Dummy(Integer id,String name,String city,Date edate)
	{
		this. id =  id;
		this. name =  name;
		this. city =  city;
		this. edate =  edate;
	}
}
