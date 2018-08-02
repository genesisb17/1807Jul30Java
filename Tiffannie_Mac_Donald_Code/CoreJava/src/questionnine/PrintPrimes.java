package questionnine;

import java.util.ArrayList;

public class PrintPrimes {
/*
 * Create an ArrayList which stores numbers from 1 to 100 
 * and printsout all the prime numbers tothe console
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for(int i = 0; i< 101; i++) {
			System.out.println(i);
			nums.add(i);
		}
	}

}
