// Created by Darius Moomivand @ 04Aug18
package com.revature.hw;

public class Factorial {
	//Recursive method used to get the factorial of a number
	public static int factorNum(int n) {
		if(n == 0) 
			return 1;
		else
		return( n*factorNum(n-1));
	}
	
	public static void main(String[] args) {
		int num = 4;
		int temp = Factorial.factorNum(num);
		System.out.println(temp);
	}

}
