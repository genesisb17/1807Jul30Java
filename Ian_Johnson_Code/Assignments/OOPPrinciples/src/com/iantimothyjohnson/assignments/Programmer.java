package com.iantimothyjohnson.assignments;

public class Programmer extends Person implements Worker {
	private String language;

	/**
	 * Construct a new Programmer.
	 * @param name The programmer's name.
	 * @param age The programmer's age.
	 * @param language The programmer's programming language of choice.
	 */
	public Programmer(String name, int age, String language) {
		super(name, age);
		this.language = language;
	}
	
	@Override
	public void doWork() {
		System.out.println("I'm programming in " + language + "!");
	}
}
