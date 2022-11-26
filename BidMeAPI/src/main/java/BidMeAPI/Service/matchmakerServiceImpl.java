package BidMeAPI.Service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import BidMeAPI.DAO.matchmakerDAO;
import BidMeAPI.Model.Matchmaker;

@Primary
@Service
public class matchmakerServiceImpl implements matchmakerService {
	
	@Autowired
	matchmakerDAO dao;
	
	
	public Matchmaker createMatchmaker(Matchmaker matchmake) throws SQLException {
		return dao.createMatchmaker(matchmake);
	}
	
	public void deleteMatchmaker(Matchmaker matchmake) throws SQLException {
		dao.deleteMatchmaker(matchmake);
		return;
	}
	
	public void updateMatchmaker(Matchmaker matchmake) throws SQLException {
		dao.updateMatchmaker(matchmake);
		return;
	}
	
	public Matchmaker getMatchmaker(int id) throws SQLException {
		return dao.getMatchmaker(id);
	}

}
