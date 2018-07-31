package com.revature.datatypes;

public class Testing {

	public static void main(String[] args) {
		Days.MONDAY.live();
		
		Days day = Days.FRIDAY;
		Days day2 = Days.valueOf("Monday");
		
		switch(day) {
		case MONDAY:
			day.live();
			break;
		}
		
		double dollars = 10.0;
//		switch(dollars) {
//		
//		}
		
		Calendar c = new Calendar();
		c.setDay(Days.TUESDAY);
	}

}
