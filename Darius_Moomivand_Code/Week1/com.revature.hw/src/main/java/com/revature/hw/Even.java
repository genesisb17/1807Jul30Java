//Created by Darius Moomivand @ 04Aug18
package com.revature.hw;

public class Even {
	//Method used to check if a given number is even or odd
	//by using a bitwise operation '&' with 1 and comparing it to 1
	public static void isEven(int n) {
		if((n & 1) == 1)
			System.out.println("This number is odd!");
		else
			System.out.println("This number is even!");
	}

	public static void main(String[] args) {
		int num = 9;
		Even.isEven(num);
		
		
	}

}
