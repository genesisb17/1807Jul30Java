package q05;

/*
 * Write a substring method that accepts a string str and an integer idx and returns
 * the substring contained between 0 and idx-1, inclusive. Do NOT use any of the
 * existing substring methods in the String, StringBuilder, or StringBuffer APIs.
 */

public class Q5 {
	
	public static void main(String[] arg) {
		String str = "Hello world!";	// str
		int idx = 8;	// idx
		System.out.println(stringMethod(str, idx));
	}
	
	static String stringMethod(String str, int idx) {
		char[] substr = new char[idx];
		for (int i=0; i<idx; i++) {	// 0 through idx-1
			char c = str.charAt(i);	// character at index i
			substr[i] = c;	// assign to ith element of character array
		}
		String newStr = String.valueOf(substr);	// convert char array to String
		return newStr;
	}

}
