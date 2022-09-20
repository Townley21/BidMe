package BidMeAPI.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import BidMeAPI.Model.HistoricalListing;
import BidMeAPI.Model.Listing;
import BidMeAPI.Model.User;

class HistoricalListingDAOTest {
	
	HistoricalListingsDAOImpl historicalListingDAO = new HistoricalListingsDAOImpl();
	UsersListDAOImpl usersDAO = new UsersListDAOImpl();
	ListingTableDAOImpl listingDao = new ListingTableDAOImpl();
	
	User user = new User(2, "norm", "norm@gmail.com", "123", "768 park ave.", false);
	Listing listing = new Listing(1, user, "concrete", "123 fake st.", 0, 0);
	HistoricalListing hList = new HistoricalListing(0, listing, user);
	
	@Test
	void createHistoricalListingTest() throws SQLException {
		System.out.println("Testing create historical listings...");
		
		historicalListingDAO.createHistoricalListing(hList);
		
		assertEquals(hList, historicalListingDAO.getHistoricalListing(10));
	}
	
	@Test
	void updateHistoricalListingTest() throws SQLException {
		User newuser = new User(5, "Danny Devito", "funnyguy@gmail.com", "comedian", "466 something drive", false);
		hList = new HistoricalListing(0, listing, newuser);
		
		historicalListingDAO.updateHistoricalListing(hList);
		
		assertNotNull(historicalListingDAO.getHistoricalListing(5));
	}
	
	@Test
	void deleteHistoricalListingTest() throws SQLException {
		
		historicalListingDAO.deleteHistoricalListing(hList);
		
		assertNull(historicalListingDAO.getHistoricalListing(0));
	}

}
