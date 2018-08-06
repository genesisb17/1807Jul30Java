package com.revature.questionseven;

import java.util.Comparator;

class SortByAge implements Comparator<Employee>
{
	public int compare(Employee a, Employee b) {
		return a.age - a.age;
	}
}
