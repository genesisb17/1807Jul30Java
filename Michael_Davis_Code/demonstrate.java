import java.util.*;
public class demonstrate {
	
	private int Age;
	private String address;
	private String email;
	public demonstrate() {
		
	}
	
	
	static void Examps(String name, int age) {
		int g=0;
		
		while(g<name.length()) {
			if(g==0) {
				System.out.println("The 1 letter in your name is "+name.substring(0,1));
			g++;
			}
			else if(name.length()>200) {
				
				System.out.println("That name is too large sorry");
				break;
			}
			
			else {
				int holder=g+1;
			System.out.print("The "+holder+" letter in your name is ");
			System.out.println(name.substring(g,g+1));
			g++;
			}
		}
		//enum 

		int holder=name.length();

		
		switch(holder) {
		
		
		
		case 1:
			System.out.println("Your name is very very short thats not even a name");
		break;
		case 2:
			System.out.println("Your name is very short");
		break;
		case 3:
			System.out.println("Your name is very short");
		break;
		case 4 :
			System.out.println("Your name is not too short or too long just right");
		break;
		case 5 :
			System.out.println("Your name is not too short or too long just right");
		break;
		case 6 :
			System.out.println("Your name is not too short or too long just right");
		break;
		case 7 :
			System.out.println("Your name is not too short or too long just right");
		break;
		
		
		default:System.out.println("Sorry your names way too long friend, or your trying to break my program");
		}

		
		
	}
	
	
	static void ca2(String name1,String name2,String name3,String name4,String name5){
		String[]names=new String[5];
		String[]backup=new String[5];
		
		names[0]=name1;
		names[1]=name2;
		names[2]=name3;
		names[3]=name4;
		names[4]=name5;
		
		int count=0;
		int count2=0;
		for (int i=0; i<names.length; i++)
		{		
	
			System.out.println(names[count]+" was name number "+ count+" name to be added to the array");
		count++;	
		}
		
		do {
			count2++;		
		}
		while(count2<backup.length);
		
		
		for(String d:names) {
			
			System.out.println(d.toString());
		}
	}
	
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Examps("Michael",23);
		ca2("brock","Ash","Tori","ash","Jermaine");

	}



	

}
