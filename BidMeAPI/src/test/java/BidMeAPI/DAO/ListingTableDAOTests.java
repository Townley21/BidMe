package BidMeAPI.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import BidMeAPI.Model.Listing;
import BidMeAPI.Model.User;




class ListingTableDAOTests {
	ListingTableDAOImpl listingDAO =  new ListingTableDAOImpl();
	UsersListDAOImpl usersDAO = new UsersListDAOImpl();

	
	int id = 2;
	User user = new User(2, "norm", "norm@gmail.com", "123", "768 park ave.", false);
	Listing listing = new Listing(1, user, "concrete", "123 fake st.", 0, 0);
	
	
	
	
	@Test
	void testCreateListing() throws SQLException {
		System.out.println("Testing Create listing...");
		
		listingDAO.createListing(listing);
		
		assertEquals(null, listingDAO.getListing(1));
	}
	
	@Test
	void testDeleteListing() throws SQLException {
		System.out.println("Testing delete listing...");
		
		listingDAO.deleteListing(listing);
		
		assertEquals(null, listingDAO.getListing(1));
	}
	
	@Test
	void testUpdateListing() throws SQLException {
		System.out.println("Testing update listing...");
		listing.setPrice(567.89);
		listing.setGalleryID(1);
		listingDAO.updateListing(listing);
		assertEquals(listing, listingDAO.getListing(1));
		
	}

}
