package BidMeAPI.Model;

public class Matchmaker {
	
	private int mmID;
	private Bid bid;
	private Listing listing;
	
	public Matchmaker(int mmID, Bid bid, Listing listing) {
		this.mmID = mmID;
		this.bid = bid;
		this.listing = listing;
	}
	
	public Bid getBid() {
		return this.bid;
	}
	
	public void setBid(Bid bid) {
		this.bid = bid;
	}

	public Listing getListing() {
		return this.listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

	public int getMmID() {
		return mmID;
	}

	public void setMmID(int mmID) {
		this.mmID = mmID;
	}
	
	

}
