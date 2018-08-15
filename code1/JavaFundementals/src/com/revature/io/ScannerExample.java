package com.revature.io;

import java.util.Scanner;

public class ScannerExample {
	
	public static void main(String[] args) {
		System.out.println("Hello welcome to my app");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		System.out.println("hi " + name + "! Please enter your age");
		String age = scan.nextLine();
		int a = Integer.parseInt(age);
		
		scan.close();
	}

}
