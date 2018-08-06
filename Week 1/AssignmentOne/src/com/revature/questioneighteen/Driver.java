package com.revature.questioneighteen;

public class Driver {

	public static void main(String[] args) {
		String randomWord = "Leggo my Eggooooo";
		SubClass testing = new SubClass();
		
		System.out.println(testing.checkUpper(randomWord));
		System.out.println(testing.convertLower(randomWord));
		System.out.println(testing.stringAndTen(randomWord));
	}

}
