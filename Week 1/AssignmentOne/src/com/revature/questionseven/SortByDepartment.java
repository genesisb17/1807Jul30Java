package com.revature.questionseven;

import java.util.Comparator;

public class SortByDepartment implements Comparator<Employee>{
	
	public int compare(Employee a, Employee b) {
		return a.department.compareTo(b.department);
	}
}
