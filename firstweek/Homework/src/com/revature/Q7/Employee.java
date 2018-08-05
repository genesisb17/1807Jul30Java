package com.revature.Q7;


import java.util.Arrays;

public class Employee {
	
	private String name;
	private String department;
	private int age;
	
	
	public  Employee(String name, String department, int age) {
		this.setName(name);
		this.setDepartment(department);
		this.setAge(age);
	}
	
	public static void printArray(Employee[] empsList) {
		for(Employee e : empsList) {
			System.out.println(e.toString());
		}
	}
	
	
	public static void main(String[] args) {
		Employee e1,e2;
		e1 = new Employee("Dylan Corbus" ,"Database", 23);
		e2 = new Employee("John Smith" , "Marketing", 21);
		
		Employee[] emps = {e1, e2};
		Arrays.toString(emps);
		// By name
		Arrays.sort(emps, new Sorter());
		printArray(emps);
		// By age
		Arrays.sort(emps, new SortByDept());
		printArray(emps);
		Arrays.sort(emps, new SortByAge());
		printArray(emps);
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return name + ", " + department + " " + age;
	}
}
