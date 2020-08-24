package com.exam.simulator.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.simulator.model.Questions;
import com.exam.simulator.model.UserQuestionResponse;
import com.exam.simulator.repository.QuestionsRepositiory;
import com.exam.simulator.repository.UserQuestionResponseRepositiory;


@RestController
public class ExamSimulatorController {	
	@Autowired
	private QuestionsRepositiory questionsRepositiory;
	
	@Autowired
	private UserQuestionResponseRepositiory userQuestionResponseRepositiory;
	
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
	  
}
