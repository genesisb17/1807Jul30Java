package com.iantimothyjohnson.assignments;

public class Ant extends Animal implements Worker {
	/**
	 * Construct a new Ant.
	 * @param isFriendly Whether the ant is friendly to humans.
	 */
	public Ant(boolean isFriendly) {
		super(isFriendly);
	}

	@Override
	public void interact(Person person) {
		if (isFriendly) {
			System.out.println("The ant crawls on " + person.getName() + ".");
		} else {
			System.out.println("The ant bites " + person.getName() + ".");
		}
	}
	
	@Override
	public void doWork() {
		System.out.println("The ant moves some dirt.");
	}
}
