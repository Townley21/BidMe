package BidMeAPI.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import BidMeAPI.Model.Matchmaker;

public class MatchmakerDAOImpl implements matchmakerDAO {
	
	final static String CREATE_MATCHMAKER = "INSERT INTO BidMeUsers.matchmaker " + "(mm-id, bid-id, listing-id) VALUES" + "(?, ?, ?);";
	final static String DELETE_MATCHMAKER = "DELETE FROM BidMeUsers.matchmaker WHERE mm-id = ?";
	final static String UPDATE_MATCHMAKER = "UPDATE BidMeUsers.matchmaker SET bid-id = ?, listing-id WHERE mm = ?;";
	
	//TODO Decide what the getter parameter will be
	final static String GET_MATCHMAKER = "SELECT * FROM BidMeUsers.matchmaker WHERE  = ?";
	
	public Connection connectToDB() throws SQLException {
		
		Connection conn = BidMeAPI.Database.DatabaseManager.openConnection();
		
		return conn;
	}

	@Override
	public Matchmaker createMatchmaker(Matchmaker mm) throws SQLException {
		
		int mmID = mm.getMmID();
		int bidID = mm.getBidID();
		int listingID = mm.getListingID();
		Matchmaker matchmaker = new Matchmaker(mmID, bidID, listingID);
		
		Connection conn = connectToDB();
		
		PreparedStatement preparedstatement = conn.prepareStatement(CREATE_MATCHMAKER);
		
		preparedstatement.setInt(1, mmID);
		preparedstatement.setInt(2, bidID);
		preparedstatement.setInt(3, listingID);
		
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
		int bidID = mm.getBidID();
		int listingID = mm.getListingID();
		
		Connection conn = connectToDB();
		
		PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_MATCHMAKER);
		
		preparedStatement.setInt(1, bidID);
		preparedStatement.setInt(2, listingID);
		preparedStatement.setInt(3, mmID);
		
		preparedStatement.executeUpdate();
		
		return;
	}

	@Override
	public Matchmaker getMatchmaker(Matchmaker mm) throws SQLException {
		
		return null;
	}

}
