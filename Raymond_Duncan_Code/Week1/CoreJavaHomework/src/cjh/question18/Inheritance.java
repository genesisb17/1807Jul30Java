package cjh.question18;

public class Inheritance {
	/*
	 *  Write a program having a concrete subclass that inherits three abstract methods from a superclass. Provide the following three 
	 *  implementations in the subclass corresponding to the abstract methods in the superclass:
	 *  1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
	 *  2. Convert all of the lower case characters to uppercase in the input string, and return the result.
	 *  3. Convert the input string to integer and add 10, output the result to the console.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child c = new Child();
		System.out.println("Should return true: " + c.hasUpperCase("Should Return True"));
		System.out.println("Should return THIS IS ALL CAPS: " + c.toUpperCase("this Is alL caps"));
		System.out.println("Should print 20 on the next line");
		c.add10("10");
	}

}
