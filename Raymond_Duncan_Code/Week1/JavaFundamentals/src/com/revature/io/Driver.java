package com.revature.io;

import java.util.List;

public class Driver {
	static IODataAccessObject iodao= new IODataAccessObject();

	public static void main(String[] args) {

		Student s = new Student("Raymond", "raymond.duncan@gmail.com", 99.99, null);
		System.out.println(s);
		
//		iodao.addStudent(s);
		viewStudents();
		
		
	}
	
	static void viewStudents() {
		List<Student> students = iodao.readStudents();
		for(Student s : students) {
			System.out.println(s.getName());
		}
	}

	
}
