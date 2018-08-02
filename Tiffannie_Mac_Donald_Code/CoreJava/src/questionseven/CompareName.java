package questionseven;

import java.util.Comparator;

public class CompareName implements Comparator<Employee>{

	public int compare(Employee a, Employee b) {
		//sorts in ascending order of employee name
		return a.name.compareTo(b.name);
	}

}
