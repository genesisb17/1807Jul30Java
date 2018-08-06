package com.revature.questionfive;

public class QuestionFive {
	
	static String substring(String str, int idx) {
		String inString = str;
		String outString = "";
		
		for(int i = 0; i < idx; i++) {		
			outString = outString + inString.charAt(i);
		}
		
		return outString;
	}
	
	public static void main(String[] args) {
		System.out.println(substring("hello", 3));
	}
	
}
