package com.exam.simulator.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.simulator.exception.ResourceNotFoundException;
import com.exam.simulator.model.User;
import com.exam.simulator.repository.UsersRepositiory;


//@RestController @CrossOrigin(origins = "http://localhost:4200")

@RestController @CrossOrigin(origins = "*") 
public class UserController {	
	@Autowired
	private UsersRepositiory usersRepositiory;
	
	  @PostMapping(value="/createUser") 
	  public User saveUser(@RequestBody User user){ 
		  return usersRepositiory.save(user);
	  } 
	  @PutMapping(value="/updateUser/{userId}") 
	  public ResponseEntity<User> updateUser(@PathVariable(value = "userId") String userId, @Valid @RequestBody User form)throws ResourceNotFoundException {
		  User user = usersRepositiory.findById(Integer.valueOf(userId))
	       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	        user.setFullName(form.getFullName());
	        final User updatedUser = usersRepositiory.save(user);
	        return ResponseEntity.ok(updatedUser);
	  } 
	  
	  @GetMapping(value="/getAllUsers") 
	  public List<User> getAllUsers(){ 
		  return usersRepositiory.findAll();
	  }
	  
	  @GetMapping(value="/getUserById/{userId}") 
	  public List<User> getUserById(@PathVariable(value = "userId") String emailId){ 
		  return usersRepositiory.findByEmailId(emailId);
	  } 
	  
	  @GetMapping(value="/validateUser/{emailId}") 
	  public User validateUser(@PathVariable(value = "emailId") String emailId){ 
			return usersRepositiory.findUserEmailId(emailId);
	  } 
	  
	  @DeleteMapping("/deleteUser/{userId}")
	    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "userId") String userId)
	         throws ResourceNotFoundException {
		  User user = usersRepositiory.findById(Integer.valueOf(userId))
	       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	        usersRepositiory.deleteById(Integer.valueOf(userId));
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}
