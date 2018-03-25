package com.example.lah3.losaltoshacks3.Backend;

public class Occasion {
	
	private String name;

	public Occasion(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
