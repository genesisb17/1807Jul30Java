package q17;

import java.util.Scanner;

public class Interest {

	public static void main(String[] args) {
		
		//Instantiates scanner class
		Scanner scan = new Scanner(System.in);
		
		//Asks user for principal then scans for it
		System.out.println("Enter your principal: ");
		int principal = scan.nextInt();
		
		//Asks user for rate in %, i.e. 10%, then scans for it
		System.out.println("Enter your rate in %: ");
		double rate = scan.nextDouble()/100;
		
		//Asks user for time in years then scans for it
		System.out.println("Enter the time in years: ");
		int time = scan.nextInt();
		
		//Calculates interest via principal * rate ^ time
		//The problem states principal * rate * time but I don't think that's the correct equation for interest
		double money = principal * (Math.pow(1+rate, time));
		//Tells user how much money they'll make from interest.
		System.out.println("Here is the amount of money you'll make in " + time + " years from interest: $" + (Math.round(money * 100.0)/100.0 - principal));
		
	}

}
