package q09;

import java.util.ArrayList;

public class Prime {

	public static void main(String[] args) {

		//declare array to store numbers
		ArrayList<Integer> allNums = new ArrayList<Integer>();
		
		//loops from numbers 0 to 100
		for(int i = 0; i < 101; i++) {
			//add each number to arraylist
			allNums.add(i);
			
			//if prime is true
			if (isPrime(i)) {
				//print prime number
				System.out.println(i);
				
			}
		}
	}
	
	//Is the number prime? function
	static boolean isPrime(int a) {
		
		//Ignore numbers less than 2 since they are not prime
		if(a < 2) {
			return false;
		}
		
		//Starting from 2, divide number by all subsequent numbers
		for(int b = 2; b <= a/2; b++) {
			//if at any point there is a modulus 0
			if(a%b == 0) {
				//boolean is false
				return false;
			}
		}
		
		//else boolean is true
		return true;
		
	}

}
