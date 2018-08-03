package com.plus.app.client.operations;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.plus.app.client.SessionBean;
import com.plus.app.client.impl.MyRefresh_Impl;
import com.plus.app.client.impl.PopupMain;
import com.plus.app.client.util.MyButtonPanel;
import com.plus.app.client.util.MyDialogBox;
import com.plus.app.client.util.MyFlexTable;
import com.plus.app.client.util.MyListBox;
import com.plus.app.client.util.MyRadioButton;
import com.plus.app.client.util.MySearchWidget;
import com.plus.app.client.util.MyTextArea;
import com.plus.app.client.util.MyTextBox;
import com.plus.app.client.util.MyVerticalPanel;

public class Hajies_Master_Screen extends Composite implements PopupMain,MyRefresh_Impl{
	
	MyButtonPanel				cmdButtons;
	private MyDialogBox			dialog;
	private MyRefresh_Impl		impl;
	private MyListBox			lstNationality,lstGender,lstIdType,lstBlood;
	private MyRadioButton		rbDiabeticYes,rbDiabeticNo,rbHyperYes,rbHyperNo,rbChestYes,rbChestNo,rbHeartYes,rbHeartNo,rbOperationYes,rbOperationNo;
	private MyTextBox			txtFirstName,txtLastName,txtIdNumber;
	private MyTextArea			textDescription;	
	MyRefresh_Impl 				IMPL;
	
	
	
	private static Hajies_Master_Screen instance;
	public static Hajies_Master_Screen getInstance()
	{
		if(instance == null)
			instance = new Hajies_Master_Screen();
		
		return instance;
	}
	
	public Hajies_Master_Screen() {
		// TODO Auto-generated constructor stub
		dialog = new MyDialogBox("Add Hajjies","Hajies_Master_Screen");
		dialog.registerDestroy(this);
		MyVerticalPanel vMain = new MyVerticalPanel();
		vMain.setSize(800, 150);
		
		
		lstNationality = new MyListBox(250, "Nationality", 0);
		lstGender = new MyListBox(250, "Gender", 0);
		lstIdType = new MyListBox(250, "ID Type", 0);
		lstBlood= new MyListBox(250, "Blood Group", 0);
		
		rbDiabeticYes = new MyRadioButton("diabtetic", "Yes");
		rbDiabeticNo = new MyRadioButton("diabtetic", "No");
		rbHyperYes = new MyRadioButton("hyper", "Yes");
		rbHyperNo = new MyRadioButton("hyper", "No");
		rbChestYes = new MyRadioButton("Chest", "Yes");
		rbChestNo = new MyRadioButton("Chest", "No");
		rbHeartYes = new MyRadioButton("heart", "Yes");
		rbHeartNo = new MyRadioButton("heart", "No");
		rbOperationYes = new MyRadioButton("Operation", "No");
		rbOperationNo = new MyRadioButton("Operation", "No");
		
		txtFirstName = new MyTextBox(250, 50, "First Name", false);
		txtLastName = new MyTextBox(250, 50, "Last Name", false);
		txtIdNumber = new MyTextBox(250, 50, "ID No", false);
		
		textDescription = new MyTextArea(680, 100, "Description");
		
		
		cmdButtons = new MyButtonPanel();
		
		
		
		MyFlexTable flex = new MyFlexTable();
		flex.setCellPadding(3);
		flex.setColumnWidth(0, 170);
		//flex.setColumnWidth(2, 100);
		flex.setColumnWidth(3, 150);
		
		flex.setWidget(0, 0, txtFirstName.getNameValue(), 0);
		flex.setWidget(0, 1, txtFirstName, 0);
		flex.setWidget(0, 3, txtLastName.getNameValue(), 0);
		flex.setWidget(0, 4, txtLastName, 0);
		
		flex.setWidget(1, 0, lstGender.getNameValue(), 0);
		flex.setWidget(1, 1, lstGender, 0);		
		flex.setWidget(1, 3, lstNationality.getNameValue(), 0);
		flex.setWidget(1, 4, lstNationality, 0);
		
		flex.setWidget(2, 0, lstIdType.getNameValue(), 0);
		flex.setWidget(2, 1, lstIdType, 0);		
		flex.setWidget(2, 3, txtIdNumber.getNameValue(), 0);
		flex.setWidget(2, 4, txtIdNumber, 0);
		
		flex.setWidget(3, 0, lstBlood.getNameValue(), 0);
		flex.setWidget(3, 1, lstBlood, 0);		
		flex.setWidget(3, 3, "Diabetic", 0);
		flex.setWidget(3, 4, new MySearchWidget(new Widget[]{rbDiabeticYes,rbDiabeticNo}), 0);
		
		flex.setWidget(4, 0, "Hyper Tension", 0);
		flex.setWidget(4, 1, new MySearchWidget(new Widget[]{rbHyperYes,rbHyperNo}), 0);
		flex.setWidget(4, 3, "Chest Disease", 0);
		flex.setWidget(4, 4, new MySearchWidget(new Widget[]{rbChestYes,rbChestNo}), 0);
		
		flex.setWidget(5, 0, "Heart Disease", 0);
		flex.setWidget(5, 1, new MySearchWidget(new Widget[]{rbHeartYes,rbHeartNo}), 0);
		flex.setWidget(5, 3, "Operation", 0);
		flex.setWidget(5, 4, new MySearchWidget(new Widget[]{rbOperationYes,rbOperationNo}), 0);
		
		flex.setWidget(6, 0, textDescription.getNameValue(), 0);
		flex.setColspan(6, 1, 4);
		flex.setWidget(6, 1, textDescription, 0);
		
		flex.setWidget(7, 1, cmdButtons, 0);
		
		vMain.addWidgetTop(flex);
		
		
		dialog.add(vMain);
		
		
		
		
		cmdButtons.getCmdReset().addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent arg0) 
			{
				clear();
			}
		});
		
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
		txtFirstName.clear();
		textDescription.clear();
		lstNationality.reset();
		lstIdType.reset();
		lstGender.reset();
		cmdButtons.updateEnable(false);
	}

	@Override
	public void setPrevs(String menuId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SessionBean getSession() {
		// TODO Auto-generated method stub
		return SessionBean.getInstance();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		dialog.show();
	}

	@Override
	public void refresh(String item, String value) {
		// TODO Auto-generated method stub
		
	}
	
	public void init()
	{
		
	}
	

	
	public void registerRefresh(MyRefresh_Impl impl)
	{
		IMPL = impl;
	}
}
