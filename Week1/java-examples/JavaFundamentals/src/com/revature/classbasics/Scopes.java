package com.revature.classbasics;

public class Scopes {
	/* Scopes
	 * The lifetime of a variable
	 * There are four different scopes in Java
	 * Class/Static = This is what we usually mean by global
	 * 		Static entities(vars, methods, nested classes) are
	 * 		accessible from outside of the class WITHOUT an instance
	 * 		ie. Class.x or Class.method();
	 * 		Regarding static variables, these variables are SHARED throughout
	 * 		all instances of the class. 
	 * 		Class c = new Class();
	 * 		Class c2 = new Class();
	 * 		c.x == c2.x // true
	 * 		
	 * Object/Instance = the object's fields/state
	 * 		Entities in this scope can only be accessed by an instance
	 * 		of the object they belong to.
	 * 		ie. Class c = new Class();
	 * 			c.x or c.method()
	 * 			NOT Class.method(); . this would be a static method
	 * 
	 * Method = mostly parameters and any variables defined at the method level
	 * 		Variables in this scope exist for the lifetime of a  method call
	 * 
	 * Loop/Block = any variables defined within curly braces
	 * 
	 * 
	 * 
	 * WE CAN access static variables and methods from an instance
	 * of an object
	 * we CANNOT access instance var and methods from a class alone
	 * 
	 * class A{
	 * 	static int count;
	 * 	int age;
	 * }
	 * 
	 * class B{
	 * 
	 * 	main{
	 * 	A.count; //valid because count is static 
	 * 	A a = new A; //create INSTANCE of a aka INSTANTIATE A
	 * 	a.age; //valid because age is instance var
	 * 	a.count; //valid because a is an instance of class A to which count belongs
	 * 	A.age;//NOT VALID NO DONT DO THIS WILL NOT COMPILE	
	 * 	}
	 * }
	 * 
	 * 
	 * ALSO* instance and static vars have default values (values
	 * present if never initialized) whereas method and block
	 * scope variables do not
	 */
	

	int age;
	String name;
	
	static Integer integer;
	static double d;
	static int count;
	static boolean b;
	static short s;
	static char ch;
	static long l;
	static float f;
	static byte by;
	
	public static void main(String[] args) {
		System.out.println("Integer default: " + integer);
		System.out.println("int: " + count);
		System.out.println("boolean: " + b);
		System.out.println("short: " + s);
		System.out.println("char: " + ch);
		System.out.println("long: " + l);
		System.out.println("float: " + f);
		System.out.println("byte: " + by);
		System.out.println("double: " + d);
	}
	
	

	
	
	public Scopes() {
		//constructor.. will discuss later
		count++;
	}
	
	
	
	
	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public static int getCount() {
		return count;
	}




	public static void setCount(int count) {
		Scopes.count = count;
	}





	static void doThings() {
		//test();
	}
	
	void test() {
		doThings();
	}
	
	
	
	
}
