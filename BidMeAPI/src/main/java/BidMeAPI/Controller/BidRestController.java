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
	
	//UPDATE - works
	@GetMapping("/api/bids/update/{bidID},{userID},{price},{timestamp}")
	public void updateBid(	@PathVariable int bidID,
							@PathVariable int userID,
							@PathVariable double price,
							@PathVariable Timestamp timestamp) throws SQLException {
		
		Bid bid = new Bid(user_ser.getUser(userID), bidID, price, timestamp);
		service.updateBid(bid);
		return;
	}
	
	//CREATE - works
	@GetMapping("/api/bids/create/{bidID},{userID},{price},{timestamp}")
	public void createBid(	@PathVariable int bidID,
							@PathVariable int userID,
							@PathVariable double price,
							@PathVariable Timestamp timestamp) throws SQLException {
		
		Bid bid = new Bid(user_ser.getUser(userID), bidID, price, timestamp);
		service.createBid(bid);
		return;
	}
	
	//DELETE - works
	@GetMapping("/api/bids/delete/{id}")
	public void deleteBid(@PathVariable int id) throws SQLException {
		service.deleteBid(id);
		return;
		
	}
	

}
