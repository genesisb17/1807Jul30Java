package cjh.tests;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import cjh.question07.Employee;
import cjh.question07.EmployeeComparator;

public class Question07Test {
	/*
	 * Sort two employees based on their name, department, and age using the Comparator interface.
	 */

	@Test
	public void test() {
		Employee[] employees= new Employee[10];
		employees[0] = new Employee("Charles","Hardware",44);
		employees[1] = new Employee("Jeff","Hardware",32);
		employees[2] = new Employee("Jeff","Appliances",62);
		employees[3] = new Employee("Sam","Hardware",23);
		employees[4] = new Employee("Sam","Hardware",51);
		employees[5] = new Employee("Cassandra","Appliances",22);
		employees[6] = new Employee("Ashley","Softlines",28);
		employees[7] = new Employee("Marla","Softlines",36);
		employees[8] = new Employee("John","Appliances",53);
		employees[9] = new Employee("Mark","Hardware",50);
		
		int[] correctOrder = {6,5,0,2,1,8,9,7,3,4};
		Employee[] orderedEmployees = new Employee[10];
		
		for(int i = 0; i < 10; i++) {
			orderedEmployees[i] = employees[correctOrder[i]];
		}
		
		Arrays.sort(employees, new EmployeeComparator());
		assertArrayEquals(orderedEmployees, employees);
	}

}
