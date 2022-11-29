package BidMeAPI.Model;

public class Listing {

    private int listingID;
    private User user;
    private User contractor;
    private String title;
    private String address;
    private int galleryID;
    private Double price;
    private String desc;

    public Listing(int listingID, User user, User contractor, String title, String address, int galleryID, double price, String desc) {
        this.listingID = listingID;
        this.user = user;
        this.contractor = contractor;
        this.title = title;
        this.address = address;
        this.galleryID = galleryID;
        this.price = price;
        this.desc = desc;
    }

    public int getListingID() {
        return listingID;
    }

    public void setListingID(int listingID) {
        this.listingID = listingID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGalleryID() {
        return galleryID;
    }

    public void setGalleryID(int galleryID) {
        this.galleryID = galleryID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

	public User getContractor() {
		return contractor;
	}

	public void setContractor(User contractor) {
		this.contractor = contractor;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
