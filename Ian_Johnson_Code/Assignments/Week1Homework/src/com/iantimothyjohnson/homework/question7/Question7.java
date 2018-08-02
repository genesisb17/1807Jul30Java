package com.iantimothyjohnson.homework.question7;

import java.util.Arrays;

/**
 * Sort two employees based on their name, department, and age using the
 * Comparator interface.
 * 
 * @author Ian Johnson
 */
public class Question7 {
	public static void main(String[] args) {
		// Construct an array of employees.
		Employee[] employees = { new Employee("Ian Johnson", 22, "Training"),
				new Employee("John Smith", 50, "Management"),
				new Employee("Jane Doe", 26, "HR"),
				new Employee("Bill Billingston", 21, "Training")};
		System.out.println("Employees:");
		printEmployees(employees);

		// Sort the employees by name. We use a lambda function as a comparator
		// here to keep things brief; the compareTo method of String is a simple
		// way to sort alphabetically.
		Arrays.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));
		System.out.println("Sorted by name:");
		printEmployees(employees);
		
		// Sort the employees by age. The comparator (a, b) -> a - b, where a
		// and b are numbers, will sort a list of numbers in increasing order,
		// since a - b is positive whenever a is larger than b (and so on for
		// the other cases, satisfying the comparator condition).
		Arrays.sort(employees, (e1, e2) -> e1.getAge() - e2.getAge());
		System.out.println("Sorted by age:");
		printEmployees(employees);
		
		// Sort the employees by department. This is very much like sorting by
		// name.
		Arrays.sort(employees, (e1, e2) -> e1.getDepartment().compareTo(e2.getDepartment()));
		System.out.println("Sorted by department:");
		printEmployees(employees);
	}
	
	/**
	 * Print out the given array of employees (helper function).
	 * 
	 * @param employees The employee array to print.
	 */
	private static void printEmployees(Employee[] employees) {
		for (Employee employee : employees) {
			System.out.println("  - " + employee);
		}
		System.out.println();
	}
}
