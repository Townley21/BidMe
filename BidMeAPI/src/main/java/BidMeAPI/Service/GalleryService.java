package BidMeAPI.Service;

import java.sql.SQLException;
import java.util.List;

public interface GalleryService {

	 public List<byte[]> getAllGalleries(int galleryID) throws SQLException;
	 
}
