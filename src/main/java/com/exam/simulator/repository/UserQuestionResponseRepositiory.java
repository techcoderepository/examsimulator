package com.exam.simulator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.simulator.model.User;
import com.exam.simulator.model.UserQuestionResponse;

@Repository
public interface UserQuestionResponseRepositiory extends JpaRepository<UserQuestionResponse,Integer>{
	List<UserQuestionResponse> findByUser(User user);
	
//	@Query("select uqr from UserQuestionResponse uqr where uqr.user =:userEmailId and uqr.certification =:certificationId")
	//List<UserQuestionResponse> findByUserandCert(@Param("userEmailId")User userEmailId, @Param("certificationId") Certification certificationId);
}
