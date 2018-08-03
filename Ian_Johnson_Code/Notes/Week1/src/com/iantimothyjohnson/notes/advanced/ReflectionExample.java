package com.iantimothyjohnson.notes.advanced;

import java.time.LocalDateTime;

@SuppressWarnings("unused")
public class ReflectionExample {
	// Java reflection makes it possible to inspect classes, interfaces, fields
	// and methods at runtime without knowing the name of the class, method,
	// etc. It also makes it possible to instantiate new object, invoke methods
	// and get/set fields.

	private String name;
	private int id;
	private LocalDateTime todaysTime;

	public ReflectionExample() {
		super();
	}

	public ReflectionExample(String name, int id, LocalDateTime todaysTime) {
		super();
		this.name = name;
		this.id = id;
		this.todaysTime = todaysTime;
	}

	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime(); // This is a singleton!
		System.out.println("Free memory: " + run.freeMemory() / 1000000.0 + " MB");
		System.out.println("Maximum memory: " + run.maxMemory() / 1000000.0 + " MB");
		System.out.println("Total memory: " + run.totalMemory() / 1000000.0 + " MB");
		
		ReflectionExample re = new ReflectionExample();
		System.out.println("Class name: " + re.getClass().getSimpleName());
		System.out.println("Superclass: " + re.getClass().getSuperclass().getName());
	}
}
