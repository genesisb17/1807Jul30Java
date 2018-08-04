package questionfourteen;

import java.util.Date;

public class SwitchCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2;
		double b = 0.0;
		String s = new String( "I am learning Core Java");
		Date d = new Date();
		
		switch(a) {
		case 1: Math.sqrt(a);
			break;
		case 2: System.out.println(d);
			break;
		case 3: String[] arr = s.split(" ");
		for(String word : arr) {
			System.out.print(word);
		}
		break;
		}
	}

}
