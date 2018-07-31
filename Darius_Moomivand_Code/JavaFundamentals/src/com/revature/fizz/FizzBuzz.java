package com.revature.fizz;

public class FizzBuzz {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Scanner sc = new Scanner(System.in);
		int temp = 0;
		temp = sc.nextInt();
		*/
		
		// access first element of string
		String num = args[0];
		
		//parse String into int. An example of boxing
		int n = Integer.parseInt(num);
		
		for(int i = 1; i <= n; i++) {
			if(i % 3 == 0) {
				 System.out.println("Fizz"); 
			} else if(i % 5 == 0) {
				System.out.println("Buzz");
			} else if(i % 15 == 0){
				System.out.println("FizzBuzz");
			} else {
			System.out.println(i);
			}
		}

	}
}
