package com.HR.server;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.jdo.PersistenceManager;

import com.HR.client.GreetingService;
import com.HR.shared.FieldVerifier;
import com.HR.shared.UserSessionInfo;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.HR.server.User;
import com.HR.server.Persistence;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {
	
	UserService userService = UserServiceFactory.getUserService();

	public class NotLoggedInException extends Exception {

	}

	public String greetServer(String input, String password) throws IllegalArgumentException {
		
		

		PersistenceManager pm = Persistence.getPersistenceManager();
		int id=0;
		String a="";
		
		int point = 0;
		try{
		User q = pm.getObjectById(User.class, input);
		if (q.password().equals(hashPassword(password))){
			
			a= "correct";
			getUserSessionInfo();
			return a;
			 
			
		}
		
		
		} catch(Exception e) {
		
		    try {
		    	String idRaw = null;
				String userName = null;
				String image = null;
				   String bio = null;
				   
				    
				    String website = null;
				   
				    
				    String full_name = null ;
				   
				User addUser=new User( idRaw,  userName, "",  "fahmi Musa", "JB",  "",  "81300",  "0186665234",
						   "", false, "", "", "", "", "") ;
				 	    	
			      pm.makePersistent(addUser);
			   
			    } finally {
			      pm.close();
			    }}
		
		
		

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

	
		
		
		
		
		
		
		return "wrong";
	}

			  private String hashPassword(String text) {
			  MessageDigest digest = null;
			try {
				digest = MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
			  StringBuffer hexString = new StringBuffer();

		        for (int i = 0; i < hash.length; i++) {
		            String hex = Integer.toHexString(0xff & hash[i]);
		            if(hex.length() == 1) hexString.append('0');
		            hexString.append(hex);
		        }

		        return hexString.toString();
	}


	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}

	@Override
	public UserSessionInfo getUserSessionInfo() throws GreetingService.NotLoggedInException
	{
		   // Before we do anything, check to see if the user is logged in.
		   
		   com.google.appengine.api.users.User user = checkUserLoggedIn (userService);
		   if (user == null) throw new GreetingService.NotLoggedInException ();

		   String loginUrl = userService.createLoginURL("/");
		   String logoutUrl = userService.createLogoutURL (loginUrl);
		   //UserSessionInfo info = new UserSessionInfo (user.getNickname (), user.getEmail (),
		                                               //loginUrl, logoutUrl);
		   return null;
	}


public com.google.appengine.api.users.User checkUserLoggedIn (UserService userService) throws GreetingService.NotLoggedInException
{
   if (!userService.isUserLoggedIn ()) throw new GreetingService.NotLoggedInException ();
  
   return userService.getCurrentUser ();
}
}
