package com.revature.Q5;


public class Q5 {
	public static void subString(String word, int n) {
		for (int i =0; i<=n; i++) {
			System.out.print(word.charAt(i));
		}
	}
	public static void main(String[] args) {
		Q5.subString("Hello", 3);
		
	}
}
