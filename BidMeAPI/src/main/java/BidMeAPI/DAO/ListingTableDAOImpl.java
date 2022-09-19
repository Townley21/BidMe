package BidMeAPI.DAO;

import BidMeAPI.Model.Listing;
import BidMeAPI.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ListingTableDAOImpl implements ListingTableDAO {

    final static String CREATE_LISTING = "INSERT INTO BidMeUsers.listingTable " + "(listingID, userID, title, address, galleryID, price) VALUES" + "(?, ?, ?, ?, ?, ?);";
    final static String GET_LISTING = "SELECT * FROM BidMeUsers.listingTable WHERE title = ?;";
    final static String DELETE_LISTING = "DELETE FROM BidMeUsers.listingTable WHERE listingID = ?;";
    final static String UPDATE_LISTING = "UPDATE BidMeUsers.listingTable SET title = ?, address = ?, galleryID = ?, price = ? WHERE listingID = ?;";

    UsersListDAOImpl userDao;
    
    public Connection connectToDB() throws SQLException {

        Connection conn = BidMeAPI.Database.DatabaseManager.openConnection();

        return conn;
    }


    @Override
    public Listing createListing(Listing listing) throws SQLException {

        int listingID = listing.getListingID();
        int userID = listing.getUserID();
        String title = listing.getTitle();
        String address = listing.getAddress();
        int galleryID = listing.getGalleryID();
        double price = listing.getPrice();

        Connection connection = connectToDB();

        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_LISTING);

        preparedStatement.setLong(1, listingID);
        preparedStatement.setLong(2, userID);
        preparedStatement.setString(3, title);
        preparedStatement.setString(4, address);
        preparedStatement.setLong(5, galleryID);
        preparedStatement.setDouble(6, price);

        preparedStatement.executeUpdate();

        return null;
    }
    
    
    //Might have to change parameters
    @Override
    public Listing getListing(int listID) throws SQLException{

        Listing listing = null;
        int listingID = listID;
        User user;
        String listingTitle;
        String address;
        int galleryID;
        double price;


        Connection conn = connectToDB();
        PreparedStatement preparedStatement = conn.prepareStatement(GET_LISTING);
        preparedStatement.setInt(1, listingID);

        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()) {
            listingID = rs.getInt("listingID");
            user = userDao.getUser(listingID);
            listingTitle = rs.getString("title");
            address = rs.getString("address");
            galleryID = rs.getInt("galleryID");
            price = rs.getDouble("price");

            listing = new Listing(listingID, user, listingTitle, address, galleryID, price);
        }



        return listing;
    }

    @Override
    public void updateListing(Listing listing) throws SQLException{

        Connection conn = connectToDB();
        PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_LISTING);

        preparedStatement.setString(1, listing.getTitle());
        preparedStatement.setString(2, listing.getAddress());
        preparedStatement.setInt(3, listing.getGalleryID());
        preparedStatement.setDouble(4, listing.getPrice());
        preparedStatement.setInt(5, listing.getListingID());

        preparedStatement.executeUpdate();

    }

    @Override
    public void deleteListing(Listing listing) throws SQLException{

        int listingID = listing.getListingID();

        Connection conn = connectToDB();
        PreparedStatement preparedStatement = conn.prepareStatement(DELETE_LISTING);
        preparedStatement.setInt(1, listingID);

        preparedStatement.executeUpdate();

        return;
    }


}
