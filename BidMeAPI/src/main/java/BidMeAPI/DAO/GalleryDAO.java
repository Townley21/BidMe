package BidMeAPI.DAO;

import BidMeAPI.Model.Gallery;

import java.sql.SQLException;
import java.util.List;

public interface GalleryDAO {

    public Gallery createGallery(Gallery gallery) throws SQLException;

    public List<byte[]> getAllGalleries(int galleryID) throws SQLException;

    public void updateGallery(Gallery gallery) throws SQLException;

    public void deleteGallery(Gallery gallery) throws SQLException;

}
