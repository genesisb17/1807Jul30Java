package com.revature.q7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * The following deomstrates sorting an ArrayList of Employees using an implemented compare()
 * 
 * An ArrayList of Employees is created and 8 Employee objects are created and added
 * into the structure. For comparison, the roster is printed before the sort and
 * after the sort. The compare() method from the Comparator interface is implemented
 * within the same statement as the sort.
 * 
 * 
 * @author Kevin Hui
 *
 */
public class QuestionSeven {

	public static void main(String[] args) {
		
		// Creating the list to demonstrate the sort utilizing Comparator
		List<Employee> roster = new ArrayList<Employee>();

		// Add Employees
		roster.add(new Employee("Kevin", "Front Desk", 25));
		roster.add(new Employee("John", "Recruiter", 33));
		roster.add(new Employee("Rodney", "IT Manager", 25));
		roster.add(new Employee("Rodney", "Manager", 25));
		roster.add(new Employee("Reed", "Front Desk", 25));
		roster.add(new Employee("Reed", "Front Desk", 33));
		roster.add(new Employee("David", "Customer Support Staff", 21));
		roster.add(new Employee("David", "Customer Support Staff", 21));

		// Print out unordered roster
		System.out.println("Unordered List before the sort()");
		for (Employee e : roster) {
			System.out.println(e);

		}

		// Sort the array using compare() method that is implemented here
		roster.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				int nameComp = e1.getName().compareTo(e2.getName());
				int deptComp = e1.getDepartment().compareTo(e2.getDepartment());
				int ageComp = e1.getAge().compareTo(e2.getAge());

				if (nameComp != 0) {
					return nameComp;
				}

				if (deptComp != 0) {
					return deptComp;
				}

				if (ageComp != 0) {
					return ageComp;
				}

				return 0;
			}

		});

		// Print out ordered roster
		System.out.println("\nOrdered List after sort()");
		for (Employee e : roster) {
			System.out.println(e);

		}
	}
}
