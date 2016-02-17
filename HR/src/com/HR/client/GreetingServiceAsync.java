package com.HR.client;

import com.HR.shared.UserSessionInfo;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String username, String password, AsyncCallback<String> callback)
			throws IllegalArgumentException;

	void getUserSessionInfo(AsyncCallback<UserSessionInfo> asyncCallback);

	
}
