package pojo;

public class AccountType {
	
	private int accountTypeId;
	private String type;
	
	public AccountType() {}
	
	public AccountType(int accountTypeId, String type) {
		super();
		this.accountTypeId = accountTypeId;
		this.type = type;
	}
	public int getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
