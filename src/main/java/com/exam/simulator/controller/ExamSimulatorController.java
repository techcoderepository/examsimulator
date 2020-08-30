package com.exam.simulator.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.simulator.exception.ResourceNotFoundException;
import com.exam.simulator.model.Certifications;
import com.exam.simulator.model.IdClassUser;
import com.exam.simulator.model.Questions;
import com.exam.simulator.model.UserQuestionResponse;
import com.exam.simulator.model.Users;
import com.exam.simulator.repository.CertificationsRepositiory;
import com.exam.simulator.repository.QuestionsRepositiory;
import com.exam.simulator.repository.UserQuestionResponseRepositiory;
import com.exam.simulator.repository.UsersRepositiory;


@RestController @CrossOrigin(origins = "http://localhost:4200")
public class ExamSimulatorController {	
	@Autowired
	private QuestionsRepositiory questionsRepositiory;
	
	@Autowired
	private UserQuestionResponseRepositiory userQuestionResponseRepositiory;
	
	@Autowired
	private UsersRepositiory usersRepositiory;
	
	@Autowired
	private CertificationsRepositiory certificationsRepositiory;
	@Autowired
	private IdClassUser idClassUser;	
	
	@GetMapping("/getQuestion/{questionId}")
	public Optional<Questions> getQuestion(@PathVariable("questionId") Integer questionId){			
		return 	questionsRepositiory.findById(questionId);
				
	}
	
	@GetMapping("/getAllQuestions")
	public Iterable<Questions> getAllQuestions(){			
		return 	questionsRepositiory.findAll();				
	}
	
	  @PostMapping(value="/addQuestion") 
	  public Questions addQuestion(@RequestBody Questions question ){ 
		  return questionsRepositiory.save(question);
	  }
	 
	  @PostMapping(value="/saveUserQuestionResponse/{userId}") 
	  public void saveUserQuestionResponse(@PathVariable("userId") String userId, @RequestBody UserQuestionResponse userQuestionResponse ){ 
		  userQuestionResponseRepositiory.save(userQuestionResponse);
	  }
	  
	  @PostMapping(value="/addUsers") 
	  public void saveUser(@RequestBody Users user){ 
		  usersRepositiory.save(user);
	  } 
	  
	  @GetMapping(value="/getUsers") 
	  public List<Users> getUsers(){ 
		  return usersRepositiory.findAll();
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
	  
	  
	  @PostMapping(value="/addCertifications") 
	  public void addCertifications(@RequestBody Certifications certification){ 
		  certificationsRepositiory.save(certification);
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
