package com.plus.app.client.util;

import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class LoadingGadgetPopup implements ClickListener
{
	static int width,height;
    PopupPanel popup;
    PopupPanel glass;
    
    private static LoadingGadgetPopup instance;
    public static LoadingGadgetPopup getInstance(int w,int h)
    {
    	width = w;
    	height = h+25;
    	
    	if(instance == null )
    		instance = new LoadingGadgetPopup("Please wait...",false);
    	
    	return instance;
    }
    public LoadingGadgetPopup(String message, boolean addDefaultStyles)
    {
        /*********************************************
         * A glass panel or 'blinder'
         * to wash out the current screen
         ********************************************/
        glass = new PopupPanel();
        glass.setStyleName("rx-glass");
        /*
         * Set full screen
         */
        DOM.setStyleAttribute(glass.getElement(), "width", width+"px");
        DOM.setStyleAttribute(glass.getElement(), "height", height+"px");
        /*
         * Add default styles if required
         */
        if (addDefaultStyles)
        {
            DOM.setStyleAttribute(glass.getElement(),
                 "backgroundColor", "#000");
            DOM.setStyleAttribute(glass.getElement(),
                 "opacity", "0.70");
            DOM.setStyleAttribute(glass.getElement(),
                 "opacity", "0.70");
            DOM.setStyleAttribute(glass.getElement(),
                 "filter",  " alpha(opacity=70)");
        }
        /**********************************************
         * A popup
         *********************************************/
        popup = new PopupPanel(false);
        popup.setStyleName("rx-BlindedPopup");
        /*
         * Add default styles if required
         */
        if (addDefaultStyles)
        {
            DOM.setStyleAttribute(popup.getElement(),
                "backgroundColor", "#fff");
            DOM.setStyleAttribute(popup.getElement(), "border", "3px solid #009");
        }
        /*
         * Popups can only hold one widget,
         * so we need something to keep all
         * our bits in
         */
        VerticalPanel popupContents = new VerticalPanel();
        /*
         * The header element
         */
        Label header = new Label("BlindedPopup Demo");
        header.setStyleName("rx-BlindedPopup-header");
        if (addDefaultStyles)
        {
            DOM.setStyleAttribute(header.getElement(),
                "backgroundColor", "#ff0");
            DOM.setStyleAttribute(header.getElement(),
                "borderBottom", "3px solid #009");
            DOM.setStyleAttribute(header.getElement(),
                "fontWeight", "bold");
            DOM.setStyleAttribute(header.getElement(),
                "fontSize", "90%");
            DOM.setStyleAttribute(header.getElement(),
                "padding", "5px");
            DOM.setStyleAttribute(header.getElement(),
                "textAlign", "center");
        }
        /*
         * The main element
         */
        HTML html = new HTML(message);
        html.setStyleName("rx-BlindedPopup-message");
        if (addDefaultStyles)
        {
            DOM.setStyleAttribute(html.getElement(),
                "fontSize", "80%");
            DOM.setStyleAttribute(html.getElement(),
                "padding", "15px");
        }
        /*
         * A button to close the popup
         */
        
        /*
         * Assemble it all
         */
        //popupContents.add(MyLoadedImages.approved());
        //popupContents.add(html);
       // popup.add(popupContents);
        Image img=new Image("images/loader.gif");
        MyVerticalPanel v=new MyVerticalPanel();
        v.setHeight("100%");
        v.setWidth("100%");
        v.addWidget(img, 1, 1);
        glass.add(v);
        
        /*
         * Show the glass first, then the popup will be over it
         */
        glass.show();
        //popup.center();
    }
    public void onClick(Widget sender)
    {
        //popup.hide();
        glass.hide();
    }
    
    public void show(Image imgclose)
    {
    	
    	//eight())).show((getMain().imgclose.getAbsoluteLeft()-getWidth()+18),(getMain().imgclose.getAbsoluteTop()+22));
    	if(LocaleInfo.getCurrentLocale().isRTL())
    	{
	    	int x= (imgclose.getAbsoluteLeft())-5 ;
	    	int y = (imgclose.getAbsoluteTop()-4);
	    	glass.setPopupPosition(x, y);
	    	glass.show();
	    	//popup.show();
    	}
    	else
    	{
    		int x= (imgclose.getAbsoluteLeft()-width)+18 ;
	    	int y = (imgclose.getAbsoluteTop()- 4);
	    	glass.setPopupPosition(x, y);
	    	glass.show();
	    	//popup.show();
    	}
        
        
    }
    public void show(Widget wid)
    {
    	//System.out.println(wid.getAbsoluteLeft()+" : "+wid.getAbsoluteTop());
    	//eight())).show((getMain().imgclose.getAbsoluteLeft()-getWidth()+18),(getMain().imgclose.getAbsoluteTop()+22));
    	if(LocaleInfo.getCurrentLocale().isRTL())
    	{
	    	int x= (wid.getAbsoluteLeft())-5 ;
	    	int y = (wid.getAbsoluteTop()-4);
	    	glass.setPopupPosition(x, y);
	    	glass.show();
	    	//popup.show();
    	}
    	else
    	{
    		int x= (wid.getAbsoluteLeft());
	    	int y = (wid.getAbsoluteTop());
	    	glass.setPopupPosition(x, y);
	    	glass.show();
	    	//popup.show();
    	}
        
        
    }
    public void hide()
    {
    	//popup.hide();
        glass.hide();
    }
}
