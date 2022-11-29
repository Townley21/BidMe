package BidMeAPI.Service;

import java.sql.SQLException;
import java.util.List;

import BidMeAPI.Model.Listing;
import BidMeAPI.Model.User;

public interface ActiveListingService {
	
    public Listing createListing(Listing listing) throws SQLException;

    public Listing getListing(int ID) throws SQLException;

    public void updateListing(Listing listing) throws SQLException;

    public void deleteListing(int id) throws SQLException;
    
    public List<Listing> getAllListingsByUserID(int UserID0) throws SQLException;
    
    public List<Listing> getAllListingsByNullID() throws SQLException;


}
