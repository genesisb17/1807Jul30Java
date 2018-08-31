package designpatterns;

public class LazySingleton {
	
	//only declaration not instantiation
	private static LazySingleton instance;
	
	
	private LazySingleton() {
		System.out.println("Instantiating Singleton");
		
	}
	public static LazySingleton getInstance() {
		if(instance==null) {
			instance=new LazySingleton();
		}
		return instance;
	}
	
	public void test() {
		System.out.println(this.getClass());
	}
}
