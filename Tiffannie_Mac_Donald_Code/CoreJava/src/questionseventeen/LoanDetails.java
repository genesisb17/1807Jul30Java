package questionseventeen;

import java.util.Scanner;

public class LoanDetails {
/*
 * Write a program that calculates the simple interest on the principal, rate of interest
 *  and  number  of  years  provided  by  the  user.  Enter  principal,  rate  and  time 
 *   through  the console using the Scanner class
 *   
 *   Interest = Principal*Rate*Time
 */
	public static void main(String[] args) {
		// initialize variables
		float principal;
		float rate;
		float time;
		
		//instantiate new scanner object to get user input
		Scanner s = new Scanner(System.in);
		
		System.out.print("Please enter your principal loan amount");	//principal
		principal = s.nextFloat();
		
		System.out.println("Please, now enter your interest rate");		//rate
		rate = s.nextFloat();
		
		System.out.println("Now, finally, enter how many years(time)");	//time
		time = s.nextFloat();
		
		s.close();					//make sure to close scanner so that input isn't continuing
		
		float interest = principal * rate * time;	//the formula coded
		System.out.println("The simple interest on the principal is " + interest);
			
	}
	

}
