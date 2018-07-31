package com.iantimothyjohnson.assignments;

public abstract class Animal {
	boolean isFriendly;
	
	public Animal(boolean isFriendly) {
		this.isFriendly = isFriendly;
	}

	public boolean isFriendly() {
		return isFriendly;
	}

	public void setFriendly(boolean isFriendly) {
		this.isFriendly = isFriendly;
	}

	public abstract void interact(Person person);
}
