package q19;

import java.util.ArrayList;

/*
 * Create an ArrayList and insert integers 1 through 10. Display the ArrayList.
 * Add all the even numbers up and display the result. Add all the odd numbers
 * up and display the result. Remove the prime numbers from the ArrayList and
 * print out the remaining ArrayList.
 */

public class Q19 {
	
	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();	// create ArrayList
		System.out.println("ArrayList:");
		for (int i=0; i<10; i++) {
			arrList.add(i+1);		// add elements 1 through 10
			System.out.println(arrList.get(i));	// print
		}
		
		System.out.println("");
		int evenSum = 0;
		for (int i=0; i<10; i++) {
			if (arrList.get(i)%2 == 0) {
				evenSum += arrList.get(i);
			}
		}
		System.out.println("Sum of even numbers: " + evenSum);
		
		System.out.println("");
		int oddSum = 0;
		for (int i=0; i<10; i++) {
			if (arrList.get(i)%2 == 0) {
				oddSum += arrList.get(i);
			}
		}
		System.out.println("Sum of odd numbers: " + oddSum);
		
		System.out.println("");
		System.out.println("ArrayList without prime numbers:");
		for (int i=0; i<10; i++) {
			if (!isPrime(arrList.get(i))) {
				System.out.println(arrList.get(i));
			}
		}
		
	}
	
	static boolean isPrime(int n) {
		for (int i=2; i<=Math.floor(Math.sqrt(n)); i++) {
			if (n%i == 0) {
				return false;
			}
		} return (n > 1);	// 1 isn't prime
	}

}
