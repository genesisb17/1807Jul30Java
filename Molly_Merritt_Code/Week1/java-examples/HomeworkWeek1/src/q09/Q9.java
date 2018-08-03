package q09;

import java.util.ArrayList;

/*
 * Create an ArrayList which stores numbers from 1 to 100 and prints out
 * all the prime numbers to the console.
 */

public class Q9 {
	
	static public void main(String[] args) {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		for (int i=0; i<100; i++) {	// for i = 0 to 100, store i+1
			myList.add(i+1);
			if (isPrime(i) && i > 1) {
				System.out.println(i);
			}
		}
	}
	
	static boolean isPrime(int n) {
		for (int i=2; i<=Math.floor(Math.sqrt(n)); i++) {
			if (n%i == 0) {
				return false;
			}
		} return true;
	}

}
