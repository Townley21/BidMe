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
	
	public int getBidID() {
		return bid.getBidID();
	}
	
	public void setBid(Bid bid) {
		this.bid = bid;
	}

	public int getListingID() {
		return this.listing.getListingID();
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
