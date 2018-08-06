package com.revature.io;

import java.util.List;

public class Driver {

	static IODAO dao = new IODAO();
	
	public static void main(String[] args) {
		Student s = new Student("Benny", "bjs@uml.edu", 80.20);
		System.out.println(s);
		
		viewStudents();
	}
	
	static void viewStudents() {
		List<Student> students = dao.readStudents();
		for(Student s : students) {
			System.out.println(s);
		}
	}

}
