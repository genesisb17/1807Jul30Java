package com.revature.questionnineteen;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ArrayManip {

	static int sumOfEven;
	static int sumOfOdd;
	
	public static void main(String[] args) {
		List<Integer> manipArray = new ArrayList<Integer>();
		
		for(int i = 0; i <= 10; i++) {
			manipArray.add(i);
		}
		
		for(int i = 0; i <= manipArray.size()-1; i++) {
			if(manipArray.get(i)%2 == 0) {
				sumOfEven += manipArray.get(i);
			} else {
				sumOfOdd += manipArray.get(i);
			}
		}
		
		System.out.println("Sum of even is: " + sumOfEven);
		System.out.println("Sum of odd is: " + sumOfOdd);
		
		int newArraySize = manipArray.size();
		for(int i = 0; i <= newArraySize-1; i++) {
			BigInteger check = new BigInteger(Integer.toString(manipArray.get(i)));
			if(manipArray.get(i) == 0 || manipArray.get(i) == 1 ||
					check.isProbablePrime(1) == true) {
				manipArray.remove(i);
			}
		}
		
		for(int i = 0; i <= manipArray.size()-1; i++) {
			System.out.println(manipArray.get(i));
		}
	}
}
