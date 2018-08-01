package com.iantimothyjohnson.notes;

@SuppressWarnings("unused")
public class Constructors {
	String name;
	int age;
	String email;
	String hairColor;
	
	public static void main(String[] args) {
		Constructors c = new Constructors();
	}
	
	public Constructors() {
		this("testUser", 0, "dummy@email.com", "color");
	}
	
	public Constructors(String name) {
		this(name, 20, "test@gmail.com", "brown");
	}

	public Constructors(String name, int age, String email, String hairColor) {
		// A constructor is a special method in Java used to "construct" or
		// create a new instance of the class it is found in. It does not have a
		// return type, and can be overloaded. The first line, whether
		// implicitly or explicitly, is ALWAYS a call to another constructor
		// (either this() or super()). If there is no explicit superclass, it
		// calls the Object class's constructor. If you do not explicitly call
		// this() or super(), JVM interprets the first line as super()
		// implicitly. Regardless of whether you explicitly create a constructor
		// or not, there is ALWAYS a constructor in every concrete class; it is
		// called the default constructor and looks like the "no-args"
		// constructor, but disappears as soon as a constructor is explicitly
		// created.
		this.name = name;
		this.age = age;
		this.email = email;
		this.hairColor = hairColor;
	}
}
