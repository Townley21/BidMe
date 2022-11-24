package BidMeAPI.Service;

import java.sql.SQLException;

import BidMeAPI.Model.Listing;
import BidMeAPI.Model.User;

public interface ActiveListingService {
	
    public Listing createListing(Listing listing) throws SQLException;

    public Listing getListing(int ID) throws SQLException;

    public void updateListing(Listing listing) throws SQLException;

    public void deleteListing(Listing listing) throws SQLException;


}
