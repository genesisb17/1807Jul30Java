package io;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		
		System.out.println("Hello, welcome to my app! Enter your name"); 
		Scanner scan = new Scanner(System.in);
		
		String name = scan.nextLine();
		
		System.out.println("Hi, " + name + "! Please, enter your age");
		
		int age = scan.nextInt();
		System.out.println(age);
//		
//		int a = Integer.parseInt(age);
//		System.out.println(a);
//		
		scan.close();
	}

}
