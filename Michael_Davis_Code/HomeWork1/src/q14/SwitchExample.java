package q14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class SwitchExample {
	
	
	public void Switch(int a){
		
		switch(a){
			case 1:
				int p;
				double sqr;
				Scanner t= new Scanner(System.in);
				System.out.println("Enter an integer to get a square root");
				p=t.nextInt();
				
				sqr=Math.sqrt(p);
				
				System.out.println("The square root is:"+sqr);
				break;
				
			case 2:
				
				DateFormat datez = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				Calendar calen = Calendar.getInstance();
				System.out.println(datez.format(calen));
				
			case 3:
				String ax="I am learning: core Java";
				String[] g=ax.split(":");
				
				
				
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
