package com.exam.simulator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.simulator.model.Answers;

@Repository
public interface AnswersRepositiory extends JpaRepository<Answers, Integer>{

	List<Answers> findByAnswerId(Integer AnswerId);
}
