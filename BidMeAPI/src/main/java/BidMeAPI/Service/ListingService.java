package BidMeAPI.Service;

import java.sql.SQLException;

import BidMeAPI.Model.Listing;

public interface ListingService {
	
    public Listing createListing(Listing listing) throws SQLException;

    public Listing getListing(int listingID) throws SQLException;

    public void updateListing(Listing listing) throws SQLException;

    public void deleteListing(Listing listing) throws SQLException;

}
