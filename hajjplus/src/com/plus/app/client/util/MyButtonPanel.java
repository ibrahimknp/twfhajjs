package com.plus.app.client.util;

import com.google.gwt.user.client.ui.Composite;

public class MyButtonPanel extends Composite{
	
	public MyButton		cmdSave,cmdReset,cmdUpdate;
	private boolean			UPDATE = false;
	
	public MyButtonPanel()
	{
		cmdSave = new MyButton("Save", true, null);
		cmdReset = new MyButton("Reset", false, null);
		cmdUpdate = new MyButton("Update", true, null);
		
		MyHorizontalPanel hori = new MyHorizontalPanel();
		hori.addWidget(cmdSave, 1);
		hori.addWidget(cmdReset, 1);
		hori.addWidget(cmdUpdate, 1);
		
		initWidget(hori);
	}
	
	public void saveReset()
	{
		cmdSave.setText(cmdSave.getTitle());
		cmdReset.setText(cmdReset.getTitle());
		cmdUpdate.setText(cmdUpdate.getTitle());
		
		 cmdSave.setDisabled(false);
		 cmdUpdate.setDisabled(true);
		 cmdReset.setDisabled(false);
		 
	}
	public void updateReset()
	{
		cmdSave.setText(cmdSave.getTitle());
		cmdReset.setText(cmdReset.getTitle());
		cmdUpdate.setText(cmdUpdate.getTitle());
		
		 cmdSave.setDisabled(true);
		 cmdUpdate.setDisabled(false);
		 cmdReset.setDisabled(false);
		
	}
	
	public MyButton getCmdSave() {
		return cmdSave;
	}

	public void setCmdSave(MyButton cmdSave) {
		this.cmdSave = cmdSave;
	}

	public MyButton getCmdReset() {
		return cmdReset;
	}

	public void setCmdReset(MyButton cmdReset) {
		this.cmdReset = cmdReset;
	}

	public MyButton getCmdUpdate() {
		return cmdUpdate;
	}

	public void setCmdUpdate(MyButton cmdUpdate) {
		this.cmdUpdate = cmdUpdate;
	}
	
	private void setPr(String prevs)
	{
		String str[]=prevs.split("-");
		int save=Integer.parseInt(str[0]);
		int update=Integer.parseInt(str[1]);
		int delete=Integer.parseInt(str[2]);
		int browse=Integer.parseInt(str[3]);
		
		if(save == 1)
			cmdSave.setVisible(true);
		else
			cmdSave.setVisible(false);
		
		if(update == 1)
			cmdUpdate.setVisible(true);
		else
			cmdUpdate.setVisible(false);		
		
	}
	
	public void setPrevs(String menuId)
	{
		String prevs=Util.getPrivilege(menuId);
		//System.out.println(prevs);
		setPr(prevs);
	}

	public void updateEnable(boolean enable)
	{
		UPDATE = enable;
		
		cmdSave.setDisabled(enable);
		cmdUpdate.setDisabled(!enable);
	}

}
