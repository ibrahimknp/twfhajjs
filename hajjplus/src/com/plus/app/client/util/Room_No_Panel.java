package com.plus.app.client.util;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.plus.app.client.SessionBean;
import com.plus.app.client.util.right.AdvClickListener;
import com.plus.app.client.util.right.AdvClickNotifier;

public class Room_No_Panel extends Composite  implements AdvClickNotifier
{

	MyVerticalPanel			main,vMain;
	MyHTML					hyper;
	MyHTML					htCounts,htDayLeft,htGender;
	public MyHTML getHtCounts() {
		return htCounts;
	}


	Image					imgAgent;
	
	private AdvClickListener listener = null;

	public Image getImgAgent() {
		return imgAgent;
	}


	private static Room_No_Panel instance;

	public static Room_No_Panel getInstance() {
		if (instance == null)
			instance = new Room_No_Panel();

		return instance;
	}

	public Room_No_Panel() {
		// TODO Auto-generated constructor stub
	}

	public Room_No_Panel(String name,String color)
	{
		super();
		main = new MyVerticalPanel(false);
		main.addStyleName("flowLeft");

		vMain = new MyVerticalPanel(false);
		vMain.setSize(100, 100);
		vMain.setBackgroundColor(color);
		vMain.addStyleName("widgets");



		hyper = new MyHTML("");
		hyper.setText(name);
		hyper.addStyleName("widgets-child");


		htCounts = new MyHTML("0");
		htCounts.addStyleName("widgetCountStatus");
		htDayLeft = new MyHTML("");
		htDayLeft.addStyleName("widgetDayLeft");
		
		htGender = new MyHTML("");
		htGender.addStyleName("widgetGender");

		MyHorizontalPanel h = new MyHorizontalPanel(false);
		h.addWidget(hyper, 0 ,2);

		vMain.addWidget(htCounts, 1, 1);
		vMain.addWidget(htGender, 1, 1);
		vMain.addWidget(htDayLeft, 1, 1);

		main.addWidgetTop(vMain);
		main.addWidget(h, 1, 1);

		initWidget(main);
		
		
		sinkEvents(Event.ONMOUSEUP | Event.ONDBLCLICK | Event.ONKEYDOWN | Event.ONCONTEXTMENU); 

	}
	public Room_No_Panel(String name,String color,boolean big)
	{
		super();
		main = new MyVerticalPanel(false);
		main.addStyleName("flowLeft");
		main.setSize(150, 220);

		vMain = new MyVerticalPanel(false);
		vMain.setSize(100, 100);
		vMain.setBackgroundColor(color);
		vMain.addStyleName("widgets");



		hyper = new MyHTML("");
		hyper.setText(name);
		hyper.addStyleName("widgets-child");


		htCounts = new MyHTML("0");
		htCounts.addStyleName("widgetCountStatus");
		htDayLeft = new MyHTML("");
		htDayLeft.addStyleName("widgetDayLeft");

		htGender = new MyHTML("");
		htGender.addStyleName("widgetGender");

		MyHorizontalPanel h = new MyHorizontalPanel(false);
		h.addWidget(hyper, 0 ,2);

		vMain.addWidget(htCounts, 1, 1);
		vMain.addWidget(htGender, 1, 1);
		vMain.addWidget(htDayLeft, 1, 1);

		main.addWidgetTop(vMain);
		main.addWidget(h, 1, 0);
		

		main.setCellHeight(vMain, "110px");
		initWidget(main);


		sinkEvents(Event.ONMOUSEUP | Event.ONDBLCLICK | Event.ONKEYDOWN | Event.ONCONTEXTMENU);

	}
	public Room_No_Panel(String name)
	{
		main = new MyVerticalPanel(false);
		main.addStyleName("flowLeft");

		vMain = new MyVerticalPanel(false);
		vMain.setSize(150, 150);
		vMain.setBackgroundColor("red");
		vMain.addStyleName("widgets");



		hyper = new MyHTML("");
		hyper.setText(name);
		hyper.addStyleName("widgets-child");


		htCounts = new MyHTML(name);
		htCounts.addStyleName("widgetCountStatus");

		//MyHorizontalPanel h = new MyHorizontalPanel(false);
		//h.addWidget(hyper, 0 ,2);

		vMain.addWidget(htCounts, 1, 1);


		main.addWidgetTop(vMain);
		//main.addWidget(h, 1, 1);

		initWidget(main);

	}
	public void loadData(Object obj)
	{
		if(obj!=null)
		{
			htCounts.setText(obj.toString());
		}
	}

	public void setSize(int width,int height)
	{
		vMain.setSize(width, height);
	}

	public void addClickHandler(ClickHandler handler)
	{
		vMain.addDomHandler(handler, ClickEvent.getType());
		//hyper.addClickHandler(handler);
	}
	public void addMouseHandler(MouseOverHandler handler)
	{
		vMain.addDomHandler(handler, MouseOverEvent.getType());
	}
	public void addMouseOutHandler(MouseOutHandler handler)
	{
		vMain.addDomHandler(handler, MouseOutEvent.getType());
	}
	public void addArchiveClickHandler(ClickHandler handler)
	{
		//htCountsArch.addClickHandler(handler);
	}
	public void smallWidgets(int width,int height)
	{
		vMain.setSize(width, height);
		vMain.removeStyleName("widgets");
		hyper.removeStyleName("widgets-child");
		htCounts.removeStyleName("widgetCountStatus");

		vMain.addStyleName("widgetsSmall");
		hyper.addStyleName("widgetsSmall-child");
		htCounts.addStyleName("widgetCountStatusSmall");
	}

	public void load() {
		// TODO Auto-generated method stub

	}

	public SessionBean getSession() {
		// TODO Auto-generated method stub
		return SessionBean.getInstance();
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void refresh() {
		// TODO Auto-generated method stub

	}

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setColor(String color)
	{
		vMain.setBackgroundColor(color);
	}

	public void setDayLeft(Object val)
	{
		if(val!=null)
		{
			if(val.toString().equals("1"))
			htDayLeft.setText(val+" Day Left");	
			else
				htDayLeft.setText(val+" Days Left");
		}
	}
		
	public void setBedLeft(Object val)
	{
		if(val!=null)
		{
			if(val.toString().equals("1"))
			htDayLeft.setText(val+" Bed Left");	
			else
				htDayLeft.setText(val+" Bed Left");
		}
	}
	public void setGender(int gender)
	{
		if(gender==0)
			htGender.setHtml("M");
		else if(gender==1)
			htGender.setHtml("F");
	}
	public void setRoomLock(int status)
	{
		if(status==1)
			htGender.setHtml("<img src='images/lock.png' />");
		else if(status==1)
			htGender.setHtml("");
	}
	public void onBrowserEvent(Event event) {
		//GWT.log("onBrowserEvent", null);
        event.cancelBubble(true);//This will stop the event from being propagated to parent elements.
        event.preventDefault();
        switch (DOM.eventGetType(event)) {
	        case Event.ONMOUSEUP:
	        	if (DOM.eventGetButton(event) == Event.BUTTON_LEFT) {
	        		//GWT.log("Event.BUTTON_LEFT", null);
	        		try {
	        			listener.onClick(this, event);	
					} catch (Exception e) {
						// TODO: handle exception
					}
	        	}
	        	if (DOM.eventGetButton(event) == Event.BUTTON_RIGHT) {
	        		//GWT.log("Event.BUTTON_RIGHT", null);
	        		listener.onRightClick(this, event);
	        	}
	        	break;
	
	        case Event.ONDBLCLICK: 

	        	break;
	        	
	        case Event.ONCONTEXTMENU: 
	        	//GWT.log("Event.ONCONTEXTMENU", null);

	        	break;

	        default: 
	                // Do nothing
        }//end switch
	}
	
	public void addClickListener(AdvClickListener listener) {
		this.listener = listener;
	}

	public void removeClickListener(AdvClickListener listener) {
		this.listener = null;
	}
	

}
