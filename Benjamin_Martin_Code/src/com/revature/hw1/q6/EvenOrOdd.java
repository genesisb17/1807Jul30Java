package com.revature.hw1.q6;

public class EvenOrOdd {

	public static void main(String[] args) {
		
		int input = Integer.parseInt(args[0]);
		int x = input;
		
		if (x <= 0) {
			System.out.println("Take your negatives and put 'em somewhere else!");
			System.exit(x);
		}
		
		while (x >=2) {
			x -= 2;
		}
		
		if (x == 1) {
			System.out.println(input + " is odd.");			
		}
		else {
			System.out.println(input + " is even.");
		}
	}
}
