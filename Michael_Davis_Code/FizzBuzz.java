import java.util.*;
public class FizzBuzz {
	
	//Scanners
	//wrapper classes
	//Strings
	//ararys
	
	//long a=09840958209438508L
	//the l is needed at the end as it is interpreted as an int case doesent matter
	
	public static void FizzBuzz(int n) {
		String output="";
		int i=0;
		int a=n;
		if(n!=0) {
			
		
		if((n%3==0)){
			
			System.out.print("Fizz ");
			i++;
			FizzBuzz(n-1);
		}
		else if(n%5==0){
			System.out.print("Buzz  ");
			i++;
			FizzBuzz(n-1);
			
		}
		else if(n%15==0){
			System.out.print("FizzBuzz ");
			i++;
			FizzBuzz(n-1);
		}
		else {
			System.out.print(n+" ");
			i++;
			FizzBuzz(n-1);
			
		}
		}
		}
		
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			FizzBuzz(20);
		/*Scanner x=new Scanner(System.in);
		 * 
		 * 
		 * add f to the end of floating point numbers
		 * float a= 3.22222F
		 * 
		 * char a =g;
		 *  System.out.println(charAsNum);
		 *  this is called casting
		 *  
		 *  int to Char=80;
		 *  char c=(char) toChar;
		 * 
		 * 
		 * non decimal number reprisentations
		 * 
		 * decimal base 10;
		 * 
		 * binary base 2
		 * 
		 * octal base 8 0-7
		 * int octal 0107624
		 * System.out.println("octal: " +octal):
		 * 
		 * autoboxing 
		 * is going from wrapper Integer to int
		 * 
		 * wrapping class to primitive
		 * 
		 * considered autoboxing to put primitive into wrapper class 
		 * ie. int x=10 -> Integer wrapped=x;
		 * 
		 * vs casting which is changing opjects of differnet types.
		 * Arrays.sort(Arra
		 * 
		 * Var args below->variable argument must be the last argument in 
		 * method(int... nums) allows you to pass in as many integers as you want
		 * good time saver-------------------   
		 * )
		 * 
		 * this created a new object in the heap vs
		 * String x=new String x
		 * this references an area in the string pool 
		 * String x="test
		 " Garbage collection happens when something has no reference to it anymore
		 java cleans these things up to free memory
		  
		  final classes cannot be extended such as STRING
		   
		   final applied to methods means they cannot be overridden however they
		   can be overloaded
		   
		   final variables cannot be changed once initialized
		   
		   String Builder & String buffer are mutable
		   
		    sb=hello
		    
		    if i use sb.append it changes object not changing reference
		    
		    StringBuilder is faster but not treadsafe
		    
		    means 
		    STRINGS ARE IMMUATABLE MEANING THAT THEY CANNOT BE CHANGED AFTER CREATION BUT 
		    THE REFERENCE POINTS TO MEMORY ARE FOUND IN JAVA.LANG PACKAGE STRING POOL
		    
		    StringBuilder sbuild=new StringBuilder("Hello);
		    sbuild.append(" world");
		    sbuild.reverse();
		    dont have to declare now sbbuild will be backwards
		    this allows direct manipulation without
		    
		     "this" refers to constructor of same name
		     "Super" refers to supercalss's constructor
		    
		 */
	}

}
