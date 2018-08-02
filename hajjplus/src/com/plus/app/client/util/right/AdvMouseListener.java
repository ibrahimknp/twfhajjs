package com.plus.app.client.util.right;

import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.MouseListener;
import com.google.gwt.user.client.ui.Widget;

public interface AdvMouseListener extends ClickListener,MouseListener {
	
	void onClick(Widget sender);
	void onMouseOver(Widget widget,Event event);
	void onMouseOut(Widget widget,Event event);
	
}
