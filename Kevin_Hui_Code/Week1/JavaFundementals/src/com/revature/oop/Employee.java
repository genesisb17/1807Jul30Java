package com.revature.oop;

public class Employee implements Person{
	
	private double salary;
	private String name;
	
	public Employee() {
		this("Jake");
	}
	
	public Employee(String name) {
		this(name, 45000);
	}
	
	public Employee(double salary) {
		this("Jake", salary);
	}
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void talk() {
		System.out.println("I like trains.");
		
	}

	@Override
	public void brag() {
		System.out.println("I can type at 200 words per minute.");
		
	}

	@Override
	public void work() {
		System.out.println("I work at my office computer for 8 hours, from 9 AM to 5 PM.");
		
	}
	
	@Override
	public String toString() {
		return  "My name is " + name + " and I make " + salary + " per year.";
	}
	
	
}
