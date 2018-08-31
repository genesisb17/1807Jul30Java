package Reflection;

import java.time.LocalDateTime;

public class ReflectionExample {
	
	/*
	 * Java Reflectoin makes it possible to inspect classes,interfaces
	 * fields, and methods at runtime without knowing the name of the class
	 * ,method,etc.
	 * 
	 * It also makes it possible to instantiate new objects, invoke methods
	 * and get/set fields
	 * 
	 */
	
	private String name;
	private int id;
	private LocalDateTime todaysTime;
	
	public ReflectionExample(String name, int id, LocalDateTime todaysTime) {
		super();
		this.name = name;
		this.id = id;
		this.todaysTime = todaysTime;
	}

	public ReflectionExample() {
	
	}

	public static void main(String[] args) {
		
		
		Runtime run= Runtime.getRuntime();
		/*
		for(int i=0;i<100;i++) {
			
		}
		*/
		
		
		System.out.println(run.freeMemory()+" :bytes free ");
		System.out.println(run.maxMemory()+" :bytes max");
		System.out.println(run.totalMemory()+" :bytes total");
		
		ReflectionExample re=new ReflectionExample();
		System.out.println(re.getClass().getCanonicalName());
		
	}

}
