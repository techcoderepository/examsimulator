package com.exam.simulator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exam.simulator.model.User;

@Repository
public interface UsersRepositiory extends JpaRepository<User, Integer>{	
	@Query("select user from User user where user.emailId =:emailId")
	User findUserEmailId(String emailId);
	List<User> findByEmailId(String emailId);
}
