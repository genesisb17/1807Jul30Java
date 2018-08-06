package q14;

import java.util.Date;
import java.util.Random;

/*
 * Write a program that demonstrates the switch case. Implement the following
 * functionalities in the cases:
 * 
 * Case 1: Find the square root of a number using the Math class method
 * 
 * Case 2: Display today's date
 * 
 * Case 3: Split the following string and store it in a string array:
 * 		   "I am learning Core Java"
 */

public class Q14 {
	
	public static void main(String[] args) {
		Random r = new Random();
		int num = r.nextInt(3) + 1;	// generate random num between 1 and 3
		switch (num) {
			case 1:
				double x = Math.random()*100;	// generate random num
				double sqRoot = Math.sqrt(x);	// calculate square root
				System.out.print("The square root of " + x + " is " + sqRoot);
				break;
			case 2:
				Date date = new Date();	// get date
				System.out.println(date);
				break;
			case 3:
				String[] str = new String[5];	// create string array
				str[0] = "I";
				str[1] = "am";
				str[2] = "learning";
				str[3] = "Core";
				str[4] = "Java";
				System.out.println(str[0]+" "+str[1]+" "+str[2]+" "+str[3]+" "+str[4]);
		}
	}

}
