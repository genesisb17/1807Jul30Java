package q08;

import java.util.ArrayList;
import java.util.Arrays;

public class Palindromes {

	public static void main(String[] args) {

		//Setting up Array of Strings
		String[] palinArray = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer",
				"billy", "did"};
		
		//Converting String Array into ArrayList of Strings
		ArrayList<String> isPalinList = new ArrayList<String>(Arrays.asList(palinArray));

		//Declaring new Array to store palindromes
		ArrayList<String> palinList = new ArrayList<String>();
		
		//Goes through list of all words
		for(String isPalin: isPalinList) {
			
			//Stringbuilder object of the reverse word
			StringBuilder reverse = new StringBuilder(isPalin).reverse();
			//Stringbuilder object of the regular word
			StringBuilder normal = new StringBuilder(isPalin);
			
			//checks if normal string is equal to reverse string
			if(normal.toString().equals(reverse.toString())) {
				//if so, add to ArrayList of palindromes
				palinList.add(isPalin);
			}
		}
		
		//print out palindromes
		for (int i=0; i<palinList.size(); i++) {
            System.out.println(palinList.get(i));
		}
	}

}
