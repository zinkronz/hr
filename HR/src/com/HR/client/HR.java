package com.HR.client;

import com.HR.shared.FieldVerifier;
import com.HR.shared.UserSessionInfo;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class HR implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	
	
	int currentWidth=0;
	int currentHeight=0;
	String currentWidthString;
	String currentHeightString; 
	int testOn=1;
	VerticalPanel mainVerticalPanel = new VerticalPanel();
	HorizontalPanel mainHorizontalPanel = new HorizontalPanel();
	HorizontalPanel mainHorizontalPanel2 = new HorizontalPanel();
	HorizontalPanel mainHorizontalPanel2_ = new HorizontalPanel();
	HorizontalPanel mainHorizontalPanel3 = new HorizontalPanel();
	HorizontalPanel mainHorizontalPanel4 = new HorizontalPanel();
	HorizontalPanel mainHorizontalPanel5 = new HorizontalPanel();
	HorizontalPanel mainHorizontalPanel6 = new HorizontalPanel();
	HorizontalPanel mainHorizontalPanel7 = new HorizontalPanel();
	HorizontalPanel mainHorizontalPanel8 = new HorizontalPanel();
	private UserSessionInfo userInfo = null;
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		getUserSessionInfo ();
		
	}
		private void onLoginScreeen() {
		screenSize();
		
		Image imageLogo = new Image();
		Image imageLogo2 = new Image();
		imageLogo.setWidth("100px");
		imageLogo.setUrl("/Images/Logo.png");
		imageLogo2.setWidth("100px");
		imageLogo2.setUrl("http://127.0.0.1:8888/hr/images/Logo2.jpg");
		imageLogo.getElement().getStyle().setPaddingRight(10.00,Style.Unit.PX);
		//Window.alert("Hostname: "+Window.Location.getHostName());
		//Window.alert("href: "+Window.Location.getHref());
		
		
		String loginWidth="700px";
		
	
		mainHorizontalPanel2_.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		mainHorizontalPanel2_.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		//mainHorizontalPanel2_.getElement().getStyle().setBackgroundColor("red");
		mainHorizontalPanel2_.add(imageLogo);
		mainHorizontalPanel2_.add(new Label("Malaysia"));
		
		mainHorizontalPanel2.setWidth(currentWidthString);
		mainHorizontalPanel2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		mainHorizontalPanel2.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
		mainHorizontalPanel2.setHeight("50px");
		mainHorizontalPanel2.addStyleName("line");
		
		mainHorizontalPanel3.setWidth(loginWidth);
		mainHorizontalPanel3.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		mainHorizontalPanel3.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		
		mainHorizontalPanel3.setHeight("40px");
		mainHorizontalPanel3.addStyleName("line_thin");
		mainHorizontalPanel3.add(new Label("Online CPS"));
		//mainHorizontalPanel3.getElement().getStyle().setBackgroundColor("red");
		
		/*final Grid gridLogin = new Grid();
		for (int row = 0; row < 5; row++) {
			gridLogin.setWidget(row, row, new HTML("&NBSP"));
		    }*/
		
		final FlexTable flexTable = new FlexTable();
		Label loginLbl = new Label("Login");
		loginLbl.getElement().getStyle().setFontSize(13, Style.Unit.PX);
		Label usernameLbl = new Label("Username:");
		usernameLbl.getElement().getStyle().setFontSize(13, Style.Unit.PX);
		Label passwordLbl = new Label("Password:");
		passwordLbl.getElement().getStyle().setFontSize(13, Style.Unit.PX);
		
		
		flexTable.setWidget(0, 0, loginLbl);
		flexTable.setWidget(1, 0, new HTML("&nbsp"));
		flexTable.setWidget(2, 0, usernameLbl);
		//flexTable.setWidget(3, 0, new HTML("&nbsp"));
		flexTable.setWidget(4, 0, passwordLbl);
		
		
		final TextBox userNameTextBox = new TextBox();
		final PasswordTextBox passwordTextBox = new PasswordTextBox();
		
		
		
		final Button loginButton = new Button("Login");
		userNameTextBox.setHeight("10px");
		passwordTextBox.setHeight("10px");
		userNameTextBox.setWidth("200px");
		passwordTextBox.setWidth("200px");
		
		userNameTextBox.setText("fahmi");
		passwordTextBox.setText("fahmi");
		
		final DialogBox dialogBox = createDialogBox();
	    dialogBox.setGlassEnabled(true);
	    dialogBox.setAnimationEnabled(true);
		Hyperlink linkForgotPassword = new Hyperlink("Forgot Password?","s");
		linkForgotPassword.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				dialogBox.center();
				dialogBox.show();			
				
			}		
			
		});
		passwordTextBox.addKeyDownHandler(new KeyDownHandler() {

		  
			@Override
			public void onKeyDown(KeyDownEvent event) {
				 if(event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					 if(passwordTextBox.getText().trim().isEmpty()){
		                 Window.alert("password empty");
		           }
						 else {loginButton.click();}
	           }
				
			}
		});
		
		userNameTextBox.addKeyDownHandler(new KeyDownHandler() {
		
		
			@Override
			public void onKeyDown(KeyDownEvent event) {
				 if(event.getNativeKeyCode() == KeyCodes.KEY_ENTER ) {
					 if(userNameTextBox.getText().trim().isEmpty()){
	                 Window.alert("username empty");
	           }
					 else {loginButton.click();}
				
			
		}}});
		
		loginButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
			
				            sendNameToServer();
				            
					
			}

					private void sendNameToServer() {
				
				greetingService.greetServer(userNameTextBox.getText(),passwordTextBox.getText(),
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								Window.alert("System down/error. Please try again later. "+caught.getMessage());
							}

							public void onSuccess(String result) {
							
								if (result.equals("correct")){
									
									onModuleStart();
									
								}
								else {
									
									
									Window.alert("Invalid username or password");
									
									
								}
							
							}
						});
				
			}});

		
		HorizontalPanel loginAndPasswordPanel =new HorizontalPanel();
		loginAndPasswordPanel.add(loginButton);
		loginAndPasswordPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		loginAndPasswordPanel.add(new HTML("&nbsp;"));
		loginAndPasswordPanel.add(new HTML("&nbsp;"));
		loginAndPasswordPanel.add(new HTML("&nbsp;"));
		loginAndPasswordPanel.add(new HTML("&nbsp;"));
		loginAndPasswordPanel.add(linkForgotPassword);
		
		flexTable.setWidget(2, 1, userNameTextBox);
		flexTable.setWidget(4, 1, passwordTextBox);
		flexTable.setWidget(5, 1, new HTML("&nbsp;"));
		flexTable.setWidget(6, 1, loginAndPasswordPanel);
		
		
		
	    //flexTable.addStyleName("cw-FlexTable");
	    //flexTable.setWidth("32em");
	    //flexTable.setCellSpacing(5);
	   // flexTable.setCellPadding(3);
	    
		DecoratorPanel loginPanel = new DecoratorPanel();
		loginPanel.add(flexTable);
		mainHorizontalPanel4.add(loginPanel);
		mainHorizontalPanel4.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		mainHorizontalPanel4.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		//mainHorizontalPanel4.getElement().getStyle().setBackgroundColor("yellow");
		mainHorizontalPanel4.setWidth(loginWidth);
		mainHorizontalPanel4.setHeight("350px");
		
		mainHorizontalPanel2.add(mainHorizontalPanel2_);
		/*mainVerticalPanel.add(mainHorizontalPanel2);
		mainVerticalPanel.add(mainHorizontalPanel3);
		mainVerticalPanel.add(mainHorizontalPanel4);
		mainVerticalPanel.add(mainHorizontalPanel5);
		mainVerticalPanel.add(mainHorizontalPanel6);
		mainVerticalPanel.add(mainHorizontalPanel7);
		mainVerticalPanel.add(mainHorizontalPanel8);*/
		
		
		
		
		final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");
		final Label errorLabel = new Label();

		
		//Main UI to display
		mainVerticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		mainVerticalPanel.add(mainHorizontalPanel2);
		mainVerticalPanel.add(mainHorizontalPanel3);
		mainVerticalPanel.add(new HTML("&nbsp"));
		mainVerticalPanel.add(new HTML("&nbsp"));
		mainVerticalPanel.add(mainHorizontalPanel4);
		
		// Frame frame = new Frame("http://www.hlive.my");
		// frame.setWidth("900px");
		 //frame.setHeight("900px");
		 //mainVerticalPanel.add(frame);
		
		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("Top").add(mainVerticalPanel);
		//RootPanel.get("nameFieldContainer").add(nameField);
		/*RootPanel.get("sendButtonContainer").add(sendButton);*/
		/*RootPanel.get("errorLabelContainer").add(errorLabel);*/

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Create the popup dialog box
		
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			public void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				//String password = passwordField.
				

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer,"",
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								dialogBox
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}

							public void onSuccess(String result) {
								dialogBox.setText("Remote Procedure Call");
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(result);
								dialogBox.center();
								closeButton.setFocus(true);
							}
						});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);
	}

	private void getUserSessionInfo() {
		 greetingService.getUserSessionInfo (new AsyncCallback<UserSessionInfo> () {
		      public void onFailure(Throwable caught) 
		      {
		         Window.alert ("You have not logged in yet. Refresh this page to try again."+ caught.getMessage());
		         onLoginScreeen();
				}

		      public void onSuccess (UserSessionInfo result) 
		      {
		         userInfo = result;
		         onModuleStart();
		      }
		   });
		
	}

	//main System Start after login
	protected void onModuleStart() {
		mainVerticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		mainVerticalPanel.remove(mainHorizontalPanel3);
		mainVerticalPanel.remove(mainHorizontalPanel4);		
		mainVerticalPanel.remove(mainHorizontalPanel4);
		
		
		
		
		
		
	}


	private DialogBox createDialogBox() {
		
		// Create a dialog box and set the caption text
	    final DialogBox dialogBox = new DialogBox();
	    dialogBox.ensureDebugId("cwDialogBox");
	    dialogBox.setText("Password Recovery");

	    // Create a table to layout the content
	    VerticalPanel dialogContents = new VerticalPanel();
	    dialogContents.setSpacing(4);
	    dialogBox.setWidget(dialogContents);

	    // Add some text to the top of the dialog
	    HTML details = new HTML("Password and username Recovery");
	    dialogContents.add(details);
	    dialogContents.setCellHorizontalAlignment(
	        details, HasHorizontalAlignment.ALIGN_CENTER);

	 /*   // Add an image to the dialog
	    Image image = new Image(Showcase.images.jimmy());
	    dialogContents.add(image);
	    dialogContents.setCellHorizontalAlignment(
	        image, HasHorizontalAlignment.ALIGN_CENTER);*/

	    // Add a close button at the bottom of the dialog
	    Button closeButton = new Button(
	       "", new ClickHandler() {
	          public void onClick(ClickEvent event) {
	            dialogBox.hide();
	            //test datastore
	         

	
	          } });
	    dialogContents.add(closeButton);
	    if (LocaleInfo.getCurrentLocale().isRTL()) {
	      dialogContents.setCellHorizontalAlignment(
	          closeButton, HasHorizontalAlignment.ALIGN_LEFT);

	    } else {
	      dialogContents.setCellHorizontalAlignment(
	          closeButton, HasHorizontalAlignment.ALIGN_RIGHT);
	    }

	    // Return the dialog box
	    return dialogBox;
				
	}


	private void screenSize() {
		currentWidth=Window.getClientWidth()-30;
		currentHeight=Window.getClientHeight()-20;		
		currentWidthString=currentWidth+"px";
		currentHeightString=currentHeight+"px";
		
	}
}
