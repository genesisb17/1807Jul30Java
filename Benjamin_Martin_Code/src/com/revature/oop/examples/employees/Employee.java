package com.revature.oop.examples.employees;

public class Employee implements Typing {
	
	private String firstName;
	
	private String lastName;
	
	private double salary;
	
	public Employee(String firstName, String lastName, double salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public double getSalary() {
		return this.salary;
	}
	// Top 3 are Getters
	// For Encapsulation due to them being private
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	// Next 3 are Setters
	// Also for Encapsulation
	
	public void type() {
		System.out.println("I'm typin' 'ere!");	
	}// Abstraction since it implements the typing interface
}
