package com.example.lah3.losaltoshacks3.Backend;

import com.example.lah3.losaltoshacks3.MainActivity;
import com.example.lah3.losaltoshacks3.WeekViewTest;

import java.util.*;

public class DateSchedule {
	
	Calendar date;
	HashMap<Calendar, Chunk> schedule;

	public DateSchedule(Calendar date) {
		schedule = new HashMap<>();
		this.date = date;
	}
	
	public int add(Chunk chunk) {
		Calendar calendar = CalendarUtils.truncate(date);
		
		while (schedule.containsKey(calendar) || Calendar.getInstance().compareTo(calendar) > 0) {
			
			boolean dueTomorrow = ((Homework) chunk.parent).isDueTomorrow(calendar);
			boolean currSleep = schedule.get(calendar).parent.getName().equals("Sleep");
			boolean prevSleep;
			
			Calendar temp = Calendar.getInstance();
			CalendarUtils.copy(temp, calendar);
			temp.add(Calendar.MINUTE, -15);
			if (temp.get(Calendar.DATE) != calendar.get(Calendar.DATE)) prevSleep = true;
			else prevSleep = schedule.get(temp).parent.getName().equals("Sleep");
			
			if (dueTomorrow && currSleep && !prevSleep) {
				break;
			}
			
			//System.out.println(calendar.getTime());
			calendar.add(Calendar.MINUTE, 15);
			if (calendar.get(Calendar.HOUR) == 0 && calendar.get(Calendar.MINUTE) == 0 && calendar.get(Calendar.AM_PM) == 0) {
				return -1;
			}
		}
		
		schedule.put(calendar, chunk);
		return 0;
	}
	
	public void addEvent(Event event) {
		System.out.println(event);
		Chunk[] chunks = ChunkUtils.eventToChunk(event);
		Calendar c = Calendar.getInstance();
		
		//System.out.println(Arrays.toString(chunks));

		//System.out.println(new Date(c.getTimeInMillis()));
		//System.out.println(new Date(event.getStart().getTimeInMillis()));
		
		CalendarUtils.copy(c, event.getStart());
		
		System.out.println("MILLIS: " + event.getStart().get(Calendar.MILLISECOND));
		
		for (int i = 0; i < chunks.length; i++) {
			//System.out.println(new Date(c.getTimeInMillis()));
			Calendar temp = Calendar.getInstance();
			CalendarUtils.copy(temp, c);
			
			schedule.put(temp, chunks[i]);
			c.add(Calendar.MINUTE, 15);
		}
		
		System.out.println(schedule.size());
		
		clearAllHomework();
		WeekViewTest.userSchedule.refresh();
	}
	
	public void clearAllHomework() {
		//System.out.println("---");

		HashMap<Calendar, Chunk> newSchedule = new HashMap<>();
		
		for (Calendar cal : schedule.keySet()) {
			//System.out.println(cal.getTime());
			//System.out.println(schedule.get(cal));
			if (schedule.get(cal).parent instanceof Event) {
				newSchedule.put(cal, schedule.get(cal));
			}
		}
		
		schedule = newSchedule;
	}

	@Override
	public String toString() {
		
		Object[] arr = schedule.keySet().toArray();
		Arrays.sort(arr);
		
		String s = "{";
		for (Object o : arr) {
			Calendar c = (Calendar) o;
			s += (c.getTime() + "=" + schedule.get(c));
			s += "\n";
		}
		s += "}";
		return s;
	}
}
