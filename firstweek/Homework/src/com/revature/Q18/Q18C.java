package com.revature.Q18;

public class Q18C extends Q18 {

	@Override
	public String convertToLowerCase(String input) {

		String lower = input.toLowerCase();
		System.out.println(lower);
		return lower;

	}

	@Override
	public Integer convertStringAndAddTen(String input) {

		int num = Integer.parseInt(input);
		int result = num + 10;
		System.out.println(result);
		return result;

	}

	@Override
	public boolean checkForUpperCase(String input) {
		for (int i = 0; i < input.length(); i++) {
			char x = input.charAt(i);
			if (Character.isUpperCase(x)) {
				System.out.println("True");
				return true;
			}
		}
		System.out.println("False");
		return false;

	}

	public static void main(String[] args) {
		Q18C q18 = new Q18C();
		q18.checkForUpperCase("hellOo");
		q18.convertToLowerCase("DYLAN");
		q18.convertStringAndAddTen("100");
	}

}
