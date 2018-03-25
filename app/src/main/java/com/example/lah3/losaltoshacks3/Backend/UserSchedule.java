package com.example.lah3.losaltoshacks3.Backend;

import com.example.lah3.losaltoshacks3.Backend.DateSchedule;
import com.example.lah3.losaltoshacks3.MainActivity;
import com.example.lah3.losaltoshacks3.WeekViewTest;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;

public class UserSchedule {
	HashMap<Calendar, DateSchedule> schedule;

	public UserSchedule() {
		schedule = new HashMap<>();
	}
	
	public void add(Calendar cal, DateSchedule d) {
		schedule.put(cal, d);
	}
	
	public void resetHomework() {
		for (DateSchedule ds : schedule.values()) {
			ds.clearAllHomework();
		}
	}
	
	public void refresh() {
		
		resetHomework();
		
		Calendar cal = Calendar.getInstance();
		cal = CalendarUtils.truncate(cal);
		
		System.out.println("REFRESH");
		System.out.println(cal.getTime());
		
		for (int i = 0; i < 100; i++) {
			
			Calendar temp = Calendar.getInstance();
			CalendarUtils.copy(temp, cal);
			
			if (!Homework.bucketList.containsKey(cal.getTimeInMillis())) {
				//System.out.println(i + " new");
				Homework.bucketList.put(cal.getTimeInMillis(), new Bucket(temp));
			}
			cal.add(Calendar.DATE, 1);
		}

		cal = Calendar.getInstance();
		cal = CalendarUtils.truncate(cal);
		System.out.println(cal.getTime());
		
		for (int i = 0; i < 100; i++) {
			
			//System.out.println(cal.getTime() + " " + Homework.bucketList.containsKey(cal.getTimeInMillis()));
			Homework.bucketList.get(cal.getTimeInMillis()).bucketToDateSchedule();
			cal.add(Calendar.DATE, 1);
		}
	}
	
	public void addEvent(Event event) {
		Calendar cal = Calendar.getInstance();
		CalendarUtils.copy(cal, event.getStart());
		cal = CalendarUtils.truncate(cal);

		if (!WeekViewTest.userSchedule.schedule.containsKey(cal)) WeekViewTest.userSchedule.schedule.put(cal, new DateSchedule(cal));
		DateSchedule dateSchedule = WeekViewTest.userSchedule.schedule.get(cal);
		
		dateSchedule.addEvent(event);
	}
	
	public void removeEvent(Event event) {
		Calendar cal = Calendar.getInstance();
		CalendarUtils.copy(cal, event.getStart());
		cal = CalendarUtils.truncate(cal);

		System.out.println(cal.getTime() + "-------------------------------------------REMOVING-------------------------------------------");
		
		if (!schedule.containsKey(cal)) {
			System.out.println("-------------------------------------------DNE------------------------------------");
			return;
		}
		DateSchedule dateSchedule = schedule.get(cal);
		System.out.println(dateSchedule);
		System.out.println("-------------------------------------------REMOVING EVENT-------------------------------------------");
		
		Calendar cal2 = Calendar.getInstance();
		CalendarUtils.copy(cal2, event.getStart());

		double hours = (event.getEnd().getTimeInMillis() - event.getStart().getTimeInMillis()) / (1000.0*60*60);
		int numOfChunks = (int) (hours * 4);
		
		System.out.println(numOfChunks);
		
		for (int i = 0; i < numOfChunks; i++) {
			dateSchedule.schedule.remove(cal2);
			cal2.add(Calendar.MINUTE, 15);
		}
		
		System.out.println(dateSchedule);
		System.out.println("-------------------------------------------REMOVED SCHEDULE-------------------------------------------");
		refresh();
	}

	@Override
	public String toString() {
		String s = "{";

		Object[] arr = schedule.keySet().toArray();
		Arrays.sort(arr);
		
		for (Object o : arr) {
			Calendar c = (Calendar) o;
			if (schedule.get(c).schedule.isEmpty()) continue;
			
			s += (c.getTime() + "=" + schedule.get(c));
			s += ", ";
		}
		s += "}";
		return s;
	}
}
