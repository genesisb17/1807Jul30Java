import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Q8 {
	
	

	
	public static  void storeInArray(String[] state) {
		for(String i : state) {
			
		}
		
	}
	

	public static Boolean isPalindrome(String input) {

			String mystr = input.replaceAll("[^A-Za-z]+", "").toUpperCase();
			String revstring = "";
			for (int i = mystr.length() - 1; i > -1; i--) {
				revstring = revstring + mystr.charAt(i);
			}
			if (revstring.equals(mystr)) {
				return true;
			} else {
				return false;
			}
		}
	

	public static String reverse(String input) {
		if (input == null) {
			throw new IllegalArgumentException();
		} else {

			String revstring = "";
			for (int i = input.length() - 1; i > -1; i--) {
				revstring = revstring + input.charAt(i);
			}
			return revstring;
		}
	}

	public static void main(String[] args) {
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("karan");
		wordList.add("madam");
		wordList.add("tom");
		wordList.add("civic");
		wordList.add("radar");
		wordList.add("sexes");
		wordList.add("jimmy");
		wordList.add("kayak");
		wordList.add("john");
		wordList.add("refer");
		wordList.add("billy");
		wordList.add("did");
		ArrayList<String> onlyPalindromes = new ArrayList<String>();
		for(String s : wordList) {
			if(isPalindrome(s)) {
				onlyPalindromes.add(s);	
				System.out.println(s);
			}
		}
					
				
	}
}

	
