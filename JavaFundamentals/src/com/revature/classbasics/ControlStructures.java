package com.revature.classbasics;

public class ControlStructures {
	
	public static void main(String[] args) {
		int x = 10;
		int i = 2;
		
		while (i < x) {
			if (i % 2 == 0) {
				System.out.println("He loves me...");
				i += 1;
			}
			else {
				System.out.println("He loves me not...");
				i += 1;
			}
		}
		
		if (x % 2 == 0)
			System.out.println("He definitely loves me!");
		else
			System.out.println("And I'm forever alone...");
	}
}