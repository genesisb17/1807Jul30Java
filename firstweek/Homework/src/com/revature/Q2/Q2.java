package com.revature.Q2;



public class Q2 {
	
	public static void fibonacci(int n) {
		int f1 = 1; //Sets the first 2 number equal to 1
		int f2 = 1;
		for(int i = 3; i<=n; i++) {
			/*runs threw the loop summing the previous 2 numbers to make
			 * the next number in the sequence 
			 */
			int f2a = f1;
			f1 = f1+f2;
			f2=f2a;
			
		} System.out.println(f1);		
	}
	public static void main(String[] args) {
		Q2.fibonacci(25);
	}
}
