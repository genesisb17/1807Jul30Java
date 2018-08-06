package q03;

/*
 * Reverse a string without using a temporary variable.
 * Do NOT use reverse() in the StringBuffer or StringBuilder APIs.
 */

public class Q3 {
	
	public static void main(String[] args) {
		
		String str = "Hello";
		char[] ch = str.toCharArray();	// convert to character array
		int a = 0;
		int b = str.length()-1;
		
		while(a < b) {
			ch[a] ^= ch[b];	// XOR
			ch[b] ^= ch[a];
			ch[a] ^= ch[b];
			++a;
			--b;
			
		}
		str = String.valueOf(ch);	// assign reverse to str
		System.out.println(str);	// print
		
	}

}
