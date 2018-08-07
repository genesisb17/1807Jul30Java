package com.revature.datatypes;

public class Testing {

	public static void main(String[] args) {
		Days.MONDAY.live();
		
		
		Days day = Days.FRIDAY;
		Days day2 = Days.valueOf("MONDAY");
		
		switch(day) {
		case MONDAY:
			day.live();
			break;
		}
		
		double dollars = 10.0;
		
		
		Calendar c = new Calendar();
		c.setDay(day);
		

	}

}
