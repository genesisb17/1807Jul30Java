package com.revature.io;

public class Driver {

	public static void main(String[] args) {
		Student s = new Student("Gen", "gab12@duke.edu", 99.99);
		System.out.println(s);
		
		IODAO dao = new IODAO();
		dao.addStudent(s);
	}

}
