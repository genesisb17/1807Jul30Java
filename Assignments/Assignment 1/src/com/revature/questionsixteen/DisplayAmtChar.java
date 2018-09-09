package com.revature.questionsixteen;

public class DisplayAmtChar {
	static int count;
	
	public static void main(String[] args) {
		
		if(args.length > 0) {
			System.out.println("The command lines arguments are: ");
			for(String val:args) {
				count += val.length();
			}
			System.out.println("The amount of characters in"
					+ " the argument line is: " + count);
		}
		else {
			System.out.println("End of arguments");
		}
	}
}
