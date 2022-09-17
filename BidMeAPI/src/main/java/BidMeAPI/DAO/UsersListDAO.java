package BidMeAPI.DAO;

import java.sql.SQLException;

import BidMeAPI.Model.User;

public interface UsersListDAO {

	public User createuser(User user) throws SQLException;
	
	public User getUser(String email) throws SQLException;
	
	public void updateUser(User user)throws SQLException;
	
	public void deleteUser(User user)throws SQLException;
}