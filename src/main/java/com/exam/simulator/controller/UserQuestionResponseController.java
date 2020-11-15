package com.exam.simulator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.simulator.model.Answer;
import com.exam.simulator.model.OptionResponse;
import com.exam.simulator.model.Question;
import com.exam.simulator.model.UserQuestionResponse;
import com.exam.simulator.repository.CertificationsRepositiory;
import com.exam.simulator.repository.QuestionsRepositiory;
import com.exam.simulator.repository.UserQuestionResponseRepositiory;
import com.exam.simulator.repository.UsersRepositiory;


//@RestController @CrossOrigin(origins = "http://localhost:4200")
@RestController @CrossOrigin(origins = "*")
public class UserQuestionResponseController {	
	@Autowired
	private UserQuestionResponseRepositiory userQuestionResponseRepositiory;
	@Autowired
	private UsersRepositiory usersRepositiory;
	@Autowired
	private QuestionsRepositiory questionsRepositiory;
	@Autowired
	private CertificationsRepositiory certificationsRepositiory;
	
	  @PostMapping(value="/saveUserQuestionResponse/{userId}") 
	  public void saveUserQuestionResponse(@PathVariable("userId") String userId, 
			  								@RequestBody UserQuestionResponse userQuestionResponse ){ 
		  userQuestionResponseRepositiory.save(userQuestionResponse);
	  }
	  
	  public void setUserQuestionResponse(String emailId, String certificationId){
		  
		  List<Question> questionlist = questionsRepositiory.findQuestionsByCertification(
				  certificationsRepositiory.findByCertificationId(Integer.valueOf(certificationId)));
		  
		for (Question question : questionlist) {
			List<OptionResponse> optionResponseList = new ArrayList<>();
			UserQuestionResponse userQuestionResponse= new UserQuestionResponse();
			userQuestionResponse.setUser(usersRepositiory.findUserByEmailId(emailId));
			setOption(question, optionResponseList, userQuestionResponse);			
		} 
		 
	  }	  
	  
	  void setOption(Question question, List<OptionResponse> optionResponseList, UserQuestionResponse userQuestionResponse ) {
		  for (Answer answer : question.getAnswer()) {
				OptionResponse  optionResponse = new OptionResponse();
				optionResponse.setAnswer(answer);
				optionResponse.setUserResponse(false);
				optionResponseList.add(optionResponse);
				optionResponse=null;
			}
			
			userQuestionResponse.setQuestion(question);
			userQuestionResponse.setOptionResponse(optionResponseList);
			userQuestionResponseRepositiory.save(userQuestionResponse);
	  }
	  
		@GetMapping(value = "/getUserQuestionsByUser", params = { "emailId"})
		public List<UserQuestionResponse> getUserQuestionsByUser(@RequestParam("emailId") String emailId,
																@RequestParam("certificationId") String certificationId) {
			setUserQuestionResponse(emailId, certificationId);
			return userQuestionResponseRepositiory.findByUser(usersRepositiory.findUserByEmailId(emailId));  
		} 	  
	  
}
