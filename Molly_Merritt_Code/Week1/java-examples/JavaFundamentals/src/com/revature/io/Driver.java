package com.revature.io;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	static IODAO dao = new IODAO();

	public static void main(String[] args) {
		Student s = new Student("Molly", "elimar@live.unc.edu", 99.99);
		System.out.println(s.toString());
		
		
		dao.addStudent(s);
		
		ArrayList a = new ArrayList();
		a.add(s);
		a.add(new Integer(5));
		a.add("ahoiajoj");
		
		for(Object o : a) {
			System.out.println(o);
		}
	}
	
	static void viewStudents() {
		List<Student> students = dao.readStudents();
		for(Student s : students) {
			System.out.println(s.getName());
		}
	}

}
