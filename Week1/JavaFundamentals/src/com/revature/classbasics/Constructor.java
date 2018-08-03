package com.revature.classbasics;

public class Constructor {

	/*
	 * A constructor is a special method in Java used to CONSTRUCT or create a 
	 * new instance of the class it is found in. It must have the same name as the
	 * class, does not have a return type, and can be overloaded. The first line is
	 * ALWAYS a call to another constructor. Either this() (calling another constructor
	 * of the same class) or super() (calls its superclass's constructor. If there is
	 * no class that said class extends explicitly, it is calling the Object class's
	 * constructor). If you don't explicitly call either this() or super(), JVM
	 * interprets the first line as super() implicitly. Regardless of if you create a 
	 * constructor or not, there is ALWAYS a constructor in every concrete class. It is 
	 * called the default constructor, and looks like the "no-args" constructor, 
	 * but disappears as soon as a constructor is explicitly created. 
	 */
	
	//dummy instance vars:
	String name;
	int age;
	String email;
	String hairColor;
	
	//Constructors c = new Constructors();
	
	//These are all overloaded constructors
	//no args constructor
	public Constructor() {
		this("testUser", 20, "test@gmail.com", "brown");//these are default variables
	}
	
	public Constructor(String name) {
		this(name, 20, "test@gmail.com", "brown"); 
	}
	
	public Constructor(int age) {
		this.age = age;
	}

	public Constructor(String name, int age, String email, String hairColor) {
		super(); //implicitly called too in case this isn't listed
		//super is calling the object class's constructor
		this.name = name;
		this.age = age;
		this.email = email;
		this.hairColor = hairColor;
	}

}
