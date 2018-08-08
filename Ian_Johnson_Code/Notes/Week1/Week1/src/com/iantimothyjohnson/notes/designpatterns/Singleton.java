package com.iantimothyjohnson.notes.designpatterns;

public class Singleton {
	public String name; // To demonstrate the example instance.
	
	// A singleton is a class that must have no more than one instance at any
	// time. There are two different types: lazy and eager. Eager means that the
	// instance is created up-front, while lazy means that the instance is
	// created on-demand (if it hasn't already been created).
	
	// We can use a private constructor to implement the Singleton. The private
	// constructor prevents any other class from instantiating the singleton.
	private Singleton() {
		System.out.println("Reporting for instantiation, SIR!");
	}
	
	// We have a private static member referring to the single instance (this is
	// an eager singleton). To make it a lazy singleton, just leave out the
	// constructor call here and instead call it in getInstance if the instance
	// hasn't been created yet.
	private static Singleton singleton = new Singleton();
	
	public static Singleton getInstance() {
		return singleton;
	}
}
