package com.iantimothyjohnson.homework.question2;

/**
 * Write a program to display the first 25 Fibonacci numbers beginning at 0.
 * 
 * @author Ian Johnson
 */
public class Question2 {
	public static void main(String[] args) {
		for (int i = 0; i <= 25; i++) {
			System.out.printf("F_%-2d = %d\n", i, fibonacci(i));
		}
	}

	/**
	 * Compute the nth Fibonacci number. Although the recursive algorithm is more
	 * natural, given the mathematical definition of the Fibonacci numbers, it is
	 * considerably slower than the iterative algorithm which is used in this
	 * implementation.
	 * 
	 * @param n The index of the Fibonacci number to compute.
	 * @return The nth Fibonacci number. The return type is long because the
	 *         Fibonacci numbers get pretty big, even with relatively small n
	 *         (exponential growth).
	 */
	public static long fibonacci(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Fibonacci numbers with negative indices are not supported.");
		}

		// We start out with the 0th and 1st Fibonacci numbers in a and b,
		// respectively.
		long a = 0, b = 1;
		// Now, we simply repeat the process of shifting a and b up one index: b
		// becomes a + b, and a becomes what b was originally. Thus, after one
		// step, a is the 1st Fibonacci number; after two steps, a is the 2nd,
		// and so on. That is, we need to perform n iterations so that a
		// contains the nth Fibonacci number.
		for (int i = 0; i < n; i++) {
			// We need to make sure we hold on to the old value of b, because
			// we're about to overwrite it.
			long oldB = b;
			b = a + b;
			a = oldB;
		}

		// a now contains the value we want, as explained above.
		return a;
	}
}
