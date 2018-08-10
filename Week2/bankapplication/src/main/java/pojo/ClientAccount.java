package pojo;

public class ClientAccount {

	private int clientId;
	private int accountId;
	
	public ClientAccount() {}
	
	public ClientAccount(int clientId, int accountId) {
		super();
		this.clientId = clientId;
		this.accountId = accountId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	
}
