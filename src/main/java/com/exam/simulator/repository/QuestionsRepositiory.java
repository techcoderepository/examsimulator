package com.exam.simulator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.simulator.model.Certification;
import com.exam.simulator.model.Question;

@Repository
public interface QuestionsRepositiory extends JpaRepository<Question, Integer>{
	List<Question> findQuestionsByCertification(Certification certification);
}
