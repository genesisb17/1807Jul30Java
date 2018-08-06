package q2;
import java.util.*;

public class Fibon {

	ArrayList<Integer> lis= new ArrayList<>();
	
	static int[] ge=new int[29];
	public int a;
	
	public static void Fibon(){
		
		int a=3;
		ge[0]=0;
		ge[1]=1;
		int counter=0;
		
		while (a<29) {
		ge[a]=ge[a-1]+ge[a-2];
		
		System.out.println(counter+":"+ge[a]);
		a++;
		counter++;
			
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fibon();

	}

}
