package BidMeAPI.Model;

public class Listing {

    private int listingID;
    private User user;
    private String title;
    private String address;
    private int galleryID;
    private Double price;

    public Listing(int listingID, User user, String title, String address, int galleryID, double price) {
        this.listingID = listingID;
        this.user = user;
        this.title = title;
        this.address = address;
        this.galleryID = galleryID;
        this.price = price;
    }

    public int getListingID() {
        return listingID;
    }

    public void setListingID(int listingID) {
        this.listingID = listingID;
    }

    public int getUserID() {
        return user.getUserID();
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

}
