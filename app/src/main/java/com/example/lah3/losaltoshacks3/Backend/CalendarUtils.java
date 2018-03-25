package com.example.lah3.losaltoshacks3.Backend;

import java.util.Calendar;

public class CalendarUtils {
	
	public static Calendar truncate(Calendar c) {
		Calendar n = Calendar.getInstance(); 
		n.set(Calendar.YEAR, c.get(Calendar.YEAR));
		n.set(Calendar.MONTH, c.get(Calendar.MONTH));
		n.set(Calendar.DATE, c.get(Calendar.DATE));
		
		n.set(Calendar.HOUR, 0);
		n.set(Calendar.MINUTE, 0);
		n.set(Calendar.SECOND, 0);
		n.set(Calendar.AM_PM, 0);
		n.set(Calendar.MILLISECOND, 0);
		
		return n;
	}
	
	public static void copy(Calendar copyInto, Calendar toCopy) {
		copyInto.setTime(toCopy.getTime());
	}
	
}
