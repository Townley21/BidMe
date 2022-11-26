package BidMeAPI.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import BidMeAPI.Model.Bid;
import BidMeAPI.Model.Listing;
import BidMeAPI.Model.Matchmaker;

public class MatchmakerDAOImpl implements matchmakerDAO {
	
	@Autowired
	BidTableDAO bid_dao;
	
	@Autowired
	ListingTableDAO listing_dao;
	
	final static String CREATE_MATCHMAKER = "INSERT INTO BidMeUsers.matchmaker " + "(mmID, bidID, listingID) VALUES" + "(?, ?, ?);";
	final static String DELETE_MATCHMAKER = "DELETE FROM BidMeUsers.matchmaker WHERE mmID = ?;";
	final static String UPDATE_MATCHMAKER = "UPDATE BidMeUsers.matchmaker SET bidID = ?, listingID = ? WHERE mmID = ?;";
	
	//TODO Decide what the getter parameter will be
	final static String GET_ALL_MATCHMAKERS_BY_LISTING = "SELECT * FROM BidMeUsers.matchmaker WHERE listingID = ?;";
	
	public Connection connectToDB() throws SQLException {
		
		Connection conn = BidMeAPI.Database.DatabaseManager.openConnection();
		
		return conn;
	}
	
	@Override
	public List<Matchmaker> getAllMatchmakersByListing(Listing listing) throws SQLException { 
		
		List<Matchmaker> matchmakers = new ArrayList<>();
		
		int mmID;
		Bid bid;
		Listing selectedListing = listing;
		
		Connection conn = connectToDB();
		PreparedStatement ps = conn.prepareStatement(GET_ALL_MATCHMAKERS_BY_LISTING);
		ps.setInt(1, listing.getListingID());
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			mmID = rs.getInt("mmID");
			bid = bid_dao.getBid(rs.getInt("bidID"));
			matchmakers.add(new Matchmaker(mmID, bid, selectedListing));
		}
		
		return matchmakers;
		
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
	public void deleteMatchmaker(int mmID) throws SQLException {
		
		int id = mmID;
		
		Connection conn = connectToDB();
		
		PreparedStatement preparedStatement = conn.prepareStatement(DELETE_MATCHMAKER);
		preparedStatement.setInt(1, id);
		
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

}
