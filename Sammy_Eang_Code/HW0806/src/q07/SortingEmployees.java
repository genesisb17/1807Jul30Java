package q07;

import java.util.ArrayList;
import java.util.Collections;

public class SortingEmployees {
	public static void main (String[] args) {
		
		//New list and adding employees to that list
        ArrayList<Employee> ar = new ArrayList<Employee>();
        ar.add(new Employee(25, "Dandy", "Accounting"));
        ar.add(new Employee(33, "Aardvark", "Human Resources"));
 
        //In order of adding
        System.out.println("Unsorted");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));
 
        //Sorting by age
        Collections.sort(ar, new SortbyAge());
 
        //Printing sort by age
        System.out.println("\nSorted by Age");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));
 
        //Sorting by name
        Collections.sort(ar, new SortbyName());
 
        //Printing sort by name
        System.out.println("\nSorted by Name");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));
        
        //Sorting by department
        Collections.sort(ar, new SortbyDepartment());
        
        //Printing sort by department
        System.out.println("\nSorted by Department");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));
    }
}
