package BidMeAPI.DAO;

import java.sql.SQLException;

import BidMeAPI.Model.User;

public interface UsersListDAO {

	public User createuser(User user) throws SQLException;
	
	public User getUser(String email) throws SQLException;
	
	public void update(User user)throws SQLException;
	
	public void delete(User user)throws SQLException;
}