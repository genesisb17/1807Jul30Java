package cjh.question20;

import java.io.Serializable;

public class Personnage implements Serializable{
	/*
	 * Create a notepad file called Data.txt and enter the following:
	 * 		Mickey:Mouse:35:Arizona		
	 * 		Hulk:Hogan:50:Virginia
	 * 		Roger:Rabbit:22:California
	 * 		Wonder:Woman:18:Montana
	 * Write a program that would read from the file and print it out to the screen in the following format:
	 * 		Name: Mickey Mouse
	 * 		Age: 35 years
	 * 		State: Arizona State
	 */
	
	private String firstName;
	private String lastName;
	private int age;
	private String homeState;
	
	public Personnage() {};

	public Personnage(String firstName, String lastName, int age, String homeState) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.homeState = homeState;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHomeState() {
		return homeState;
	}

	public void setHomeState(String homeState) {
		this.homeState = homeState;
	}
	
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\nAge: " + age + " years\nState: " + homeState + "\n";
	}
	

}
