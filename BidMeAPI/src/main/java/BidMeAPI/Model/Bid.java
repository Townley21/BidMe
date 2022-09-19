package BidMeAPI.Model;

import java.sql.Timestamp;

public class Bid {

	private int bidID;
	private User user;
	private double price;
	private boolean nullBids;
	private Timestamp timestamp;
	
	public Bid(User user, int bidID, double price, boolean nullBids, Timestamp timestamp) {
		super();
		this.user = user;
		this.bidID = bidID;
		this.price = price;
		this.nullBids = nullBids;
		this.timestamp = timestamp;
	}
	
	public int getBidID() {
		return bidID;
	}
	
	public void setBid(int bidID) {
		this.bidID = bidID;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean getNullBids() {
		return nullBids;
	}
	
	public void setNullBids(boolean nullBids) {
		this.nullBids = nullBids;
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
	

}
