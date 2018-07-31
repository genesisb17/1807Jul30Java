package com.revature.oop;

public class Boss extends Employee {
		
	public Boss() {
		super();
	}
	
	public Boss(String name) {
		super(name, 200000.00);
	}
	
	public Boss(String name, double salary) {
		super(name, salary);
	}
	
	public Boss(double salary) {
		super(salary);
	}
	
	@Override
	public void work() {
		System.out.println("I have to manage other Employees, and I have to rok from 7 AM to 6 PM.");
	}
	
	@Override
	public void talk() {
		System.out.println("Be quiet and get back to work...");
		
	}

	@Override
	public void brag() {
		System.out.println("I make more money than you.");
		
	}
	
	@Override
	public String toString() {
		return  "My name is " + getName() + " and I make " + getSalary() + " per year as a person in charge.";
	}
}
