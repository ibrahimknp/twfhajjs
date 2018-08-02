package com.plus.app.client.util;
 

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.plus.app.client.SessionBean;
import com.plus.app.client.lang.Languages;
 

public class MyLogo extends Composite{

	public MyImage			img;
	public MyButton		    btnImg;
	public MyLabel		hypRemove,hypUpload;
 
	 
	private String id;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MyLogo()
	{
		MyVerticalPanel vMain = new MyVerticalPanel();
	    vMain.setWidth("140px");
	    btnImg=new MyButton(Languages.constants.uploadLogo(),false,"");
	    btnImg.setWidth("130px");
	    
		MyVerticalPanel vLabel = new MyVerticalPanel();
		vLabel.setSize(140, 10);
		vLabel.setBackgroundColor("#DEE2CD");
		Label ht = new Label(Languages.constants.companyLogo());
		vLabel.addWidget(ht,1,1);
				    
		MyVerticalPanel vImage = new MyVerticalPanel();
	    vImage.setBorder();
	    vImage.setWidth("100px");
		vImage.setHeight("100px");
	 
	    vImage.addWidget(vLabel,1,0);
	    vImage.setBackgroundColor("#E8E5E5");	   
	    
	    hypRemove = Util.makeLabel(Languages.constants.removeLogo());
	    hypUpload = Util.makeLabel(Languages.constants.uploadLogo());
	    hypRemove.addStyleName("hypColorBlue");
	    hypUpload.addStyleName("hypColorBlue");
	    hypRemove.setWidth("130px");
        hypUpload.setWidth("130px");
	  
	    hypRemove.addClickHandler(new ClickHandler() {
		 	public void onClick(ClickEvent arg0) {
					// TODO Auto-generated method stub
		 		removeFile();
				}
			});
	    
	    img =new MyImage(); 
	    img.setSize("80px", "80px");
	    img = new MyImage("images/agents/blanks.png");
	    img.addStyleName("imgLogo");
		
	    setUrl(null);
	   
	   
	    vImage.addWidget(Util.makeBlankWithHeight("10px"), 1, 1);
		vImage.addWidget(img, 1, 1);
		vImage.addWidget(Util.makeBlankWithHeight("10px"), 1, 1);
		vMain.addWidget(vImage, 1, 1);
		vMain.addWidget(hypRemove, 1, 1);		 
		vMain.addWidget(btnImg, 1, 1);
		initWidget(vMain);
	}
	 
	public void removeFile()
	{
		setUrl(null);
	}
	public void updateEnable(boolean bool)
	{
		if(bool)
		 btnImg.setText(Languages.constants.changeLogo());
		else
		 btnImg.setText(Languages.constants.uploadLogo());
	}
	public void clear()
	{
		 setUrl(null);
		 btnImg.setVisible(true);
	}
	private String passportNo;	
	
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	private String fileName;	 
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setBackground(String imageStyleName)
	{
		img.addStyleName(imageStyleName);
	}

	public void addClickHandler(ClickHandler click)
	{
		img.addClickHandler(click);
	}
	public void setUrl(String fileName)
	{
		if(fileName!=null)
		{
			 hypRemove.setVisible(true);
			  btnImg.setVisible(false);
			  hypUpload.setVisible(false);
			  img.setUrl(SessionBean.getInstance().getDownloadPath()+fileName);
		     
		}
		else
		{
			 img.setUrl("images/agents/blanks.png");
			 hypRemove.setVisible(false);
			 btnImg.setVisible(true);
			 hypUpload.setVisible(true);
		}
		setFileName(fileName);
	}
	public String getUrl()
	{
		return img.getUrl();
	}
	public void setVisible(boolean vis)
	{
		 
		img.setVisible(vis);
		 
	}
	public void setAltText(String txt)
	{
		img.setAltText(txt);
	}
	public SessionBean getSession() {
		// TODO Auto-generated method stub
		return SessionBean.getInstance();
	}
	 
	 
}
