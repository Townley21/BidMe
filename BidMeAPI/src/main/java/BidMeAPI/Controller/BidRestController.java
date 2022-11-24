package BidMeAPI.Controller;

import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import BidMeAPI.Model.Bid;
import BidMeAPI.Service.BidService;
import BidMeAPI.Service.UserService;

@RestController
public class BidRestController {
	
	@Autowired
	BidService service;
	
	@Autowired
	UserService user_ser;
	
	//GET bid - works
	@GetMapping("/api/bids/get/{id}")
	public Bid getBid(@PathVariable int id) throws SQLException {
		return service.getBid(id);
		
	}
	
	//UPDATE
	@GetMapping("/api/bids/update/{bidID},{userID},{price},{nullBids},{timestamp}")
	public void updateBid(	@PathVariable int bidID,
							@PathVariable int userID,
							@PathVariable double price,
							@PathVariable boolean nullBids,
							@PathVariable Timestamp timestamp) throws SQLException {
		
		Bid bid = new Bid(user_ser.getUser(userID), bidID, price, nullBids, timestamp);
		service.updateBid(bid);
		return;
	}
	
	//CREATE
	
	//DELETE

}
