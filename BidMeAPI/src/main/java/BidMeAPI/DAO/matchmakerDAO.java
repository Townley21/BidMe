package BidMeAPI.DAO;

import java.sql.SQLException;
import java.util.List;

import BidMeAPI.Model.Listing;
import BidMeAPI.Model.Matchmaker;

public interface matchmakerDAO {
	
	public List<Matchmaker> getAllMatchmakersByListing(Listing listing) throws SQLException;
	
	public Matchmaker createMatchmaker(Matchmaker matchmake) throws SQLException;
	
	public void deleteMatchmaker(int mmID) throws SQLException;
	
	public void updateMatchmaker(Matchmaker matchmake) throws SQLException;
	
}
