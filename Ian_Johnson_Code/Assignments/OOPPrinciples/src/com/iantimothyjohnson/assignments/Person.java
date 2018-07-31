package com.iantimothyjohnson.assignments;

public class Person {
	private String name;
	private int age;
	
	/**
	 * Construct a new Person.
	 * @param name The person's name.
	 * @param age The person's age.
	 */
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
