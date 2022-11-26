package BidMeAPI.Controller;

import java.sql.SQLException;

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
import BidMeAPI.Service.matchmakerService;

@RestController
public class matchmakerRestController {
	@Autowired
	matchmakerService service;
	
	@GetMapping("/api/matchmaker/create/{mmID},{bidID},{listingID}")
	public Matchmaker createMatchMaker (
							@PathVariable int mmID,
							@PathVariable Bid bidID,
							@PathVariable Listing listingID) throws SQLException {
		Matchmaker matchmaker = new Matchmaker(mmID, bidID, listingID);		
		
		return service.createMatchmaker(matchmaker);
	}
	
	@GetMapping("/api/matchmaker/delete/{id}")
	public void deleteMatchmaker(@PathVariable int id) throws SQLException {
		service.deleteMatchmaker(null);
		return;
	}
	
	@GetMapping("/api/matchmaker/update/{mmID},{bidID},{listingID}")
	public void updateMatchMaker (
							@PathVariable int mmID,
							@PathVariable Bid bidID,
							@PathVariable Listing listingID) throws SQLException {

		System.out.println("Update MatchMaker Called");
		Matchmaker matchmaker = new Matchmaker(mmID, bidID, listingID);		
		service.updateMatchmaker(matchmaker);
	}
	
	@GetMapping("/api/matchmaker/get/{id}")
	public Matchmaker getMatchMaker(@PathVariable int id) throws SQLException {
		System.out.println("Get MatchMaker called");
		return service.getMatchmaker(id);
	}
	
	
	
}
