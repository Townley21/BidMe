package BidMeAPI.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BidMeAPI.Model.Bid;
import BidMeAPI.Model.Listing;
import BidMeAPI.Model.Matchmaker;

public class MatchmakerDAOImpl implements matchmakerDAO {
	
	final static String CREATE_MATCHMAKER = "INSERT INTO BidMeUsers.matchmaker " + "(mmID, bidID, listingID) VALUES" + "(?, ?, ?);";
	final static String DELETE_MATCHMAKER = "DELETE FROM BidMeUsers.matchmaker WHERE mmID = ?";
	final static String UPDATE_MATCHMAKER = "UPDATE BidMeUsers.matchmaker SET bidID = ?, listingID WHERE mm = ?;";
	
	ListingTableDAOImpl listingDAO = new ListingTableDAOImpl();
	BidTableDAOImpl bidDAO = new BidTableDAOImpl();
	
	//TODO Decide what the getter parameter will be
	final static String GET_MATCHMAKER = "SELECT * FROM BidMeUsers.matchmaker WHERE mmID = ?";
	
	public Connection connectToDB() throws SQLException {
		
		Connection conn = BidMeAPI.Database.DatabaseManager.openConnection();
		
		return conn;
	}

	@Override
	public Matchmaker createMatchmaker(Matchmaker mm) throws SQLException {
		
		int mmID = mm.getMmID();
		Bid bid = mm.getBid();
		Listing listing = mm.getListing();
		Matchmaker matchmaker = new Matchmaker(mmID, bid, listing);
		
		Connection conn = connectToDB();
		
		PreparedStatement preparedstatement = conn.prepareStatement(CREATE_MATCHMAKER);
		
		preparedstatement.setInt(1, mmID);
		preparedstatement.setInt(2, bid.getBidID());
		preparedstatement.setInt(3, listing.getListingID());
		
		preparedstatement.executeUpdate();
		
		return matchmaker;
	}

	@Override
	public void deleteMatchmaker(Matchmaker mm) throws SQLException {
		
		int mmID = mm.getMmID();
		
		Connection conn = connectToDB();
		
		PreparedStatement preparedStatement = conn.prepareStatement(CREATE_MATCHMAKER);
		preparedStatement.setInt(1, mmID);
		
		preparedStatement.executeUpdate();
		
		return;
		
	}

	@Override
	public void updateMatchmaker(Matchmaker mm) throws SQLException {
		
		int mmID = mm.getMmID();
		Bid bid = mm.getBid();
		Listing listing = mm.getListing();
		
		Connection conn = connectToDB();
		
		PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_MATCHMAKER);
		
		preparedStatement.setInt(1, bid.getBidID());
		preparedStatement.setInt(2, listing.getListingID());
		preparedStatement.setInt(3, mmID);
		
		preparedStatement.executeUpdate();
		
		return;
	}

	@Override
	public Matchmaker getMatchmaker(int id) throws SQLException {
		
		Matchmaker mm;
		int mmID = id;
		Bid bid;
		Listing listing;
		
		Connection conn = connectToDB();
		PreparedStatement preparedstatement = conn.prepareStatement(GET_MATCHMAKER);
		ResultSet rs = preparedstatement.executeQuery();
		
		while(rs.next()) {
			mmID = rs.getInt(mmID);
			bid = bidDAO.getBid(rs.getInt("bidID"));
			listing = listingDAO.getListing(rs.getInt("listingID"));
			
			
			mm = new Matchmaker(id, bid, listing);
		}
		return null;
	}

}
