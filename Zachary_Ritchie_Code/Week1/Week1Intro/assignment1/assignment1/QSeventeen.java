package assignment1;

import java.util.Scanner;

public class QSeventeen {

	public static void main(String[] args) 
	{
		System.out.println("Please enter your principal");
		Scanner scan = new Scanner(System.in);
		double input = Double.parseDouble(scan.nextLine());
		double principal = input;
		System.out.println("Please enter your rate");
		input = Double.parseDouble(scan.nextLine());
		double rate = input;
		System.out.println("Please enter your time");
		input = Double.parseDouble(scan.nextLine());
		double time = input;
		
		double interest;
		interest = principal*rate*time;
		
		System.out.println(interest);
		scan.close();
	}

}
