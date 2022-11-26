package BidMeAPI.Service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import BidMeAPI.DAO.BidTableDAO;
import BidMeAPI.Model.Bid;

@Primary
@Service
public class BidServiceImpl implements BidService {
	
	@Autowired
	BidTableDAO dao;

	public Bid createBid(Bid bid) throws SQLException {
		return dao.createBid(bid);
		
	}
	
	public Bid getBid(int id) throws SQLException {
		return dao.getBid(id);
	}
	
	public void deleteBid(int bidID) throws SQLException {
		dao.deleteBid(bidID);
		return;
	}
	
	public void updateBid(Bid bid) throws SQLException {
		dao.updateBid(bid);
		return;
	}

}
