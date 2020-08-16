package com.exam.simulator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exam.simulator.model.Questions;

@Repository
public interface QuestionsRepositiory extends CrudRepository<Questions, Integer>{

	List<Questions> findByQuestionId(Integer QuestionId);
}
