package com.exam.simulator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.simulator.model.ExamSchedule;
import com.exam.simulator.model.User;

@Repository
public interface ExamScheduleRepositiory extends JpaRepository<ExamSchedule, Integer>{

	List<ExamSchedule> findByExamScheduleId(String emailId);
	List<ExamSchedule> findByUser(User user);
}
