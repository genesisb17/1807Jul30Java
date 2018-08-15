package com.revature.io;

import java.util.List;

public class Driver {
	static IODAO dao = new IODAO();
	
	static void viewStudents() {
		List <Student> students = dao.readStudents();
		for(Student s : students) {
			System.out.println(s);
		}
		
	}
	public static void main(String[] args) {
		Student s = new Student("John Smith", "johnsmith@csumb.edu", 90.0);
		
		
		viewStudents();
		
		dao.addStudent(s);
	}
}
