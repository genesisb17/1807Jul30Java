package com.iantimothyjohnson.homework.question13;

/**
 * Display the triangle on the console as follows using any type of loop. Do NOT
 * use a simple group of print statements to accomplish this.
 * 
 * <pre>
 * 0
 * 1 0
 * 1 0 1
 * 0 1 0 1
 * </pre>
 * 
 * @author Ian Johnson
 */
public class Question13 {
	public static void main(String[] args) {
		// Everything has a pattern :) Here, the pattern is: start with 0. Then
		// add 1 on the left. Then add 1 on the right. Then add 0 on the left.
		// And so forth (switching sides and digits 0 or 1). At least, I think
		// that's the pattern.
		String out = "0"; // The string to start with.
		boolean addLeft = true; // Whether to add on the left side.
		boolean addOne = true; // Whether to add the digit 1 (if false, add 0).
		
		// We only want 4 rows of the triangle.
		for (int i = 0; i < 4; i++) {
			System.out.println(out);
			char digit = addOne ? '1' : '0'; // The digit to add to the output.
			out = addLeft ? digit + out : out + digit; // Add the digit.

			// Now, we need to update our addLeft and addOne variables according
			// to the pattern. We always switch direction, and we also need to
			// switch digit when the direction moves from right to left.
			addLeft = !addLeft;
			if (addLeft) {
				// We moved back to the left side; update digit.
				addOne = !addOne;
			}
		}
	}
}
