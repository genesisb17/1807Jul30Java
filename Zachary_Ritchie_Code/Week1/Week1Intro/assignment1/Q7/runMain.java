package Q7;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class runMain 
{

	public static LinkedList<employeeObject> list = new LinkedList<employeeObject>();
	
	public static void main(String[] args) 
	{		
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i <= 1; ++i)
		{
			System.out.println("Please enter users name");			
			employeeObject employee = new employeeObject();
			employee.setName(scan.nextLine());
			System.out.println("Please enter users department");
			employee.setDepartment(scan.nextLine());
			System.out.println("Please enter users age");
			employee.setAge(Integer.parseInt(scan.nextLine()));
			list.add(employee);
			
		}
		scan.close();
		
		compareName cen = new compareName();		
		compareDepartment ced = new compareDepartment();
		compareAge cea = new compareAge();
		
		Collections.sort(list, cen);
		for(employeeObject eo1 : list)
		{
			System.out.println(eo1.getName());
		}
		
		Collections.sort(list, ced);
		for(employeeObject eo2 : list)
		{
			System.out.println(eo2.getDepartment());
		}
		
		Collections.sort(list, ced);
		for(employeeObject eo3 : list)
		{
			System.out.println(eo3.getAge());
		}
	}
}

class compareName implements Comparator<employeeObject>
{

	@Override
	public int compare(employeeObject o1, employeeObject o2) {

		int returnInt = o1.getName().compareTo(o2.getName());
		
		return returnInt;
	}
	
}

class compareDepartment implements Comparator<employeeObject>
{

	@Override
	public int compare(employeeObject o1, employeeObject o2) 
	{
		
		int returnInt = o1.getDepartment().compareTo(o2.getDepartment());
		
		return returnInt;
	}
	
}

class compareAge implements Comparator<employeeObject>
{

	@Override
	public int compare(employeeObject o1, employeeObject o2) {
		
		int returnInt = o1.getAge() - o2.getAge();
		return returnInt;
	}
	
}
