package com.plus.app.client.util;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class MyDataTable extends Composite{

	private Grid			grid;
	private int 			ROW_COUNTER = 0;
	boolean 				ROW_STATUS = true;

	public MyDataTable(int rows,int columns)
	{
		grid = new Grid(rows, columns);
		grid.setCellSpacing(1);
		grid.setCellPadding(0);
		grid.setWidth("100%");
		grid.addStyleName("myDataTable");

		initWidget(grid);
	}
	public MyDataTable(int rows,int columns,int cellSpacing)
	{
		grid = new Grid(rows, columns);
		grid.setCellSpacing(cellSpacing);
		grid.setCellPadding(0);
		grid.setWidth("100%");
		grid.addStyleName("myDataTable");

		initWidget(grid);
	}
	public void setHeader(String str[])
	{
		for(int a=0;a<str.length;a++)
		{
			if(str[a].trim().length()==0)
			grid.setHTML(0, a, "&nbsp;");
			else
				grid.setText(0, a, str[a]);

			grid.getCellFormatter().addStyleName(0,a, "myDataTable-header");
		}
	}
	public void setFlightHeader(String str[])
	{
		for(int a=0;a<str.length;a++)
		{
			if(str[a].trim().length()==0)
			grid.setHTML(0, a, "&nbsp;");
			else
				grid.setText(0, a, str[a]);

			grid.getCellFormatter().addStyleName(0,a, "flights-header");
		}
	}
	public void setHeader(String str[][])
	{
		for(int x=0;x<str.length;x++)
		{
			if(str[x][0].trim().length()==0)
				grid.setHTML(0, x, "&nbsp;");
				else
					grid.setText(0, x, str[x][0]);
			grid.getCellFormatter().addStyleName(0, x, "myDataTable-header");
			if(Integer.parseInt(str[x][1])!=0)
			grid.getColumnFormatter().setWidth(x, str[x][1]+"px");
			else
			grid.getColumnFormatter().setWidth(x, "10px");
		}

	}
	public void setHeaders(String str[][])
	{
		for(int x=0;x<str.length;x++)
		{
			if(str[x][0].trim().length()==0)
				grid.setHTML(0, x, "&nbsp;");
				else
					grid.setText(0, x, str[x][0]);
			grid.getCellFormatter().addStyleName(0, x, "myDataTable-headers");
			if(Integer.parseInt(str[x][1])!=0)
			grid.getColumnFormatter().setWidth(x, str[x][1]+"px");
			else
			grid.getColumnFormatter().setWidth(x, "10px");
		}

	}
	public void setHeaderCheckBox(int col)
	{
			final MyCheckBox chkBox = new MyCheckBox();
			setWidgets(0, col, chkBox , 1);

			chkBox.addClickHandler(new ClickHandler()
			{
				public void onClick(ClickEvent w)
				{
					int row=grid.getRowCount();
					for(int a=1;a<row;a++)
			 		{
						MyCheckBox ch=(MyCheckBox)grid.getWidget(a, 1);
						if(ch!=null)
						{
							ch.setChecked(chkBox.isChecked());
							if(chkBox.isChecked() && ch.isVisible())
								setBackgroundRowSelected(a);
							else
								removeBackgroundRowSelected(a);
						}
						else
							removeBackgroundRowSelected(a);

			 		}
				}
			});

	}

	public void resizeRows(int noOfRows)
	{
		Widget w=grid.getWidget(0, 1);
		if(w instanceof MyCheckBox)
		{
			((MyCheckBox)w).setChecked(false);
		}
		grid.resizeRows(noOfRows);
	}
	public void resizeColumn(int col)
	{
		grid.resizeColumns(col);
	}

	public void setClearRows(int row,int noOfRows)
	{
		while(row<=noOfRows)
		{
			int col = grid.getColumnCount();
			for(int a=0;a<col;a++)
			{
				grid.clearCell(row, a);

				grid.getCellFormatter().removeStyleName(row, a, "extraNight");

				if(ROW_STATUS)
				grid.getCellFormatter().addStyleName(row,a,"myDataTable-RowD");
				else
				grid.getCellFormatter().addStyleName(row,a,"myDataTable-RowL");

				removeBackgroundRowSelected(row);


			}
			HTML ht=new HTML();
			ht.addStyleName("f12");
			ht.setText(""+row);
			grid.setWidget(row, 0, ht);
			grid.getCellFormatter().addStyleName(row,0,"myDataTable-RowCounter");
			row++;

			ROW_STATUS = !ROW_STATUS;
		}

		LoadingGadgetPopup.getInstance(0,0).hide();
	}
	public int getRowCount()
	{
		return grid.getRowCount();
	}
	public int getColumnCount()
	{
		return grid.getColumnCount();
	}
	public void removeBackgroundRowSelected(int row)
	{
		grid.getRowFormatter().removeStyleName(row, "myDataTable-selected");
		grid.getRowFormatter().removeStyleName(row, "myDataTable-select");
		grid.getRowFormatter().removeStyleName(row, "rajjab");
		grid.getRowFormatter().removeStyleName(row, "shaban");
		grid.getRowFormatter().removeStyleName(row, "ramadhan");

	}
	public void hideVisibleRow(int row)
	{
		grid.getRowFormatter().setVisible(row, false);
	}
	public boolean isRowVisible(int row)
	{
		return grid.getRowFormatter().isVisible(row);
	}
	public void showVisibleRow(int row)
	{
		grid.getRowFormatter().setVisible(row, true);
	}
	public void hideVisibleColumn(int row,int col,boolean visible)
	{
		grid.getCellFormatter().setVisible(row,col, visible);
	}
	public void setRowNumData(Object obj[],int row,boolean rowStatus,boolean editStatus)
	{
		if(editStatus)
		{
			int rows = grid.getRowCount();
			grid.resizeRows(rows+1);
			//	grid.getCellFormatter().setHorizontalAlignment(row, a, HorizontalPanel.ALIGN_CENTER);
		}
		removeBackgroundRowSelected(row);
		//System.out.println("Row start: "+rowStatus);
		for(int a=0;a<obj.length;a++)
		{
			grid.getCellFormatter().removeStyleName(row,a, "myDataTable-RowD");
			grid.getCellFormatter().removeStyleName(row,a, "myDataTable-RowL");
			grid.getCellFormatter().removeStyleName(row, a, "extraNight");

			if(isRowVisible(row)==false)
				showVisibleRow(row);

			if(a==0)
			{
				Object o=obj[a];
				if(o instanceof String)
				{
					HTML ht=new HTML();
					ht.addStyleName("f12");
					ht.setText(""+row);
					ht.setTitle(obj[a].toString());
					grid.setWidget(row, a, ht);
					grid.getCellFormatter().addStyleName(row,0,"myDataTable-RowCounter");
				}
				else
				{
					HTML ht=new HTML();
					ht.setText(""+row);
					ht.setTitle(obj[a].toString());
					grid.setWidget(row, a, ht);
				}
			}
			else
			{
				Object o=obj[a];
				if(o instanceof String || o instanceof Integer  || o instanceof Long || o == null || o instanceof Double || o instanceof MyLabelSalePurchase)
				{
					if(o!=null)
					{
						if(o instanceof Double)
						{
							if(row==1)
							{
								grid.getCellFormatter().setHorizontalAlignment(0, a, HorizontalPanel.ALIGN_RIGHT);
							}
							setWidgets(row, a, Util.getHTMLLabel(o.toString()), 2);
							//setRowText(row, a, o, 2, false);
						}
						else if(o instanceof Long || o instanceof Integer)
						{
							if(row==1)
							{
								grid.getCellFormatter().setHorizontalAlignment(0, a, HorizontalPanel.ALIGN_CENTER);
							}
							setWidgets(row, a, Util.getHTMLLabel(o.toString()), 1);
							//setRowText(row, a, o, 2, false);
						}
						if(o instanceof MyLabelSalePurchase)
						{
							if(row==1)
							{
								grid.getCellFormatter().setHorizontalAlignment(0, a, HorizontalPanel.ALIGN_RIGHT);
							}
							setWidgets(row, a, Util.getHTMLLabel(o.toString()), 2);
						}
						else
						{
							grid.setText(row, a, o.toString());
							//System.out.println("Row : "+rowStatus);
							if(rowStatus)
							grid.getCellFormatter().addStyleName(row,a,"myDataTable-RowFontBig");
							else
								grid.getCellFormatter().addStyleName(row,a,"myDataTable-RowFont");
						}

							//grid.getCellFormatter().setHorizontalAlignment(row, a, HasHorizontalAlignment.ALIGN_RIGHT);

					}
					else
					{
						grid.setText(row, a, " ");
						grid.getCellFormatter().addStyleName(row,a,"myDataTable-RowFont");
					}
				}
				else if(o instanceof MyCheckBox)
				{
					final MyCheckBox chk = (MyCheckBox)o;
					setWidgets(row, a, (MyCheckBox)(obj[a]), chk.getAlignment());
					final Integer chkRow = new Integer(row);
					chk.addClickHandler(new ClickHandler()
					{
						public void onClick(ClickEvent e)
						{
							if(chk.isChecked())
							setBackgroundRowSelected(chkRow.intValue());
							else
							removeBackgroundRowSelected(chkRow.intValue());
						}
					});
				}
				else if(o instanceof MyButton)
				{
					//if(editStatus)
					MyButton but = (MyButton) o;
					grid.getCellFormatter().setWidth(row, a, "50px");
					grid.getCellFormatter().addStyleName(row, a, "paddingBothSide");
					grid.setWidget(row, a, but);
				}
				else if(o instanceof MyVerticalPanel)
				{
					//if(editStatus)
					MyVerticalPanel but = (MyVerticalPanel) o;
					if(but.getId()!=null && but.getId().equals("ROOM"))
					{
						grid.setWidget(row, a, but);
					}
					else
					{
						grid.getCellFormatter().addStyleName(row, a, "paddingBothSide");
						setWidgets(row, a, but, but.getAlignment());
					}
					if(row==1)
					{
						setHorizontalAlign(0, a, but.getAlignment());
					}
				}
				else if(o instanceof Image)
				{
					final Integer chkRow = new Integer(row);
					Image img = (Image)o;
					grid.setWidget(row, a, (Image)(obj[a]));
					grid.getCellFormatter().setWidth(row, a, ""+img.getWidth());
					grid.getCellFormatter().addStyleName(row, a, "paddingBothSide");
					img.addClickHandler(new ClickHandler()
					{
						public void onClick(ClickEvent e)
						{
							setBackground(chkRow.intValue());
						}
					});
				}
				else if(o instanceof MyHyperLinkMain)
				{
					//if(editStatus)
					MyHyperLinkMain but = (MyHyperLinkMain) o;
					grid.getCellFormatter().addStyleName(row, a, "paddingBothSide");
					if(row==1)
					{
						setHorizontalAlign(0, a, but.getAlignment());
					}
					setWidgets(row, a, but, but.getAlignment());
					final Integer ROW = new Integer(row);
					
				}
				else if(o instanceof MyLabel)
				{
					//if(editStatus)
					MyLabel but = (MyLabel) o;
					grid.getCellFormatter().addStyleName(row, a, "paddingBothSide");
					if(row==1)
					{
						setHorizontalAlign(0, a, but.getAlignment());
					}
					setWidgets(row, a, but, but.getAlignment());
				}
				else if(o instanceof Widget)
				{
					grid.setWidget(row, a, (Widget)obj[a]);
					grid.getCellFormatter().addStyleName(row, a, "paddingBothSide");
				}

			}


			Object o=obj[a];
			if(o instanceof MyHTML)
			{
				MyHTML ht = (MyHTML)o;
				if(ht.getId().equals("2"))
				grid.getCellFormatter().setHorizontalAlignment(row, a, HorizontalPanel.ALIGN_RIGHT);
				else if(ht.getId().equals("1"))
					grid.getCellFormatter().setHorizontalAlignment(row, a, HorizontalPanel.ALIGN_CENTER);
				else if(ht.getId().equals("0"))
					grid.getCellFormatter().setHorizontalAlignment(row, a, HorizontalPanel.ALIGN_LEFT);

			}
		}

		if(ROW_STATUS)
		grid.getRowFormatter().addStyleName(row, "myDataTable-RowD");
		else
		grid.getRowFormatter().addStyleName(row, "myDataTable-RowL");

		ROW_STATUS = !ROW_STATUS;

	}

	public void setWidgets(int row,int col,Widget w,int align)
	{
		grid.setWidget(row, col, w);
		grid.getCellFormatter().addStyleName(row,col, "paddingBothSide");

		if(row==0 && col==1 && w instanceof MyCheckBox)
		{
			//grid.getCellFormatter().removeStyleName(0,1, "myDataTable-header");
			//grid.getCellFormatter().addStyleName(0,1, "myDataTable-headerCheckbox");
		}

		setHorizontalAlign(row, col, align);
		/*
		if(align==0)
			grid.getCellFormatter().setHorizontalAlignment(row, col, HorizontalPanel.ALIGN_LEFT);
			else if(align==1)
				grid.getCellFormatter().setHorizontalAlignment(row, col, HorizontalPanel.ALIGN_CENTER);
			if(align==2)
				grid.getCellFormatter().setHorizontalAlignment(row, col, HorizontalPanel.ALIGN_RIGHT);
				*/
	}
	public void setFlightWidgets(int row,int col,Widget w,int align)
	{
		grid.setWidget(row, col, w);
		grid.getCellFormatter().addStyleName(row,col, "flights");

		setHorizontalAlign(row, col, align);
		
	}
	public void setHorizontalAlign(int row,int a,int align)
	{
		if(align==0)
		{
			if(LocaleInfo.getCurrentLocale().isRTL())
			grid.getCellFormatter().setHorizontalAlignment(row, a, HorizontalPanel.ALIGN_RIGHT);
			else
				grid.getCellFormatter().setHorizontalAlignment(row, a, HorizontalPanel.ALIGN_LEFT);
		}
		else if(align==1)
			grid.getCellFormatter().setHorizontalAlignment(row, a, HorizontalPanel.ALIGN_CENTER);
		else if(align==2)
		{
			if(LocaleInfo.getCurrentLocale().isRTL())
				grid.getCellFormatter().setHorizontalAlignment(row, a, HorizontalPanel.ALIGN_LEFT);
			else
				grid.getCellFormatter().setHorizontalAlignment(row, a, HorizontalPanel.ALIGN_RIGHT);
		}
	}
	public void setBackgroundRowSelected(int row)
	{
		grid.getRowFormatter().addStyleName(row, "myDataTable-selected");
	}
	public void setBackgroundSelected(int row)
	{
		grid.getRowFormatter().addStyleName(row, "myDataTable-select");
	}
	public void setBackground(int row,String style)
	{
	 	//grid.getRowFormatter().setStyleName(row, "myDataTable-RowL");
		grid.getRowFormatter().setStyleName(row, style);

	}
	public void setBackground(int row)
	{
		removeBackground(ROW_COUNTER);
		ROW_COUNTER = row;
		grid.getRowFormatter().addStyleName(row, "myDataTable-selected");
	}
	public void removeBackground(int row)
	{
		grid.getRowFormatter().removeStyleName(row, "myDataTable-selected");
	}

	@SuppressWarnings("unused")
	public String getTextValue(int row,int col)
	{
		Widget w = grid.getWidget(row, col);
		if(w instanceof MyTextBox)
		{
			MyTextBox lbl = (MyTextBox)w;
			if(lbl.getText().trim().length()!=0)
			return lbl.getText();
			else
				return "0";
		}
		else if(w instanceof MyLabel)
		{
			MyLabel txt = (MyLabel)w;
			return txt.getText();
		}
		else if(w == null)
		{
			String str = grid.getText(row, col);
			return str;
		}
		else if(w instanceof MyDateBox)
		{
			MyDateBox txt = (MyDateBox)w;

			return txt.getText();
		}
	 	else if(w instanceof MyUpdatebleCombo)
		{
			MyUpdatebleCombo txt = (MyUpdatebleCombo)w;
			return txt.getLstBox().getComboItem();
		}
		else if(w instanceof MyListBox)
		{
			MyListBox txt = (MyListBox)w;
			return txt.getComboItem();
		}
		else if(w instanceof MyHyperLink)
		{
			MyHyperLink lbl = (MyHyperLink)w;
			return lbl.getText();
		}
		else if(w instanceof MyHyperLinkMain)
		{
			MyHyperLinkMain lbl = (MyHyperLinkMain)w;
			return lbl.getText();
		}
	 	else if(w instanceof MyHTML)
		{
			MyHTML lbl = (MyHTML)w;
			return lbl.getText();
		}
		else if(w instanceof MyLabelSalePurchase)
		{
			MyLabelSalePurchase lbl = (MyLabelSalePurchase)w;
			return ""+lbl.getSale();
		}
		else if(w instanceof MyTextSalePurchase)
		{
			MyTextSalePurchase lbl = (MyTextSalePurchase)w;
			return ""+lbl.getSale();
		}
		else if(w instanceof MyCustomDate)
		{
			MyCustomDate txt = (MyCustomDate)w;
			return txt.getText();
		}

		return null;
	}
	public Long getTextCode(int row,int col)
	{
		Widget w = grid.getWidget(row, col);
		if(w instanceof MyUpdatebleCombo)
		{
			MyUpdatebleCombo txt = (MyUpdatebleCombo)w;
			return txt.getCode();
		}
		return null;
	}
	public String getTextId(int row,int col)
	{
		Widget w = grid.getWidget(row, col);
		if(w instanceof MyTextBox)
		{
			MyTextBox lbl = (MyTextBox)w;
			return lbl.getId();
		}
		else if(w instanceof MyLabel)
		{
			MyLabel txt = (MyLabel)w;
			return txt.getId();
		}
		else if(w instanceof Image)
		{
			Image txt = (Image)w;
			return txt.getAltText();
		}
		else if(w == null)
		{
			String str = grid.getText(row, col);
			return str;
		}
		else if(w instanceof MyDateBox)
		{
			MyDateBox txt = (MyDateBox)w;
			return txt.getText();
		}
		else if(w instanceof MyCustomDate)
		{
			MyCustomDate txt = (MyCustomDate)w;
			return txt.getText();
		}
		else if(w instanceof MyUpdatebleCombo)
		{
			MyUpdatebleCombo txt = (MyUpdatebleCombo)w;
			return txt.getLstBox().getComboValue();

		}
		else if(w instanceof MyHyperLinkMain)
		{
			MyHyperLinkMain lbl = (MyHyperLinkMain)w;
			return lbl.getId();
		}
		else if(w instanceof MyListBox)
		{
			MyListBox txt = (MyListBox)w;
			return txt.getComboValue();
		}
		else if(w instanceof MyLabelSalePurchase)
		{
			MyLabelSalePurchase lbl = (MyLabelSalePurchase)w;
			return ""+lbl.getPurchase();
		}

		return null;
	}

	public MyLabel	getMyLabel(int row,int col)
	{
		Widget w = grid.getWidget(row, col);

		if(w instanceof MyLabel)
		{
			MyLabel lbl = (MyLabel)w;
			return lbl;
		}

		return null;
	}
	public MyCustomDate	getMyCustomDate(int row,int col)
	{
		Widget w = grid.getWidget(row, col);

		if(w instanceof MyCustomDate)
		{
			MyCustomDate lbl = (MyCustomDate)w;
			return lbl;
		}

		return null;
	}
	public void customHeaderColumn(int col,String title,String cols[])
	{
		MyVerticalPanel v = new MyVerticalPanel();
		v.setWidth("100%");
		MyHorizontalPanel h = new MyHorizontalPanel();
		h.setWidth("100%");
		for(int a=0;a<cols.length;a++)
		{
			h.addWidget(Util.getHTMLLabel(cols[a]), 1, 1);
		}

		v.addWidget(Util.getHTMLLabel(title+"<hr/>"),1,1);
		v.addWidget(h,1,1);

		DOM.setStyleAttribute(h.getElement(), "borderTop", "gainsboro");

		setWidgets(0, col, v, 1);

	}
	public Widget customDataColumn(Object cols[])
	{
		MyVerticalPanel v = new MyVerticalPanel();
		v.setWidth("100%");
		MyHorizontalPanel h = new MyHorizontalPanel();
		h.setWidth("100%");
		for(int a=0;a<cols.length;a++)
		{
			if(cols[a]!=null)
			{
				if(cols[a] instanceof MyHTML)
				{
					MyHTML ht = (MyHTML) cols[a];
					//MyLabel lbl = new MyLabel(ht.getText(),"boldColor");
					ht.setAlignment(2);
					h.addWidget(ht, 1, 1);
					h.setCellWidth(ht, "33%");
				}
				else if(cols[a] instanceof MyHyperLinkMain)
				{
					MyHyperLinkMain ht = (MyHyperLinkMain) cols[a];
				 	ht.setAlignment(2);
					h.addWidget(ht, 1, 1);
					h.setCellWidth(ht, "33%");
				}
				else if(cols[a] instanceof MyLabel)
				{
					MyLabel ht = (MyLabel) cols[a];
				 	ht.setAlignment(2);
					h.addWidget(ht, 1, 1);
					h.setCellWidth(ht, "33%");
				}
				else
				{
					MyLabel lbl = new MyLabel(cols[a].toString());
					lbl.setAlignment(2);
					h.addWidget(lbl, 1, 1);
					h.setCellWidth(lbl, "33%");
				}
			}
			else
			{
				h.addWidget(Util.getHTMLLabel(""), 1, 1);
				h.setCellWidth(Util.getHTMLLabel(""), "33%");
			}
		}

		v.addWidget(h,1,1);


		return v;

	}

	public String getId(int row)
	{
		HTML ht=(HTML)grid.getWidget(row, 0);
		return ht.getTitle();
	}

	public MyCheckBox getCheckbox(int row, int col)
	{
		MyCheckBox chk = (MyCheckBox)grid.getWidget(row, col);
		return chk;
	}

	public Widget getWidget(int row,int col)
	{
		return grid.getWidget(row, col);
	}
	public void setBorder()
	{
		grid.addStyleName("browsePanel");
	}

	public void clear()
	{
		int row=grid.getRowCount();
		for(int x=1;x<row;x++)
		{
			int col = grid.getColumnCount();
			for(int a=0;a<col;a++)
			{
				grid.clearCell(x, a);
				removeBackgroundRowSelected(x);
			}
		}
		Widget w=grid.getWidget(0, 1);
		if(w instanceof MyCheckBox)
		{
			((MyCheckBox)w).setChecked(false);
		}
	}
	public void clearAll()
	{
		int row=grid.getRowCount();
		for(int x=0;x<row;x++)
		{
			int col = grid.getColumnCount();
			for(int a=0;a<col;a++)
			{
				grid.clearCell(x, a);
				removeBackgroundRowSelected(x);
			}
		}
		Widget w=grid.getWidget(0, 1);
		if(w instanceof MyCheckBox)
		{
			((MyCheckBox)w).setChecked(false);
		}
	}
	public void setTex(int row,int col,String val)
	{
		grid.setText(row, col, val);
	}
	public void setText(int row,int col, String str,int align)
	{
		grid.setText(row, col, str);
	    if(align==0)
	    {
	    	if(LocaleInfo.getCurrentLocale().isRTL())
				grid.getCellFormatter().setHorizontalAlignment(row, col, HorizontalPanel.ALIGN_RIGHT);
				else
					grid.getCellFormatter().setHorizontalAlignment(row, col, HorizontalPanel.ALIGN_LEFT);
	    }
		else if(align==1)
			grid.getCellFormatter().setHorizontalAlignment(row, col, HorizontalPanel.ALIGN_CENTER);
		else if(align==2)
		{
 		  if(LocaleInfo.getCurrentLocale().isRTL())
			grid.getCellFormatter().setHorizontalAlignment(row, col, HorizontalPanel.ALIGN_LEFT);
			else
				grid.getCellFormatter().setHorizontalAlignment(row, col, HorizontalPanel.ALIGN_RIGHT);
		}
	}
	public void insertRow(int row)
	{
	 	grid.insertRow(row);

	}
	public void setWidget(int row,int col,Widget w,Integer align)
	{
		grid.setWidget(row, col, w);

		if(align==0)
		{
			if(LocaleInfo.getCurrentLocale().isRTL())
				grid.getCellFormatter().setHorizontalAlignment(row, col, HorizontalPanel.ALIGN_RIGHT);
			else
				grid.getCellFormatter().setHorizontalAlignment(row, col, HorizontalPanel.ALIGN_LEFT);
		}
		else if(align==1)
			grid.getCellFormatter().setHorizontalAlignment(row, col, HorizontalPanel.ALIGN_CENTER);
		else if(align==2)
		{
			if(LocaleInfo.getCurrentLocale().isRTL())
				grid.getCellFormatter().setHorizontalAlignment(row, col, HorizontalPanel.ALIGN_LEFT);
			else
				grid.getCellFormatter().setHorizontalAlignment(row, col, HorizontalPanel.ALIGN_RIGHT);
		}
	}
	public String[] getHeader()
	{
		int count=grid.getColumnCount();
	  	String[] arr = new String[count];
	  	int col=0;
		for(int i=1;i<count;i++)
		{
			if(grid.getCellFormatter().isVisible(0, i))
			{
		 		arr[col] =grid.getText(0, i);
		 		col++;
	  		}
	 	}

		return arr;
	}

	public void setColumnBackGround(int row, int col, String color)
	{
	 	grid.getCellFormatter().removeStyleName(row,col, "myDataTable-RowD");
		grid.getCellFormatter().removeStyleName(row,col, "myDataTable-RowL");
		grid.getCellFormatter().addStyleName(row, col, "extraNight");

	 	//DOM.setStyleAttribute(grid.getCellFormatter().getElement(row, col),"backgroundColor", color);
	}
	public void getRowFormatter(Integer row,String style)
	{
		grid.getRowFormatter().addStyleName(row, style);
	}
	public int getSelectedCount()
	{
		int pax=0;
		int row=grid.getRowCount();
		for(int a=1;a<row;a++)
		{
			if(isRowVisible(a))
			{
				MyCheckBox chk = getCheckbox(a, 1);
				if(chk.isChecked())
					pax++;
			}
		}
		return pax;
	}
	public void setClearCheckBox(int startRow)
	{

			int row = grid.getRowCount();
			for(int a=startRow+1;a<row;a++)
			{
				if(grid.getWidget(a, 1) instanceof MyCheckBox)
				{
					MyCheckBox chk =(MyCheckBox) grid.getWidget(a, 1);
					chk.setChecked(false);

					removeBackgroundRowSelected(a);
				}
			}



	}
}
