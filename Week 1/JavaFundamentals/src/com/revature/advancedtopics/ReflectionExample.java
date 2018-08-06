package com.revature.advancedtopics;

import java.time.LocalDateTime;

public class ReflectionExample {
	/*
	 * Java Refelction makes it possible to inspect
	 * classes, interfaces, field, and methods at
	 * runtime without knowing the name of the class,
	 * method, etc.
	 * It also makes it possible to instantiate new 
	 * objects, invoke methods, and get/set fields
	 * 
	 */
	
	private String name;
	private int id;
	private LocalDateTime todaysTime;
	
	public ReflectionExample() { //whats the point of having an empty constructor
		
	}
	
	public ReflectionExample(String name, int id, LocalDateTime todaysTime) {
		super();
		this.name = name;
		this.id = id;
		this.todaysTime = todaysTime;
	}

	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
		System.out.println("Free memory: " + run.freeMemory() + " bytes");
		System.out.println("Total memory: " + run.totalMemory() + " bytes");
		System.out.println("Maximum memory: " + run.maxMemory() + " bytes");
		
		ReflectionExample re = new ReflectionExample();
		System.out.println("Class name: " + re.getClass().getCanonicalName());
		System.out.println("Super class: " + re.getClass().getSuperclass());
		
		//useful in huge applications
		//it's going to be used in the background scheme of things
	}
}
