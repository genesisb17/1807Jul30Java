package com.reverse.evenorodd;

public class EvenOrOdd {
	
	public static void main(String[] args) {
		
		//plz don't ever null or it'll yell at me ;__;
		int count = Integer.parseInt(args[0]);
		
		// Will reduce count until it is either 1 or 0.
		while (count > 1) {
			count -= 2;
		}
		
		// Prints out whether it is even(0) or odd(1).
		if (count == 0) {
			System.out.println("Argument passed is even.");
		}
		else {
			System.out.println("Argument passed is odd.");
		}
			
	}
}
