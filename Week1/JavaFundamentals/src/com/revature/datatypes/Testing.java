package com.revature.datatypes;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Days.MONDAY.live();
		
		Days day = Days.FRIDAY;
		Days day2 = Days.valueOf("MONDAY");
		
		switch(day) {
			case MONDAY:
				day.live();
				break;
		}

	}
}
