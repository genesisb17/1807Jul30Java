//Created by Darius Moomivand @ 04Aug18
package com.revature.hw;

public class Palindrome {
		//Method used to check if a string is a palindrome
		public static void pal(String s) {
			int counter = 0;		// counter used to index reverse string
			Boolean check = true;  // boolean used to check 
			
			for(int i = s.length()-1; i > 0; i--) {
				if(s.charAt(i) != s.charAt(counter)) {
					System.out.println("Not a palindrome!!!");
					check = false;
					break;
				} else
					counter++;
			}
			if(check)
				System.out.println("Its a palindrome");
		}
		
		public static void main(String[] args) {

			String string = "elephant";
			Palindrome.pal(string);
			String string2 = "racecar";
			Palindrome.pal(string2);
			
			
		}
}
