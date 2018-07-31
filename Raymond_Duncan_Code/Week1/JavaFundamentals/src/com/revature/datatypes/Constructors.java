package com.revature.datatypes;

public class Constructors {
	/*
	 * A constructor is a special method in java
	 * used to CONSTRUCT or create a new insgance of the clsas it is found in
	 * It must have the same name as the class
	 * It does not have a return tupe
	 * It can be overloaded
	 * The first line, whether implicityly or explicitly is ALWAYS a call to another constructor -- either
	 *  this() (calling another constuctor of the same class) or super() (calls it's superclass's constructor.
	 *   if there is no class that said class extends
	 *  explicitly, it is calling the Object's consturctor)
	 *  if you do not explicitly call either this) or super(),
	 *  JVM interprets the first line as super() implicitly
	 *  regardless of if you explicitly create a constructor or
	 *  not, there isALWAYS a constructor in every concrete class. It 
	 *  is caslled the defult constructor, and looks like the
	 *  "no-args" constructor, but disappears as soon as a
	 *  constructor is explicitly created
	 */
	
	//dummy insance vars:
	String name;
	int age;
	String email;
	String hairColor;
	
	//Constructors c = new Constructors();
	
	//no args constructor
	public Constructors() {
		this("testUser", 0, "dummy@email.com", "color");
	}
	
	public Constructors(String name) {
		this(name, 20, "test@gmail.com", "brown");
	}
	
	public Constructors(int age) {
		this("testUser", age, "dummy@email.com", "color");
	}
	
	/* public Constructors(String email) {
	 * 		this("testUser", 0, email, "color");
	 * }
	 *  is invalid because there is already a constructor with only one String as a parameter
	 */
	
	public Constructors(String name, int age, String email, String hairColor) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.hairColor = hairColor;
	}

}
