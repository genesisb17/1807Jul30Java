package com.revature.questionthree;

class Reverse{
	
	public String Reversed(String str){
		int totalL = str.length();
		String reversed = "";
		
		for(int i = 0; i < str.length(); i++) {
			reversed = reversed + str.charAt(totalL-1);
			totalL = totalL - 1;
		}
		
		return reversed;
	}
}