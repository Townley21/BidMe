package BidMeAPI.Model;

public class HistoricalListing {
	
	private int id;
	private Listing listing;
	private User user;
	
	public HistoricalListing(int id, Listing listing, User user) {
		super();
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
