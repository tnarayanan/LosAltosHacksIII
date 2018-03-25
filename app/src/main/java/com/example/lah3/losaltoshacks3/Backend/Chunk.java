package com.example.lah3.losaltoshacks3.Backend;

public class Chunk implements Comparable<Chunk> {
	Occasion parent;
	double value;

	public Chunk(Occasion parent, double value) {
		this.parent = parent;
		this.value = value;
	}

	@Override
	public int compareTo(Chunk o) {
		int dueDateComp = ((Homework) parent).getDueDate().compareTo(((Homework) o.parent).getDueDate());
		int dComp =  Double.compare(value, o.value);
		return dueDateComp == 0 ? dComp : -dueDateComp;
	}

	@Override
	public String toString() {
		return "{OCCASION: " + parent.getName() + ", VALUE: " + value + "}";
	}
}
