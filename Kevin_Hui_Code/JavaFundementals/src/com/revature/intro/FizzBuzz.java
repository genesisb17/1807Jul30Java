package com.revature.intro;

import java.util.Scanner;

public class FizzBuzz {
	
	public static void fizzBuzz() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number n: ");
		int n = sc.nextInt();
		
		sc.close();
		
		for(int i = 1; i <= n; i++) {
			
			if(i % 15 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}
	
	
	public static void main(String[] args) {
		fizzBuzz();
	}
}
