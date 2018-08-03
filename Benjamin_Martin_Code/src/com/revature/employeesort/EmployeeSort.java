package com.revature.employeesort;

import java.util.*;
import java.lang.*;
import java.io.*;

class Employee {
	
	String name;
	String department;
	int age;
	
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String toString() {
		return this.name + " " + this.department + " " + this.age;
	}
}

class Sortbyname implements Comparator<Employee> {
	
	public int compare(Employee a, Employee b) {
		return a.name.compareTo(b.name);
	}
}

class Sortbydepartment implements Comparator<Employee> {
	
	public int compare(Employee a, Employee b) {
		return a.name.compareTo(b.name);
	}
}

class Sortbyage implements Comparator<Employee> {
	
	public int compare(Employee a, Employee b) {
		return a.age - b.age;
	}
}

class EmployeeSort {
	
	public static void main (String[] args) {
		ArrayList<Employee> em = new ArrayList<Employee>();
		em.add(new Employee("Benjamin", "Accounting", 30));
		em.add(new Employee("Kyle", "Technology", 23));
		em.add(new Employee("Cody","Finance", 25));
		
		System.out.println("Unsorted");
		for (int i = 0 ; i < em.size() ; i++)
			System.out.println(em.get(i));
		
		Collections.sort(em,  new Sortbyname());
		
		System.out.println("\nSorted by name");
		for (int i = 0 ; i < em.size(); i++)
			System.out.println(em.get(i));
		
		Collections.sort(em,  new Sortbydepartment());
		
		System.out.println("\nSorted by department");
		for (int i = 0 ; i < em.size(); i++)
			System.out.println(em.get(i));
		
		Collections.sort(em,  new Sortbyage());
		
		System.out.println("\nSorted by age");
		for (int i = 0 ; i < em.size(); i++)
			System.out.println(em.get(i));
	}
}
