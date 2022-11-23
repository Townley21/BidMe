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

import BidMeAPI.Model.User;
import BidMeAPI.Service.UserService;

@RestController
@RequestMapping(value = { "/" })
public class HomeController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/api/users/{email}")
	public User getUser(@PathVariable String email) throws SQLException {
		System.out.println("Controller called");
		return service.getUser(email);
		
	}

}
