
public class gettingExceptions {
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
	}
	/*
	 * throwing a custom exception
	 */
	static void throwingCustom(String issue)throws MyException {
		String message="This is our problem "+issue;
		throw new MyException(message);
	}

}
