
import java.util.ArrayList;

//use CTRL + SHIFT + O to do imports. stay away from .*

/*
 * The first line of any java class is the package that it is in
 */
					//final or static
//[access modifier] [non-access modifiers] class [className] {}
/*
 * Access modifiers!
 * public - any class can access this entity
 * protected - any class in the same package OR its subclasses can access
 * __ (default/package) - means its only accessible from classes in the package
 * private = only accessible within the class
 * you can have a private class if it is a sub class or nested class 
 */
public class HelloWorld {
	//This is our first class. This is ignored by the compiler
	//[access modifier(more like a level)] [non-access modifiers] [return type] [methodName] ([parameters])
	public static void main(String[] args){
		//public is an access modifier
		
		//whatever happens in this main method is executed sequentially
		/*
		 * @author Tiffannie
		 * 
		 * params
		 */
		System.out.println("Hello, World");
		//if we had a compilation issue, it would not even run.
		
		ArrayList<String> list = new ArrayList<String>();
	}
	
}