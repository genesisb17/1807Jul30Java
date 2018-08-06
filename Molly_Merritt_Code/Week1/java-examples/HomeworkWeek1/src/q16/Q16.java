package q16;

import java.util.Scanner;

/*
 * Write a program to display the number of characters for a string input. The
 * string should be entered as a command line argument using (String[] args)
 */

public class Q16 {
	
	public static void main(String[] args) {
		int numChars;
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			numChars = scan.nextLine().length();
			System.out.println("Number of characters: " + numChars);
		}
		scan.close();
	}

}
