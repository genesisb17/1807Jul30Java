package com.revature.hw1.q12;

import java.util.ArrayList;

public class Enhanced {
	public static void main(String[] args) {
		
		// ArrayList to store all of our numbers
		ArrayList<Integer> even = new ArrayList<>();
		
		// Inserts all numbers into ArrayList
		for (int i = 1 ; i <= 100 ; i++) {
			even.add(i);
		}
		
		// Enhanced for-loop to print each even number (% of 2 being 0)
		for (int element : even) {
			if (element % 2 == 0) {
				System.out.println(element);
			}
		}
	}
}
