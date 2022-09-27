package BidMeAPI.DAO;

import BidMeAPI.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersListDAOImpl implements UsersListDAO {

	final static String CREATE_USER = "INSERT INTO BidMeUsers.usersList " + "(userID, name, email, password, address, contractor) VALUES" + "(?, ?, ?, ?, ?, ?);";
	final static String GET_USER = "SELECT * FROM BidMeUsers.usersList WHERE email = ?;";
	final static String DELETE_USER = "DELETE FROM BidMeUsers.usersList WHERE userID = ?;";
	final static String UPDATE_USER = "UPDATE BidMeUsers.usersList SET name = ?, email = ?, password = ?, address = ?, contractor = ?, WHERE userID = ?;";
	
	public Connection connectToDB() throws SQLException {
		
		Connection conn = BidMeAPI.Database.DatabaseManager.openConnection();
		
		return conn;
	}
	
	
	@Override
	public User createUser(User user) throws SQLException {
		
		int userID = user.getUserID();
		String name = user.getName();
		String email = user.getEmail();
		String password = user.getPassword();
		String address = user.getAddress();
		boolean contractor = user.getContractor();
		
		Connection connection = connectToDB();
		
		PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER);
		
		preparedStatement.setLong(1, userID);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, email);
		preparedStatement.setString(4, password);
		preparedStatement.setString(5, address);
		preparedStatement.setBoolean(6, contractor);
		
		preparedStatement.executeUpdate();
		
		return null;
	}

	@Override
	public User getUser(String email) throws SQLException{
		
		User user = null;
		int userID;
		String name;
		String userEmail = email;
		String password;
		String address;
		boolean contractor;
		
		Connection conn = connectToDB();
		PreparedStatement preparedStatement = conn.prepareStatement(GET_USER);
		preparedStatement.setString(1, userEmail);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			userID = rs.getInt("userID");
			name = rs.getString("name");
			userEmail = rs.getString("email");
			password = rs.getString("password");
			address = rs.getString("address");
			contractor = rs.getBoolean("contractor");
			
			user = new User(userID, name, userEmail, password, address, contractor);
		}
		
		
		
		return user;
	}
	
	@Override
	public User getUser(int id) throws SQLException{
		
		User user = null;
		int userID = id;
		String name;
		String userEmail;
		String password;
		String address;
		boolean contractor;
		
		Connection conn = connectToDB();
		PreparedStatement preparedStatement = conn.prepareStatement(GET_USER);
		preparedStatement.setInt(1, userID);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			userID = rs.getInt("userID");
			name = rs.getString("name");
			userEmail = rs.getString("email");
			password = rs.getString("password");
			address = rs.getString("address");
			contractor = rs.getBoolean("contractor");
			
			user = new User(userID, name, userEmail, password, address, contractor);
		}
		
		
		
		return user;
	}

	@Override
	public void updateUser(User user) throws SQLException{
		
		Connection conn = connectToDB();
		PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_USER);
		
		preparedStatement.setString(1, user.getName());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.setString(4, user.getAddress());
		preparedStatement.setBoolean(5, user.getContractor());
		preparedStatement.setInt(6, user.getUserID());
		preparedStatement.executeUpdate();
		
	}

	@Override
	public void deleteUser(User user) throws SQLException{
		
		int userID = user.getUserID();
		
		Connection conn = connectToDB();
		PreparedStatement preparedStatement = conn.prepareStatement(DELETE_USER);
		preparedStatement.setInt(1, userID);
		
		preparedStatement.executeUpdate();
		
		return;
	}

}
