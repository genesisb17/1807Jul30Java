package com.codewars;

public class XbonacciDriver {

	public static void main(String[] args) {

		testTribonacci();
	}
		
	public static void testTribonacci() {
		Xbonacci tri = new Xbonacci();
		double[] signature1 = {0.0,0.0,1.0};
		System.out.println(tri.tribonacci(signature1, 4));
	}
}
