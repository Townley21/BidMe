package BidMeAPI.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import BidMeAPI.Model.Bid;
import BidMeAPI.Model.User;

public class BidTableDAOImpl implements BidTableDAO {
	
	final static String CREATE_BID = "INSERT INTO BidMeUsers.bidTable " + "(bid-id, user-id, price, null-bids, timestamp) VALUES" + "(?, ?, ?, ?, ?);";
	final static String GET_BID = "SELECT * FROM BidMeUsers.bidTable WHERE bid-id = ?;";
	final static String DELETE_BID = "DELETE FROM BidMeUsers.bidTable WHERE bid-id = ?;";
	final static String UPDATE_BID = "UPDATE BidMeUsers.listingTable SET user-id = ?, price = ?, null-bids = ?, timestamp = ? bid-id = ?;";

	UsersListDAOImpl userDAO = new UsersListDAOImpl();
	
	public Connection connectToDB() throws SQLException {

	        Connection conn = BidMeAPI.Database.DatabaseManager.openConnection();

	        return conn;
	}
	
	@Override
	public Bid createBid(Bid bid) throws SQLException {
		
		int bidID = bid.getBidID();
		User user = bid.getUser();
		double price = bid.getPrice();
		boolean bids = bid.getNullBids();
		Timestamp timestamp = bid.getTimestamp();
		Bid newbid = new Bid(user, bidID, price, bids, timestamp);
		
		Connection conn = connectToDB();
		PreparedStatement ps = conn.prepareStatement(CREATE_BID);
		
		ps.setInt(1, bidID);
		ps.setInt(2, user.getUserID());
		ps.setDouble(3, price);
		ps.setBoolean(4, bids);
		ps.setTimestamp(5, timestamp);
		
		ps.executeQuery();
		
		return newbid;
	}

	@Override
	public Bid getBid(int id) throws SQLException {
		
		Bid getbid = null;
		int bidID = id;
		User user;
		double price;
		boolean bids;
		Timestamp timestamp;
		
		Connection conn = connectToDB();
		PreparedStatement ps = conn.prepareStatement(GET_BID);
		ps.setInt(1, bidID);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			bidID = rs.getInt("bid-id");
			user = userDAO.getUser(rs.getInt("user-id"));
			price = rs.getDouble("price");
			bids = rs.getBoolean("null-bids");
			timestamp = rs.getTimestamp("timestamp");
			
			getbid = new Bid(user, bidID, price, bids, timestamp);
		}
		return getbid;
	}

	@Override
	public void deleteBid(int bidID) throws SQLException {
		
		Connection conn = connectToDB();
		PreparedStatement ps = conn.prepareStatement(DELETE_BID);
		ps.setInt(1, bidID);
		ps.executeUpdate();
		
	}

	@Override
	public void updateVid(Bid bid) throws SQLException {
		
		Connection conn = connectToDB();
		PreparedStatement ps = conn.prepareStatement(UPDATE_BID);
		ps.setInt(1, bid.getUser().getUserID());
		ps.setDouble(2, bid.getPrice());
		ps.setBoolean(3, bid.getNullBids());
		ps.setTimestamp(4, bid.getTimestamp());
		
		
	}

}
