package com.revature.questionseven;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionSeven{
		public static void main(String[] args) {
			ArrayList<Employee> ar = new ArrayList<Employee>();
			ar.add(new Employee("Sonny", "Mechanic", 39));
			ar.add(new Employee("Jake", "Marketing", 24));
			
			Collections.sort(ar, new SortByAge());
			for(int i = 0; i < ar.size(); i++) {
				System.out.println(ar.get(i));
			}
			
			Collections.sort(ar, new SortByName());
			for(int i = 0; i < ar.size(); i++) {
				System.out.println(ar.get(i));
			}
			
			Collections.sort(ar, new SortByDepartment());
			
			for(int i = 0; i < ar.size(); i++) {
				System.out.println(ar.get(i));
			}
			
	}
}
	 
