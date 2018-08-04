package com.revature.advancedtopics;

import java.time.LocalDateTime;

public class ReflectionExample {
	//ReflectionExample
	
	/*
	 * Java Reflection makes it possible to inspect
	 * class, interfaces, fields, and methods at runtime
	 * without knowing the name of the class, method, etc.
	 * 
	 * It also makes it possible to instantiate new objects,
	 * invoke methods, and get/set fields
	 */
	
	
	private String name;
	private int id;
	private LocalDateTime todaysTime;
	
	public ReflectionExample() {}
	
	
	public ReflectionExample(String name, int id, LocalDateTime todaysTime) {
		super();
		this.name = name;
		this.id = id;
		this.todaysTime = todaysTime;
	}



	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
		System.out.println("Free mem: " + run.freeMemory() + " bytes");
		System.out.println("Max mem: " + run.maxMemory() + " bytes");
		System.out.println("Total mem: " + run.totalMemory() + " bytes");
	
		ReflectionExample re = new ReflectionExample();
		System.out.println("Class name: " + re.getClass().getCanonicalName());
		System.out.println("Super class: " + re.getClass().getSuperclass());
	}
}
