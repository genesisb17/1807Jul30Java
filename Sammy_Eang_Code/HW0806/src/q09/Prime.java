package q09;

import java.util.ArrayList;

public class Prime {

	public static void main(String[] args) {

		//declare array to store numbers
		ArrayList<Integer> allNums = new ArrayList<Integer>();
		
		//loops from numbers 0 to 99
		for(int i = 0; i < 100; i++) {
			//adds each number + 1, aka 1 to 100, to arraylist
			allNums.add(i+1);
		}
		
		//Prints out all numbers from 1 to 100 to show they are there
		System.out.println(allNums);
				
		//Prints out new line for organizational purposes
		System.out.println("");
		//For each number
		for(int i: allNums) {
			//if less than 2, skip
			if(i < 2) {
				continue;
			}
			//factors from 1 to 10
			for(int j = 2; j < 11; j++) {
				//if number is greater is greater than factor and has modulus of 0
				//this is done so numbers 1 through 10 are ignored for dividing by their own factors
				if(i % j == 0 && i > j) {
					//skip current for loop and go onto next number in parent for loop
					break;
					//if number is not divisible by any factors from 2 through 9
				} else if (j == 10) {
					//print number and comma
					System.out.print(i + ", ");
				}
			}
		}
	}

}
