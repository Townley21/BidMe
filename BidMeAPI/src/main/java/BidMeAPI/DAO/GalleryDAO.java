package BidMeAPI.DAO;

import BidMeAPI.Model.Gallery;

import java.sql.SQLException;

public interface GalleryDAO {

    public Gallery createGallery(Gallery gallery) throws SQLException;

    public Gallery getGallery(int galleryID) throws SQLException;

    public void updateGallery(Gallery gallery) throws SQLException;

    public void deleteGallery(Gallery gallery) throws SQLException;

}
