package assignment1;

import java.util.Scanner;

public class QSixteen {

	public static void main(String[] args) 
	{
		System.out.println("Enter a string of characters");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		System.out.println(input.length());
		scan.close();
	}	
}
