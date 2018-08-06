package cjh.question05;

public class SubString {
	/*
	 * Write a substring method that accepts a string str and an integer idx and returns the
	 * substring contained between 0 and idx-1 inclusive. Do NOT use any of the existing
	 * substring methods in the String, StringBuilder, or StringBuffer APIs
	 */

	public static void main(String[] args) {
		String str = "Hello";
		for(int i = 0; i < str.length(); i++) {
			System.out.println("Substring at index " + i + " is " + subString(str,i));
		}
	}
	
	public static String subString(String str, int i) {
		char[] strArray = str.toCharArray();
		String subStr = "";
		for(int j = 0; j < i; j++) {
			subStr += strArray[j];
		}
		return subStr;
	}
}
