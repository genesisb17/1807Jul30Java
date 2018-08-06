package cjh.question16;

public class InputLength {

	public static void main(String[] args) {
		/*
		 * Write a program to display the number of characters for a string input. The string should be entered as a command line argument using (String [ ] args)
		 */
		
		//This function should return 29 for the string "This string has 29 characters"
		StringBuffer sb = new StringBuffer(args[0]);
		System.out.println(sb.length());
	}
}
