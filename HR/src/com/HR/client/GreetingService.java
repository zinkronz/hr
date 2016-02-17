package com.HR.client;


import com.HR.shared.UserSessionInfo;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String greetServer(String username, String password);

	UserSessionInfo getUserSessionInfo() throws NotLoggedInException;
	
	@SuppressWarnings("serial")
	static class NotLoggedInException extends Exception {}
}
