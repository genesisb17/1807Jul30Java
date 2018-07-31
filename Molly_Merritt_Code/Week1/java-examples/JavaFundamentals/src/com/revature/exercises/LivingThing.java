package com.revature.exercises;

abstract class LivingThing {    // abstract, so can't be instantiated but CAN have subclasses
	// subclass is Person
	
    private int weight;
    
    public LivingThing() {}
    
    public LivingThing(int weight) {
    	this.weight = weight;
    }
}
