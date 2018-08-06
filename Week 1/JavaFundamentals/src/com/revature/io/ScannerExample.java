package com.revature.io;

import java.util.Scanner;
import static java.lang.System.in;

public class ScannerExample {
	//Scanner Object is for taking input from the console
	
	public static void main(String[] args) {
		System.out.println("Hello! Welcome to my app, enter your name.\n");
		Scanner scan = new Scanner(in);
		String name = scan.nextLine();
		
		System.out.println("Hi! " + name + ". Please enter your age.");
		String age = scan.nextLine();
		int a;
		
		try {
			a = Integer.parseInt(age);
		} catch(NumberFormatException nfe) {
			nfe.printStackTrace();
			System.out.println("You didn't enter a valid number");
			a = 5;
		}
		System.out.println(a);
		scan.close();
	}
}
