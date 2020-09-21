package com.exam.simulator.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.simulator.model.IdClassUser;
import com.exam.simulator.model.UserQuestionResponse;
import com.exam.simulator.repository.UserQuestionResponseRepositiory;


@RestController @CrossOrigin(origins = "http://localhost:4200")
public class UserQuestionResponseController {	
	@Autowired
	private UserQuestionResponseRepositiory userQuestionResponseRepositiory;
	
	@Autowired
	private IdClassUser idClassUser;	
	
	 
	  @PostMapping(value="/saveUserQuestionResponse/{userId}") 
	  public void saveUserQuestionResponse(@PathVariable("userId") String userId, @RequestBody UserQuestionResponse userQuestionResponse ){ 
		  userQuestionResponseRepositiory.save(userQuestionResponse);
	  }
	  
	  @GetMapping(value="/getUserQuestions", params= {"user","question","answer", "certification"}) 
	  public Optional<UserQuestionResponse> getUserQuestions(@RequestParam("user") String user,
			  @RequestParam("question") String question,
			  @RequestParam("answer") String answer,
			  @RequestParam("certification") String certification){ 
		  idClassUser.setUser(user);
		  idClassUser.setQuestion(Integer.valueOf(question));
		  idClassUser.setAnswer(Integer.valueOf(answer));
		  idClassUser.setCertification(Integer.valueOf(certification));
		  return userQuestionResponseRepositiory.findById(idClassUser);
	  }
}
