package com.revature.classbasics;

public class Constructors {
	/*
	 * -A constructor is a special method in java
	 * used to CONSTRUCT or create a new instance
	 * of the class it is found in 
	 * -it must have the same name as the class
	 * -it does not have a return type
	 * -it can be overloaded
	 * -the first line, whether implicitly or explicitly,
	 * 	is ALWAYS a call to another constructor -- either
	 * 	this() (calling another constructor of the same 
	 * 	class) or super() (calls its superclass's constructor
	 * 	. if there is no class that said class extends 
	 * 	explicitly, it is calling the Object class's constructor)
	 * 	if you do not explicitly call either this() or super(), 
	 * 	JVM interprets the first line as super() implicitly
	 * -regardless of if you explicitly create a constructor or
	 * 	not, there is ALWAYS a constructor in every concrete class. It
	 * 	is called the default constructor, and looks like the
	 * 	"no-args" constructor, but disappears as soon as a 
	 * 	constructor is explicitly created
	 */
	
	//dummy instance vars:
	String name;
	int age;
	String email;
	String hairColor;
	
	//no args constructor
	public Constructors() {
		this("testUser", 0, "dummy@email.com", "color");
	}
	
	public Constructors(String name) {
		this(name, 20, "test@gmail.com", "brown");
	}
	
	public Constructors(int age) {
		this.age = age;
	}
	
	public Constructors(String email, String name) {
		
	}
	
	public Constructors(String n, int age, String email, 
			String hairColor) {
		name = n;
		this.age = age;
		this.email = email;
		this.hairColor = hairColor;
	}
	
	
	//Constructors c = new Constructors();
	
	
	

}
