package com.exam.simulator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.simulator.model.Answer;

@Repository
public interface AnswerRepositiory extends JpaRepository<Answer, Integer>{

	List<Answer> findByAnswerId(Integer AnswerId);
}
