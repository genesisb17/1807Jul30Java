package com.revature.Q16;

import java.util.Scanner;

public class Q16 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		scanner.close();
		int countOfCharacters = 0;
		for(int i = 0; i <= word.length(); i++) {
			countOfCharacters = i;
		}
			System.out.println("Number of characters is: " + countOfCharacters);
	}
	
}
