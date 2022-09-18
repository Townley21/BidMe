package BidMeAPI.DAO;

import BidMeAPI.Model.Listing;

import java.sql.SQLException;

public interface ListingTableDAO {

    public Listing createListing(Listing listing) throws SQLException;

    public Listing getListing(int listingID) throws SQLException;

    public void updateListing(Listing listing) throws SQLException;

    public void deleteListing(Listing listing) throws SQLException;

}
