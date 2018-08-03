package com.revature.io;

// ctrl + shift + o to import
import java.util.Scanner;

// static import:
import static java.lang.System.in;

public class ScannerExample {
	
		public static void main(String[] args) {
		System.out.println("Hello! Welcome to my app, enter your name");
		Scanner scan = new Scanner(in);
		String name = scan.nextLine();
		System.out.println("Hi, " + name + "! Please enter your age");
		String age = scan.nextLine();
		try {
			int a = Integer.parseInt(age);
		} catch(NumberFormatException nfe) {
			nfe.printStackTrace();
			System.out.println("You didn't answer a valid number.");
		}
//		System.out.println(a);
	}
}
