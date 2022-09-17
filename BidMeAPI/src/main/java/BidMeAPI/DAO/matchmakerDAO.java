package BidMeAPI.DAO;

import java.sql.SQLException;

import BidMeAPI.Model.Matchmaker;

public interface matchmakerDAO {
	
	public Matchmaker createMatchmaker(Matchmaker matchmake) throws SQLException;
	
	public void deleteMatchmaker(Matchmaker matchmake) throws SQLException;
	
	public void updateMatchmaker(Matchmaker matchmake) throws SQLException;
	
	public Matchmaker getMatchmaker(Matchmaker matchmake) throws SQLException;
	
}
