package BidMeAPI.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import BidMeAPI.Model.*;
import org.junit.jupiter.api.Test;
import BidMeAPI.DAO.*;

class UsersListDAOTests {

	public int id = 5;
	public String name = "Norm MacDonalad";
	public String email = "funnyguy@gmail.com";
	public String password = "comedian";
	public String address = "466 something drive";
	public boolean contractor = false;
	
	public User user = new User(id, name, email, password, address, contractor);
	
	UsersListDAOImpl dao = new UsersListDAOImpl();
	
	
	@Test
	void testCreateUser() throws SQLException {
		System.out.println("Testing create user...");
		
		dao.createuser(user);
		assertEquals(user.getEmail(), dao.getUser(user.getEmail()).getEmail());
		System.out.println("Made it here");
	}
	
	@Test
	void testDeleteUser() throws SQLException {
		System.out.println("Testing delete user...");
		
		dao.deleteUser(user);
		
		assertEquals(null, dao.getUser(user.getEmail()));
	}
	
	@Test
	void testUpdateUser() throws SQLException {
		System.out.println("Testing update user...");
		
		user.setEmail("NewEmail@gmail.com");
		dao.updateUser(user);
		assertEquals(dao.getUser(user.getEmail()).getEmail(), "NewEmail@gmail.com");
	}

}
