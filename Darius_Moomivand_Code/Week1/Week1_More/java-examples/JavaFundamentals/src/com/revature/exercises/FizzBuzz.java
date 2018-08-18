package com.revature.exercises;

public class FizzBuzz {
	public static void main(String[] args){
		/*Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();*/
		
		
		
		//access first element of String array
		String num = args[0];
		
		//parse String into int 
		int n = Integer.parseInt(num);
		
		for(int i = 1; i < n; i++){
			if(i % 15==0) {
				System.out.println("FizzBuzz");
			}
			else if(i%5==0){
				System.out.println("Buzz");
			}
			else if(i%3==0){
				System.out.println("Fizz");
			}
			else{
				System.out.println(i);
			}
		}
		
		
	}
}
