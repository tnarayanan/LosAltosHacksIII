package com.example.lah3.losaltoshacks3.Backend;

import com.example.lah3.losaltoshacks3.MainActivity;
import com.example.lah3.losaltoshacks3.WeekViewTest;

import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Homework extends Occasion {
	
	public static HashMap<Long, Bucket> bucketList = new HashMap<>();
	
	private Calendar dueDate;
	private double hours;
	private int priority;
	
	public Homework(String name, Calendar dueDate, double hours, int priority) {
		super(name);
		this.dueDate = dueDate;
		this.hours = hours;
		this.priority = priority;
	}

	public Calendar getDueDate() {
		return dueDate;
	}

	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public double getValue(Calendar date) {
		return (hours * priority) / TimeUnit.HOURS.convert(dueDate.getTimeInMillis() - date.getTimeInMillis(), TimeUnit.MILLISECONDS);
	}

	public void createScheduleAroundHW() {
		ChunkUtils.homeworkToBucket(this);
		
		WeekViewTest.userSchedule.refresh();
	}
	
	public boolean isDueTomorrow(Calendar calendar) {
		Calendar c1 = Calendar.getInstance();
		CalendarUtils.copy(c1, calendar);
		c1 = CalendarUtils.truncate(c1);
		c1.add(Calendar.DATE, 1);
		
		Calendar ddTruncated = Calendar.getInstance();
		CalendarUtils.copy(ddTruncated, dueDate);
		ddTruncated = CalendarUtils.truncate(ddTruncated);
		
		return (c1.equals(ddTruncated));
	}
	
	
}
