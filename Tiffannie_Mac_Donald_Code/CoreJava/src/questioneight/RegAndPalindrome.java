package questioneight;

import java.util.ArrayList;
import java.util.Arrays;

public class RegAndPalindrome {
	/*
	 * Write  a  program  that  stores  the  following  strings  in  an  ArrayList  
	 * and  saves  all  the palindromes in another ArrayList.“karan”, “madam”,”tom”, 
	 * “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
	 */
	public static void main(String[] args) {
		
		ArrayList<String> reg = new ArrayList<String>(Arrays.asList("karan",
				"madam","tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  
				"refer", "billy", "did"));
		
		ArrayList<String> pali = new ArrayList<String>();
		
		for(String word : reg) {
			//if the 			reverse of the word 		equals the word
			if(new StringBuilder(word).reverse().toString().equals(word)) {
				//it's a palidrome
				pali.add(word);
			}
		}
		
		//System.out.println(pali);
	}

}
