package com.revature.intro;

public class number {

	public static int factorial(int a) {

		for (int i = a - 1; i > 0; i--) {

			a = a * i;

		}
		System.out.println(a);
		return a;
	}

	public static void GetSum(int a, int b) {
		if (a == b) {
			System.out.println(a);
			;

		} else if (a < b) {
			for (int x = a + 1; x <= b; x++) {

				a = a + x;
			}
			System.out.println(a);

		} else if (a > b) {
			for (int x = b + 1; x <= a; x++) {

				b = b + x;
			}
			System.out.println(b);
		}

	}

	public static void main(String[] args) {
//		GetSum(1,-1);
		factorial(3);
	}
}
