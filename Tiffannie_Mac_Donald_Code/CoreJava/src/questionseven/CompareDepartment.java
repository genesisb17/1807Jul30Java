package questionseven;

import java.util.Comparator;

public class CompareDepartment implements Comparator<Employee>{

	public int compare(Employee a, Employee b) {
		//sorts in ascending order of employee name
		return a.department.compareTo(b.department);
	}

}
