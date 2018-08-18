package com.revature.oop.examples.employees;

public class Manager extends Employee { // Inheritance since it extends from Employee and has it's field & methods when creating an object
	
	private int corporateCardId;
	
	public Manager(String firstName, String lastName, double salary, int corporateCardId) {
		super(firstName, lastName, salary);
		this.corporateCardId = corporateCardId;
	}
	
	public Manager() {
		super();
	}
	
	public int getCorporateCardID() {
		return this.corporateCardId;
	}// Getter
	// For Encapsulation due to them being private
	
	public void setCorporateCardID(int corporateCardId) {
		this.corporateCardId = corporateCardId;
	}// Setter
	// For Encapsulation due to them being private
	
	@Override
	public void type() {
		System.out.println("I got no money, maw!");
	}// Polymorphism is present since it will override the method in the Employee class with it's own definition
}
