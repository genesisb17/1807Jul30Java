package com.revature.Q7;

import java.util.Comparator;

public class Sorter implements Comparator<Employee>{

	@Override
	public int compare(Employee arg0, Employee arg1) {
		
		return arg0.getName().compareTo(arg1.getName());
	}
	
}
