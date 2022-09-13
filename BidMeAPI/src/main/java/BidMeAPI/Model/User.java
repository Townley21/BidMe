package BidMeAPI.Model;

public class User {

	private int userID;
	private String name;
	private String email;
	private String password;
	private String address;
	private boolean contractor;
	
	
	public User(int userID, String name, String email, String password, String address, boolean contractor) {
		super();
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contractor = contractor;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getContractor() {
		return contractor;
	}

	public void setContractor(Boolean contractor) {
		this.contractor = contractor;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
