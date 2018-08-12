package pojo;

public class Account {

	private int id;
	private Double Balance;
	private int accountTypeId;
	private int clientId;
	private int counter;
	


	public Account() {}

	public Account(int id, Double balance, int accountTypeId, int clientId) {
		super();
		this.id = id;
		Balance = balance;
		this.accountTypeId = accountTypeId;
		this.clientId = clientId;
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

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
	
}