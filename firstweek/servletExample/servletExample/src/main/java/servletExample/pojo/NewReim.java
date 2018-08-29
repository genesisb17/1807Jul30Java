package servletExample.pojo;

public class NewReim {
	private int rid;
	private String status;
	public NewReim() {}	
	public NewReim(int rid, String status) {
		this.rid = rid;
		this.status = status;
	}
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
