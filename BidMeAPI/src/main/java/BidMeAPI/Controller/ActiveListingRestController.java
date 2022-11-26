package BidMeAPI.Controller;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import BidMeAPI.Model.Listing;
import BidMeAPI.Model.User;
import BidMeAPI.Service.ActiveListingService;
import BidMeAPI.Service.UserService;

@RestController
public class ActiveListingRestController {
	
	@Autowired
	ActiveListingService service;
	
	@Autowired
	UserService user_ser;
	
	//GET listing
	@GetMapping("/api/activeListings/get/{userID}")
	public Listing getActiveListing(@PathVariable int userID) throws SQLException {
		return service.getListing(userID);
	}
	
	//UPDATE listing - works - If you want contractor to be null, input value of 0 for ID
	@GetMapping("/api/activeListings/update/{listingID},{userID},{contractorUserID},{title},{address},{galleryID},{price}")
	public void updateListing(	@PathVariable int listingID,
								@PathVariable int userID,
								@PathVariable int contractorUserID,
								@PathVariable String title,
								@PathVariable String address,
								@PathVariable int galleryID,
								@PathVariable double price) throws SQLException {
		User contractor = null;
		if (contractorUserID != 0) {
			contractor = user_ser.getUser(contractorUserID);
		}
		
		
		Listing listing = new Listing(listingID, user_ser.getUser(userID), contractor, title, address, galleryID, price);
		service.updateListing(listing);
		
		return;
	}

	
	//CREATE listing - Wworks - If you want contractor to be null, input value of 0 for ID
	@GetMapping("/api/activeListings/create/{listingID},{userID},{contractorUserID},{title},{address},{galleryID},{price}")
	public Listing createListing(	@PathVariable int listingID,
								@PathVariable int userID,
								@PathVariable int contractorUserID,
								@PathVariable String title,
								@PathVariable String address,
								@PathVariable int galleryID,
								@PathVariable double price) throws SQLException {
		
		if(user_ser.getUser(userID) == null) {
			System.out.println("Error: user does not exist.");
			return null;
		}
	
		User contractor = null;
		if (contractorUserID != 0) {
			contractor = user_ser.getUser(contractorUserID);
		}
		
		Listing listing = new Listing(listingID, user_ser.getUser(userID), contractor, title, address, galleryID, price);
		return service.createListing(listing);
	}

	//DELETE listing - works
	@GetMapping("/api/activeListings/delete/{listingID}")
	public void deleteListing(@PathVariable int listingID) throws SQLException {
		service.deleteListing(listingID);
	}
}
