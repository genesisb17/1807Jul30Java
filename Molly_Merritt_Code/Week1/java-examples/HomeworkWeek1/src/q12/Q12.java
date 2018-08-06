package q12;

/*
 * Write a program to store numbers from 1 to 100 in an array. Print out all
 * the even numbers from the array. Use the enhanced FOR loop for printing
 * out the numbers.
 */

public class Q12 {
	
	public static void main(String[] args) {
	
		int[] arr = new int[100];	// create int array of size 100
		for (int i=0; i<100; i++) {
			arr[i] = i+1;	// add elements 1 through 100
		}
		for (int element : arr) {
			if (element%2 == 0) {				// if even
				System.out.println(element);	// print
			}
		}
	
	}


}
