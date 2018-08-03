package com.revature.into;

import java.awt.List;

import com.revature.io.IODAO;
import com.revature.io.Student;

public class Driver {

	static IODAO dao = new IODAO();
	
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		Student s = new Student("Warbler", "warblerboy@harvard.edu", 80);
		//System.out.println(s);
		
		//dao.addStudent(s);
		//viewStudents();
		
		/*ArrayList a = new ArrayList();
		a.add(s);
		a.add(new Integer(5));
		a.addAll("SAFDOI");
		
		for (Object o: a) {
			System.out.println(o);
		}*/
	}

	/*static void viewStudents() {
		List<Student> students = dao.readStudents();
		for(Student s : students) {
			System.out.println(s.getName());
		}
	}*/

}
