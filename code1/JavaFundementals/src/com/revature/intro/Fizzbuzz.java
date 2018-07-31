package com.revature.intro;

public class Fizzbuzz {
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		int n =scan.nextInt();
		String num = args[0];
		int n = Integer.parseInt(num);
		
		for(int i = 1; i<=n;i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("Fizzbuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) System.out.println("buzz");
			else System.out.println(i);
		
		}
		

	}
	

}

