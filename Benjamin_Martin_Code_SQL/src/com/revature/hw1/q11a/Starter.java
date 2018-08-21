package com.revature.hw1.q11a;

import com.revature.hw1.q11b.Finisher;

public class Starter{

	public static void main(String[] args) {
		
		// Creates a Finisher object with a Finisher reference point
		Finisher item = new Finisher();
		
		// Assigns the X and Y from Finisher class to a variable in the Starter class
		float a = item.getX();
		float b = item.getY();
		
		// Prints each variable out to show both floats moved over successfully
		System.out.println(a);
		System.out.println(b);
	}
	
}
