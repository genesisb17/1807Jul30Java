package com.revature.io;

import java.util.Scanner;
import static java.lang.System.in;
//static imports allow us to access static fields of a class without class name

public class ScannerExample {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Salty Spitoon. Who do you think you are?");
		Scanner scan = new Scanner(in); //Previously System.in, now shorter thanks to import
		String name = scan.nextLine(); //nextLine takes in everything until the user presses enter
		
		System.out.println("Well " + name + ", I don't think your quite tough enough! How old are ye?");
		String age = scan.nextLine();
		int a;
		try {
			a = Integer.parseInt(age);
		} catch(NumberFormatException nfe) {
			nfe.printStackTrace();
			System.out.println("Weenie Hut Junior is that way wise guy.");
			a = 5;
		}
		System.out.println("Oh, you think your soooo tough just because you're " + age + " do ya?");
		
		scan.close(); //Make sure to close your scanners or you get memory leaks
	}
	
}
