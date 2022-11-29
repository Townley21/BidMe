package BidMeAPI.DAO;

import BidMeAPI.Model.Listing;
import BidMeAPI.Model.User;

import java.sql.SQLException;
import java.util.List;

public interface ListingTableDAO {

    public Listing createListing(Listing listing) throws SQLException;

    public Listing getListing(int listingID) throws SQLException;

    public void updateListing(Listing listing) throws SQLException;

    public void deleteListing(int listingID) throws SQLException;
    
    public List<Listing> getAllListingsByUserID(int UserID0) throws SQLException;
    
    public List<Listing> getAllListingsByNullID() throws SQLException;

}
