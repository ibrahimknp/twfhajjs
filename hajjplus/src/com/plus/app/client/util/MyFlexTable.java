package com.plus.app.client.util;

import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Widget;

public class MyFlexTable extends Composite{
	
	FlexTable			flex;
	
	public MyFlexTable()
	{
		flex = new FlexTable();
		
		initWidget(flex);
	}
	
	public void setWidget(int row,int col,Widget w,int align)
	{
		flex.setWidget(row, col, w);
		if(align==0)
		{
			if(LocaleInfo.getCurrentLocale().isRTL())
				flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_RIGHT);
			else
				flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_LEFT);
			
		}
		else if(align==1)
		{
			flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_CENTER);
		}
		else if(align==2)
		{
			if(LocaleInfo.getCurrentLocale().isRTL())
				flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_LEFT);
			else
				flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_RIGHT);
			
		}
	}
	public void setWidget(int row,int col,String w,int align)
	{
		flex.setText(row, col, w);
		if(align==0)
		{
			if(LocaleInfo.getCurrentLocale().isRTL())
				flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_RIGHT);
			else
				flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_LEFT);
			
		}
		else if(align==1)
		{
			flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_CENTER);
		}
		else if(align==2)
		{
			if(LocaleInfo.getCurrentLocale().isRTL())
				flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_LEFT);
			else
				flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_RIGHT);
			
		}
	}
	public void setWidget(int row,int col,String w,int halign,int valign)
	{
		flex.setText(row, col, w);
		setHoriVerticalAlignment(row,col,halign,valign);
	}
	public void setWidget(int row,int col,Widget w,int halign,int valign)
	{
		flex.setWidget(row, col, w);
		setHoriVerticalAlignment(row,col,halign,valign);
	}

	public void setColumn(int row,int col,String columnName,int halign,int valign)
	{
		flex.setText(row, col, columnName);
		flex.getCellFormatter().addStyleName(row, col, "flexColumn");
		setHoriVerticalAlignment(row,col,halign,valign);
	}
	public void setColumn(int row,int col,String columnName,int halign,int valign,String style)
	{
		flex.setText(row, col, columnName);
		flex.getCellFormatter().addStyleName(row, col, style);
		setHoriVerticalAlignment(row,col,halign,valign);
	}
	public void setColumn(int row,int col,Widget wid,int halign,int valign)
	{
		flex.setWidget(row, col, wid);
		flex.getCellFormatter().addStyleName(row, col, "flexColumn");
		setHoriVerticalAlignment(row,col,halign,valign);
	}
	public void setColumnData(int row,int col,Widget columnData,int halign,int valign)
	{
		flex.setWidget(row, col, columnData);
		flex.getCellFormatter().addStyleName(row, col, "flexData");
		setHoriVerticalAlignment(row,col,halign,valign);
	}
	public void setColumnData(int row,int col,Widget columnData,int halign,int valign,String style)
	{
		flex.setWidget(row, col, columnData);
		flex.getCellFormatter().addStyleName(row, col, style);
		setHoriVerticalAlignment(row,col,halign,valign);
	}
	public void setColumnDataString(int row,int col,String columnData,int halign,int valign)
	{
		flex.setText(row, col, columnData);
		flex.getCellFormatter().addStyleName(row, col, "flexData");
		setHoriVerticalAlignment(row,col,halign,valign);
	}
	
	public void setSize(int width,int height)
	{
		flex.setSize(width+"px", height+"px");
	}
	
	public void setWidth(int width)
	{
		flex.setWidth(width+"px");
	}
	
	public void setColumnWidth(int column,int width)
	{
		flex.getFlexCellFormatter().setWidth(0, column, width+"px");
	}
	
	public void setColspan(int row,int startCol,int noOfCol)
	{
		flex.getFlexCellFormatter().setColSpan(row, startCol, noOfCol);
	}
	
	public void setCellPadding(int padding)
	{
		flex.setCellPadding(padding);
	}
	public void setCellSpacing(int spacing)
	{
		flex.setCellSpacing(spacing);
	}
	
	public void setHoriVerticalAlignment(int row, int col,int halign,int valign)
	{
		if(halign==0)
		{
			if(LocaleInfo.getCurrentLocale().isRTL())
				flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_RIGHT);
			else
				flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_LEFT);
			
		}
		else if(halign==1)
		{
			flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_CENTER);
		}
		else if(halign==2)
		{
			if(LocaleInfo.getCurrentLocale().isRTL())
				flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_LEFT);
			else
				flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_RIGHT);			
		}
		
		if(valign==0)
		{
			flex.getCellFormatter().setVerticalAlignment(row, col, HasVerticalAlignment.ALIGN_TOP);
		}
		else if(valign==1)
		{
			flex.getCellFormatter().setVerticalAlignment(row, col, HasVerticalAlignment.ALIGN_MIDDLE);
		}
		if(valign==2)
		{
			flex.getCellFormatter().setVerticalAlignment(row, col, HasVerticalAlignment.ALIGN_BOTTOM);
		}
	}
	
	public void clear()
	{
		flex.removeAllRows();		
	}
	public void setBorder(int width)
	{
		flex.setBorderWidth(width);
	}
	
	 public void setWidgetsColLable(int row,int col,Widget w,int align )
		{
		 flex.setWidget(row, col, w);
		 flex.getCellFormatter().addStyleName(row, col, "bgResHotel");
	 	 if(align==1)
			flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_CENTER);
		else if(align==0)
			flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_LEFT);
		else if(align==2)
			flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_RIGHT);
		}
	 
	 public void setWidgetsColLable(int row,int col,Widget w,int align ,String style)
	{
		 flex.setWidget(row, col, w);
		 flex.getCellFormatter().addStyleName(row, col, style);
	 	 if(align==1)
			flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_CENTER);
		else if(align==0)
			flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_LEFT);
		else if(align==2)
			flex.getCellFormatter().setHorizontalAlignment(row, col, HasHorizontalAlignment.ALIGN_RIGHT);
		}
	 
	 
	 
	 
	 
	 
	 
	 
	
}
