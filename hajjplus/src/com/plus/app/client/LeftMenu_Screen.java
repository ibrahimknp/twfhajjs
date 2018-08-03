package com.plus.app.client;

import java.util.HashMap;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;
import com.plus.app.client.lang.MyImagesResource;
import com.plus.app.client.masters.Browse_Area_Screen;
import com.plus.app.client.masters.Browse_CaseTypes_Screen;
import com.plus.app.client.masters.Browse_City_Screen;
import com.plus.app.client.operations.Browse_Complaints_Screen;
import com.plus.app.client.operations.Hajies_Master_Screen;
import com.plus.app.client.util.MyDecoratedStackPanel;
import com.plus.app.client.util.MyErrorBox;
import com.plus.app.client.util.MyVerticalPanel;
import com.plus.app.shared.Utils;

public class LeftMenu_Screen extends Composite{

	HashMap					hashHeader;
	
	private static LeftMenu_Screen		instance;

	public static LeftMenu_Screen	getInstance()
	{
		if(instance == null)
			instance = new LeftMenu_Screen();

		return instance;
	}


	public LeftMenu_Screen()
	{
	 	MyVerticalPanel vMain = new MyVerticalPanel();
		vMain.addStyleName("leftMenu");
		vMain.setSize("100%", "90%");

		MyDecoratedStackPanel stack = new MyDecoratedStackPanel();
		stack.setStyleName("navigation-menu");
		stack.addStyleName("browse-content");
		stack.setWidth("100%");
	 	stack.addWidget(designMenus(1001), "Home",MyImagesResource.getImages().dashboard(), true);
	 	stack.addWidget(designMenus(1002), "Masters",MyImagesResource.getImages().controlPanel(), true);
	 	stack.addWidget(designMenus(1003), "Operations",MyImagesResource.getImages().organisation(), true);
	 	
		vMain.addWidget(stack,0);

		initWidget(vMain);

	}

	public Widget designMenus(Integer headerId)
	{
		MyVerticalPanel v = new MyVerticalPanel();
		v.setSize("200px", "100%");

		MenuBar bar = new MenuBar(true);
		bar.setWidth("100%");

				if(headerId==1001)
				{
					final MenuItem menuItem = new MenuItem(Utils.getMenuString("Dashboard",MyImagesResource.getImages().treeOpen()),true,new Cmd());
					menuItem.setCommand(new Command()
					{
						public void execute()
						{
									new MenuAction(1,"1-1-1-1",Home_Screen.getInstance()).executeMenu();
						}
					});
					bar.addItem(menuItem);
				}
				else if(headerId==1002)
				{
					MenuItem menuItem = new MenuItem(Utils.getMenuString("Cities",MyImagesResource.getImages().treeOpen()),true,new Cmd());
					menuItem.setCommand(new Command()
					{
						public void execute()
						{
									new MenuAction(1,"1-1-1-1",Browse_City_Screen.getInstance()).executeMenu();
						}
					});
					bar.addItem(menuItem);
					menuItem = new MenuItem(Utils.getMenuString("Areas",MyImagesResource.getImages().treeOpen()),true,new Cmd());
					menuItem.setCommand(new Command()
					{
						public void execute()
						{
									new MenuAction(1,"1-1-1-1",Browse_Area_Screen.getInstance()).executeMenu();
						}
					});
					bar.addItem(menuItem);
					menuItem = new MenuItem(Utils.getMenuString("Jobs",MyImagesResource.getImages().treeOpen()),true,new Cmd());
					menuItem.setCommand(new Command()
					{
						public void execute()
						{
									new MenuAction(1,"1-1-1-1",Home_Screen.getInstance()).executeMenu();
						}
					});
					//bar.addItem(menuItem);
					menuItem = new MenuItem(Utils.getMenuString("Case Types",MyImagesResource.getImages().treeOpen()),true,new Cmd());
					menuItem.setCommand(new Command()
					{
						public void execute()
						{
									new MenuAction(1,"1-1-1-1",Browse_CaseTypes_Screen.getInstance()).executeMenu();
						}
					});
					bar.addItem(menuItem);
				}
				else if(headerId==1003)
				{
					MenuItem menuItem = new MenuItem(Utils.getMenuString("Hajjies",MyImagesResource.getImages().treeOpen()),true,new Cmd());
					menuItem.setCommand(new Command()
					{
						public void execute()
						{
									//new MenuAction(1,"1-1-1-1",Home_Screen.getInstance()).executeMenu();
									Hajies_Master_Screen haj =  Hajies_Master_Screen.getInstance();
									PopupAction.getInstance().show(haj);
						}
					});
					bar.addItem(menuItem);
					menuItem = new MenuItem(Utils.getMenuString("Medical Centers",MyImagesResource.getImages().treeOpen()),true,new Cmd());
					menuItem.setCommand(new Command()
					{
						public void execute()
						{
									new MenuAction(1,"1-1-1-1",Home_Screen.getInstance()).executeMenu();
						}
					});
					bar.addItem(menuItem);
					menuItem = new MenuItem(Utils.getMenuString("Complaints",MyImagesResource.getImages().treeOpen()),true,new Cmd());
					menuItem.setCommand(new Command()
					{
						public void execute()
						{
									new MenuAction(1,"1-1-1-1",Browse_Complaints_Screen.getInstance()).executeMenu();
						}
					});
					bar.addItem(menuItem);
				}
					

		
		v.addWidget(bar,0);
		return v;
	}

	class Cmd implements Command
	{
		public void execute()
		{
			MyErrorBox.alert("Under construction..");
		}
	}

	
}
