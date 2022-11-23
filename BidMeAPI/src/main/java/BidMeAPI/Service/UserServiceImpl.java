package BidMeAPI.Service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import BidMeAPI.DAO.UsersListDAO;
import BidMeAPI.Model.User;

@Primary
@Service
public  class UserServiceImpl implements UserService {
	
	@Autowired
	UsersListDAO dao;
	
	public User createuser(User user) throws SQLException{
		return dao.createuser(user);
	}
	
	public User getUser(String email) throws SQLException{
		return dao.getUser(email);
	}
	
	public User getUser(int id) throws SQLException{
		return dao.getUser(id);
	}
	
	public void updateUser(User user)throws SQLException{
		dao.updateUser(user);
		return;
	}
	
	public void deleteUser(User user)throws SQLException{
		dao.deleteUser(user);
		return;
	}
	
}
