package com.revature.io;

import java.util.Scanner;
import static java.lang.System.in; //Static import. Allows us to access static fields of a class w/o class name

public class ScannerExample {

	public static void main(String[] args) {

		System.out.println("Hello! Welcome to my app. Enter your name");
		Scanner scan = new Scanner(in);
		String name = scan.nextLine();
		System.out.println("Hi " + name + "! Please enter your age");
		String age = scan.nextLine();
		while(true) {
			try {
				int a = Integer.parseInt(age);
				break;
			} catch(NumberFormatException nfe) {
				System.out.println("Please enter a valid number");
			}
		}
		System.out.println();
		scan.close();
	}

}
