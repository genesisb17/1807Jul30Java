package com.revature.questionsix;

public class QuestionSix {
	
	public static void main(String[] args) {
		checkEven(21);
	}
	
	static void checkEven(int n) {
		if((n/2)*2 == n) { 
			System.out.println("n is even: " + n);
		} 
		else {
			System.out.println("n is odd: " + n);
		}
	}
}
