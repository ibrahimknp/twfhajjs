package com.plus.app.client.util;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PopupPanel;

public class LoadingDlg extends PopupPanel {

	public LoadingDlg(boolean autoHide, boolean modal) {
	    super(autoHide, modal);
	    this.setGlassEnabled(true);
	    this.setTitle("Press Esc Key to Hide.");
	    this.setGlassStyleName("loadingstyle");     
	    FlowPanel hp=new FlowPanel();
	    hp.setStyleName("loadingImg");
	    this.getElement().getStyle().setZIndex(500);
	    this.setWidget(hp);

	}
}
