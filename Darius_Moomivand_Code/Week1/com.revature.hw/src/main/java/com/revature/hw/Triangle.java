//Created by Darius Moomivand @ 05Aug18
package com.revature.hw;

public class Triangle {
	//Method to print a triangle
	public static void printTriangle() {
		
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= i; j++) {
				if((i + j) % 2 == 0) {
					System.out.print("1");
				}else {
					System.out.print("0");
				}
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Triangle.printTriangle();
	}

}
