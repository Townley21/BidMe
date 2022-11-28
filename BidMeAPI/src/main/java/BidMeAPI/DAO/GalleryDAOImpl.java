package BidMeAPI.DAO;

import BidMeAPI.Model.Gallery;
import BidMeAPI.Model.Listing;
import BidMeAPI.Model.User;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GalleryDAOImpl implements GalleryDAO {

    final static String CREATE_GALLERY = "INSERT INTO BidMeUsers.gallery " + "(galleryID, entryID, photo) VALUES" + "(?, ?, ?);";
    final static String GET_GALLERY = "SELECT photo FROM BidMeUsers.gallery WHERE galleryID = ?;";
    final static String DELETE_GALLERY = "DELETE FROM BidMeUsers.gallery WHERE galleryID = ?;";
    final static String UPDATE_GALLERY = "UPDATE BidMeUsers.gallery SET photo = ? WHERE galleryID = ?;";


    public Connection connectToDB() throws SQLException {

        Connection conn = BidMeAPI.Database.DatabaseManager.openConnection();

        return conn;
    }

    @Override
    public Gallery createGallery(Gallery gallery) throws SQLException {

        return null;
    }

    @Override
    public List<byte[]> getAllGalleries(int ID) throws SQLException{

        List<byte[]> images = new ArrayList<>();
        int galleryID = ID;
        byte[] image;
        Blob blob;
        int blobLength;
        

        Connection conn = connectToDB();
        PreparedStatement preparedStatement = conn.prepareStatement(GET_GALLERY);
        preparedStatement.setInt(1, galleryID);

        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()) {
           blob = rs.getBlob("photo");
           System.out.println("blob to string: " + blob.toString());
           blobLength = (int) blob.length();
           System.out.println("blob legnth: " + blobLength);
           image = blob.getBytes(1, blobLength);
           System.out.println("blob to bytes: " + image);
           blob.free();
           System.out.println("blob to bytes After free: " + image);
           images.add(image);
           
           
        }


        System.out.println("images list: " + images.toString());
        return images;
    }

    @Override
    public void updateGallery(Gallery gallery) throws SQLException{

    }

    @Override
    public void deleteGallery(Gallery gallery) throws SQLException{

    }

}
