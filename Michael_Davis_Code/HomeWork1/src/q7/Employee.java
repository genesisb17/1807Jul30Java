package q7;

public class Employee implements Comparable {
private String name;
private String department;
private int age;

public Employee(String name,String department,int age) {
	this.name=name;
	this.department=department;
	this.age=age;
			
			
}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	static int compareTo(Employee a,Employee b) {
		
		if(a.name.equalsIgnoreCase(b.name)) {
			if(a.age==b.age) {
				if(a.department.compareToIgnoreCase(b.department)==0) {
					return 0;
				}
				if(a.department.compareToIgnoreCase(b.department)==-1) {
					return -1;
				}
				else return 1;
			}
			else {
			if(a.age<b.age) {
				return -1;
			}
			else return 1;
			}
		}
		else {
			if((a.name.compareToIgnoreCase(b.name))==-1){
		
			return -1;
			}
			else return 1;
			
		}
			
	
	}public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee b=new Employee("james","finance",32);
		Employee c=new Employee("james","finance",47);
		
		
		System.out.println(compareTo(c,b));
		//returns -1 and 1 just like regular compare and 0 if the 
		//objects are exactly the same
	}
	

}
