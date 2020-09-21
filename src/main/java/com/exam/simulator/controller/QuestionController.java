package com.exam.simulator.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.simulator.model.Questions;
import com.exam.simulator.repository.QuestionsRepositiory;


@RestController @CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {	
	@Autowired
	private QuestionsRepositiory questionsRepositiory;
	
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
}
