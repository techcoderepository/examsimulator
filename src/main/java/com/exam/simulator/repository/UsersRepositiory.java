package com.exam.simulator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.simulator.model.Users;

@Repository
public interface UsersRepositiory extends JpaRepository<Users, String>{

	List<Users> findByEmailId(String emailId);
}
