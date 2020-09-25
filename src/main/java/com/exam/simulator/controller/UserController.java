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
import com.exam.simulator.model.Users;
import com.exam.simulator.repository.UsersRepositiory;


@RestController @CrossOrigin(origins = "http://localhost:4200")
public class UserController {	
	@Autowired
	private UsersRepositiory usersRepositiory;
	
	  @PostMapping(value="/createUser") 
	  public void saveUser(@RequestBody Users user){ 
		  usersRepositiory.save(user);
	  } 
	  @PutMapping(value="/updateUser/{userId}") 
	  public ResponseEntity<Users> updateUser(@PathVariable(value = "userId") String userId, @Valid @RequestBody Users form)throws ResourceNotFoundException {
		  Users user = usersRepositiory.findById(userId)
	       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	        user.setFullName(form.getFullName());
	        final Users updatedUser = usersRepositiory.save(user);
	        return ResponseEntity.ok(updatedUser);
	  } 
	  
	  @GetMapping(value="/getAllUsers") 
	  public List<Users> getAllUsers(){ 
		  return usersRepositiory.findAll();
	  }
	  
	  @GetMapping(value="/getUserById/{userId}") 
	  public List<Users> getUserById(@PathVariable(value = "userId") String emailId){ 
		  return usersRepositiory.findByEmailId(emailId);
	  } 
	  
	  @GetMapping(value="/validateUser/{emailId}") 
	  public String validateUser(@PathVariable(value = "emailId") String emailId){ 
		  List<Users> userList = usersRepositiory.findByEmailId(emailId);
		   if(userList.isEmpty()) {
			   return "fail";
		   }
		  return "success";
	  } 
	  
	  @DeleteMapping("/deleteUser/{userId}")
	    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "userId") String userId)
	         throws ResourceNotFoundException {
	        Users user = usersRepositiory.findById(userId)
	       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	        usersRepositiory.deleteById(userId);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}
