
public class Driver2 {

	public static void main(String[] args) 
	{
		
		Singleton s = Singleton.getIntstance();
		s.name = "First Instance";
		
		Singleton s2 = Singleton.getIntstance();
		s2.name = "Second Instance";		
		
		System.out.println(s.name);
		System.out.println(s2.name);
		System.out.println(s == s2);
		
		s= null;
		s2 = null;
		
		Singleton s3 = Singleton.getIntstance();
		System.out.println(s3.name);
		
		LazySingleton lazy = LazySingleton.getInstance();
		lazy.test();
		LazySingleton lazy2 = LazySingleton.getInstance();
		
		
		}

}
