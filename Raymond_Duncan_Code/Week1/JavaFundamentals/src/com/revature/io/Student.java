package com.revature.io;

import java.io.Serializable;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private transient double grade;	//Transient keyword makes this variable non-serializable. It will instead serialize the default value instead
	private transient Object transientObject;
	
	//Student s = new student();
	public Student() {}

	//Student s = new Student("name", "email", "99.99");
	public Student(java.lang.String name, String email, double grade, Object transientObject) {
		super();
		this.name = name;
		this.email = email;;
		this.grade = grade;
		this.transientObject = transientObject;
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

	public Object getTransientObject() {
		return transientObject;
	}

	public void setTransientObject(Object transientObject) {
		this.transientObject = transientObject;
	}

	@Override
	public String toString() {
		//name;email;grade
		return name + ";" + email + ";" + grade + "\n";
	}	
	
	
	

}
