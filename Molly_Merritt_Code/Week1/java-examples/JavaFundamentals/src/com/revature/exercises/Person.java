package com.revature.exercises;

public class Person extends LivingThing {

    private int height;     // private fields
    private int weight;
    private int age;

    public Person(int height, int weight, String email) {
    	super(weight);
        this.height = height;
    }

    // overloaded constructor
    public Person(int age) {
    	this.age = age;
    }
    

    // Getters and setters
    public int getHeight() { return height; }
    public void setHeight(int h) { height = h; }

    public int getWeight() { return weight; }
    public void setWeight(int w) { weight = w; }
    
    public int getAge() { return age; }
    public void setAge(int n) { age = n; }
    


    
}