package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import tcpClasses.TCPClient;
import GUI.Container;
import GUI.ShowCalendar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Logic {

	
		private Container container;

		TCPClient tcp = new TCPClient();
		Gson gson = new GsonBuilder().create();
//		int week;
//		int year;
	
		public Logic(){
			
		
			container = new Container();
			
//			container.getLoginPanel().addActionListener(new LoginPanelActionListener());
			container.getShowCalendar().addActionListener(new ShowCalendarActionListener());
			
			
		}
	
		
		public void run() {
//			container.getShowCalendar().refreshCalendar(week, year);
			container.show(Container.SHOWCALENDAR);
			container.setVisible(true);
		}
		
		
		private class ShowCalendarActionListener implements ActionListener{

			
			public void actionPerformed(ActionEvent e) {
				
//				if (e.getSource() == container.getShowCalendar().getBtnNext()){
//					week = container.getShowCalendar().getCurrentWeek();
//					year = container.getShowCalendar().getCurrentYear();
//					if (week == 52) { // Foward one year
//						container.getShowCalendar().setCurrentWeek(1);
//						container.getShowCalendar().setCurrentYear(year += 1);
//					} else { // Foward one month
//						container.getShowCalendar().setCurrentWeek(week +=1);
//					}
//					container.getShowCalendar().refreshCalendar(container.getShowCalendar().getCurrentWeek(), container.getShowCalendar().getCurrentYear());
//					System.out.println(("current week: " + week + "\n current year: " + year));
//				
//					
//				}
				
				
				
			}
			
		}
		
		
	}

//		private class LoginPanelActionListener implements ActionListener {
//			public void actionPerformed(ActionEvent e) {
//				try {
//
//					action = e.getActionCommand();
//
//					String userName = container.getLoginPanel().getTextFieldUsername()
//							.getText().trim();
//					String pass = container.getLoginPanel().getTextFieldPassword()
//							.getText();
//										
//					if ((action.equals("btnLogin"))) {
//						System.out.println("hit1");
//						
						//Creates object of jsonClasses.ClientLogin
						//Sets login information
//						cl.setEmail(userName);
//						cl.setPassWord(pass);
//						//Converts object to jsonString
////						String gsonString = gson.toJson(cl);
//						//Sends object to server using tcpClient.TCPClient and receives response as string serverResponse
//						String serverResponse = tcp.TalkToServer(gsonString);
//						System.out.println("hit2");
//						
//						//Uses serveResponse as a check for login confirmation
//						if (serverResponse != "")
//
//						{
//
//							container.show(Container.CALENDARPANEL);
//
//						}
//
//						else if (loggedIn != 0) {
//							JOptionPane.showMessageDialog(null,
//									"\nLogin failed, error: " + loggedIn,
//									"Error message", JOptionPane.PLAIN_MESSAGE);
//						}
//					
//					}
//				}catch (Exception e3) {
//				}
//			}	
		

	
//	}

							
	
