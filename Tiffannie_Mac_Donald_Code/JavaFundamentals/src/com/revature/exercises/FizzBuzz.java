package com.revature.exercises;

import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {
		// Take in n and print out numbers 1-n
		Scanner inn = new Scanner(System.in);
		
		
		System.out.println("Please, enter a number: ");
		int num = inn.nextInt();
		
			//declaring variable, our condition, incrementing factor by 1
		for(int i = 1; i < num + 1; i++) {
			if (i % 3 == 0 && i % 5 != 0) {
				System.out.println("Fizz");
			}
			else if(i % 5 == 0 && i % 3 != 0) {
				System.out.println("Buzz");
			}
			else if(i % 3 == 0 && i % 5 == 0){
				System.out.println("FizzBuzz");
			}
			else {
				System.out.println(i);
			}
		}
		
		

	}

}
