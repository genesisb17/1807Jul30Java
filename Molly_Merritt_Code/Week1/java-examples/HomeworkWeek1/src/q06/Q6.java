package q06;

/*
 * Write a program to determine if an integer is even without using the
 * modulus operator (%)
 */

public class Q6 {
	
	public static void main(String[] args) {
		int n = (int) Math.floor(Math.random()*100);	// rand num between 0 and 100
		boolean b = isEven(n);
		if (b) {
			System.out.println(n + " is even");
		} else {
			System.out.println(n + " is odd");
		}
		
	}
	
	static boolean isEven(int n) {
		// if n is even, then n/2 = floor(n/2)
		return ((double) n/2 == Math.floor(n/2));
	}

}
