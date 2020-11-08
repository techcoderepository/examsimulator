package com.exam.simulator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.simulator.model.Answer;
import com.exam.simulator.model.Certification;
import com.exam.simulator.model.IdClassUser;
import com.exam.simulator.model.OptionResponse;
import com.exam.simulator.model.Question;
import com.exam.simulator.model.User;
import com.exam.simulator.model.UserQuestionResponse;
import com.exam.simulator.repository.QuestionsRepositiory;
import com.exam.simulator.repository.UserQuestionResponseRepositiory;


@RestController @CrossOrigin(origins = "http://localhost:4200")
public class UserQuestionResponseController {	
	@Autowired
	private UserQuestionResponseRepositiory userQuestionResponseRepositiory;
	
	//@Autowired
	//private UserQuestionResponse userQuestionResponse= new UserQuestionResponse();
	
	//@Autowired
	private User user = new User();
	
	//@Autowired
	private Certification certification =new Certification();	
	
	/*
	 * @Autowired private Question question;
	 * 
	 * @Autowired private Answer answer;
	 */
	
	@Autowired
	private IdClassUser idClassUser;
	
	@Autowired
	private QuestionsRepositiory questionsRepositiory;
	 
	  @PostMapping(value="/saveUserQuestionResponse/{userId}") 
	  public void saveUserQuestionResponse(@PathVariable("userId") String userId, 
			  								@RequestBody UserQuestionResponse userQuestionResponse ){ 
		  userQuestionResponseRepositiory.save(userQuestionResponse);
	  }
	  
	  @PostMapping(value="/setUserQuestionsResponse",params= {"userEmailId", "certificationId"}) 
	  public void setUserQuestionResponse(@RequestParam("userEmailId") String userEmailId,
			  								@RequestParam("certificationId") String certificationId){
		  user.setEmailId(userEmailId);		  
		  certification.setCertificationId(Integer.valueOf(certificationId));		  
		  List<Question> questionlist = questionsRepositiory.findAll();
		  
		for (Question question : questionlist) {
			List<OptionResponse> optionResponseList = new ArrayList<>();
			UserQuestionResponse userQuestionResponse= new UserQuestionResponse();
			check(question, optionResponseList, userQuestionResponse );			
		} 
		
		 
	  }	  
	  
	  UserQuestionResponse check(Question question, List<OptionResponse> optionResponseList, UserQuestionResponse userQuestionResponse ) {
		  for (Answer answer : question.getAnswer()) {
				OptionResponse  optionResponse = new OptionResponse();
				optionResponse.setAnswer(answer);
				optionResponse.setUserResponse(false);
				optionResponseList.add(optionResponse);
				optionResponse=null;
			}
			
			userQuestionResponse.setUser(user);
			userQuestionResponse.setCertification(certification);
			userQuestionResponse.setQuestion(question);
			userQuestionResponse.setOptionResponse(optionResponseList);
			return userQuestionResponseRepositiory.save(userQuestionResponse);
			//userQuestionResponse=null;
			//optionResponseList.clear();
	  }
	  
	/*
	 * @GetMapping(value="/getUserQuestions", params= {"user","question","answer",
	 * "certification"}) public Optional<UserQuestionResponse>
	 * getUserQuestions(@RequestParam("user") String user,
	 * 
	 * @RequestParam("question") String question,
	 * 
	 * @RequestParam("answer") String answer,
	 * 
	 * @RequestParam("certification") String certification){
	 * idClassUser.setUser(user); //
	 * idClassUser.setQuestion(Integer.valueOf(question));
	 * //idClassUser.setAnswer(Integer.valueOf(answer));
	 * idClassUser.setCertification(Integer.valueOf(certification)); return
	 * userQuestionResponseRepositiory.findById(idClassUser); }
	 */
	  
	
	@GetMapping(value = "/getUserQuestionsByUserCert", params = { "userEmailId", "certificationId" })
	public List<UserQuestionResponse> getUserQuestionsByUserCert(@RequestParam("userEmailId") String userEmailId,
			@RequestParam("certificationId") String certificationId) {
		user.setEmailId(userEmailId);
		certification.setCertificationId(Integer.valueOf(certificationId));	
		//return userQuestionResponseRepositiory.findByUser(user);
		return userQuestionResponseRepositiory.findByUserandCert(user, certification); 
	}
	  
}
