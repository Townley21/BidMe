package BidMeAPI.Service;

import java.sql.SQLException;
import BidMeAPI.Model.Matchmaker;


public interface matchmakerService {
	
	public Matchmaker createMatchmaker(Matchmaker matchmake) throws SQLException;
	
	public void deleteMatchmaker(Matchmaker matchmake) throws SQLException;
	
	public void updateMatchmaker(Matchmaker matchmake) throws SQLException;
	
	public Matchmaker getMatchmaker(int id) throws SQLException;
	

}
