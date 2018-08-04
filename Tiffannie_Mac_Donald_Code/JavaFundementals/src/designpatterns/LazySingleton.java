package designpatterns;

public class LazySingleton {

	private static LazySingleton instance;
	
	private LazySingleton() {
		System.out.println("instantiating singleton");
	}
	
	public static LazySingleton getInstance() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
}
