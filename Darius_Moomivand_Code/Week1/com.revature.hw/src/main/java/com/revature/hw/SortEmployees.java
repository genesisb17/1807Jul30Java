//Created by Darius Moomivand @ 04Aug18
package com.revature.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Employee class with 
class Employee{
	String name;
	String department;
	int age;
	
	
	//Overloaded constructor added, must implement default construct (see below)
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}

	// No parameter constructor added to replace lost default constructor
	public Employee() {
		this.name = "John";
		this.department = "Unassigned";
		this.age = 18;
	}
	
	//ToString used for printing out objects
	public String toString() {
		return this.name + " " + this.department + " " + age; 
	}
}

class sortName implements Comparator<Employee>{

	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.name.compareTo(o2.name);
	}
	
}

public class SortEmployees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("Joe", "Special Projects", 20));
		list.add(new Employee("Darius", "Software Development", 29));
		list.add(new Employee("Annie", "Corporate", 25));

		System.out.println("The Unsorted list: ");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		Collections.sort(list, new sortName());
		
		System.out.println("The Sorted list: ");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}



}
