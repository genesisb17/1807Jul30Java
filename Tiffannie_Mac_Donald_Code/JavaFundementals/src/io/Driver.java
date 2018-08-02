package io;

import java.util.List;

public class Driver {
	static IODAO dao = new IODAO();
	static void main(String[] args) {
		Student s = new Student("Gen", "blah@duke.com", 99.99);
		System.out.println(s);
		
		
		
		dao.addStudent(s);
	}
	
	static void viewStudents() {
		List<Student> students = dao.readStudents();
		for(Student s : students) {
			System.out.println(s.getName());
		}
	}
}
