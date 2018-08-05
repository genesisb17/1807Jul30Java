//Created by Darius Moomivand @ 05Aug18
package com.revature.hw;

public class Ternary {

		//Method finds the smallest of two numbers and prints it
		public static void min(int a, int b) {
			int temp = (a < b) ? a : b;
			System.out.println(temp);
		}
	public static void main(String[] args) {
		int first = 5; 
		int second = 10;
		Ternary.min(first,second);
		
		
		
	}

}
