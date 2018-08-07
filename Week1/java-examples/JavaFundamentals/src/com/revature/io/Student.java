package com.revature.io;

import java.io.Serializable;

public class Student implements Serializable{
	
	/**
	 * . In simple terms, Java objects exist only within the 
	 * limits of the JVM. When the JVM exits, object values 
	 * also get destroyed. Serialization means you save the 
	 * objects as bytes somewhere. Probably in the filesystem. 
	 * Deserialization means you read these bytes as constructing 
	 * the Java object again. 
	
	 The SerialVersionUID is used during deserialization to verify 
	 that the sender ( the person who serializes) and receiver 
	 ( the person who deserializes) of a serialized object have loaded 
	 classes for that object that are compatible with respect to 
	 serialization. In case a receiver has loaded a class for the object 
	 that has a different serialVersionUID than that used to serialize, 
	 then deserialization will end with InvalidClassException. A 
	 serializable class can declare its own serialVersionUID explicitly 
	 by declaring a field named “serialVersionUID” that must be static, 
	 final, and of type long:
	 
	 https://dzone.com/articles/what-is-serialversionuid
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private transient double grade;
	
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
