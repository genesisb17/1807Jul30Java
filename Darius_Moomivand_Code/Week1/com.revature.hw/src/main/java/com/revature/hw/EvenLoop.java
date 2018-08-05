//Created by Darius Moomivand @ 05Aug18
package com.revature.hw;

public class EvenLoop {
	static int[] tempArr = new int[100];

	//Method used to fill an array
	public static void fill() {
		for(int i = 0; i < tempArr.length; i++) {
			tempArr[i] = i+1;
		}
	}
	
	//Method used to print out even numbers
	public static void printEven() {
		for(int even: tempArr) {
			if(even % 2 == 0)
				System.out.println(even);
		}
	}
	

	public static void main(String[] args) {
		EvenLoop.fill();
		EvenLoop.printEven();
		
		
	}

}
