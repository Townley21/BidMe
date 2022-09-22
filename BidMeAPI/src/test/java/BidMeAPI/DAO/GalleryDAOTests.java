package BidMeAPI.DAO;

import BidMeAPI.Model.Gallery;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GalleryDAOTests {

	GalleryDAOImpl galleryDAO = new GalleryDAOImpl();

	int galleryID = 1;
	int entryID = 0;
	File fi = new File("images/hammerBoi.png");
	byte[] image;

	{
		try {
			image = Files.readAllBytes(fi.toPath());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	Gallery gallery = new Gallery(galleryID, entryID, image);

	@Test
	void testCreateGallery() throws SQLException {
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
