package BidMeAPI.Service;

import BidMeAPI.Model.User;

import java.sql.SQLException;

public interface UserService {

    public User createUser(User user) throws SQLException;

    public User getUser(String email) throws SQLException;

    public User getUser(int id) throws SQLException;

    public void updateUser(User user)throws SQLException;

    public void deleteUser(User user)throws SQLException;
	
}
