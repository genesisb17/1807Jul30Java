package questiontwelve;

import java.util.ArrayList;

public class printEven {
/*
 * Write a program to store numbers from 1 to 100 in an array. Print out all the even
 *  numbers from the array. Use the enhanced FORloop for printing out the numbers.
 */
	public static void main(String[] args) {

		//initializing an arraylist
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		//populate the arraylist
		for(int i = 0; i< 101; i++) {
			//System.out.println(i);
			nums.add(i);
		}
		
		for(int num : nums) {			//enhanced for loop through the numbers
			if(num % 2 == 0) {			//num divided by 2 remainder 0 means it's even
				System.out.println(num);
			}
		}
	}

}
