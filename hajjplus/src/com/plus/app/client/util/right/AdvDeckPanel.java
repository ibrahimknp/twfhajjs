package com.plus.app.client.util.right;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.DeckPanel;

public class AdvDeckPanel extends DeckPanel implements AdvClickNotifier {

	private AdvClickListener listener = null;

	public AdvDeckPanel() {
		super();
		sinkEvents(Event.ONMOUSEUP | Event.ONDBLCLICK | Event.ONKEYDOWN | Event.ONCONTEXTMENU); 
	}
	
	public void onBrowserEvent(Event event) {
		GWT.log("onBrowserEvent", null);
        event.cancelBubble(true);//This will stop the event from being propagated to parent elements.
        event.preventDefault();
        switch (DOM.eventGetType(event)) {
	        case Event.ONMOUSEUP:
	        	if (DOM.eventGetButton(event) == Event.BUTTON_LEFT) {
	        		GWT.log("Event.BUTTON_LEFT", null);
	        		listener.onClick(this, event);
	        	}
	        	if (DOM.eventGetButton(event) == Event.BUTTON_RIGHT) {
	        		GWT.log("Event.BUTTON_RIGHT", null);
	        		listener.onRightClick(this, event);
	        	}
	        	break;
	
	        case Event.ONDBLCLICK: 

	        	break;
	        	
	        case Event.ONCONTEXTMENU: 
	        	GWT.log("Event.ONCONTEXTMENU", null);

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
