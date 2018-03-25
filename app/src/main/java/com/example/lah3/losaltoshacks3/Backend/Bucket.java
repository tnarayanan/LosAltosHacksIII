package com.example.lah3.losaltoshacks3.Backend;

import com.example.lah3.losaltoshacks3.MainActivity;
import com.example.lah3.losaltoshacks3.WeekViewTest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Bucket {
	ArrayList<Chunk> bucket;
	Calendar date;

	public Bucket(Calendar date) {
		bucket = new ArrayList<>();
		this.date = date;
	}
	
	public void sort() {
		Collections.sort(bucket);
	}

	public void bucketToDateSchedule() {
		
		if (bucket.size() == 0) return;
		
		sort();

		Collections.reverse(bucket);
		System.out.println(bucket);
		
		if (!WeekViewTest.userSchedule.schedule.containsKey(date)) WeekViewTest.userSchedule.schedule.put(date, new DateSchedule(date));
		DateSchedule dateSchedule = WeekViewTest.userSchedule.schedule.get(date);
		
		int i = 0;
		
		while (true) {
			if (i == bucket.size()) return;
			int result = dateSchedule.add(bucket.get(i));
			if (result == -1) {
				System.out.println(i + " -1 with " + bucket.get(i));
				Calendar nextDay = Calendar.getInstance();
				CalendarUtils.copy(nextDay, date);
				nextDay.add(Calendar.DATE, 1);
				
				//if (!Homework.bucketList.containsKey(nextDay)) Homework.bucketList.put(nextDay, new Bucket(nextDay));
				Bucket bucket2 = Homework.bucketList.get(nextDay.getTimeInMillis());
				bucket2.bucket.addAll(bucket.subList(i, bucket.size()));
				bucket.removeAll(bucket.subList(i, bucket.size()));
				return;
			}
			i++;
		}
	}
}
