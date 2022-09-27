package BidMeAPI.Service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import BidMeAPI.DAO.ListingTableDAO;
import BidMeAPI.Model.Listing;

public class ListingServiceImpl implements ListingService {
	
	@Autowired
	ListingTableDAO dao;

	@Override
	public Listing createListing(Listing listing) throws SQLException {
		return dao.createListing(listing);
	}

	@Override
	public Listing getListing(int listingID) throws SQLException {
		return dao.getListing(listingID);
	}

	@Override
	public void updateListing(Listing listing) throws SQLException {
		dao.updateListing(listing);
		return;
	}

	@Override
	public void deleteListing(Listing listing) throws SQLException {
		dao.deleteListing(listing);
		return;
	}

	
}
