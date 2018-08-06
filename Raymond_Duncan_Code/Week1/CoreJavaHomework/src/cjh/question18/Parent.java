package cjh.question18;

abstract public class Parent {
	/*
	 *  Write a program having a concrete subclass that inherits three abstract methods from a superclass. Provide the following three 
	 *  implementations in the subclass corresponding to the abstract methods in the superclass:
	 *  1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
	 *  2. Convert all of the lower case characters to uppercase in the input string, and return the result.
	 *  3. Convert the input string to integer and add 10, output the result to the console.
	 */
	public abstract boolean hasUpperCase(String str);
	
	public abstract String toUpperCase(String str);
	
	public abstract void add10(String str);

}
