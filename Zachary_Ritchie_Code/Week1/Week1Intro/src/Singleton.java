
public class Singleton 
{
	private static Singleton singleton = new Singleton();
	public String name;
	
	/*
	 * Singleton design pattern - used in scenrieos
	 * which require only one instance of  an object
	 * to be created
	 */
	 
	private Singleton() 
	{
		
	}

	public static Singleton getIntstance()
	{
		return singleton;
	}
	

}
