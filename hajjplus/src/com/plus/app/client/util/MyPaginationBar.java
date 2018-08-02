package com.plus.app.client.util;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.plus.app.client.RPCConnection.Generic_Connection;
import com.plus.app.client.impl.MyPagination_Impl;
import com.plus.app.client.lang.Languages;
import com.plus.app.client.lang.MyLoadedImages;
import com.plus.app.shared.dao.Generic_Wrapper;


public class MyPaginationBar extends Composite {
	
	private HTML			htmlCenter;
	public  MyListBox	lstNoOfRows;
	private Image		imgPrev,imgNext;
	private MyTextBox	txtPage;
	private MyHTML		lblTotalPage;
	private MyButton	cmdGo;
	MyPagination_Impl 	mi;
	int					PAGE_NO = 1;
	public String		QUERY;
	MyHorizontalPanel		horiMain;
	public MyVerticalPanel	panTotal;
	
	public MyPaginationBar()
	{
		horiMain = new MyHorizontalPanel();
		horiMain.setHeight("20px");
		horiMain.addStyleName("pagination");
	//	horiMain.addStyleName("enhanceGrayUpDown");
		panTotal=new MyVerticalPanel();
		
		MyHorizontalPanel hori = new MyHorizontalPanel();
		hori.setSpacing(5);
		
		//imgPrev1 = new MyImage("images/prev1.png" , true);
		imgPrev = MyLoadedImages.prev();
		imgNext = MyLoadedImages.next();
		//imgNext1 = new MyImage("images/next1.png" , true);
		
		txtPage = new MyTextBox(50,3,Languages.constants.page(),true);
		lblTotalPage = Util.getHTMLLabel("");
		cmdGo = new MyButton(" "+Languages.constants.go()+" ",false,null);
		cmdGo.setWidth("60px");
		
		//hori.add(imgPrev1);
		
		if(LocaleInfo.getCurrentLocale().isRTL())
		{
			hori.addWidget(imgNext,1,1);
			hori.addWidget(imgPrev,1,1);
		}
		else
		{
			hori.addWidget(imgPrev,1,1);
			hori.addWidget(imgNext,1,1);
		}
		
		hori.addWidget(Util.makePagLabel(Languages.constants.page()),1,1);
		hori.addWidget(txtPage,1,1);
		hori.addWidget(Util.makePagLabel(" of "),1,1);
		hori.addWidget(lblTotalPage,1,1);
		hori.addWidget(cmdGo,1,1);
		
		
		
		horiMain.addWidget(hori,0);
		
		htmlCenter = new HTML("");
		htmlCenter.addStyleName("pagCenter");
		
		horiMain.addWidget(htmlCenter,1,1);
		horiMain.addWidget(panTotal,1,1);
		//horiMain.setVertiAlignMiddle(htmlCenter);
		
		
		lstNoOfRows = new MyListBox();
		//lstNoOfRows.addItem("10", "10");
		lstNoOfRows.addItem("20", "20");
		lstNoOfRows.addItem("30", "30");
		lstNoOfRows.addItem("40", "40");
		lstNoOfRows.addItem("50", "50");
		lstNoOfRows.addItem("60", "60");
		lstNoOfRows.addItem("100", "100");
		
		
		MyHorizontalPanel horiR = new MyHorizontalPanel();
		horiR.setSpacing(5);
		horiR.setWidth("150px");
		horiR.addWidget(Util.makePagLabel(Languages.constants.noOfRows()),1,1);
		horiR.addWidget(lstNoOfRows,1,1);
		
		//horiMain.add(horiR);
		//horiMain.setCellHorizontalAlignment(horiR, HasHorizontalAlignment.ALIGN_RIGHT);
		horiMain.addWidget(horiR,2,1);
		
		//flex.setVisible(false);
		
		initWidget(horiMain);
		
		imgNext.addClickHandler(new Page());
		imgPrev.addClickHandler(new Page());
		cmdGo.addClickHandler(new Page());
		lstNoOfRows.addChangeHandler(new ChangeHandler()
		{
			public void onChange(ChangeEvent e)
			{
				if(mi!=null)
				{
					mi.resizeRows(lstNoOfRows.getComboValueInteger().intValue());
					count(QUERY);
				}
			}
		});
		
	}

	
	public Image getImgPrev() {
		return imgPrev;
	}

	public void setImgPrev(Image imgPrev) {
		this.imgPrev = imgPrev;
	}

	public Image getImgNext() {
		return imgNext;
	}

	public void setImgNext(Image imgNext) {
		this.imgNext = imgNext;
	}

	

	public MyListBox getLstNoOfRows() {
		return lstNoOfRows;
	}


	public void setLstNoOfRows(MyListBox lstNoOfRows) {
		this.lstNoOfRows = lstNoOfRows;
	}


	public MyTextBox getTxtPage() {
		return txtPage;
	}


	public void setTxtPage(MyTextBox txtPage) {
		this.txtPage = txtPage;
	}


	public MyHTML getLblTotalPage() {
		return lblTotalPage;
	}


	public void setLblTotalPage(MyHTML lblTotalPage) {
		this.lblTotalPage = lblTotalPage;
	}


	public MyButton getCmdGo() {
		return cmdGo;
	}


	public void setCmdGo(MyButton cmdGo) {
		this.cmdGo = cmdGo;
	}

	public void count(final String query)
	{
		QUERY = query;
		
		final Integer noOfRows = lstNoOfRows.getComboValueInteger();
		Generic_Wrapper meta = new Generic_Wrapper();
		meta.setQuery("select count(*) "+query);
		//System.out.println(meta.getQuery());
		Generic_Connection.getRpcConnection().getNoOfRecords(meta, new AsyncCallback<String>()
		{
			public void onSuccess(String str)
			{
				getTxtPage().setText("1");
				
				int pg=Util.totalPages(Integer.valueOf(str), noOfRows);
				getLblTotalPage().setText(String.valueOf(pg));
				 
				mi.load(txtPage.getIntegerText()-1,noOfRows,QUERY);
			}
			public void onFailure(Throwable thr)
			{
				//thr.printStackTrace();
				System.out.println("Count Error :"+thr.getMessage()+"\n"+query);
			}
		});
		
	}
	
	public void registerPagination(Object obj)
	{
		mi = (MyPagination_Impl)obj;
	}
	
	
	class Page implements ClickHandler
	{
		public void onClick(ClickEvent e)
		{
			executePageQuery(e);
		}
	}
	
	public void executePageQuery(ClickEvent e)
	{
		int noOfRows = lstNoOfRows.getComboValueInteger().intValue();
		int currentPageNo = txtPage.getIntegerText().intValue();
		if(e!=null && e.getSource() instanceof Image)
		{
			Image img=(Image)e.getSource();
			if(img.getAltText().equals("Next"))
			{
				if(lblTotalPage.getIntegerText().intValue()>currentPageNo )
				{
					PAGE_NO=currentPageNo+1;
					txtPage.setText(String.valueOf(PAGE_NO));
				}
			}
			else if(img.getAltText().equals("Prev"))
			{
				if(currentPageNo>1)
				{
					PAGE_NO=currentPageNo-1;
					txtPage.setText(String.valueOf(PAGE_NO));
				}
			}
		}
		else
		{
			if(currentPageNo!=0 && lblTotalPage.getIntegerText().intValue()>=currentPageNo )
			{
				PAGE_NO=currentPageNo;
			}
		}
		//mi. pageNo(PAGE_NO-1,noOfRows);
		mi.load(PAGE_NO-1,noOfRows,QUERY);
	}
	
	public void clearPage()
	{
		txtPage.clear();
	}
	
	public void load()
	{
		int noOfRows = lstNoOfRows.getComboValueInteger().intValue();
		int currentPageNo = txtPage.getIntegerText().intValue();
		
		mi.load(currentPageNo-1,noOfRows,QUERY);
	}


	public MyHorizontalPanel getHoriMain() {
		return horiMain;
	}
	
	public void refresh()
	{
		count(QUERY);
	}
	public String getAndQuery()
	{
		String str = QUERY;
		str= str.substring(str.indexOf("where")+6);
		return "AND "+str;
	}
	public HTML getHtmlCenter() {
		return htmlCenter;
	}
	
	public void loadAll()
	{
		lstNoOfRows.clear();
		lstNoOfRows.addItem("10", "10");
		lstNoOfRows.addItem("20", "20");
		lstNoOfRows.addItem("30", "30");
		lstNoOfRows.addItem("40", "40");
		lstNoOfRows.addItem("50", "50");
		lstNoOfRows.addItem("60", "60");
	}
}
