package BidMeAPI.DAO;

import java.nio.file.Files;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GalleryDAOTests {

	GalleryDAOImpl galleryDAO = new GalleryDAOImpl();

	int galleryID = 1;
	int entryID = 0;
	File fi = new File("toolssplash.jpg");
	byte[] image = Files.readAllBytes(fi.toPath());

	Gallery gallery = new Galllery(galleryID, entryID, image);



	@Test
	void testCreateGallery() {
		System.out.println("testing create gallery...");

		galleryDAO.createGallery(gallery);

		assertNotNull(galleryDAO.getGallery(galleryID));
		
	}
	
	@Test
	void testGetGallery() {
		
	}
	
	@Test
	void testUpdateGallery() {
		
	}
	
	@Test
	void testDeleteGallery() {
		
	}

}
