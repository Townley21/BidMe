package BidMeAPI.DAO;

import java.sql.SQLException;

import BidMeAPI.Model.Bid;

public interface BidTableDAO {
	
	public Bid createBid(Bid bid) throws SQLException;
	
	public Bid getBid(int id) throws SQLException;
	
	public void deleteBid(int bidID) throws SQLException;
	
	public void updateVid(Bid bid) throws SQLException;

}
