package BidMeAPI.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import BidMeAPI.Model.User;

public class UsersListDAOImpl implements UsersListDAO {

	final static String CREATE_USER = "INSERT INTO BidMeUsers.usersList " + "(userID, name, email, password, address, contractor) VALUES" + "(?, ?, ?, ?, ?, ?);";
	
	public Connection connectToDB() throws SQLException {
		
		Connection conn = BidMeAPI.Database.DatabaseManager.openConnection();
		
		return conn;
	}
	
	
	@Override
	public User createuser(User user) throws SQLException {
		
		int userID = user.getUserID();
		String name = user.getName();
		String email = user.getEmail();
		String password = user.getPassword();
		String address = user.getAddress();
		boolean contractor = user.getContractor();
		
		Connection connection = connectToDB();
		
		PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER);
		
		preparedStatement.setLong(1, userID);
		preparedStatement.setString(2, email);
		preparedStatement.setString(3, name);
		preparedStatement.setString(4, password);
		preparedStatement.setString(5, address);
		preparedStatement.setBoolean(6, contractor);
		
		preparedStatement.executeUpdate();
		
		return null;
	}

	@Override
	public User getUser(String email) throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User user) throws SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) throws SQLException{
		// TODO Auto-generated method stub
		
	}

}
