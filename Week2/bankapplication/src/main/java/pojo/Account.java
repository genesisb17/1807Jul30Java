package pojo;

public class Account {

	private int id;
	private Double Balance;
	private int accountTypeId;
	
	public Account() {}

	public Account(int id, Double balance, int accountTypeId) {
		super();
		this.id = id;
		Balance = balance;
		this.accountTypeId = accountTypeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}

	public Double getBalance() {
		return Balance;
	}

	public void setBalance(Double balance) {
		Balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", Balance=" + Balance + ", accountTypeId=" + accountTypeId + "]";
	}

	public int getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}


	
	
}