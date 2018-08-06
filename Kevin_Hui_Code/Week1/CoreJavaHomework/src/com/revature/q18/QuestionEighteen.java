package com.revature.q18;

public class QuestionEighteen {
	
	// Test Driver for the implemented ConcreteExmaple class
	public static void main(String[] args) {
		AbstractExample example = new ConcreteExample();
		
		String str1 = "a very odd penguin.";
		String str2 = "bowties are Cool.";
		String str3 = "ten";
		String str4 = "11111098";
		
		System.out.println("String \"" + str1 + "\" contains Uppercase letters?? => " + example.containsUppercase(str1));
		
		System.out.println("String \"" + str2 + "\" contains Uppercase letters?? => " + example.containsUppercase(str2));
		
		System.out.println("String \"" + str1 + "\" converted to all Uppercase => " + example.convertToUppercase(str1));
		
		System.out.println("String \"" + str2 + "\" converted to all Uppercase => " + example.convertToUppercase(str2));
		
		System.out.println(example.convertToIntPlusTen(str4));
		
		try {
			System.out.println(example.convertToIntPlusTen(str3));
		} catch (Exception e) {
			System.out.println("NaN... wait, this isn't JavaScript!");
		}

	}

}
