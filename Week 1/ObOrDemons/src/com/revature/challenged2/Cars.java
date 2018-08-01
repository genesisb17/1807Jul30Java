package com.revature.challenged2;
	//superclass
 class Cars{
	
	public String interior; 
	public String color;
	
	//Constructor
	public Cars(String interior, String color) {
		this.color = color;
		this.interior = interior;
	}
	
	//output
	public String toString(){
		return("The interior is: " + interior + "\n"
				+ "And the color of the car is: " + color +"\n");
		}
	
	}
