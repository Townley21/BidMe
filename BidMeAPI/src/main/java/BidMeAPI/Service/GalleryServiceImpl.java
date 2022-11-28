package BidMeAPI.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import BidMeAPI.DAO.GalleryDAO;

@Primary
@Service
public class GalleryServiceImpl implements GalleryService {
	
	@Autowired
	GalleryDAO dao;
	
	 public List<byte[]> getAllGalleries(int galleryID) throws SQLException {
		 return dao.getAllGalleries(galleryID);
	 }

}
