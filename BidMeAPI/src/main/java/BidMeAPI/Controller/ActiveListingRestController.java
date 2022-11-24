package BidMeAPI.Controller;

import java.sql.SQLException;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import BidMeAPI.Model.Listing;
import BidMeAPI.Service.ActiveListingService;
import BidMeAPI.Service.UserService;

@RestController
public class ActiveListingRestController {
	
	@Autowired
	ActiveListingService service;
	
	
	//GET listing
	@GetMapping("/api/activeListings/get/{userID}")
	public Listing getActiveListing(@PathVariable Integer userID) throws SQLException {
		return service.getListing(userID);
	}

}
