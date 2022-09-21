package BidMeAPI.Model;

public class Gallery {

	private int galleryID;
	private int entryID;
	private byte[] image;
	
	public Gallery(int galleryID, int entryID, byte[] image) {
		super();
		this.galleryID = galleryID;
		this.entryID = entryID;
		this.image = image;
	}

	public int getGalleryID() {
		return galleryID;
	}

	public void setGalleryID(int galleryID) {
		this.galleryID = galleryID;
	}

	public byte[] getImage() {
		return image;
	}
	
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public int getEntryID() {
		return entryID;
	}
	
	public void setEntryID(int entryID) {
		this.entryID = entryID;
	}
	
	
}
