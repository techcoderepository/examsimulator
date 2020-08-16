package com.exam.simulator.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.simulator.dto.QARequest;
import com.exam.simulator.model.Questions;
import com.exam.simulator.repository.QuestionsRepositiory;


@RestController
public class ExamSimulatorController {	
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
	  public Questions addQuestion(@RequestBody QARequest qARequest ){ 
		  return questionsRepositiory.save(qARequest.getQuestion()); 
	  
	  }
	 

}
