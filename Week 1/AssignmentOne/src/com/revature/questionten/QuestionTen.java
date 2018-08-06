package com.revature.questionten;

public class QuestionTen {
	
	public static void main(String[] args) {
		int n1 = 5;
		int n2 = 10;
		System.out.println(Integer.toString(Minimum(n1, n2)));
	}
	
	static int Minimum(int n1, int n2) {
		int minVal = n1 < n2 ? n1 : n2;
		return minVal; 
	}
}
