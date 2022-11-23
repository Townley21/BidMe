package BidMeAPI.DAO;

import BidMeAPI.Model.Gallery;
import BidMeAPI.Model.Listing;
import BidMeAPI.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GalleryDAOImpl {

    final static String CREATE_GALLERY = "INSERT INTO BidMeUsers.gallery " + "(galleryID, entryID, photo) VALUES" + "(?, ?, ?);";
    final static String GET_GALLERY = "SELECT * FROM BidMeUsers.gallery WHERE galleryID = ?;";
    final static String DELETE_GALLERY = "DELETE FROM BidMeUsers.gallery WHERE galleryID = ?;";
    final static String UPDATE_GALLERY = "UPDATE BidMeUsers.gallery SET photo = ? WHERE galleryID = ?;";

    UsersListDAOImpl userDao;

    public Connection connectToDB() throws SQLException {

        Connection conn = BidMeAPI.Database.DatabaseManager.openConnection();

        return conn;
    }

    @Override
    public Gallery createGallery(Gallery gallery) throws SQLException {

        int galleryID = gallery.getGalleryID();
        int entryID = gallery.getEntryID();
        Listing listing = gallery.getListing();
        Byte[] image = gallery.getImage();

        Connection connection = connectToDB();

        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_GALLERY);

        preparedStatement.setByte(1, galleryID);
        preparedStatement.setLong(2, entryID);
        preparedStatement.setLong(3, gallery.getListing(););
        preparedStatement.setBlob(4, image);

        preparedStatement.executeUpdate();

        return null;
    }

    @Override
    public Gallery getGallery(int ID) throws SQLException{

        Gallery gallery = null;
        int galleryID = ID;
        Listing listing;

        Connection conn = connectToDB();
        PreparedStatement preparedStatement = conn.prepareStatement(GET_GALLERY);
        preparedStatement.setInt(1, galleryID);

        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()) {
            galleryID = rs.getInt("galleryID");
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
    public void updateGallery(Gallery gallery) throws SQLException{

    }

    @Override
    public void deleteGallery(Gallery gallery) throws SQLException{

    }

}
