package com.revature.classbasics;

import java.util.Random;

public class ControlStructures {

	/*
	 * Class that demonstrates the following control structures in pairs:
	 * Loops:
	 * 		*for
	 * 		*for each
	 * 		*while
	 * 		*do-while
	 * Statements:
	 * 		*if/else
	 * 		if/else if/else
	 * 		*switch
	 * Show difference between break and continue
	 * 
	 * Bonus: 
	 * Demonstrate labels for blocks of code
	 */
	public static void main(String[] args) {

		int monkeysJumping = 0;
		for(int i = 5; i >= 0; i--) {
			monkeysJumping = i;
			System.out.println(i);
			String[] s = {"Little","monkeys","jumping","on","the","bed"};
			for (String string : s) {
				System.out.println(string);
			}
			System.out.println("Jumping on a bed");
			
			if(i == 0) {
				System.out.println("They all fell off and bumped their heads");
				
			} else {
				System.out.println("One fell off and bumped it's head");
			}
			System.out.println("Momma called the docter, and the doctor said:");
			
			switch(monkeysJumping){
			case 0:
				System.out.println("It's 'cause all those monkeys were jumping on the bed");
				continue;
			default:
				System.out.println("No more monkeys jumping on the bed!");
			}
			System.out.println();
				
		}
		
		Random rnd = new Random();
		int spinCounter;
		do {
			spinCounter = 1;
			int rndInt = rnd.nextInt(5);
			while(rndInt != monkeysJumping){
				spinCounter++;
				rndInt = rnd.nextInt(5);
				if(rndInt == 0) {
					//Special case
					break;
				}
			}
			monkeysJumping++;
			System.out.println("Monkey " + monkeysJumping + " took " + spinCounter + " weeks to recover");
		}while(monkeysJumping < 5);
	}

}
