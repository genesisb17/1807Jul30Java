package q16;

public class LengthOfString {

	public static void main(String[] args) {
		
		//Takes the first word of the args array and splits it into its own array
		String[] split = args[0].split("");
		//Length of that word 
		System.out.println(split.length);

	}

}
