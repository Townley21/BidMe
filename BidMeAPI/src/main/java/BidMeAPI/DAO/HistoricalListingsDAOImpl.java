package BidMeAPI.DAO;

import BidMeAPI.Model.HistoricalListing;
import BidMeAPI.Model.Listing;
import BidMeAPI.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoricalListingsDAOImpl implements HistoricalListingsDAO {

    final static String CREATE_HISTORICALLISTING = "INSERT INTO BidMeUsers.historicalListings " + "(listingID, userID) VALUES" + "(?, ?);";
    final static String GET_HISTORICALLISTING = "SELECT * FROM BidMeUsers.historicalListings WHERE listingID = ? AND userID = ?;";
    final static String DELETE_HISTORICALLISTING = "DELETE FROM BidMeUsers.historicalListings WHERE listingID = ? AND userID = ?;";
    final static String UPDATE_HISTORICALLISTING = "UPDATE BidMeUsers.historicalListings SET listingID = ?, userID = ? WHERE listingID = ? AND userID = ?;";

    UsersListDAOImpl userDao;

    public Connection connectToDB() throws SQLException {

        Connection conn = BidMeAPI.Database.DatabaseManager.openConnection();

        return conn;
    }


    @Override
    public HistoricalListing createHistoricalListing(Listing listing, User user) throws SQLException {

        int listingID = listing.getListingID();
        int userID = listing.getUserID();

        Connection connection = connectToDB();

        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_HISTORICALLISTING);

        preparedStatement.setLong(1, listingID);
        preparedStatement.setLong(2, userID);

        preparedStatement.executeUpdate();

        return null;
    }


    //Needs to be looked over, not correctly implemented.
    @Override
    public HistoricalListing getHistoricalListing(int listID, int userID) throws SQLException{

        HistoricalListing listing = null;
        int listingID = listID;

        User user;

        Connection conn = connectToDB();
        PreparedStatement preparedStatement = conn.prepareStatement(GET_HISTORICALLISTING);
        preparedStatement.setInt(1, listingID);

        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()) {
            listingID = rs.getInt("listingID");
            user = userDao.getUser(listingID);

            listing = new HistoricalListing(listing, user);
        }

        return listing;
    }

    @Override
    public void updateHistoricalListing(Listing listing, User user) throws SQLException{

        Connection conn = connectToDB();
        PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_HISTORICALLISTING);

        preparedStatement.setLong(1, listing.getListingID());
        preparedStatement.setLong(2, user.getUserID());

        preparedStatement.executeUpdate();

    }

    @Override
    public void deleteHistoricalListing(Listing listing, User user) throws SQLException{

        int listingID = listing.getListingID();
        int userID = user.getUserID();

        Connection conn = connectToDB();
        PreparedStatement preparedStatement = conn.prepareStatement(DELETE_HISTORICALLISTING);
        preparedStatement.setInt(1, listingID);
        preparedStatement.setInt(2, userID);

        preparedStatement.executeUpdate();

        return;
    }


}