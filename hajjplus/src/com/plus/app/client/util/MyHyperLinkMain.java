package com.plus.app.client.util;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.plus.app.client.util.right.AdvMouseAdapter;
import com.plus.app.client.util.right.AdvMouseNotifier;

public class MyHyperLinkMain extends Composite implements AdvMouseNotifier{
	
	Hyperlink	hyper;
	Image		imgLoading;
	boolean		PREV=true;
	
	AdvMouseAdapter		click = null , mouse = null;
	
	public MyHyperLinkMain()
	{
		hyper = new Hyperlink();
		hyper.addStyleName("hyper");
		initWidget(hyper);
		
		sinkEvents(Event.ONMOUSEUP | Event.ONMOUSEOUT | Event.ONMOUSEOVER | Event.ONCONTEXTMENU);		
	}
	public MyHyperLinkMain(String text)
	{
		hyper = new Hyperlink();
		hyper.addStyleName("hyper");
		hyper.setText(text);
		initWidget(hyper);
		
		sinkEvents(Event.ONMOUSEUP | Event.ONMOUSEOUT | Event.ONMOUSEOVER | Event.ONCONTEXTMENU);
	}
	
	
	public MyHyperLinkMain(String text,String menuId,int pos)
	{
		hyper = new Hyperlink();
		hyper.addStyleName("hyper");
		hyper.setText(text);
		initWidget(hyper);
		
		//System.out.println("menuId:"+menuId);
		String prevs=Util.getPrivilege(menuId);
		
		PREV = Util.setPrviliage(prevs,this,pos);
		hyper.setVisible(PREV);
		sinkEvents(Event.ONMOUSEUP | Event.ONMOUSEOUT | Event.ONMOUSEOVER | Event.ONCONTEXTMENU);
	}	
	public MyHyperLinkMain(String text,String menuId,int pos,boolean isServer)
	{
		if(isServer)
		{
			MyVerticalPanel vMain = new MyVerticalPanel();
			
			hyper = new Hyperlink();
			hyper.addStyleName("hyper");
			hyper.setText(text);
			
			imgLoading = new Image("images/loading.gif");
			
			imgLoading.setVisible(false);
			
			vMain.addWidgetTop(hyper);
			vMain.addWidgetTop(imgLoading);
			
			initWidget(vMain);
		}
		else
		{
			hyper = new Hyperlink();
			hyper.addStyleName("hyper");
			hyper.setText(text);
			initWidget(hyper);		
		}
		
		String prevs=Util.getPrivilege(menuId);
		PREV = Util.setPrviliage(prevs,this,pos);
		hyper.setVisible(PREV);
		
		sinkEvents(Event.ONMOUSEUP | Event.ONMOUSEOUT | Event.ONMOUSEOVER | Event.ONCONTEXTMENU);
	}
	
	public MyHyperLinkMain(String text,boolean isServer)
	{
		if(isServer)
		{
			MyVerticalPanel vMain = new MyVerticalPanel();
			hyper = new Hyperlink();
			hyper.addStyleName("hyper");
			hyper.setText(text);
			imgLoading = new Image("images/loading.gif");
			
			imgLoading.setVisible(false);
			
			vMain.addWidgetTop(hyper);
			vMain.addWidgetTop(imgLoading);
			
			initWidget(vMain);
		}
		else
		{
			hyper = new Hyperlink();
			hyper.addStyleName("hyper");
			hyper.setText(text);
			initWidget(hyper);	
		}
		
		sinkEvents(Event.ONMOUSEUP | Event.ONMOUSEOUT | Event.ONMOUSEOVER | Event.ONCONTEXTMENU);
	}
	public MyHyperLinkMain(String text,boolean bool,boolean bool2)
	{
		hyper = new Hyperlink();
		hyper.addStyleName("hyper");
		hyper.setText(text);
		initWidget(hyper);
		
		//sinkEvents(Event.ONMOUSEUP | Event.ONMOUSEOUT | Event.ONMOUSEOVER | Event.ONCONTEXTMENU);
	}
	public void setBackground(String imageStyleName)
	{
		hyper.setStyleName(imageStyleName);
	}
	
	public void setText(String text)
	{
		hyper.setText(text);
	}
	public String getText()
	{
		return hyper.getText();
	}
	public void setHtml(String html)
	{
		hyper.setHTML(html);
	}
	public String getHtml()
	{
		return hyper.getHTML();
	}
	public void setTitle(String title)
	{
		hyper.setTitle(title);
	}
	public String getTitle()
	{
		return hyper.getTitle();
	}
	
	public void addClickHandler(ClickHandler handler)
	{
		hyper.addClickHandler(handler);
	}
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	private int alignment=1;

	public int getAlignment() {
		return alignment;
	}
	public void setAlignment(int alignment) {
		this.alignment = alignment;
	}
	
	
	
	
	public void onBrowserEvent(Event event) {
		//GWT.log("onBrowserEvent", null);
        event.cancelBubble(true);//This will stop the event from being propagated to parent elements.
        event.preventDefault();
        switch (DOM.eventGetType(event)) {
	        	case Event.ONMOUSEOVER:
	        	{
	        		if(mouse!=null)
	        		mouse.onMouseOver(this, event);
	        	}
	        	break;
	        	case Event.ONMOUSEOUT:
	        	{
	        		if(mouse!=null)
	        		mouse.onMouseOut(this, event);
	        	}
        		break;
	        	case Event.ONMOUSEUP:
	        	{
	        		if(click!=null)
	        		click.onClick(this);
	        	}
	        	break;		        	        	
	        	case Event.ONCONTEXTMENU: 
	        	//GWT.log("Event.ONCONTEXTMENU", null);

	        	break;

	        default: 
	                // Do nothing
        }//end switch
	}
	
	public void addClickListener(AdvMouseAdapter listener) {
		this.click = listener;
	}

	public void removeClickListener(AdvMouseAdapter listener) {
		this.click = null;
	}
	
	public void addMouseListener(AdvMouseAdapter listener) {
		// TODO Auto-generated method stub
		this.mouse = listener;
	}
	
	
	public void setDisable(boolean disable)
	{
		if(disable)
		{
			hyper.removeStyleName("hyper");
			hyper.removeStyleName("hyper a,a:visited");
			hyper.removeStyleName("gwt-Hyperlink");	
			hyper.addStyleName("hyper-disable");
			
			removeClickListener(null);
		}
	}
	
	public void waiting(boolean wait)
	{
		hyper.setVisible(!wait);
		imgLoading.setVisible(wait);
		
	}
	
	public void setVisible(boolean vis)
	{
		if(PREV)
		{
			hyper.setVisible(vis);
		}
		else
			hyper.setVisible(false);
	}
}