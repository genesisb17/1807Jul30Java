package questionthree;

public class ReverseString {

	public static void main(String[] args) {
		// Reverse a string w/o using a temp variable. do NOT use reverse() in
		//the stringbuffer or the stringbuilder api's
		
		//enter any string within the quotes you would like to reverse
		String plzReverse = "cat";
		
		//we will loop through the length of the string
		for( int i = 0; i < plzReverse.length(); i++) {
			//getting the substring(how many characters to work with, our starting point (the end) minus how many loop iterations so we don't do the same char twice, then the ending point (the beginning)

			//plzReverse is now composed of new Strings for each iteration. 
			plzReverse = plzReverse.substring(1, plzReverse.length() - i)
					+ plzReverse.substring(0,1) 
					+ plzReverse.substring(plzReverse.length()- i, plzReverse.length());
			
			//uncomment to see what is happening behind the scenes
//			System.out.println("(1, plzReverse.length() - i: )" + (plzReverse.substring(1, plzReverse.length() - i)));
//			System.out.println("(0,1) : " + plzReverse.substring(0,1) );
//			System.out.println("(plzReverse.length()- i, plzReverse.length(): " +  (plzReverse.substring(plzReverse.length()- i, plzReverse.length())));
		}
		System.out.println(plzReverse);
	}

}
