package q17;

import java.util.Scanner;

public class Interest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your principal: ");
		int principal = scan.nextInt();
		
		System.out.println("Enter your rate in %: ");
		double rate = scan.nextDouble()/100;
		
		System.out.println("Enter the time in years: ");
		int time = scan.nextInt();
		
		double money = principal * (Math.pow(1+rate, time));
		System.out.println("Here is the amount of money you'll have in " + time + " years from interest: $" + Math.round(money * 100.0)/100.0);
		
	}

}
