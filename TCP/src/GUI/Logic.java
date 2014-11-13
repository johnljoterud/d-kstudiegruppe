package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import jsonClasses.*;
import tcpClasses.TCPClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Logic {

	public class GUILogic {
		private Container container;
		private String action;
		private int loggedIn;
		
		TCPClient tcp = new TCPClient();
		Gson gson = new GsonBuilder().create();
	
		public GUILogic(){
			container = new Container();
			
			container.getLoginPanel().addActionListener(new LoginPanelActionListener());
			container.getCalendarPanel().addActionListener(new CalendarPanelActionListener());
			
		}
	
		
		public void run() {

			container.show(Container.LOGINPANEL);
			container.setVisible(true);
		}
		private class LoginPanelActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {

					action = e.getActionCommand();

					String userName = container.getLoginPanel().getTextFieldUsername()
							.getText().trim();
					String pass = container.getLoginPanel().getTextFieldPassword()
							.getText();
										
					if ((action.equals("btnLogin"))) {
						System.out.println("hit1");
						
						//Creates object of jsonClasses.ClientLogin
						ClientLogin cl = new ClientLogin();
						//Sets login information
						cl.setEmail(userName);
						cl.setPassWord(pass);
						//Converts object to jsonString
						String gsonString = gson.toJson(cl);
						//Sends object to server using tcpClient.TCPClient and receives response as string serverResponse
						String serverResponse = tcp.TalkToServer(gsonString);
						System.out.println("hit2");
						
						//Uses serveResponse as a check for login confirmation
						if (serverResponse != "")

						{

							container.show(Container.CALENDARPANEL);

						}

						else if (loggedIn != 0) {
							JOptionPane.showMessageDialog(null,
									"\nLogin failed, error: " + loggedIn,
									"Error message", JOptionPane.PLAIN_MESSAGE);
						}

					}
				}catch (Exception e3) {
				}
			
		
		private class CalendarPanelActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
					if (e.getSource() == container.getCalendarPanel().getBtnDelKalender()) {
						container.show(Container.//class);
					}
					if (e.getSource() == container.getCalendarPanel().getBtnOpretKalender()) {
						container.show(Container.//class);
					}
					
			
		
	
			}
	}
}

							
	
