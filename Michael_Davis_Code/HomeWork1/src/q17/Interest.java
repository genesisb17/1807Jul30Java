package q17;

import java.util.Scanner;

public class Interest {

	
	static double InterestCalc() {
		double g;
		Scanner t= new Scanner(System.in);
		System.out.println("Enter the amount you borrowed");
		g=t.nextDouble();
		System.out.println("Enter your interest rate i.e: 4.5 for 4.5 percent");
		double e=t.nextDouble();
		e=e/100;
		System.out.println("Enter how many years.");
		int years;
		years=t.nextInt();
		
		return (g*e)*years;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(InterestCalc());

	}

}
