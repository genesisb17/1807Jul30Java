package cjh.question10;

public class Minimum {
	/*
	 * Find the minimum of two numbers using ternary operators.
	 */

	public static int whichMin(int a, int b) {
		return (a < b)? a : b;
	}
	
	//The following are for question 11
	private static float minInt = Float.MIN_VALUE;
	private static float maxInt = Float.MAX_VALUE;
	
	public static float getMinInt() {
		return minInt;
	}

	public static float getMaxInt() {
		return maxInt;
	}

}
