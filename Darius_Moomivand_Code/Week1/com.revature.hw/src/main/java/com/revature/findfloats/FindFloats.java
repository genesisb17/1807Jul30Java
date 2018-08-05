//Created by Darius Moomivand @ 05Aug18
package com.revature.findfloats;

//Floats class is located in package com.revature.floats
import com.revature.floats.Floats;

public class FindFloats {
	//Method used to find first float
	public static Float finderA() {
		Float temp1 = Floats.getOne();
		return temp1;
		
	}
	//Method used to find second float
	public static Float finderB() {
		Float temp2 = Floats.getTwo();
		return temp2;
		
	}
	
	public static void main(String[] args) {

		Float floatA = FindFloats.finderA();
		Float floatB = FindFloats.finderB();
		
		System.out.println(floatA);
		System.out.println(floatB);
	}

}
