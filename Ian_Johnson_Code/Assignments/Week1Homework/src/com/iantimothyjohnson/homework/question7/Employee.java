package com.iantimothyjohnson.homework.question7;

/**
 * A class representing an employee, with the properties mentioned in the
 * problem description.
 * 
 * @author Ian Johnson
 */
public class Employee {
	private String name;
	private int age;
	private String department;
	
	public Employee(String name, int age, String department) {
		this.setName(name);
		this.setAge(age);
		this.setDepartment(department);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Must provide a name.");
		}
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 16) {
			throw new IllegalArgumentException("Employee is too young.");
		}
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		if (department == null || department.isEmpty()) {
			throw new IllegalArgumentException("Must provide a department.");
		}
		this.department = department;
	}
	
	@Override
	public String toString() {
		return name + " (" + age + "), " + department;
	}
}
