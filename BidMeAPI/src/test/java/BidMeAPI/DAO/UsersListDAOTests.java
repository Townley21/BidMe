package BidMeAPI.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import BidMeAPI.Model.*;
import org.junit.jupiter.api.Test;
import BidMeAPI.DAO.*;

class UsersListDAOTests {

	public int id = 0;
	public String name = "Tom Brady";
	public String email = "BidMe@gmail.com";
	public String password = "bidme";
	public String address = "123 Fake st.";
	public boolean contractor = false;
	
	public User user = new User(id, name, email, password, address, contractor);
	
	UsersListDAOImpl dao = new UsersListDAOImpl();
	
	
	@Test
	void testCreateUser() throws SQLException {
		System.out.println("Testing create user...");
		
		dao.createuser(user);
		System.out.println("Made it here");
	}

}
