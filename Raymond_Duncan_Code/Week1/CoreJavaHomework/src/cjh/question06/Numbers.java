package cjh.question06;

public class Numbers {
	/*
	 * Write a program to determine if an integer is even without using the modulus operator (%) 
	 */
	public static void main(String[] args) {
		int n = 10;
		for(int i = 0; i < n; i++) {
			System.out.println(i + " is even: " + isEven(i));
		}
		
	}

	public static boolean isEven(int n) {
		return n != 0 && n/2*2 == n ? true : false;
	}
}
