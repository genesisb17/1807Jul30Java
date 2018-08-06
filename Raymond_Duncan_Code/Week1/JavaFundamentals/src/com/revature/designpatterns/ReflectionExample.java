package com.revature.designpatterns;

import java.time.LocalDateTime;

public class ReflectionExample {
	/*
	 * Java Reflection makes it possible to inspect
	 * classes, interfaces, fields, and methods at
	 * runtime without knowing the name of the class,
	 * method, etc.
	 * It also makes it possible to instantiate new 
	 * objects, invoke methods and get/set fields
	 */

	private String name;
	private int id;
	private LocalDateTime todaysTime;
	
	public ReflectionExample() {};
	
	public ReflectionExample(String name, int id, LocalDateTime todaysTime) {
		super();
		this.name = name;
		this.id = id;
		this.todaysTime = todaysTime;
	}



	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
		System.out.println("Free memory:\t" + run.freeMemory() + " bytes");
		System.out.println("Max memory:\t" + run.maxMemory() + " bytes");
		System.out.println("Total memory:\t" + run.totalMemory() + " bytes");
		
		ReflectionExample re = new ReflectionExample();
		System.out.println("Class name: " + re.getClass().getCanonicalName());
		System.out.println("Superclass: " + re.getClass().getSuperclass());
	}
}
