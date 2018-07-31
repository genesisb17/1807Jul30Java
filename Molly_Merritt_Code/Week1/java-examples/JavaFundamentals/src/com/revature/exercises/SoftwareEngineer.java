package com.revature.exercises;

public class SoftwareEngineer extends Person {
    
	private int age;
    private String favoritePokemon;
    private static boolean likesComputers;	// all software engineers like computers right?
    
    public SoftwareEngineer(int age, String favoritePokemon) {
    	super(age);
    	this.age = age;
    	this.favoritePokemon = favoritePokemon;
    }
    
    public int getAge() { return age; }		// overridden
    public void setAge(int n) { age = n; }
    
    
    
    
}
