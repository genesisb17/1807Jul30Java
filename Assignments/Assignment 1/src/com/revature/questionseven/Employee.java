package com.revature.questionseven;

class Employee{
	String name, department;
	int age;
	
	//Constructor
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	//used to print details to main()
	public String toString() {
		return this.name + " " + this.department + " " + this.age; 
	}
}




