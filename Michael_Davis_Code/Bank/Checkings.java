
public class Checkings extends Account {
	String accType;
	int accNumber;
	int pin;
	String name;
	String email;
	public Checkings() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Checkings a=new Checkings();
		a.setUpAcc("bob",3333,"myemail@whatever.com");
		
			a.checkAccNumber();
	}

	@Override
	void checkAccType() {
		System.out.println("This is a "+this.accType+" account");
		
	}


	@Override
	void checkAccNumber() {
		System.out.println("Your account number is "+this.accNumber+ ", try and keep it safe");
		
	}


	void resetPin(int a) {
		// TODO Auto-generated method stub
		//Simple reset 
		this.pin=a;
		
		System.out.print("Your new Pin is "+a+" now dont lose it again!");
		
	}




	
	void setUpAcc(String namez,int pinz, String emailz) {
		
		this.accNumber=accountNumbersList;
		accountNumbersList+=1;
		 this.pin=pinz;
		 this.name=namez;
		 this.email=emailz;
		
		
	}

	@Override
	void resetPin() {
		// TODO Auto-generated method stub
		
	}
	




	


}
