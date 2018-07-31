package com.revature.fizzbuzz;

public class FizzBuzz{
	public static void main(String[] args){
		/*Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();*/
		String num = args[0];
		//access first element of String array 
		int n = Integer.parseInt(num);
		//parse String into int
		
		for(int i = 0; i < n; i++){
			//figures out if i is divisible by BOTH 3 and 5
			if(i%15 == 0){
				//whats the difference between println and print?
				System.out.println("FizzBuzz");
			}
			else if(i%5 == 0){
				System.out.println("Buzz");
			}
			else if(i%3 == 0){
				System.out.println("Fizz");
			}
			//if none of the statements are true, then this is a default statement
			else{
				System.out.println();
			}
		}
	}
}