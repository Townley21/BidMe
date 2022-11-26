package BidMeAPI.Controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import BidMeAPI.Model.Bid;
import BidMeAPI.Model.Listing;
import BidMeAPI.Model.Matchmaker;
import BidMeAPI.Service.ActiveListingService;
import BidMeAPI.Service.BidService;
import BidMeAPI.Service.matchmakerService;

@RestController
public class matchmakerRestController {
	
	@Autowired
	matchmakerService service;
	
	@Autowired
	BidService bid_ser;
	
	@Autowired
	ActiveListingService listing_ser;
	
	
	//CREATE - Works
	@GetMapping("/api/matchmaker/create/{mmID},{bidID},{listingID}")
	public Matchmaker createMatchMaker (
							@PathVariable int mmID,
							@PathVariable int bidID,
							@PathVariable int listingID) throws SQLException {
		Matchmaker matchmaker = new Matchmaker(mmID, bid_ser.getBid(bidID), listing_ser.getListing(listingID));		
		
		return service.createMatchmaker(matchmaker);
	}
	
	//DELETE - Works
	@GetMapping("/api/matchmaker/delete/{id}")
	public void deleteMatchmaker(@PathVariable int id) throws SQLException {
		service.deleteMatchmaker(id);
		return;
	}
	
	//UPDATE - Works
	@GetMapping("/api/matchmaker/update/{mmID},{bidID},{listingID}")
	public void updateMatchMaker (
							@PathVariable int mmID,
							@PathVariable int bidID,
							@PathVariable int listingID) throws SQLException {

		System.out.println("Update MatchMaker Called");
		Matchmaker matchmaker = new Matchmaker(mmID, bid_ser.getBid(bidID), listing_ser.getListing(listingID));		
		service.updateMatchmaker(matchmaker);
	}
	
	//GET ALL - Works
	@GetMapping("/api/matchmaker/getAll/{listingID}")
	public List<Matchmaker> getAllMatchMakersByListing(@PathVariable int listingID) throws SQLException {
		System.out.println("Get MatchMaker called");
		return service.getAllMatchmakersByListing(listing_ser.getListing(listingID));
	}
	
	
	
}
