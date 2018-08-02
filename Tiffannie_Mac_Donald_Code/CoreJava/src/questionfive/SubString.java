package questionfive;

public class SubString {

	public static void main(String[] args) {
		// write a substring method that accepts a string str and an integer idx
		// and returns the substring contained between 0 and idx-1 inclusive. do
		//NOT use any of the existing substring methods in the String, StringBuilder
		//or stringBuffer api's
		
		//define your string
		String n = "Hello there";
		
		subString(n, 3);

	}
	
	static void subString(String str, int idx) {
		
		char[] chars = str.toCharArray(); //convert the string to char array
//		System.out.println(chars.length);
		
		char[] substr = new char[chars.length];  //create new char array to store substring
	//		getChars(starting pt, ending index, destination array, index to begin storing)
		str.getChars(0, idx, substr, 0); 		//getChars will populate substring array
		
		System.out.println(substr);				//print the substring
		
	}

}
