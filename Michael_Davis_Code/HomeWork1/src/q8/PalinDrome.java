package q8;
import java.util.ArrayList;
import q3.ReverseString;

public class PalinDrome {
static ArrayList<String> a=new ArrayList<String>();
static ArrayList<String> b=new ArrayList<String>();
static ReverseString c=new ReverseString();
static void work() {
	a.add("karan");
	a.add("madam");
	a.add("tom");
	a.add("civic");
	a.add("radar");
	a.add("sexes");
	a.add("jimmy");
	a.add("kayak");
	a.add("john");
	a.add("refer");
	a.add("billy");
	a.add("did");
	
	for(String d:a) {
	
		if(c.Reverse(d).equals(d)){
			b.add(d);
			System.out.println(d);
		
		}
		
	}

	

}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			work();
	}

}
