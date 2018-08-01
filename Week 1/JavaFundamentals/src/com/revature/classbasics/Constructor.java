package com.revature.classbasics;

public class Constructor {
	/*
	 * A constructor is a special method in java used to construct
	 * or create a new instance of the class it is found in
	 * It must have the same name as the class
	 * It does not have a return type
	 * It can be overloaded (meaning you can have the same methods in the same class 
	 * with the same name)
	 * The first line, whether implicitly or explicitly,
	 * is ALWAYS a call to another constructor -- either
	 * this() (calling another constructor of the same
	 * class) or super() (calls its superclass's constructor.
	 * If there is no class that said class extends explicitly,
	 * it is calling the Object class's constructor)
	 * If you do not explicitly call either this() or super(),
	 * JVM interprets the first line as super() implicitly
	 * regardless of if you explicitly create a constructor or
	 * not, there is ALWAYS a constructor in every class. It is called
	 * the default constructor and looks like the "no-args" constructor, but 
	 * disappears as soon as a constructor is explicitly created
	 */
	
	//dummy instance vars:
	String name;
	int age;
	String email;
	String haircolor;
	
	public Constructor() {
		this("testUser", 20, "test@gmail.com", "brown");
	}
	
	public Constructor(String name) {
		this(name, 20, "test@gmail.com", "brown");
	}
	
	public Constructor(int age) {
		this.age = age;
	}
	
	public Constructor(String n, int age, String email, String haircolor) {
		super(); //implicitly and explicitly there
		name = n;
		this.age = age;
		this.email = email;
		this.haircolor = haircolor;
	}
	
	//Constructor c = new Constructor();
	
}
