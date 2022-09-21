package BidMeAPI.DAO;

import BidMeAPI.Model.Gallery;
import BidMeAPI.Model.Listing;
import BidMeAPI.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GalleryDAOImpl implements GalleryDAO {

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
        byte[] image = gallery.getImage();

        Connection connection = connectToDB();

        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_GALLERY);

        preparedStatement.setInt(1, galleryID);
        preparedStatement.setLong(2, entryID);
        preparedStatement.setBytes(3, image);

        preparedStatement.executeUpdate();

        return null;
    }

    @Override
    public Gallery getGallery(int galleryID) throws SQLException{

        Gallery gallery = null;
        int id = galleryID;
        int entryID;
        byte[] photo;

        Connection conn = connectToDB();
        PreparedStatement preparedStatement = conn.prepareStatement(GET_GALLERY);
        preparedStatement.setInt(1, id);

        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()) {
            id = rs.getInt("galleryID");
            entryID = rs.getInt("entryID");
            photo = rs.getBytes("photo");

            gallery = new Gallery(id, entryID, photo);
        }



        return gallery;
    }

    @Override
    public void updateGallery(Gallery gallery) throws SQLException{
    	
    }

    @Override
    public void deleteGallery(Gallery gallery) throws SQLException{

    }

}
