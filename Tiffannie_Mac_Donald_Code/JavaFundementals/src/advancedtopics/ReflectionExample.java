package advancedtopics;


import java.time.LocalDateTime;

public class ReflectionExample {
	/*
	 * Java reflection makes it possible to inspect classes, interfaces =, fields, and
	 * methods at runtime w/o knowing the name of the class, method, etc
	 * 
	 * it also makes it possible to instantiate new objects, invoke methods, and get/set
	 * fields
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
	
	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
//		StringBuilder sb;
//		for(int i = 0; i < 100; i++) {
//			Object o = new Object();
//			//sb goes here somewhere
//		}
		System.out.println("Free mem: " + run.freeMemory() + " bytes");
		System.out.println("Max mem: " + run.maxMemory() + " bytes");
		System.out.println("Toal mem: " + run.totalMemory() + " bytes");
		
		ReflectionExample re = new ReflectionExample();
		System.out.println("class name: " + re.getClass().getCanonicalName());
		System.out.println("super class name: " + re.getClass().getSuperClass());
		
	}
}
