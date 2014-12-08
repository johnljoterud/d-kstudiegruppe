package Logic;

import java.io.IOException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import tcpClasses.TCPClient;
import JsonClasses.CalendarInfo;
import JsonClasses.GetNotes;
import JsonClasses.UserEvent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CalendarHandler {
	
	private ArrayList <CalendarInfo> calendar = new ArrayList <CalendarInfo>();
	Gson gson = new GsonBuilder().create();
	TCPClient tcp = new TCPClient();


	public CalendarInfo getWeekEvents(int weeknumber, int year , int cId){
		
		CalendarInfo weekEvents = new CalendarInfo();

		ArrayList<String> dates = YearAndWeekDates(weeknumber, year);
		
		
		if(cId == 0){

		for(String tempdate : dates){

			for(CalendarInfo tempcal : calendar){

				for (int i = 0 ; i < tempcal.getCalendars().size(); i++){
							
					if(tempcal.getCalendars().get(i).getStart().contains(tempdate + " ")){

						weekEvents.getCalendars().add(tempcal.getCalendars().get(i));
					}
					
				}
			}
			
		}
		}else{
			
			
			for(String tempdate : dates){

				for(CalendarInfo tempcal : calendar){

					for (int i = 0 ; i < tempcal.getCalendars().size(); i++){
								
						if(tempcal.getCalendars().get(i).getStart().contains(tempdate + " ")&& tempcal.getCalendars().get(i).getCalendarID() ==cId){

							weekEvents.getCalendars().add(tempcal.getCalendars().get(i));
						}
						
					}
				}
				
			}
			
		}
		
		return weekEvents;
	}
	
	public ArrayList<UserEvent> getMyEvents(String createdBy){
		
		ArrayList<UserEvent> myEvents = new ArrayList<UserEvent>();
		
		for(CalendarInfo myInfo : calendar){
			
			for(UserEvent ue: myInfo.getCalendars()){
				
				if(createdBy.equals(ue.getCreatedby())){
					
					myEvents.add(ue);
				}
			}
		}
		return myEvents;
		
	}
		

	public void setCalendar(ArrayList<CalendarInfo> calendar) {
		this.calendar = calendar;
	}
	
	/**Method to get dates of given week in a given year, in the "yyyy-MM-dd" format
	 * @author Niklas Broge
	 * @param 
	 * @return ArrayList<String> of dates
	 */
	 public ArrayList<String> YearAndWeekDates(int week, int year){
		ArrayList<String> dates = new ArrayList<String>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-d");
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));
		
		for(int i=2 ; i<7 ; i++){
		cal.set(Calendar.DAY_OF_WEEK, i);
		dates.add(sdf.format(cal.getTime()));
		}
		for(int i=0 ; i<2 ; i++){
			cal.set(Calendar.DAY_OF_WEEK, i);
			dates.add(sdf.format(cal.getTime()));

		}
		
		return dates;
	 }	
	 
	 public int getWeekDay(String date){
		 int column = 0;
			Calendar cal = Calendar.getInstance();
			Date d;
			try {
				d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
				cal.setTime(d);
				

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek == 1) {
				column = 6;
			}
			else if (dayOfWeek == 2){
				column = 0;
			}
			else if (dayOfWeek == 3){
				column = 1;
			}
			else if (dayOfWeek == 4){
				column = 2;
			}
			else if (dayOfWeek == 5){
				column = 3;
			}
			else if (dayOfWeek == 6){
				column = 4;
			}
			else if (dayOfWeek == 7){
				column = 5;
			}	

		return column;
	
	 }
	
	 public int getArrayWeekDay(String arraydate){
		 int column = 0;
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-d");
			Date d;
			String datehandler = "";
			try {
				d = sdf.parse(arraydate);
				cal.setTime(d);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			datehandler = sdf.format(cal.getTime());
			int newMonth = cal.get(Calendar.MONTH);
			newMonth ++;
			datehandler = datehandler.replace("-MM-", "-" + newMonth + "-");
			
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek == 1) {
				column = 6;
			}
			else if (dayOfWeek == 2){
				column = 0;
			}
			else if (dayOfWeek == 3){
				column = 1;
			}
			else if (dayOfWeek == 4){
				column = 2;
			}
			else if (dayOfWeek == 5){
				column = 3;
			}
			else if (dayOfWeek == 6){
				column = 4;
			}
			else if (dayOfWeek == 7){
				column = 5;
			}	

		return column;
	
	 }
	 public String[] getCellDate(int column, int row, int year, int week){
		 
		 System.out.println("column: " + column);
		 System.out.println("row: " + row);
		 System.out.println("year: " + year);
		 System.out.println("week: " + week);
		 
		 Calendar cal = Calendar.getInstance();
		 cal.set(Calendar.YEAR, year);
		 cal.set(Calendar.WEEK_OF_YEAR, week);
			
		 if (column == 0) {
				cal.set(Calendar.DAY_OF_WEEK, 2);
			}
			else if (column == 1){
				cal.set(Calendar.DAY_OF_WEEK, 3);
			}
			else if (column == 2){
				cal.set(Calendar.DAY_OF_WEEK, 4);
			}
			else if (column == 3){
				cal.set(Calendar.DAY_OF_WEEK, 5);
			}
			else if (column == 4){
				cal.set(Calendar.DAY_OF_WEEK, 6);
			}
			else if (column == 5){
				cal.set(Calendar.DAY_OF_WEEK, 7);
			}
			else if (column == 6){
				cal.set(Calendar.DAY_OF_WEEK, 1);
			}	
		 System.out.println("day of week selected: " + String.valueOf(cal.get(Calendar.DAY_OF_WEEK)));
		 String[] dateReturned = {String.valueOf(cal.get(Calendar.YEAR)), String.valueOf(cal.get(Calendar.MONTH)+1),String.valueOf(cal.get(Calendar.DAY_OF_MONTH)), String.valueOf(row+7)};
		 return dateReturned;
	 }
		 
	 
	 public GetNotes getNotes(CalendarInfo weekEvents){
	     String answer = "";
	     
	     GetNotes gn = new GetNotes();
	     ArrayList<UserEvent> aue = weekEvents.getCalendars();
	          
	     for ( UserEvent ue : aue){
	    	 gn.getEvents().add(ue);
	     }    	 
	     System.out.println("requesting notes from server");
	     String toClient = gson.toJson(gn);
	     try {
	  	   
			answer = tcp.TalkToServer(toClient);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	     gn = (GetNotes)gson.fromJson(answer, GetNotes.class);
	     
	     return gn;
	     
		 }
}
