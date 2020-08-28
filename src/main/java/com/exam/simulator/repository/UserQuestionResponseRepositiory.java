package com.exam.simulator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.simulator.model.IdClassUser;
import com.exam.simulator.model.UserQuestionResponse;

@Repository
public interface UserQuestionResponseRepositiory extends JpaRepository<UserQuestionResponse,IdClassUser>{
	//List<UserQuestionResponse> findByIdClassUserId(IdClassUser idClassUser);	

}
