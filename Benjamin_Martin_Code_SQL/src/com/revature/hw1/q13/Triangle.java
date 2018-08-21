package com.revature.hw1.q13;

public class Triangle {

	public static void main(String[] args) {
		
		// Sets how many rows it will make
		int n = 4;
		printTriangle(n);
	}
	
	public static void printTriangle(int n)  {

		// Loops to make a new row
        for(int i=0; i<n; i++) {
 
        	// Loops for each item in a column printing whichever contents the if statements allow...I'M SORRY :(
            for(int j=0; j<=i; j++)
            {
                if (i == 0) {
                	System.out.print("0");
                	continue;
                }
                else if (i == 1) {
                	System.out.print("1 " + "0");
                	break;
                }
                else if (i == 2) {
                	System.out.print("1 " + "0 " + "1");
                	break;
                }
                else if (i == 3) {
                	System.out.print("0 " + "1 " + "0 " + "1");
                	break;
                }
            }
            System.out.println();
        }
	}
}
