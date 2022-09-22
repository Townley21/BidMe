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
		
		assertNotNull(bidDAO.getBid(3));
	}
	
	@Test
	void testGetBid() throws SQLException {
		System.out.println("Testing get bid...");
		
		assertNotNull(bidDAO.getBid(1));
	}
	
	@Test
	void testUpdateBid() throws SQLException {
		System.out.println("testing update bid...");
		
		Bid newbid = new Bid(user, 1, 10.34, false, timestamp);
		
		bidDAO.updateBid(newbid);
		assertEquals(10.34, bidDAO.getBid(1).getPrice());
		
	}
	
	@Test
	void testDeleteBid() throws SQLException {
		System.out.println("Testing delete bid...");
		
		bidDAO.deleteBid(2);
		
		assertNull(bidDAO.getBid(2));
		
	}

}
