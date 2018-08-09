package pojo;

public class Account {
	
	private int accountId;
	private int ownerId;
	private String accountName;
	private int accountTypeId;
	
	public Account( ) {}
	
	public Account(int accountId, int ownerId, String accountName, int accountTypeId) {
		super();
		this.accountId = accountId;
		this.ownerId = ownerId;
		this.accountName = accountName;
		this.accountTypeId = accountTypeId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	
	
}
