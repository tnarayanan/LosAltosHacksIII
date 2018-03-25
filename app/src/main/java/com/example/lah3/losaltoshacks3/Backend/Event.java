package com.example.lah3.losaltoshacks3.Backend;

import java.util.Calendar;
import java.util.Date;

public class Event extends Occasion {
	
	private Calendar start;
	private Calendar end;

	public Event(String name, Calendar start, Calendar end) {
		super(name);
		this.start = start;
		this.end = end;
	}

	public Calendar getStart() {
		return start;
	}

	public void setStart(Calendar start) {
		this.start = start;
	}

	public Calendar getEnd() {
		return end;
	}

	public void setEnd(Calendar end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return new Date(start.getTimeInMillis()) + "/" + new Date(end.getTimeInMillis());
	}
}
