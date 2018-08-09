package pojo;

public class Account {

	private String id;
	private String userId;
	private String accountName;
	private int accountTypeId;
	
	public Account() {}
	
	public Account(String id, String userId, String accountName, int accountTypeId) {
		super();
		this.id = id;
		this.userId = userId;
		this.accountName = accountName;
		this.accountTypeId = accountTypeId;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
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


	@Override
	public String toString() {
		return "Account [id=" + id + ", userId=" + userId + ", accountName=" + accountName + ", accountTypeId="
				+ accountTypeId + "]";
	}
	
}
