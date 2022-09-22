package BidMeAPI.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

import BidMeAPI.Model.Bid;
import BidMeAPI.Model.Listing;
import BidMeAPI.Model.Matchmaker;
import BidMeAPI.Model.User;

class MatchmakerDAOTests {
	
	
	int mmID = 0;
	
	int bidID = 3;
	double price = 9.00;
	boolean nullBids = false;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	int id = 2;
	String name = "Norm";
	String email = "funnyguy@gmail.com";
	String password = "comedian";
	String address = "466 something drive";
	boolean contractor = false;
	
	User user = new User(id, name, email, password, address, contractor);
	Listing listing = new Listing(1, user, "concrete", "123 fake st.", 0, 567.89);
	Bid bid = new Bid(user, bidID, price, nullBids, timestamp);
	Matchmaker mm = new Matchmaker(mmID, bid, listing);
	
	MatchmakerDAOImpl mmDAO = new MatchmakerDAOImpl();
	
	@Test
	void testCreateMatchmaker() throws SQLException {
		System.out.println("Testing create matchmaker...");
		
		mmDAO.createMatchmaker(mm);
		
		assertNotNull(mmDAO.getMatchmaker(bidID));
		
	}
	
	@Test
	void testGetMatchmaker() throws SQLException {
		System.out.println("Testing get matchmaker...");
		
		assertNotNull(mmDAO.getMatchmaker(bidID));
	}
	
	@Test
	void testUpdateMatchmaker() throws SQLException {
		System.out.println("Testing update matchmaker...");
		
		double newPrice = 456;
		
		mmDAO.getMatchmaker(bidID).getBid().setPrice(newPrice);
		
		mmDAO.updateMatchmaker(mm);
		assertEquals(newPrice, mmDAO.getMatchmaker(bidID).getBid().getPrice());
	}
	
	@Test
	void testDeleteMatchmaker() {
		
	}

}
