
public class Primitives {
	/*
	 * Java has 8 primitive datatypes, which represent raw data
	 * in an organized form
	 * int, boolean, byte, char, short, double, long, float
	 * 
	 * boolean N/A true or False
	 * byte		1 byte -128 to 127
	 * char		2 bytes 0 to 65536
	 * double	8 bytes	1.7e-308 to 1.7,,,
	 * int 4 bytes all the way up to 2.1 bil
	 * long 8 bytes all the way up to 9,,,,,,000
	 * float	4 bytes to 3.4e+308
	 * 
	 * when a number/string/array/etc is actually written out,
	 * it is called a literal
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int var; //declaring value
		var = 5; //initializing variable
		var = 10; //reassigning variable
		
		int x = 10; //declaring AND initializing var
		x = 100; //cannot declare the same var twice in the same scope
		/*
		 * in java there are scopes
		 * block scope
		 */
		char ch = 'a';
		
		int million = 1_000_000;
/*
 * must put an l after a long to be recognize. number literals are interpreted as ints. must specify
 * l or L. also put an f for floating point values
 */
		long longNum = 10000000000000000L;
		
		//CASTING
		// - to change the reference type of an entity
		
		char charAsNum = 160;
		System.out.println(charAsNum);
		
		int toChar = 80;
		char c = (char) toChar;
		System.out.println("int value -" + toChar);
		
		//non decimal number representations
		
		//decimal - base 10
		int decimal = 10;
		
		//Binary - base 2. preface the number with 0b to be a binary number. lower or upper case b works
		int binary = 0b10101010111;
		
		//Octal - base 8 only using #'s 0-7. preface with a 0
		int octal = 0107624;
		
		//Hexadecimal - base 16 / 0-9,a-f. preface with 0x. lower or upper case x
		int hex = 0xa3f19d2b;
		
		//wrapper classes. entity that gives your primitive functionality
		//casting changes the relative type of an entity, if you're going from wrapper to primitive is autoboxing, 
		
		Integer i = new Integer(90); //object to primitive
		int eighty = i; //unboxing
		
		int x1 = 10;			//primitive to object of corresponding wrapper class
		Integer wrapped = x1; //autoboxing
		
		//getters and setters are something and mutating methods
	}

}

//public class UnderstandingArrays {
//	
//	/*An array is
//	 * 
//	 */
//	public static void main(string[] args) {
//		int [] nums = {9,5,2,10}
//		/*
//		 * int [] wring = new int[] //in order to initialize an array, we must either explicityly add its values or sp
//		 * specify the size we want to allocate to it
//		 */
//		
//		int length = nums.length;
//		int[][] twoD = new int[4][4];
//		twoD[0][0] = 'x';
//		
//		for(int i = 0; i <twoD.length; i ++) {
//			for(int j = 0; twoD[i].length; j++) {
//				System.out.println(twoD[i][j]);
//			}
//			System.out.println();
//		}
//	}
//	//understand var args. look at her examples. each method can only have 1 var args parameter
//	//can only have one per param list . and must be last param in list.
//}
