package BidMeAPI.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import BidMeAPI.Service.GalleryService;

@RestController
public class GalleryRestController {
	
	@Autowired
	GalleryService service;
	
	@GetMapping("/api/gallery/getAllByListingID/{galleryID}")
	public List<byte[]> getAllByListingID(@PathVariable int galleryID) throws SQLException {
		return service.getAllGalleries(galleryID);
	}
	
}
