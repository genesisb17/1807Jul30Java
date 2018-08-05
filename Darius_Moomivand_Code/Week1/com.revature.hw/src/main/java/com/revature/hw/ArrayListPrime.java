//Created by Darius Moomivand @ 05Aug18
package com.revature.hw;

import java.util.ArrayList;

public class ArrayListPrime {
	
	//Method used to find prime numbers in an ArrayList
	public static void printPrimes(ArrayList temp) {
		int num;
		Boolean check;
		for(int i = 2; i < temp.size(); i++) {
			check = true;
			num = (Integer) temp.get(i);
			for(int j = 2; j < i; j++) {
				if(num % j == 0) {
					check = false;
					break;
				}
			}
			if(check == true && num != 1 && num != 0) {
				System.out.println(num);

			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++) {
			list.add(i);
		}
		
		ArrayListPrime.printPrimes(list);
		
	}

}
