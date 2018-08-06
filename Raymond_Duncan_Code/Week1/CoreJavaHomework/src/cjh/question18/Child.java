package cjh.question18;

public class Child extends Parent {
	/*
	 *  Write a program having a concrete subclass that inherits three abstract methods from a superclass. Provide the following three 
	 *  implementations in the subclass corresponding to the abstract methods in the superclass:
	 *  1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
	 *  2. Convert all of the lower case characters to uppercase in the input string, and return the result.
	 *  3. Convert the input string to integer and add 10, output the result to the console.
	 */

	@Override
	public boolean hasUpperCase(String str) {
		for(Character c:str.toCharArray()) {
			if(Character.isUpperCase(c)) return true;
		}
		return false;
	}

	@Override
	public String toUpperCase(String str) {
		return str.toUpperCase();
	}

	@Override
	public void add10(String str) {
		Integer n = null;
		try {
			n = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			System.out.println("String has no integers");
			return;
		}
		System.out.println(n+10);

	}

}
