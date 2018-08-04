package questioneighteen;

public class ChildClass extends ParentClass{
/*
 * Write  a  program having  a  concrete subclass  that inherits three  abstract methods
 *  from  a superclass.    Provide  the  following  three  implementations  in  the  subclass
 *   corresponding to the abstract methods in the superclass:
 *   
 *   Check for upper case characters in a string, and return‘true’or ‘false’ depending if any 
 *   are found
 *   
 *   Convert  all of  the lower  case characters  to upper case in  the  input  string,  and 
 *   return the result.
 *   
 *   Convert the input string to integer and add10, output the result to the console
 */
	public void main(String[] args) {
		//here is where you can call the following 3 methods
		
	}

	@Override
	Boolean isUpper(String s) {
		boolean upper = !s.equals(s.toLowerCase());
		return upper;
	}

	@Override
	String makeUpper(String s) {
		String newS = s.toUpperCase();
		return newS;
	}

	@Override
	void addTen(String x) {
		int result =Integer.parseInt(x);
		System.out.println(result);
		
	}
}