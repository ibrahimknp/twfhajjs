package com.plus.app.client.util;

import java.util.Iterator;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Node;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.plus.app.client.impl.PopupMain;
import com.plus.app.client.lang.MyImagesResource;

public class MyDialogBox extends DialogBox implements HasWidgets//,HasSafeHtml
{
	

	//DialogBox		dialog;
	private Node closeEventTarget = null;
	Image 			img;
	PopupMain 		impl;
	 public HTML headerText;
	
	public MyDialogBox(String header,String screenName)
	{
		super(false,false);
		//dialog = new DialogBox();
		//dialog.setText("Change Password");
		//Element dialogTopRight = getCellElement(0, 2);
		//Caption cp = getCaption();
		//cp.setHTML(getHeaderString(header, MyImagesResource.getImages().close()));
		Element td = getCellElement(0, 1);
        DOM.removeChild(td, (Element) td.getFirstChildElement());
        DOM.appendChild(td, getHeaderString(header, MyImagesResource.getImages().close(),screenName));
      //  super.setGlassEnabled(true);
        
		
	}
	 
	
	private Element getHeaderString(String text, ImageResource image,String title) 
	{
	    // Add the image and text to a horizontal panel
	    HorizontalPanel hPanel = new HorizontalPanel();
	    hPanel.setWidth("100%");
	    hPanel.addStyleName("Caption");
	    hPanel.setSpacing(0);
	    hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	    headerText = new HTML(text);
	    headerText.setTitle(title);
	    //headerText.setStyleName("cw-StackPanelHeader");
	    hPanel.add(headerText);
	    img = new Image(image);
	    img.addStyleName("hyper");
	    hPanel.add(img);
	    hPanel.setCellHorizontalAlignment(img, HasHorizontalAlignment.ALIGN_RIGHT);
	    
	  
	    
	   	    // Return the HTML string for the panel
	    return hPanel.getElement();
	 }
	 
	
	public void add(Widget w)
	{
		super.add(w);
	}
	public void setText(String txt)
	{
		super.setText(txt);
	}
	@Override
	public void show()
	{
		super.show();
		super.center();	
	}
	 
	@Override
	public void hide()
	{
		super.hide();
	}
	
	/*
	public Caption getCaption()
	{
		return super.getCaption();
	}
	
	@Override
	public void setHTML(SafeHtml html)
	{
		super.setHTML(html);
	}
	*/
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<Widget> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Widget w) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
    protected void onPreviewNativeEvent(NativePreviewEvent event)
      {
        NativeEvent nativeEvent = event.getNativeEvent();

        if (!event.isCanceled()
          && (event.getTypeInt() == Event.ONCLICK)
          && isCloseEvent(nativeEvent))
          {
        	if(impl!=null)
        	{
        		impl.destroy();
        	}
            super.hide();
          }
        super.onPreviewNativeEvent(event);
        
        switch (event.getTypeInt()) {
            case Event.ONKEYDOWN:
                if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ESCAPE) 
                {
                	if(impl!=null)
                	{
                		impl.destroy();
                	}
                    super.hide();
                }
                break;
        }
      }

      private boolean isCloseEvent(NativeEvent event)
      {
   	 	return event.getEventTarget().equals(img.getElement());//compares equality of the underlying DOM elements
      }
      
      public void registerDestroy(PopupMain impl)
      {
    	  this.impl = impl;
    	  
      }
      
      
      public void updateText(String text)
      {
    	  Element td = getCellElement(0, 1);
          DOM.removeChild(td, (Element) td.getFirstChildElement());
          DOM.appendChild(td, getHeaderString(text, MyImagesResource.getImages().close(),text));
         // super.setGlassEnabled(true);
      }
      
      
}
