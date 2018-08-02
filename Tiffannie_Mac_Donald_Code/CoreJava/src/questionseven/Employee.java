package questionseven;

import java.util.ArrayList;
import java.util.Collections;

public class Employee {
	
	/*
	 * Sort two employees based on   their   name,   department, and   age using   
	 * the Comparator interface
	 */

	public static void main(String[] args) {
		//create employees
		ArrayList<Employee> ppl = new ArrayList<Employee>(); //save employee objects in list
		
		ppl.add(new Employee("Avery","HR", 30));
		ppl.add(new Employee("Genesis","Awesome", 25));		

		System.out.println("Unsorted");
		for(int i = 0; i < ppl.size(); i ++) {
			System.out.println(ppl.get(i));
		}
		//sort by name
		Collections.sort(ppl,  new CompareName());
		
		System.out.println("\nSorted by Name");
        for (int i=0; i<ppl.size(); i++) {
            System.out.println(ppl.get(i));
        }
        
        //sort by department
        Collections.sort(ppl, new CompareDepartment());
        
        System.out.println("\nSorted by Department");
        for (int i=0; i<ppl.size(); i++) {
            System.out.println(ppl.get(i));
        }
        
        //sort by age
        Collections.sort(ppl, new CompareAge());
        
        System.out.println("\nSorted by Age");
        for (int i=0; i<ppl.size(); i++) {
            System.out.println(ppl.get(i));
        }
        
	}
	
	//*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	
	//This is where we will build our employees
	
	String name, department;
	int age;
	
	//construct employee
	public Employee(String name, String department, int age) {
		
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	//getters and setters of an employee object
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	//used to print employee deets in main method()
	public String toString() {
		return this.name + " " + this.department + " " + this.age;
	}
}
