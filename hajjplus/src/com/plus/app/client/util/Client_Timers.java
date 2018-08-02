package com.plus.app.client.util;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.plus.app.client.SessionBean;
import com.plus.app.client.RPCConnection.Generic_Connection;
import com.plus.app.shared.dao.Generic_Wrapper;

public class Client_Timers {

	private static int COUNTER = 1800;

	private static final Timer SESSION_MAY_HAVE_EXPIRED_TIMER = new Timer() {

        @Override
        public void run() {
            // Warn the user, that the session may have expired.
            // You could then show a login dialog, etc...
        	//Window.alert("Your session is expired");
        	if(COUNTER<=0)
        	{
        		try
				{
        			Generic_Wrapper meta = new Generic_Wrapper();
					//.setQuery("update Login_History set lh_online_status=0 where lh_user_id="+SessionBean.getInstance().getUserPrevs().getUser_id());
					Generic_Connection.getRpcConnection().updateQuery(meta, new AsyncCallback<String>()
					{

						public void onSuccess(String arg0) {
							// TODO Auto-generated method stub
							Window.Location.reload();
						}

						public void onFailure(Throwable arg0) {
							// TODO Auto-generated method stub

						}
					});
				}
				catch(Exception ee){}
        		
        	}
        	else
        	{
        		
        		COUNTER --;
        		//System.out.println(COUNTER);
        	}
        }
    };

    public static void renewSessionTimer() {

        // First cancel the previous timer
        SESSION_MAY_HAVE_EXPIRED_TIMER.cancel();
        COUNTER = 1800;
        // Schedule again in 5 minutes (maybe make that configurable?)
        // Actually, let's subtract 10 seconds from that, because our timer
        // won't be synchronized perfectly with the server's timer.
        //SESSION_MAY_HAVE_EXPIRED_TIMER.scheduleRepeating(COUNTER * 60 * 1000 - 10000);
        SESSION_MAY_HAVE_EXPIRED_TIMER.scheduleRepeating(1 * 1000);
    }

    public static void mouseMovement()
	{
		Event.addNativePreviewHandler(new Event.NativePreviewHandler() {
			  public void onPreviewNativeEvent(NativePreviewEvent event) {
			    NativeEvent ne = event.getNativeEvent();
			    if (MouseMoveEvent.getType().getName().equals(ne.getType()))
			    {
			      /*Window.alert("who fired me last?"
			          + event.getNativeEvent().getCurrentEventTarget()
			          + "\nevent target:" + event.getNativeEvent().getEventTarget());
			          */
			    	Client_Timers.renewSessionTimer();
			    }
			  }
			});
	}
}
