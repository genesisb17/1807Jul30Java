package q12;

import java.util.ArrayList;

import q6.EvenOrOdd;

public class arrayEvens {
	public static int calc(int a){
		
		int h=a;
		int holder=0;
		while(h>1) {
			
			holder=h/2;
			h=holder;
		}
		
		if(holder/2!=1) {
			return 1;
		}
		if(holder/2==1) {
			return 0;
		}
		
		else return 5;
		
		
		
	}

	 static void arrayEvensc() {
			int[] t=new int[100];
			//rrayList<Integer> g=new ArrayList<>();
			int count=1;
			
		for(int i=0;i<100;i++) {
			//if(i==0) {
			t[i]=count;
			count++;
			//System.out.println("insde loop "+t[i]);
		
		}
		for(int g:t) {
			if(g%2==0) {
				System.out.println(g);
			}
			
		}

	}
	public static void main(String[] args) {
	arrayEvens g=new arrayEvens();
	g.arrayEvensc();

	}

}
