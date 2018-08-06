package com.revature.q10;

public class QuestionTen {

	/**
	 * Compares two integers and returns the smallest of the two passed integers.
	 * 
	 * @param x An integer for comparison.
	 * @param y Another integer for comparison.
	 * @return The smaller of the two numbers; if equal, returns y.
	 */
	public static int minInt (int x, int y) {
		return (x < y) ? x : y;
	}
	public static void main(String[] args) {
		System.out.println(minInt(42,9001));
		System.out.println(minInt(42,13));
		System.out.println(minInt(332526,554));
		System.out.println(minInt(1231,1231));
		System.out.println(minInt(-1,1));
	}

}
