package q14;

import java.time.LocalDateTime;

public class Cases {

	public static void main(String[] args) {
		
		//Set decide to 0, 1, or 2 to get the sqrt, date, or string array respectively
		int decide = 0;
		String temp = "I am learning Core Java";

		switch(decide) {
			case 0:
				//Finds the square root of a number using the Math.sqrt() method
				double num = Math.sqrt(36);
				System.out.println(num);
				break;
			case 1:
				//get the time date
				System.out.println(LocalDateTime.now());
				break;
			case 2:
				//Gives you a tempArray
				String[] tempArray = temp.split("");
				for(String b: tempArray) {
					System.out.print(b);
				}
				break;
			default: 
				break;
		}
		
	}
	
	
}
