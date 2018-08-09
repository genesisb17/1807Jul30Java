package pojo;

public class AccountType {

	private int id;
	private String accountType;
	
	public AccountType() {}
	public AccountType(int id, String accountType) {
		super();
		this.id = id;
		this.accountType = accountType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "AccountType [id=" + id + ", accountType=" + accountType + "]";
	}
	
	
}
