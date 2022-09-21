package BidMeAPI.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BidMeAPI.Model.Matchmaker;

public class MatchmakerDAOImpl implements matchmakerDAO {
	
	final static String CREATE_MATCHMAKER = "INSERT INTO BidMeUsers.matchmaker " + "(mmID, bidID, listingID) VALUES" + "(?, ?, ?);";
	final static String DELETE_MATCHMAKER = "DELETE FROM BidMeUsers.matchmaker WHERE mm-id = ?";
	final static String UPDATE_MATCHMAKER = "UPDATE BidMeUsers.matchmaker SET bidID = ?, listingID WHERE mmID = ?;";
	
	//TODO Decide what the getter parameter will be
	final static String GET_MATCHMAKER = "SELECT * FROM BidMeUsers.matchmaker WHERE bidID = ?";
	
	BidTableDAOImpl bidDAO = new BidTableDAOImpl();
	ListingTableDAOImpl listingDAO = new ListingTableDAOImpl();
	
	public Connection connectToDB() throws SQLException {
		
		Connection conn = BidMeAPI.Database.DatabaseManager.openConnection();
		
		return conn;
	}

	@Override
	public Matchmaker createMatchmaker(Matchmaker mm) throws SQLException {
		
		int mmID = mm.getMmID();
		int bidID = mm.getBid().getBidID();
		int listingID = mm.getListing().getListingID();
		Matchmaker matchmaker = new Matchmaker(mmID, mm.getBid(), mm.getListing());
		
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
		int bidID = mm.getBid().getBidID();
		int listingID = mm.getListing().getListingID();
		
		Connection conn = connectToDB();
		
		PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_MATCHMAKER);
		
		preparedStatement.setInt(1, bidID);
		preparedStatement.setInt(2, listingID);
		preparedStatement.setInt(3, mmID);
		
		preparedStatement.executeUpdate();
		
		return;
	}

	@Override
	public Matchmaker getMatchmaker(int bidID) throws SQLException {
		
		Matchmaker mm = null;
		int mmID;
		int listingID;
		int tempBidID = bidID;
		
		Connection conn = connectToDB();
		PreparedStatement ps = conn.prepareStatement(GET_MATCHMAKER);
		ps.setInt(1, tempBidID);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			mmID = rs.getInt("mmID");
			tempBidID = rs.getInt("bidID");
			listingID = rs.getInt("listingID");
			
			mm = new Matchmaker(mmID, bidDAO.getBid(tempBidID), listingDAO.getListing(listingID));
		}
		
		
		return mm;
	}

}
