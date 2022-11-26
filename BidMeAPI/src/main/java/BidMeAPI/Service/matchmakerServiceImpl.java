package BidMeAPI.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import BidMeAPI.DAO.matchmakerDAO;
import BidMeAPI.Model.Listing;
import BidMeAPI.Model.Matchmaker;

@Primary
@Service
public class matchmakerServiceImpl implements matchmakerService {
	
	@Autowired
	matchmakerDAO dao;
	
	public List<Matchmaker> getAllMatchmakersByListing(Listing listing) throws SQLException {
		return dao.getAllMatchmakersByListing(listing);
	}
	
	
	public Matchmaker createMatchmaker(Matchmaker matchmake) throws SQLException {
		return dao.createMatchmaker(matchmake);
	}
	
	public void deleteMatchmaker(int mmID) throws SQLException {
		dao.deleteMatchmaker(mmID);
		return;
	}
	
	public void updateMatchmaker(Matchmaker matchmake) throws SQLException {
		dao.updateMatchmaker(matchmake);
		return;
	}

}
