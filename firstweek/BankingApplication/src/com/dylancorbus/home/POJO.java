package com.dylancorbus.home;

import java.util.Scanner;

public class POJO {
	static Scanner scan = new Scanner(System.in);
	public void userLogin() {
		System.out.println("Please enter your user name.");
		String input = scan.nextLine();
		scan.close();
		/* call method to check database to see if name exists in the customers table
		 * if((SELECT FIRSTNAME 
		 * 	  FROM USERS
		 *    WHERE NAME = 'INPUT';) == input) { 
		 */
		System.out.println("You have succesfully logged in as " + input);
		//call method to display account balance
	}	
		public void createUser() {
			
			System.out.println("Please enter your desired username.");
			String input = scan.nextLine();
			scan.close();
			/* call method to check database to see if name exists in the customers table
			 * if((SELECT USERNAME 
			 * 	  FROM USERS
			 *    WHERE NAME = 'INPUT';) == null) { 
			 */
			System.out.println("You have chosen " + input + " as your username.");
			/*} else if (
			 * if((SELECT USERNAME 
			 * 	  FROM USERS
			 *    WHERE NAME = 'INPUT';) == INPUT) {
			 * 
			 */
			//call method to display account balance	
	}

}
