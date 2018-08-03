package q04;

/*
 * Write a program to compute N factorial.
 */

public class Q4 {
	
	public static void main(String[] args) {
		int n = (int) Math.floor(Math.random()*10);	// compute random number (0-10)
		int res = computeFactorial(n);	// call factorial function
		System.out.println("n = " + n);	// print n
		System.out.println("n! = " + res);	// print n!
	}
	
	static int computeFactorial(int n) {
		int res = 1;
		for (int i=0; i<n; i++) {
			res = res * (n-i);	// calculate factorial
		}
		return res;
	}
	

}
