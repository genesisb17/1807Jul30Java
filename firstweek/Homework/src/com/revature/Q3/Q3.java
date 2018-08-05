package com.revature.Q3;


public class Q3 {

	public static void revString(String args) {
		int x = args.length();
		for(int i = x-1; i>-1; i--) {
			char y = args.charAt(i);
			System.out.print(y);
		}
	}
	
	
	public static void main(String[] args) {
		Q3.revString("Dylan");
	}
}
