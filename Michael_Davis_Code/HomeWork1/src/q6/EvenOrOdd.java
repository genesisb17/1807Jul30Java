package q6;

public class EvenOrOdd {
	
	public static String calc(int a){
		
		int h=a;
		int holder=0;
		while(h>1) {
			
			holder=h/2;
			h=holder;
		}
		
		if(holder/2!=1) {
			return "Odd Number";
		}
		
		else return "Even Number";
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calc(21));
	}

}
