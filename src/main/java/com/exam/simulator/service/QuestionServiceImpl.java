package com.exam.simulator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.simulator.model.Questions;
import com.exam.simulator.repository.QuestionsRepositiory;

@Service("questionServiceImpl")
public class QuestionServiceImpl {

	@Autowired
	private QuestionsRepositiory questionsRepositiory;
	
	public List<String> getQuestion(Integer questionId) {
		List<String> result = new ArrayList<String>();
		List<Questions> questions = questionsRepositiory.findByQuestionId(questionId);
		for (Questions question : questions) {
			result.add(question.getQuestion());
		}
		return result;
	}	
}
