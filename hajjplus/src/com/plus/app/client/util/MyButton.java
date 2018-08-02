package com.plus.app.client.util;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

public class MyButton extends Composite{

	private Button		cmd;

	/**
	 *
	 * @param txt			text display on Button
	 * @param loading		if true then it will be disable on click
	 * @param loadingMsg	if msg will be null then it will display Wait.. Message else pass the loading message
	 */
	public MyButton(String txt,final boolean loading,final String loadingMsg)
	{
			cmd = new Button(txt);
			cmd.setTitle(cmd.getText());

			initWidget(cmd);

			if(loading)
			{
				cmd.addClickHandler(new ClickHandler()
				{

					public void onClick(ClickEvent event)
					{
						cmd.setTitle(cmd.getText());

						if(loadingMsg==null)
							cmd.setText("Wait..");
							else
								cmd.setText(loadingMsg);

							setDisabled(true);
					}
				});
			}
	}

	public void setDisabled(boolean value)
	{
		cmd.setEnabled(!value);
	}

	public void addClickHandler(ClickHandler handler)
	{
		cmd.addClickHandler(handler);
	}
	
	public void setVisible(boolean visible)
	{
		cmd.setVisible(visible);
	}

	public String getText()
	{
		return cmd.getText();
	}
	public String getTitle()
	{
		return cmd.getTitle();
	}
	public void setText(String text)
	{
		cmd.setText(text);
	}
	public boolean isEnabled()
	{
		return cmd.isEnabled();
	}

	/**
	 *
	 * @param menuId pass the id of the Menu
	 * @param prev pass the prev's parameter.. 1 for prev1 , 2 for prev2 , 3 for prev4 and 4 for prev4
	 */
	public void setPrevs(String menuId,int pos)
	{
		String prevs=Util.getPrivilege(menuId);
		boolean check=Util.setPrviliage(prevs,this,pos);
		//System.out.println(menuId+ " : "+prevs+" : "+check);
		cmd.setVisible(check);
	}

	public void reset()
	{
		cmd.setText(cmd.getTitle());
		cmd.setEnabled(true);

	}

	public void colorButton()
	{
		cmd.addStyleName("colorButton");
	}
}
