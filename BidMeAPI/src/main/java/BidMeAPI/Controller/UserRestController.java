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
public class UserRestController {
	
	@Autowired
	UserService service;
	
	//GET User - Works
	@GetMapping("/api/users/get/{email}")
	public User getUser(@PathVariable String email) throws SQLException {
		System.out.println("Get User called");
		return service.getUser(email);
		
	}
	
	
	//UPDATE User - Works
	@GetMapping("/api/users/update/{id},{name},{email},{password},{address},{contractor}")
	public void UpdateUser(	@PathVariable int id,
							@PathVariable String name,
							@PathVariable String email,
							@PathVariable String password,
							@PathVariable String address,
							@PathVariable boolean contractor) throws SQLException {
		
		System.out.println("Update User Called");
		User user = new User(id, name, email, password, address, contractor);
		service.updateUser(user);
	}
	
	//CREATE User - Works
	@GetMapping("/api/users/create/{id},{name},{email},{password},{address},{contractor}")
	public User createUser(	@PathVariable int id,
							@PathVariable String name,
							@PathVariable String email,
							@PathVariable String password,
							@PathVariable String address,
							@PathVariable boolean contractor) throws SQLException {
		User user = new User(id, name, email, password, address, contractor);
		return service.createuser(user);
	}
	
	
	//DELETE User - Works
	@GetMapping("/api/users/delete/{email}")
	public void deleteUser(@PathVariable String email) throws SQLException {
		service.deleteUser(service.getUser(email));
		return;
	}

}
