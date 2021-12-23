package tiw.clients.manage;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tiw.clients.manage.domains.*;

@Controller
@CrossOrigin
public class ServletInitializer {

	@Autowired
	UserDAO domains;

	/****************** OPERATIONS ON USERS ******************************************/
	

	@RequestMapping(value="/users", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<User>> getUsers(@RequestParam(value="name",required=false) String name){
		List<User> userList;
		if (name == null) {
			userList = domains.findAll();
		} else {
			userList = domains.findByName(name);
		}
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	
	// Get users by name - with the parameter in the path
	@RequestMapping(value="/users/{name}",  method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<User> getUserByName(@PathVariable String name){
		//return daous.findByName(name);
		 User us = domains.findTop1ByName(name);
		 return new ResponseEntity<>(us, HttpStatus.OK);
	}
	
	// Get users by name - with the parameter in the path
	@RequestMapping(value="/user/{name}",  method = RequestMethod.GET)
	public @ResponseBody User get1UserByName(@PathVariable String name){
		//return daous.findByName(name);
		return domains.findTop1ByName(name);
	}
	
	// Get users by email - with the parameter in the path
	@RequestMapping(value="/login/{email}", method = RequestMethod.GET)
	public @ResponseBody User get1UserByEmail(@PathVariable String email){
		//return daous.findByName(name);
		return domains.findTop1ByEmail(email);
	}
	
	// Get users by name and surname - with the parameters in the path
	@RequestMapping(value="/users/{name}/{surname}",  method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<User>> getUserByNameAndSurname(@PathVariable String name,
											  @PathVariable String surname){
		return new ResponseEntity<>(domains.findByNameAndSurname(name, surname), HttpStatus.OK);
	}
	
	// Save a user
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<User> saveUser(@RequestBody User puser){
		ResponseEntity<User> response;
		System.out.println(puser.getEmail());
		User newUser = domains.save(puser);
		if (newUser == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(newUser, HttpStatus.CREATED);
		}
		return response;
	}
	
	// Update a user
	@RequestMapping(value="/update/{email}", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<User> updateUser(@PathVariable @Validated String email, @RequestBody User pUser) {
		ResponseEntity<User> response;
		//Optional<User> us = daous.findById(id);
		User us = domains.findTop1ByEmail(email);
		if (us == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			us.setName(pUser.getName());
			us.setSurname(pUser.getSurname());
			us.setEmail(pUser.getEmail());
			us.setPass(pUser.getPass());
			us.setCity(pUser.getCity());
			us.setImage(pUser.getImage());
			response = new ResponseEntity<>(domains.save(us), HttpStatus.OK);
		}
		return response;
	}
	
	// Delete a user
	@RequestMapping(value="/delete/{email}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<User> deleteUser(@PathVariable @Validated String email) {
		ResponseEntity<User> response;
		User us = domains.findTop1ByEmail(email);
		if (us == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			domains.delete(us);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
	}	
}
	




