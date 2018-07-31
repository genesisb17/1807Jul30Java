package com.revature.oop;

import java.util.ArrayList;

public class Workplace {

	public static void main(String[] args) {
		
		ArrayList<Person> roster = new ArrayList<Person>();
		
		roster.add(new Employee("Jason",46599.99));
		
		roster.add(new Employee("Kevin",38000.50));
		
		roster.add(new Boss(250000.00));
		
		for(Person p: roster) {
			System.out.println(p);
		}
	}

}
