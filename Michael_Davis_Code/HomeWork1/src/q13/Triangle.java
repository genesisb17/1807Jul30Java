package q13;

import java.util.ArrayList;

import q12.arrayEvens;

public class Triangle {
	
	
	
	static void printTri() {
		int count=2;
		
		ArrayList<String> a2=new ArrayList<String>();
		a2.add("0");
		a2.add("1 0");
		a2.add("1 0 1");
		a2.add("0 1 0 1");
		
		for(String a:a2) {
			System.out.println(a);
			
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		printTri();
		}

}
