package com.revature.hw;


public class Concrete extends ConcreteSuper {
	Boolean upper = false;

	@Override
	public Boolean checkUpper(String input) {
		char character;
		Boolean upper = false;

		for(int i = 0; i < input.length(); i++) {
			character = input.charAt(i);
			if(!Character.isUpperCase(character)) {
				upper = true;
				return upper;
			} 
		}
		return upper;
	}

	@Override
	public String makeUpper(String input) {
		
		return input.toUpperCase();
	}

	@Override
	public int convertString(String input) {
		int temp = Integer.parseInt(input);
		temp += 10;
		return temp;
	}


	public static void main(String[] args) {
		
		String myString = "MyCheese";
		String myIntString = "33";
		Concrete myClass = new Concrete();
		Boolean truth = myClass.checkUpper(myString);
		System.out.println(truth);
		String itsUpper = myClass.makeUpper(myString);
		System.out.println(itsUpper);
		int convertedStr = myClass.convertString(myIntString);
		System.out.println(convertedStr);
	}
}
