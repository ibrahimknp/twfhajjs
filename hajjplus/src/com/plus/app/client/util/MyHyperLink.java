package com.plus.app.client.util;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Hyperlink;
import com.plus.app.client.util.right.AdvClickListener;
import com.plus.app.client.util.right.AdvClickNotifier;

public class MyHyperLink extends Hyperlink implements AdvClickNotifier{

	
	private AdvClickListener listener = null;
	
	public MyHyperLink() {
		super();
		sinkEvents(Event.ONMOUSEUP | Event.ONDBLCLICK | Event.ONKEYDOWN | Event.ONCONTEXTMENU); 
	}
	public MyHyperLink(String text) {
		super();
		setText(text);
		sinkEvents(Event.ONMOUSEUP | Event.ONDBLCLICK | Event.ONKEYDOWN | Event.ONCONTEXTMENU); 
	}
	
	public void onBrowserEvent(Event event) {
		//GWT.log("onBrowserEvent", null);
        event.cancelBubble(true);//This will stop the event from being propagated to parent elements.
        event.preventDefault();
        switch (DOM.eventGetType(event)) {
	        case Event.ONMOUSEUP:
	        	if (DOM.eventGetButton(event) == Event.BUTTON_LEFT) {
	        		//GWT.log("Event.BUTTON_LEFT", null);
	        		listener.onClick(this, event);
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
	
	
	private Integer alignment = new Integer(0);

	public Integer getAlignment() {
		return alignment;
	}

	public void setAlignment(Integer alignment) {
		this.alignment = alignment;
	}
	


}
