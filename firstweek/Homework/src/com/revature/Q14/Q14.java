package com.revature.Q14;

import java.util.Date;

public class Q14 {
	
	public static void switchProblem(int n) {
		switch (n) {
		
		case 1:
			System.out.println(Math.sqrt(144.00));
			break;
		case 2:
			Date d = new Date();
			System.out.println(d.toString());
			break;
		case 3:
			
			String phrase = "I am learning core Java";
			
			
			String[] list = phrase.split(" ",2); 
			
			for (String i : list) {
				System.out.println(i);
			}
			
			
		}
		
		
	}
	public static void main(String[] args) {
		switchProblem(3);
	}

}
