package com.yesway.webnotify.cometd;

import org.cometd.bayeux.server.BayeuxServer.SubscriptionListener;
import org.cometd.bayeux.server.ServerChannel;
import org.cometd.bayeux.server.ServerSession;

public class ServerSessionListener implements SubscriptionListener{

	@Override
	public void subscribed(ServerSession session, ServerChannel channel) {
		// TODO Auto-generated method stub
		//System.out.println(session.getId() + " subscribed channel:" + channel);
	}

	@Override
	public void unsubscribed(ServerSession session, ServerChannel channel) {
		// TODO Auto-generated method stub
		//System.out.println(session.getId() + " UNsubscribed channel:" + channel);
		
	}


}
