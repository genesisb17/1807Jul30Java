package cjh.question07;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{

	//Sort based on name, department, and age
	@Override
	public int compare(Employee e1, Employee e2) {
		int comparison = 0;
		if((comparison = e1.getName().compareTo(e2.getName())) == 0) {
			if((comparison = e1.getDepartment().compareTo(e2.getDepartment())) == 0) {
				return e1.getAge() - e2.getAge();
			}
			return comparison;
		}
		return comparison;
	}
	
	
	

}
