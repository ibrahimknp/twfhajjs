package com.plus.app.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.KeyboardListenerAdapter;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.plus.app.client.impl.MyRefresh_Impl;
import com.plus.app.client.lang.Languages;
import com.plus.app.client.util.MyButton;
import com.plus.app.client.util.MyErrorBox;
import com.plus.app.client.util.MyFlexTable;
import com.plus.app.client.util.MyHTML;
import com.plus.app.client.util.MyPasswordTextBox;
import com.plus.app.client.util.MyTextBox;
import com.plus.app.client.util.MyVerticalPanel;

public class Login_Screen extends Composite{
	
	private MyTextBox					txtUserName;
	
	private MyPasswordTextBox			txtPassword;
	private MyButton					cmdLogin;
//	public  static MyUpdatebleCombo			lstCord;
	
	public Login_Screen()
	{
		 
		MyVerticalPanel vMain = new MyVerticalPanel();
		vMain.setSize("370px", "250px");

		 
		txtUserName = new MyTextBox(200,15,Languages.constants.userName(),false);
		txtPassword = new MyPasswordTextBox(200,20,Languages.constants.password());
		cmdLogin = new MyButton(Languages.constants.login(),true,Languages.constants.plzWait());
		

		
		txtUserName.setStyleName("userName");
		txtUserName.setPlaceHolder("Username");
		
		txtPassword.setStyleName("password");
		txtPassword.setPlaceHolder("Password");
		
		cmdLogin.setStyleName("loginButton");
		txtUserName.setText("admin");
		txtPassword.setText("admin@123");
		
		MyVerticalPanel vTop = new MyVerticalPanel(true);
		vTop.setHeight("50px");
		vTop.addWidgetTop(new MyHTML("ESS-Authentication","loginTopLabel"));
		vTop.setStyleName("loginTopBack");
		
		MyVerticalPanel vBottom = new MyVerticalPanel(true);
		vBottom.setHeight("35px");
		vBottom.addWidgetTop(new MyHTML("© Copyright 2018, All rights reserved","copyright"));
		vBottom.setStyleName("loginBottomBack");
		
		MyFlexTable flex = new MyFlexTable();
		flex.setCellPadding(5);
		//flex.setWidget(0, 0, Util.getHTMLLabel(Languages.constants.userName(),"whiteLabel"),0);
		flex.setWidget(1, 0, txtUserName,0);
		//flex.setWidget(2, 0, Util.getHTMLLabel(Languages.constants.password(),"whiteLabel"),0);
		flex.setWidget(3, 0, txtPassword,0);
		flex.setWidget(4, 0, cmdLogin,2);
				
		
		Image img = new Image("images/scorecard.png");
		Image imgVertical_Line = new Image("images/vertical_line.png");
		
		
		MyVerticalPanel v = new MyVerticalPanel();
		v.addStyleName("loginBackgroundAN");
		v.setSize(300, 277);
		v.addWidget(vTop,1,1);
		v.addWidget(flex,1,1);
		v.addWidget(vBottom,1,1);
		
		MyFlexTable flexHori = new MyFlexTable();
		flexHori.setWidth(300);
		//flexHori.setWidget(0, 0, img, 0);
		//flexHori.setWidget(0, 1, imgVertical_Line, 1);
		flexHori.setWidget(0, 2, v, 0);
		
		//vMain.addWidgetHoriCenter(img);
		vMain.addWidgetHoriCenter(flexHori);
		
		
		initWidget(vMain);
		
//		lstCord = new MyUpdatebleCombo(150, "Cordinator", 0);
		 
		cmdLogin.addClickHandler(new MyHandler());
		txtUserName.addKeyboardListener(new MyHandler());
		txtPassword.addKeyboardListener(new MyHandler());
		
	/*	lstCord.getTxtBox().addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent arg0) 
			{
				StoreSessions.getInstance().loadCordinator(lstCord.getLstBox(), 101);
			}
		});
		
		lstCord.getLstBox().addChangeHandler(new ChangeHandler()
		{
			public void onChange(ChangeEvent arg0) 
			{
				try
				{
					MenuAction.main.refresh();
				}
				catch(Exception ee)
				{
					
				}
			}
		});
		*/
		
		
	}
	 
	
	class MyHandler extends KeyboardListenerAdapter implements ClickHandler  
	{
		public void onClick(ClickEvent event) 
		{
			/*GWT.runAsync(new RunAsyncCallback()
			{
				public void onSuccess() 
				{
					
				}
				public void onFailure(Throwable arg0) 
				{					
				}
			});
			*/
			cmdLogin.setText(Languages.constants.plzWait());
			cmdLogin.setDisabled(true);
			loginCommand();
		}
		
		public void onKeyPress(Widget w, final char c,int mode)
		{
			if((int)(c)==13)
			{
				/*GWT.runAsync(new RunAsyncCallback()
				{
					public void onSuccess() 
					{
												
					}
					public void onFailure(Throwable arg0) 
					{
						
					}
				});
			*/
				cmdLogin.setText(Languages.constants.plzWait());
				cmdLogin.setDisabled(true);
				 
				loginCommand();
			}		
		}
	}
	 
	public MyTextBox getTxtUserName() {
		return txtUserName;
	}

	 
	public void loginCommand()
	{
		 
		
		if(txtPassword.getText().length()==0 || txtUserName.getText().length()==0)
		{
			MyErrorBox.alert(Languages.constants.userNameCanNotBeBlank());
			return ;
		}
		redirectLogin();
		 
		
		
		
	}
	public void redirectLogin()
	{
		
		if(true)
		{   
			
					//LoadingMenus.loadMenus(lst);
					//LoadingMenus.loadMenuGroups(lst);
				
					loginSuccessfull();
		}
		
	}
	 
	public void loginSuccessfull()
	{
		
	
		RootPanel.get("main").remove(0);
		LeftMenu_Screen left = LeftMenu_Screen.getInstance();
		RootPanel.get("leftMenu").add(left);
		RootPanel.get("leftMenu").setWidth("200px");
		RootPanel.get("main").setStyleName("mainPanelD");
		if(LocaleInfo.getCurrentLocale().isRTL())
		DOM.setElementAttribute(RootPanel.get("main").getElement(), "align", "right");
		else
			DOM.setElementAttribute(RootPanel.get("main").getElement(), "align", "left");
		
		Home_Screen myMain=Home_Screen.getInstance();
		myMain.load();
		RootPanel.get("main").add(myMain);
		//RootPanel.get("menubar").add(Alerts_Bar.getInstance());
		
		//Login_Information_Top log = Login_Information_Top.getInstance();
		//RootPanel.get("loginName").add(log);
		RootPanel.get("lang").setVisible(false);
		RootPanel.get("msgBoard").getElement().setInnerHTML("");
		RootPanel.get("msgBoard").removeStyleName("msgBoard");
		RootPanel.get("frame").setWidth("100%");
		
	}	
	
	
	class Terms_Refresh implements MyRefresh_Impl
	{
		public void refresh(String item, String value) {
			// TODO Auto-generated method stub
			loginSuccessfull();
		}
	}
	
	
}
