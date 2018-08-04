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
			//System.out.println(i);
			nums.add(i);
		}
		
		
		for(int num : nums) {			//loop through the numbers
			if(isPrime(num)) {
				System.out.println(num);
			}
		}
	}
	
	public static boolean isPrime(int n) {
		if(n < 2) {							//we don't care about these
			return false;
		}
		for(int i = 2; i <= n/2; i++) {		//only check values to half of number for efficiency
			if(n%i ==0) {					//if can be divided by any number bigger than 1 then
				return false;				//it is NOT prime
			}
		}
		return true;
	}

}
