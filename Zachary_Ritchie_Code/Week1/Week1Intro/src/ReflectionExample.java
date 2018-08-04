

import java.time.LocalDateTime;

public class ReflectionExample {

	/*
	 * Java reflection makes it possible to inspect
	 * classes, interfaces, fileds, and methods 
	 * runtime without knowing the name of the class
	 * method etc
	 * It also makes it possible to instantiate new 
	 * objects, invovke methods, and get/set fields 
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
	
	public ReflectionExample()
	{
		
	}
	
	public static void main(String[] args) 
	{
		Runtime run = Runtime.getRuntime();
		/*StringBuilder sb;
		for (int i = 0; i< 100; ++i)
		{
			sb = new StringBuilder("test" + i);
			System.out.println(sb);
		}*/
		System.out.println("Frame memory:" + run.freeMemory() + " bytes");
		System.out.println("Maximum memory: " + run.maxMemory() + " bytes");
		System.out.println("Total memory: " + run.totalMemory() + " bytes");
		
		ReflectionExample re = new ReflectionExample();
		System.out.println("Class name: "+re.getClass().getCanonicalName());
		
		
	}
}
