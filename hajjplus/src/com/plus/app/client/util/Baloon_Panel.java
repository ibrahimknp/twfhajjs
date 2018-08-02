package com.plus.app.client.util;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.plus.app.client.SessionBean;

public class Baloon_Panel extends Composite
{

	MyVerticalPanel			main,vMain;
	MyHTML					hyper;
	MyHTML					htCounts;
	Image					imgAgent;

	public Image getImgAgent() {
		return imgAgent;
	}


	private static Baloon_Panel instance;

	public static Baloon_Panel getInstance() {
		if (instance == null)
			instance = new Baloon_Panel();

		return instance;
	}

	public Baloon_Panel() {
		// TODO Auto-generated constructor stub
	}

	public Baloon_Panel(String name,String color)
	{
		main = new MyVerticalPanel(false);
		main.addStyleName("flowLeft");

		vMain = new MyVerticalPanel(false);
		vMain.setSize(150, 150);
		vMain.setBackgroundColor(color);
		vMain.addStyleName("widgets");



		hyper = new MyHTML("");
		hyper.setText(name);
		hyper.addStyleName("widgets-child");


		htCounts = new MyHTML("0");
		htCounts.addStyleName("widgetCountStatus");

		MyHorizontalPanel h = new MyHorizontalPanel(false);
		h.addWidget(hyper, 0 ,2);

		vMain.addWidget(htCounts, 1, 1);


		main.addWidgetTop(vMain);
		main.addWidget(h, 1, 1);

		initWidget(main);

	}
	public Baloon_Panel(String name)
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

		


}
