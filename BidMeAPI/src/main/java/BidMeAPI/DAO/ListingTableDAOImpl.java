package BidMeAPI.DAO;

import BidMeAPI.Model.Bid;
import BidMeAPI.Model.Listing;
import BidMeAPI.Model.Matchmaker;
import BidMeAPI.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class ListingTableDAOImpl implements ListingTableDAO {

    final static String CREATE_LISTING = "INSERT INTO BidMeUsers.listingTable " + "(listingID, userID, contractorUserID, title, address, galleryID, price, desc) VALUES" + "(?, ?, ?, ?, ?, ?, ?, ?);";
    final static String GET_LISTING = "SELECT * FROM BidMeUsers.listingTable WHERE listingID = ?;";
    final static String DELETE_LISTING = "DELETE FROM BidMeUsers.listingTable WHERE listingID = ?;";
    final static String UPDATE_LISTING = "UPDATE BidMeUsers.listingTable SET contractorUserID = ?, title = ?, address = ?, galleryID = ?, price = ?, desc = ? WHERE listingID = ?;";
    final static String GET_ALL_LISTINGS_BY_USERID = "SELECT * FROM BidMeUsers.listingTable WHERE userID = ?;";
    final static String GET_ALL_LISTINGS_WHERE_CONTRACTOR_IS_NULL = "SELECT * FROM BidMeUsers.listingTable WHERE contractorUserID IS NULL";
    
    final static String KEY_CHECK_DISABLE = "SET FOREIGN_KEY_CHECKS=0;";
    final static String KEY_CHECK_ENABLE = "SET FOREIGN_KEY_CHECKS=1;";
    
    @Autowired
    UsersListDAO dao;
    
    public Connection connectToDB() throws SQLException {

        Connection conn = BidMeAPI.Database.DatabaseManager.openConnection();

        return conn;
    }
    
    @Override
    public List<Listing> getAllListingsByNullID() throws SQLException{
    	
    	
    	List<Listing> listings = new ArrayList<>();
    	int listingID;
    	int userID;
    	Integer contractorID;
    	String title;
    	String address;
    	int galleryID;
    	double price;
    	String desc;
		User contractor;
		
		Connection conn = connectToDB();
		PreparedStatement ps = conn.prepareStatement(GET_ALL_LISTINGS_WHERE_CONTRACTOR_IS_NULL);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			 listingID = rs.getInt("listingID");
			 userID = rs.getInt("userID");
			 contractorID = rs.getInt("contractorUserID");
			 if(contractorID != null) contractorID = (int)contractorID;
			 title = rs.getString("title");
			 address = rs.getString("address");
			 galleryID = rs.getInt("galleryID");
			 price = rs.getDouble("price");
			 desc = rs.getString("desc");
			 
			 if(dao.getUser(contractorID) == null) 	contractor = null;
			 else									contractor = dao.getUser(contractorID);
			 
			 listings.add(new Listing(listingID, dao.getUser(userID), contractor, title, address, galleryID, price, desc));
		}
		
		return listings;
    }

    @Override
    public List<Listing> getAllListingsByUserID(int UserID0) throws SQLException{
    	
    	
    	List<Listing> listings = new ArrayList<>();
    	int listingID;
    	int userID = UserID0;
    	Integer contractorID;
    	String title;
    	String address;
    	int galleryID;
    	double price;
    	String desc;
		User contractor;
		
		Connection conn = connectToDB();
		PreparedStatement ps = conn.prepareStatement(GET_ALL_LISTINGS_BY_USERID);
		ps.setInt(1, userID);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			 listingID = rs.getInt("listingID");
			 userID = rs.getInt("userID");
			 contractorID = rs.getInt("contractorUserID");
			 if(contractorID != null) contractorID = (int)contractorID;
			 title = rs.getString("title");
			 address = rs.getString("address");
			 galleryID = rs.getInt("galleryID");
			 price = rs.getDouble("price");
			 desc = rs.getString("desc");
			 
			 if(dao.getUser(contractorID) == null) 	contractor = null;
			 else									contractor = dao.getUser(contractorID);
			 
			 listings.add(new Listing(listingID, dao.getUser(userID), contractor, title, address, galleryID, price, desc));
		}
		
		return listings;
    }

    @Override
    public Listing createListing(Listing listing) throws SQLException {

        int listingID = listing.getListingID();
        int userID = listing.getUser().getUserID();
        int contractorID = listing.getUser().getUserID();
        String title = listing.getTitle();
        String address = listing.getAddress();
        int galleryID = listing.getGalleryID();
        double price = listing.getPrice();
        String desc = listing.getDesc();

        Connection connection = connectToDB();

        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_LISTING);

        preparedStatement.setLong(1, listingID);
        preparedStatement.setLong(2, userID);
        preparedStatement.setLong(3, contractorID);
        preparedStatement.setString(4, title);
        preparedStatement.setString(5, address);
        preparedStatement.setLong(6, galleryID);
        preparedStatement.setDouble(7, price);
        preparedStatement.setString(8, desc);

        preparedStatement.executeUpdate();

        return listing;
    }
    
    
    //Might have to change parameters
    @Override
    public Listing getListing(int ID) throws SQLException{
    
        Listing listing = null;
        int listingID = ID;
        int userID;
        Integer contractorID;
        User user = null;
        User contractor = null;
        String listingTitle;
        String address;
        int galleryID;
        double price;
        String desc;


        Connection conn = connectToDB();
        PreparedStatement preparedStatement = conn.prepareStatement(GET_LISTING);
        preparedStatement.setInt(1, listingID);

        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()) {
            listingID = rs.getInt("listingID");
            user = dao.getUser(rs.getInt("userID"));
            contractorID = rs.getInt("contractorUserID");
            
            if(contractorID != null)
            	contractor = dao.getUser(contractorID);
            
            listingTitle = rs.getString("title");
            address = rs.getString("address");
            galleryID = rs.getInt("galleryID");
            price = rs.getDouble("price");
            desc = rs.getString("desc");
            
            
            

            listing = new Listing(listingID, user, contractor, listingTitle, address, galleryID, price, desc);
        }



        return listing;
    }

    @Override
    public void updateListing(Listing listing) throws SQLException{

        Connection conn = connectToDB();
        PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_LISTING);
        
        
        if(listing.getContractor() == null) 	preparedStatement.setNull(1, java.sql.Types.NULL);
		else 									preparedStatement.setInt(1, listing.getContractor().getUserID());
        preparedStatement.setString(2, listing.getTitle());
        preparedStatement.setString(3, listing.getAddress());
        preparedStatement.setInt(4, listing.getGalleryID());
        preparedStatement.setDouble(5, listing.getPrice());
        preparedStatement.setInt(6, listing.getListingID());
        preparedStatement.setString(7, listing.getDesc());

        preparedStatement.executeUpdate();

    }

    @Override
    public void deleteListing(int listingID) throws SQLException{

        int id = listingID;

        Connection conn = connectToDB();
        PreparedStatement disable = conn.prepareStatement(KEY_CHECK_DISABLE);
        disable.executeUpdate();
        
        PreparedStatement preparedStatement = conn.prepareStatement(DELETE_LISTING);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        
        PreparedStatement enable = conn.prepareStatement(KEY_CHECK_ENABLE);
        enable.executeUpdate();

        return;
    }


}
