package BidMeAPI.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

import BidMeAPI.Model.Bid;
import BidMeAPI.Model.User;

class BidTableTests {
	
	int bidID = 0;
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
	
	Bid bid = new Bid(user, bidID, price, nullBids, timestamp);
	
	BidTableDAOImpl bidDAO = new BidTableDAOImpl();

	@Test
	void testCreateBid() throws SQLException {
		System.out.println("Testing create bid...");
		
		bidDAO.createBid(bid);
		
		assertNotNull(bidDAO.getBid(bid.getBidID()));
	}
	
	@Test
	void testUpdateBid() throws SQLException {
		System.out.println("testing update bid...");
		
		bid.setPrice(10.34);
		
		bidDAO.updateBid(bid);
		
	}

}
