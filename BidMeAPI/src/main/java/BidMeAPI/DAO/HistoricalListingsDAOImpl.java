package BidMeAPI.DAO;

import BidMeAPI.Model.HistoricalListing;
import BidMeAPI.Model.Listing;
import BidMeAPI.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoricalListingsDAOImpl implements HistoricalListingsDAO {

    final static String CREATE_HISTORICAL_LISTING = "INSERT INTO BidMeUsers.historicalListings " + "(entryID, listingID, userID) VALUES" + "(?, ?, ?);";
    final static String GET_HISTORICAL_LISTING = "SELECT * FROM BidMeUsers.historicalListings WHERE userID = ?;";
    final static String DELETE_HISTORICAL_LISTING = "DELETE FROM BidMeUsers.historicalListings WHERE listingID = ?";
    final static String UPDATE_HISTORICAL_LISTING = "UPDATE BidMeUsers.historicalListings SET userID = ? WHERE listingID = ?;";

    UsersListDAOImpl userDao = new UsersListDAOImpl();
    ListingTableDAOImpl listingDao = new ListingTableDAOImpl();

    public Connection connectToDB() throws SQLException {

        Connection conn = BidMeAPI.Database.DatabaseManager.openConnection();

        return conn;
    }


    @Override
    public HistoricalListing createHistoricalListing(HistoricalListing HListing) throws SQLException {

    	int id = HListing.getId();
        int listingID = HListing.getListing().getListingID();
        int userID = HListing.getUser().getUserID();

        Connection connection = connectToDB();

        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_HISTORICAL_LISTING);

        preparedStatement.setLong(1, id);
        preparedStatement.setLong(2, listingID);
        preparedStatement.setLong(3, userID);

        preparedStatement.executeUpdate();

        return null;
    }

    @Override
    public HistoricalListing getHistoricalListing(int userID) throws SQLException{

        HistoricalListing HListing = null;
        Listing listing = null;
        int tempID = userID;
        int id;

        User user;

        Connection conn = connectToDB();
        PreparedStatement preparedStatement = conn.prepareStatement(GET_HISTORICAL_LISTING);
        preparedStatement.setInt(1, userID);

        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()) {
        	id = rs.getInt("entryID");
            listing = listingDao.getListing(rs.getInt("listingID"));
            user = userDao.getUser(tempID);

            HListing = new HistoricalListing(id, listing, user);
        }

        return HListing;
    }

    @Override
    public void updateHistoricalListing(HistoricalListing HListing) throws SQLException{

        Connection conn = connectToDB();
        PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_HISTORICAL_LISTING);

        preparedStatement.setLong(1, HListing.getUser().getUserID());
        preparedStatement.setLong(2, HListing.getListing().getListingID());
        preparedStatement.executeUpdate();
        
        return;
    }

    @Override
    public void deleteHistoricalListing(HistoricalListing HListing) throws SQLException{

        int listingID = HListing.getListing().getListingID();
        int userID = HListing.getUser().getUserID();

        Connection conn = connectToDB();
        PreparedStatement preparedStatement = conn.prepareStatement(DELETE_HISTORICAL_LISTING);
        preparedStatement.setInt(1, listingID);

        preparedStatement.executeUpdate();

        return;
    }


}