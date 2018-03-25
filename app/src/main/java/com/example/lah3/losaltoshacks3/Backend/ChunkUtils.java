package com.example.lah3.losaltoshacks3.Backend;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ChunkUtils {
	public static Chunk[] homeworkToChunk(Homework homework) {
		int numOfChunks = (int) (homework.getHours() * 4);
		Chunk[] arr = new Chunk[numOfChunks];
		for (int i = 0; i < numOfChunks; i++) {
			arr[i] = new Chunk(homework, homework.getValue(Calendar.getInstance()));
		}
		
		return arr;
	}

	public static Chunk[] eventToChunk(Event event) {
		//System.out.println(event);
		
		double hours = (event.getEnd().getTimeInMillis() - event.getStart().getTimeInMillis()) / (1000.0*60*60);
		
		//System.out.println(hours);
		
		int numOfChunks = (int) (hours * 4);
		
		//System.out.println(numOfChunks);
		
		Chunk[] arr = new Chunk[numOfChunks];
		for (int i = 0; i < numOfChunks; i++) {
			arr[i] = new Chunk(event, 0);
		}

		return arr;
	}

	public static void homeworkToBucket(Homework homework) {
		Chunk[] arr = homeworkToChunk(homework);
		
		//System.out.println(homework.getName() + " " + arr.length);
		
		Calendar resetHW = CalendarUtils.truncate(Calendar.getInstance());
		
		int count = 0;

		while (count < arr.length) {
			if (!Homework.bucketList.containsKey(resetHW.getTimeInMillis())) Homework.bucketList.put(resetHW.getTimeInMillis(), new Bucket(resetHW));
			int len = Math.min(8, arr.length - count);
			
			int override = homework.isDueTomorrow(resetHW) ? arr.length - count : 0;
			len = Math.max(len, override);
			
			for (int i = 0; i < len; i++) {
				Homework.bucketList.get(resetHW.getTimeInMillis()).bucket.add(arr[count]);
				count++;
			}
			
			resetHW.add(Calendar.DATE, 1);
		}
		
		//System.out.println(count);
	}
}
