package q3;

public class ReverseString {
	
	
	
	public static String Reverse(String a) {
		int i=0;
		int sec=a.length()-1;
		String reverse="";
		String[] x=new String[a.length()];
		
		while(i<a.length()) {
			
			
			x[i]=a.substring(i, i+1);
			
			i++;	
			
		}	
		
		while(sec>-1) {
			
			reverse=reverse+x[sec];
			sec--;
			
		}
		return reverse;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Backwards :"+Reverse("backwards"));

	}

}
