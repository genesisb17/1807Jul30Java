package q5;

public class subString {
	
	static String calc(String a, int b) {
		String theholder="";
		 
		   char[] arr=a.toCharArray();
		
		   for(int i=0;i<b;i++) {
			   theholder+=arr[i];
		   }
		
		return theholder;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(calc("123456789",5));

	}
	
	
	

}
