package designpatterns;

public class Singleton {
	
	public String name;
	
	private static Singleton singleton = new Singleton();
/*
 * Singleton design pattern used in scenarios which require only one instance of an object
 * to be created
 * 
 * The private constructor prevents any other class from instantiating this object
 * 
 */
	private Singleton() {}
	
	public static Singleton getInstance() {
		return singleton;
	}
}
