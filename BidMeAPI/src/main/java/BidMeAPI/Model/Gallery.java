package BidMeAPI.Model;

public class Gallery {

	private Byte[] image;
	private int entryID;
	private Listing listing;
	
	public Gallery(Byte[] image, int entryID, Listing listing) {
		super();
		this.image = image;
		this.entryID = entryID;
		this.listing = listing;
	}
	
	public Byte[] getImage() {
		return image;
	}
	
	public void setImage(Byte[] image) {
		this.image = image;
	}
	
	public int getEntryID() {
		return entryID;
	}
	
	public void setEntryID(int entryID) {
		this.entryID = entryID;
	}
	
	public Listing getListing() {
		return listing;
	}
	
	public void setListing(Listing listing) {
		this.listing = listing;
	}
	
	
	
}
