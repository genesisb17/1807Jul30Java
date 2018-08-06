package q18;

public class child extends Parent1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkUP(String a) {
		int g=0;
		int i=0;
		//char character;
		
		while (i <= a.length()){
		   Character c = a.charAt(i);
		   
		        if (Character.isUpperCase(c)) {
		            g++;
		        }
		         i++;
		}
		
		if(g>0) return true;
		return false;
		
	}

	@Override
	public int StringToInt(String b) {
		int result = Integer.parseInt(b);			
		return result;
	}

	@Override
	public String lowerToUpper(String c) {
		return c.toUpperCase();
		
	}

}
