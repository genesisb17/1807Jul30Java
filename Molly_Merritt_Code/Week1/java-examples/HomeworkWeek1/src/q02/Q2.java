package q02;

/*
 * Write a program to display the first 25 Fibonacci numbers beginning at 0.
 */

public class Q2 {

	public static void main(String[] args) {
		int n1 = 0;	// 0th in the sequence
		int n2 = 1;	// 1st in the sequence
		System.out.println(n1 + "\n" + n2);
		for (int i = 0; i < 25; i++) {
			int n = n1 + n2;	// (i+2)th in the sequence
			System.out.println(n);	// print the next number in the sequence
			n1 = n2;	// reassign n1 and n2
			n2 = n;
		}
	}

}
