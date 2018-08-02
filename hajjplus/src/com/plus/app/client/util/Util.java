package com.plus.app.client.util;

import java.util.Date;
import java.util.Map;

import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.plus.app.client.SessionBean;
import com.plus.app.client.lang.Languages;

public class Util {

	public static MyHTML getHTMLLabel(String htmlLabel)
	{
		MyHTML ht = new MyHTML(htmlLabel);
		return ht;
	}
	public static MyHTML getHTMLLabel(String htmlLabel,String style)
	{
		MyHTML ht = new MyHTML(htmlLabel);
		ht.addStyleName(style);
		return ht;
	}
	public static MyHTML makePagLabel(String htmlLabel)
	{
		MyHTML ht = new MyHTML(htmlLabel);
		return ht;
	}

	public static MyLabel makeTotalLabel(Object label)
	{
		MyLabel ht = new MyLabel(label.toString());
		ht.addStyleName("totalLabel");
		ht.setAlignment(2);
		return ht;
	}
	public static MyLabel makeBold(String label)
	{
		MyLabel ht = new MyLabel(label.toString());
		ht.addStyleName("f11B");
		return ht;
	}
	public static MyHTML makeBoldColor(String label)
	{
		MyHTML ht = new MyHTML(label.toString());
		ht.addStyleName("boldColor");
		return ht;
	}
	public static MyHTML makeBoldColor(String val,int direction)
	{
		MyHTML htm=new MyHTML(val);
		htm.setId(""+direction);
		htm.addStyleName("boldColor");
		return htm;
	}
	public static MyHTML makeBoldAlertColor(String val,int direction)
	{
		MyHTML htm=new MyHTML(val);
		htm.setId(""+direction);
		htm.addStyleName("boldAlertColor");
		return htm;
	}
	public static MyHTML makeBoldColor(Object val,int direction)
	{
		MyHTML htm=new MyHTML(val.toString());
		htm.setId(""+direction);
		htm.addStyleName("boldColor");
		return htm;
	}

	public static MyHTML makeWhiteLabel(String htmlLabel)
	{
		MyHTML ht = new MyHTML(htmlLabel);
		ht.addStyleName("whiteLabel");
		return ht;
	}
	public static Label getTitleLabel(String label,String title)
	{
		Label ht = new Label(label);
		ht.setTitle(title);
		ht.addStyleName("titleLabel");
		return ht;
	}

	public static int getComboIndex(String value,ListBox lst)
	{
		int a=0;
		int length=lst.getItemCount();
		for(;a<length;a++)
		{
			String val=lst.getValue(a);
			if(value!=null)
			{
				if(value.equals(val))
				break;
			}
		}
		return a;
	}
	public static Integer checkNullInt(String str)
	{
		if(str==null || str.trim().length()==0)
			return new Integer(0);
		else
			return new Integer(str);
	}
	public static Double checkNullDouble(String str)
	{
		if(str==null || str.trim().length()==0)
			return new Double(0);
		else
			return new Double(str);
	}
	public static int totalPages(int count,int noOfRows)
	{
		int pg=(int)(Math.ceil((double)count/(double)noOfRows));
		return pg;
	}

	public static String getConvertDate(Date date)
	{
		if(date!=null)
		{
			Date dt=date;
			int dd=dt.getDate();
			int mm=dt.getMonth()+1;
			int yy=dt.getYear()+1900;


			return getTimeLength(dd)+"-"+getTimeLength(mm)+"-"+yy;
		}
		else
			return "";

	}

	public static String getTimeLength(int val)
	{
		if(String.valueOf(val).length()==1)
		return "0"+val;
		else
			return ""+val;
	}
	public static MyHTML makeBackgroundLabel(String htmlLabel)
	{
		MyHTML ht = new MyHTML(htmlLabel);
		ht.setStyleName("backgroundLabel");

		return ht;
	}

	public static boolean setPrviliage(String prevs,Widget img, int pos)
	{  // System.out.println(prevs);
		boolean prev=false;
		if(prevs!=null && prevs.length()!=0)
		{
			String str[]=prevs.split("-");
			int save=Integer.parseInt(str[0]);
			int update=Integer.parseInt(str[1]);
			int delete=Integer.parseInt(str[2]);
			int browse=Integer.parseInt(str[3]);
			int prev4=Integer.parseInt(str[4]);
			int prev5=Integer.parseInt(str[5]);

			if(pos==1)
			{
				if(save == 1)
					prev=true;
				else
					prev=false;
			}
			else if(pos==2)
			{
				if(update == 1)
					prev=true;
				else
					prev=false;
			}
			else if(pos==3)
			{
				if(delete == 1)
					prev=true;
				else
					prev=false;
			}
			else if(pos==4)
			{
				if(browse == 1)
					prev=true;
				else
					prev=false;
			}
			else if(pos==5)
			{
				if(prev4 == 1)
					prev=true;
				else
					prev=false;
			}
			else if(pos==6)
			{
				if(prev5 == 1)
					prev=true;
				else
					prev=false;
			}
		}
		return prev;
	}

	public static String getPrivilege(String menuId)
	{
		if(SessionBean.getInstance().getHashMenuPrevs().containsKey(menuId))
		{
			//UserPrevs up = (UserPrevs)SessionBean.getInstance().getHashMenuPrevs().get(menuId);
			//String prevs = up.getP_prev_1()+"-"+up.getP_prev_2()+"-"+up.getP_prev_3()+"-"+up.getP_prev_4()+"-"+up.getP_prev_5()+"-"+up.getP_prev_6();

			//return prevs;
			return "0-0-0-0-0-0";
		}
		return "0-0-0-0-0-0";
	}
	public static String generateQuery(Map hash)
	{
		StringBuffer buff = new StringBuffer();

		Map<String,Object> map=hash;
		for (Map.Entry<String, Object> entry : map.entrySet())
		{
		      String columnName = entry.getKey();
		      Object widget = entry.getValue();
		      if(widget instanceof MyTextBox)
		      {
		    	  MyTextBox txt=(MyTextBox)widget;
		    	  if(!(txt.getText().trim().equals("")))
		    	  {
		    		  if(txt.isDigit())
		    			  buff.append(" AND lower("+columnName+") = '"+txt.getText().toLowerCase()+"'");
		    		  else
		    		  buff.append(" AND lower("+columnName+") LIKE '%"+txt.getText().toLowerCase()+"%'");
		    	  }
		      }
		      else if(widget instanceof MyListBox)
		      {
 		    	   MyListBox txt=(MyListBox)widget;
		    	   if(!(txt.getComboValueLong().intValue()==0 || txt.getComboValueLong().intValue()==100 || txt.getComboValueLong().intValue()==101))
		    		 {
		    			  buff.append(" AND "+columnName+" = '"+txt.getComboValueLong()+"'");
		    		 }

		      }
		      else if(widget instanceof MyDateBox)
		      {
		    	  MyDateBox txt=(MyDateBox)widget;
		    	  if(!(txt.getText().trim().equals("") || txt.getText().trim().equals("dd-MM-yyyy")))
		    	  {
		    		  buff.append(" AND to_date("+columnName+",'dd-MM-yyyy') = to_date('"+txt.getText()+"','dd-MM-yyyy')");
		    	  }
		      }
		      else if(widget instanceof MyTextBoxEnAr)
		      {
		    	  MyTextBoxEnAr txt=(MyTextBoxEnAr)widget;
		    	  if(!(txt.getText().trim().equals("")))
		    	  {
		    		  buff.append(" AND (lower("+columnName+"_ar) LIKE '%"+txt.getText().toLowerCase()+"%' OR lower("+columnName+"_la) LIKE '%"+txt.getText().toLowerCase()+"%' )");
		    	  }
		      }
/*		      else if(widget instanceof MySuggestBox)
		      {
		    	  MySuggestBox txt=(MySuggestBox)widget;
		    	  if(!(txt.getText().trim().equals("")))
		    	  {
		    		  if(columnName.contains("reference"))
		    			  buff.append(" AND (lower("+columnName+") LIKE '%"+txt.getText().toLowerCase()+"%' )");
		    		  else
		    		  buff.append(" AND (lower("+columnName+"_ar) LIKE '%"+txt.getText().toLowerCase()+"%' OR lower("+columnName+"_en) LIKE '%"+txt.getText().toLowerCase()+"%' )");
		    	  }
		      }	*/
		      else if(widget instanceof Object)
		      {
		    	  if(widget!=null)
		    	  {
			    	  String str=widget.toString();
			    	  if(!(str.trim().equals("")))
			    	  {
			    		  buff.append(" AND "+columnName+" = '"+str+"'");
			    	  }

		    	  }
		      }
		      else
		      {
		    	  if(widget!=null)
		    	  {
			    	  String str=widget.toString();
			    	  if(!(str.trim().equals("")))
			    	  {
			    		  buff.append(" AND "+columnName+" = '"+str+"'");
			    	  }

		    	  }
		      }
		}
		return buff.toString();
	}

	public static String getDrCrOnly(Integer val)
	{
		if(val.intValue()<0)
		{
		 return " CR";
		}
		else
			return " DR";
	}
	public static String getDrCrOnly(Double val)
	{
		if(val.intValue()<0)
		{
		 return " CR";
		}
		else
			return " DR";
	}
	public static String checkNull(Object str)
	{
		if(str==null || str.toString().trim().length()==0)
			return "";
		else
			return str.toString();
	}
	public static Double checkNullDouble(Object str)
	{
		double val=0;
		if(str==null || str.toString().trim().length()==0)
			val=0;
		else
			val=new Double(str.toString());
		return val;
	}
	public static String getLangaugeData(Object eng,Object arab)
	{
		if(LocaleInfo.getCurrentLocale().isRTL())
		{
				return getNvl(arab, eng);
		}
		else
			return getNvl(eng, arab);
	}

	public static String getNvl(Object val1,Object val2)
	{
		if(val1==null || val1.toString().trim().length()==0)
			if(val2!=null)
			return val2.toString();
			else
				return "";
		else
		{
			if(val1!=null)
			return val1.toString();
			else
				return "";
		}
	}

	public static String checkUploadedImage(String str)
	{
		if(str!=null && str.length()!=0)
		{
			str = str.replace(".", ":");
			str = str.replace("null", "");
			String s[] = str.split(":");
			String splited = s[0]+"."+s[1].substring(0,3);

			return splited;
		}
		return "blank.jpg";
	}

	/**
	 *
	 * @param orderParam Always pass in english name(LA) in first parameter and give one space after starting the quotes then dont give blank spaces between commas ex: , " acc_name_la,acc_code"
	 * @return
	 */
	public static String orderBy(String orderParam)
	{
		try
		{
			if(orderParam.length()!=0)
			{
				String s1[] = orderParam.split(" ");
				if(LocaleInfo.getCurrentLocale().isRTL())
				return " Order by "+s1[1].replace("la", "ar");
				else
					return "Order by "+orderParam;
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}

		return orderParam;

	}
	public static Label substring(String label,int length)
	{
		Label ht = new Label(label);
		ht.setTitle(label);
		if(label.length()>length)
		{
			label = label.substring(0,length)+"..";
			ht.setText(label);
		}

		return ht;
	}
	public static MyLabel getIdValue(Object ID,String NAME)
	{
		MyLabel city = new MyLabel("");
		if(NAME!=null)
		{
		  String name = NAME;
		  city.setText(name);
		}
		if(ID!=null)
		{
		String id = ID.toString();
		city.setId(id);
		}
		return city;
	}
	public static String getSubString(String str,int length)
	{
		if(str.length()>length)
		 	 str=str.substring(0,length)+"..";

		return str;
	}
	public static Long checkNullLong(Object str)
	{
		if(str==null)
			return new Long(0);
		else
			return new Long(str.toString());
	}
	public static String splitPrice(String str,int index)
	{
		if(str.indexOf(" : ")!=-1)
		{
			String val[]=str.split(" : ");
			return val[index].toString();
		}
		return null;
	}
	public static String split(String str,int index)
	{
		try {
			if(str.indexOf(":")!=-1)
			{
				String val[]=str.split(":");
				return val[index].toString();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "";
	}
	public static MyHTML makeLabelWithHeight(Integer height)
	{
		MyHTML ht = new MyHTML("");
		ht.setHeight(""+height+"px");
		return ht;
	}
	public static MyHTML makeLabelWithWidth(Integer width)
	{
		MyHTML ht = new MyHTML("");
		ht.setWidth(""+width+"px");
		return ht;
	}
	public static String getCityName(Integer val)
	{
		String str="";
		if(val==null)
			str="";
		else if(val==602)
			str="Jeddah";
		else if(val==603)
			str="Makkah";
		else if(val==605)
			str="Madina";
		else if(val==606)
			str="Madina Airport";

		return str;
	}
	public static Date getDateObject(String str)
	{

		Date dt=new java.util.Date();

		if(str!=null)
		{

			int dd=Integer.parseInt(str.substring(0,2));
			int mm=Integer.parseInt(str.substring(3,5))-1;
			int yy=Integer.parseInt(str.substring(6,10))-1900;
		 	dt.setDate(dd);
			dt.setMonth(mm);
			dt.setYear(yy);

			//dt.setTime(dt.UTC(txtYYYY.getIntegerText()-1900, txtMM.getIntegerText()-1, txtDD.getIntegerText(), 0, 0, 0));
			return dt;
		}
		return dt;
	}
	 public static String getCompareDateString(String startDt, String endDt,String columnName)
	  {
		  String date="";
			if(endDt !=null && startDt!=null && endDt.trim().length()>0 && startDt.trim().length() >0)
			{
				// date=" AND to_date("+columnName+",'dd/MM/rrrr') <=to_date('"+endDt+"','dd/MM/rrrr') AND to_date("+columnName+",'dd/MM/rrrr') >=to_date('"+startDt+"','dd/MM/rrrr') ";
				date=" AND to_date("+columnName+",'dd/MM/rrrr') between to_date('"+startDt+"','dd/MM/rrrr') AND to_date('"+endDt+"','dd/MM/rrrr') ";
		 	}
		 	else if(endDt!=null && endDt.trim().length() > 0)
		 		date=" AND to_date("+columnName+",'dd/MM/rrrr') <= to_date('"+endDt+"','dd/MM/rrrr') ";
		    else if(startDt!=null && startDt.trim().length() >0)
		    	date=" AND to_date("+columnName+",'dd/MM/rrrr') >= to_date('"+startDt+"','dd/MM/rrrr') ";

		return date;
	  }

	  public static String getDateString(String strDt,String columnName)
	  {
		  String date="";
			if(strDt!=null && strDt.trim().length()>0)
		    	date=" AND to_date("+columnName+",'dd/MM/rrrr') = to_date('"+strDt+"','dd/MM/rrrr') ";

		return date;
	  }
	  public static Widget getDiv(String style)
	  {
		 MyLabel lbl = new MyLabel(" ");
		 lbl.addStyleName(style);
		 return lbl;
	  }
	 public static HTML makeHtmlTitle(String val,String title)
	{
			HTML htm=new HTML(val);
			htm.setTitle(Languages.constants.description()+" : "+title);
			htm.addStyleName("htmlTitleTip");
			return htm;

	}
	public static String getPrintStyle()
	{
	  String css="<link rel='stylesheet' type='text/css' href='/themes/oam36.css'>";

	  return css;
	}
	public static String getFormatTime(String str)
	{
		String st[]=str.split(":");

		return st[0]+st[1];
	}
	public static String substrings(String label,int length)
	{
		if(label.length()>length)
		{
			label = label.substring(0,length)+"..";
		}

		return label;
	}
	public static String getMenuString(String text, ImageResource image)
	{
	    // Add the image and text to a horizontal panel
	    HorizontalPanel hPanel = new HorizontalPanel();
	    hPanel.setSpacing(0);
	    hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	    hPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
	    Image img = new Image(image);
	    hPanel.add(img);
	    HTML headerText = new HTML(text);
	    headerText.setStyleName("cw-MenuProp");
	    hPanel.add(headerText);
	    hPanel.setCellWidth(img, "20px");
	    hPanel.setCellHorizontalAlignment(headerText, HasHorizontalAlignment.ALIGN_LEFT);

	    // Return the HTML string for the panel
	    return hPanel.getElement().getString();
	 }
	public static MyLabel makeLabel(String val)
	{
		MyLabel lbl=new MyLabel(val);
		return lbl;
	}
	public static Label makeBlankWithHeight(String height)
	{
		Label lbl=new Label();
		lbl.setHeight(height);
		return lbl;
	}
}
