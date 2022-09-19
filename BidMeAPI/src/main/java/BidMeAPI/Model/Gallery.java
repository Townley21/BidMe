package BidMeAPI.Model;

public class Gallery {

	private int galleryID;
	private int entryID;
	private Listing listing;
	private Byte[] image;
	
	public Gallery(int galleryID, int entryID, Listing listing, Byte[] image) {
		super();
		this.galleryID = galleryID;
		this.entryID = entryID;
		this.listing = listing;
		this.image = image;
	}

	public int getGalleryID() {
		return galleryID;
	}

	public void setGalleryID(int galleryID) {
		this.galleryID = galleryID;
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
