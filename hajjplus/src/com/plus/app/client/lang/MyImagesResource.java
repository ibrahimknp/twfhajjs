package com.plus.app.client.lang;

import com.google.gwt.core.client.GWT;

public class MyImagesResource {
	
	static Images img = (Images)GWT.create(Images.class);
	
	public static Images getImages()
	{
		return img;
	}

}
