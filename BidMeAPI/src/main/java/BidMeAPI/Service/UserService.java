package BidMeAPI.Service;

import java.sql.SQLException;

import BidMeAPI.Model.User;

public interface UserService {
	
	public User createuser(User user) throws SQLException;
	
	public User getUser(String email) throws SQLException;
	
	public User getUser(int id) throws SQLException;
	
	public void updateUser(User user)throws SQLException;
	
	public void deleteUser(User user)throws SQLException;
	
}
