package com.revature.datatypes;

public class Testing {

	public static void main(String[] args) {
		
		Days.MONDAY.live(); //is Days an object?? 
		
		Days day = Days.FRIDAY;
		Days day2 = Days.valueOf("MONDAY");
		
		day.live();
		
		switch(day){
		case FRIDAY:
			day.live();
			break;
		
		}
		
		double dollars = 10.0;

		Calendar c = new Calendar();
		c.setDay(day);
		c.getDay();
		
		switch(day){
		case FRIDAY:
			day.live();
			break;
		}

	}

}
