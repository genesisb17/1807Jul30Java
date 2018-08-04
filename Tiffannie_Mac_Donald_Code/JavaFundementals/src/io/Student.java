package io;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private double grade;
	
	public Student() {}

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
		return name + ";" + email + ";" + grade + "\n";
	}
	

}
