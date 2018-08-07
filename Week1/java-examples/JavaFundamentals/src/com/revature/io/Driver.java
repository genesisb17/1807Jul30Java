package com.revature.io;

import java.util.List;

public class Driver {
	static IODAO dao = new IODAO();

	public static void main(String[] args) {
		Student s = new Student("Patrick Walsh", "pjwalsh@revature.com", 85);
		viewStudents();
	}


	static void viewStudents() {
		List<Student> students = dao.readStudents();
		for(Student s : students) {
			System.out.println(s);
		}
	}

}
