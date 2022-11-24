package BidMeAPI.Service;

import java.sql.SQLException;

import BidMeAPI.Model.Bid;

public interface BidService {

public Bid createBid(Bid bid) throws SQLException;
	
	public Bid getBid(int id) throws SQLException;
	
	public void deleteBid(int bidID) throws SQLException;
	
	public void updateBid(Bid bid) throws SQLException;

}
