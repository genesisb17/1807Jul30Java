package classbasics;

public class Constructors {

	//dummy instance vars
	int age;
	String email;
	String hairColor;
	String name;
	
	//no args constructor
	public Constructors() {}
	
	//
	public Constructors(String name) {
		//construstor within constructor
		this(name, 20, "test@gmail.com", "brown");
	}
	
	public Constructors(String name, int age, String email, 
			String hairColor) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.hairColor = hairColor;
	}


			
			//Constructors c = new Constructors();
	public static void main(String[] args) {
		/*
		 * A constructor is a special method in java used to construct
		 * of create a new instance of the class it is found in.
		 *  it must have the same name as the class
		 *  it doesn not have a return type
		 *  it can be overloaded
		 *  the first line, whether implicitly or explicitly, is 
		 *  always a call to another constructor -- either this() 
		 *  (calling another constructor of the same class) or super()
		 *   (calls its superclass's constructor explicitly, it is 
		 *   calling the object class's constructor)
		 *   if you don't explicitly call either this() or super(),
		 *   JVM interprets the first line as super() implicitly 
		 *   regardless of if you explicitly create a constructor 
		 *   or not, there is ALWAYS a constructor in every concrete
		 *   class. It is called default constructor, and looks like 
		 *   the 'no args" constructor, but disappears as soon as a 
		 *   constructor is explicitly created
		 */

		
		
	}

}
