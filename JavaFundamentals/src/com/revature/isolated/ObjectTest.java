package com.revature.isolated;

class Person extends Object {
	private String name;

	public String getName() {
		return name;	
	}
	
	public void setName(String name) {
		this.name = name;	
	}
	
	public String toString() {
		return "Hi, I'm " + this.name;
	}
}

public class ObjectTest {
	public static String print(Object o) {
		return o.toString();
	}
	
	public static void main(String[] args) {
		Person someone = new Person();
		
		someone.setName("Joe");
		
		System.out.println(someone);
	}
}

