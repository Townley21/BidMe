package BidMeAPI.Service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import BidMeAPI.DAO.MatchmakerDAO;
import BidMeAPI.Model.Matchmaker;

@Primary
@Service
public class MatchmakerServiceImpl implements MatchmakerService {
	
	@Autowired
	MatchmakerDAO dao;

	@Override
	public Matchmaker createMatchmaker(Matchmaker matchmake) throws SQLException {
		return dao.createMatchmaker(matchmake);
	}

	@Override
	public void deleteMatchmaker(Matchmaker matchmake) throws SQLException {
		dao.deleteMatchmaker(matchmake);
		return;
	}

	@Override
	public void updateMatchmaker(Matchmaker matchmake) throws SQLException {
		dao.updateMatchmaker(matchmake);
		return;
	}

	@Override
	public Matchmaker getMatchmaker(int id) throws SQLException {
		return dao.getMatchmaker(id);
	}

}
