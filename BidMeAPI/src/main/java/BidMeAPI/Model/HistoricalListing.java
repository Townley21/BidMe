package BidMeAPI.Model;

public class HistoricalListing {
	
	private Listing listing;
	private User user;
	
	public HistoricalListing(Listing listing, User user) {
		super();
		this.listing = listing;
		this.user = user;
	}
	
	public Listing getListing() {
		return this.listing;
	}
	public void setListing(Listing listing) {
		this.listing = listing;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
