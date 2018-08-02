package com.revature.io;

public class Student {
	
	private String name;
	private String email;
	private double grade;
	
	//Student s = new Student();
	public Student() {}
	
	//Student s = new Student("name", "email", 99.99);
	public Student(String name, String email, double grade) {
		super();
		this.name = name;
		this.email = email;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return name + ";" + email + ";" + grade + "\n" ;
	}
	
	
	
	
	

}
