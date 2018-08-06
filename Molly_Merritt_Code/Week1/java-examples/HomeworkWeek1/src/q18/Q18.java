package q18;

/*
 * Write a program having a concrete subclass that inherits three abstract
 * methods from a superclass. Provide the following three implementations in
 * the subclass corresponding to the abstract methods in the superclass:
 * 
 * 1. Check for uppercase characters in a string, and return 'true' or 'false'
 *    depending if any are found
 * 
 * 2. Convert all of the lower case characters to uppercase in the input
 *    string, and return the result.
 *    
 * 3. Convert the input string to integer and add 10, output the result to
 *    the console.
 */

public class Q18 {
	
	public boolean upperCase(String str) {
		for (int i=0; i<str.length(); i++) {
			if (Character.isUpperCase((Character) str.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	public String lowerToUpper(String str) {
		int l = str.length();
		char[] ch = new char[l];
		for (int i=0; i<str.length(); i++) {
			ch[i] = Character.toUpperCase(str.charAt(i));
		}
		return String.valueOf(ch);
	}
	public void convertInput(String str) {
		Integer[] integer = new Integer[str.length()];
		for (int i=0; i<str.length(); i++) {
			integer[i] = Integer.parseInt(str);
			integer[i] += 10;
			System.out.print(integer[i]);
		}
	}

}
