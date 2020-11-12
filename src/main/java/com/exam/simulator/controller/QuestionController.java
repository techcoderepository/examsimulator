package com.exam.simulator.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.simulator.model.Question;
import com.exam.simulator.repository.CertificationsRepositiory;
import com.exam.simulator.repository.QuestionsRepositiory;


//@RestController @CrossOrigin(origins = "http://localhost:4200")
@RestController @CrossOrigin(origins = "*") 

public class QuestionController {	
	@Autowired
	private QuestionsRepositiory questionsRepositiory;
	@Autowired
	private CertificationsRepositiory certificationsRepositiory;
	
	@GetMapping("/getQuestion/{questionId}")
	public Optional<Question> getQuestion(@PathVariable("questionId") Integer questionId){			
		return 	questionsRepositiory.findById(questionId);
				
	}
	
	@GetMapping("/getAllQuestions")
	public List<Question> getAllQuestions(){			
		return 	questionsRepositiory.findAll();				
	}
	
	  @PostMapping(value="/addQuestion") 
	  public Question addQuestion(@RequestBody Question questionList){		
		  questionList.setCertification(certificationsRepositiory
				  .findByCertificationId(questionList.getCertification().getCertificationId()));
		  return  questionsRepositiory.save(questionList);
	  }	 
}
