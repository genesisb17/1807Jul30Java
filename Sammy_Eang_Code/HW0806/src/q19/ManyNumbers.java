package q19;

import java.util.ArrayList;
import java.util.Arrays;

public class ManyNumbers {
	
	public static void main(String[] args) {

		//New array list for numbers 1 through 10
		ArrayList<Integer> listTen = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		//Print em out
		System.out.println(listTen);
		
		//Sum of even numbers
		int sumEven = 0;
		//Loops from 1 to 10
		for(int a: listTen) {
			//If even, add to sum
			if(a%2 == 0) {
				sumEven += a;
			}
		}
		//Print sum
		System.out.println(sumEven);
		
		//Sum of odd numbers
		int sumOdd = 0;
		//loops from 1 to 10
		for(int a: listTen) {
			//if odd, add to sum
			if(a%2 != 0) {
				sumOdd += a;
			}
		}
		//Print sum
		System.out.println(sumOdd);
		
		//for all numbers in array list
		for(int i= 0; i < listTen.size(); i++) {
			//remove if less than 2
			if(listTen.get(i) < 2) {
				listTen.remove(i);
				//reset counter
				i = 0;
			//if divisble by 2 or 3, remove and reset counter
			} else if(listTen.get(i) % 2 == 0 && listTen.get(i) > 2) {
				listTen.remove(i);
				i = 0;
			} else if (listTen.get(i) % 3 == 0 && listTen.get(i) > 3) {
				listTen.remove(i);
				i = 0;
			}
		}
		
		//print out remaining prime numbers
		System.out.println(listTen);
	}
	
}
