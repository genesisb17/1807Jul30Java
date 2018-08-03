package q07;

import java.util.*;

public class Employee{

	//Declaring vars
	int age;
	String name, department;
	
	//Declaring object and giving it params
	public Employee(int age, String name, String department) {
		super();
		this.age = age;
		this.name = name;
		this.department = department;
	}
	
	public String toString() {
        return this.age + " " + this.name +
                           " " + this.department;
    }

}

class SortbyAge implements Comparator<Employee> {
    // Used for sorting in ascending order of age
	
    public int compare(Employee a, Employee b)
    {
        return a.age - b.age;
    }
    
}

class SortbyName implements Comparator<Employee> {

	// Used for sorting in ascending order of name
	
    public int compare(Employee a, Employee b) {
    	
        return a.name.compareTo(b.name);
        
    }
    
}

class SortbyDepartment implements Comparator<Employee> {
    
	// Used for sorting in ascending order of department
	
    public int compare(Employee a, Employee b)
    {
    	
        return a.department.compareTo(b.department);
        
    }
}
