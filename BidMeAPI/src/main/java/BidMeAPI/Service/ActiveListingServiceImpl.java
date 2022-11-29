package BidMeAPI.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import BidMeAPI.DAO.ListingTableDAO;
import BidMeAPI.Model.Listing;
import BidMeAPI.Model.User;

@Primary
@Service
public class ActiveListingServiceImpl implements ActiveListingService {
	
	@Autowired
	ListingTableDAO dao;
	
    public Listing createListing(Listing listing) throws SQLException {
		return dao.createListing(listing);
    	
    }

    public Listing getListing(int ID) throws SQLException {
		return dao.getListing(ID);
    	
    }

    public void updateListing(Listing listing) throws SQLException {
    	dao.updateListing(listing);
    }

    public void deleteListing(int id) throws SQLException {
    	dao.deleteListing(id);
    }
    
    public List<Listing> getAllListingsByUserID(int UserID0) throws SQLException {
    	return dao.getAllListingsByUserID(UserID0);
    }
    
    public List<Listing> getAllListingsByNullID() throws SQLException {
    	return dao.getAllListingsByNullID();
    }


}
