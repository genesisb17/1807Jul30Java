package com.revature.exercises;


class Baap{ 
	public int h = 4;
	public int getH(){
		System.out.println("Baap "+h);
		return h;
	}
}
public class Beta extends Baap{
	public int h = 44;
	public int getH(String x){
		System.out.println("Beta "+ h); 
		return h;
	}

	public void test() {
		System.out.println("in test method");
	}

	public static void main(String[] args) {
		Baap b = new Beta(); 
		((Beta) b).test();
		System.out.println(b instanceof Beta);
		System.out.println(b.h + " " +b.getH());
		Beta bb = (Beta) b;
		System.out.println(bb.h+" "+bb.getH());
		System.out.println(bb instanceof Object);
	}
}