package com.revature.q19;

import java.util.ArrayList;

import com.revature.q09.QuestionNine;


/**
 * 
 * @author Kevin Hui
 *
 */
public class QuestionNineteen {
	
	public static ArrayList<Integer> populateArray(int n) {
		ArrayList<Integer> arr = new ArrayList<Integer>();

		// Populate list from 0 to n (the initial 0 will get removed towards the end, for simplicity)
		for (int i = 0; i <= n; i++) {
			arr.add(i);
		}
		
		return arr;
	}
	
	// Add all evens within the array
	public static int addAllEvens(ArrayList<Integer> arr) {
		int result = 0;
		for (int x: arr) {
			if(x % 2 == 0) {
				result += x;
			}
		}
		return result;
	}
	
	// Add all odds within the array
	public static int addAllOdds(ArrayList<Integer> arr) {
		int result = 0;
		for (int x: arr) {
			if(x % 2 == 1) {
				result += x;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> arr = populateArray(10);
		System.out.println("Array: " + arr);
		
		System.out.println("Adding all even numbers: " + addAllEvens(arr));
		System.out.println("Adding all odd numbers: " + addAllOdds(arr));
		
		ArrayList<Integer> primeArr = QuestionNine.listPrimes(10);
		
		for (Integer i: primeArr) {
			arr.remove(i);
		}
		
		System.out.println("Array without prime numbers: " + arr);
	}

}
