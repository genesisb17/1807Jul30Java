package com.revature.intro;

public class CodingChallenge {
	
	public static void revString(String str) {
		int length = str.length();
	
		for(int i = length - 1;i > -1; i--  ) {
			
			String x =  "" + str.charAt(i);
			System.out.print(x);
			} 
	
	}
	
	
	
	public static void main(String[] name) {
		revString("race car");
	}

}
