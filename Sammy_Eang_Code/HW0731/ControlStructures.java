package com.revature.classbasics;

public class ControlStructures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Classwork
		
		//for loop. Note, you don't need the initializer or counter or condition technically.
		//You can use a series of prior variables or ifs and breaks instead.
		String[] words = {"hello", "hi", "yo", "wassup"};

		for(int i=0;i<words.length;i++) {
			if (i == 2) {
				continue;
			}
			System.out.println(words[i]);
		}
		
		//for each loop
		int [] numericals = {100, 200, 300, 400, 500};

		for(int u : numericals){
		System.out.print( u );
		System.out.print(",");
		}
		
		//while loop
		int x = 0;
		System.out.println();
		while (x < 10) {
			if (x == 8) {
				break;
			}
			System.out.print(x+", ");
			x++;
		}
		System.out.println();
		
		//do-while loop
		do {
			System.out.println("See you again!");
			x--;
		} while (x > 0);
		
		//if else
		if(x > 0) {
			System.out.println("Correct!");
		} else {
			System.out.println("Incorrect!");
		}
		
		//if else if else
		if (x < 0) {
			x = 10;
			System.out.println("X is now 10!");
		} else if (x > 0) {
			x = 0;
			System.out.println("X is now 0!");
		} else {
		    System.out.println("X is 0!");
		}
		
		//In a switch statement, you can put string, char, byte, short, int, and their wrappers. Also enums
	}

}
