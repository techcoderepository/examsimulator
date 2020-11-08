package com.exam.simulator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.simulator.model.ExamSchedule;
import com.exam.simulator.model.User;
import com.exam.simulator.repository.ExamScheduleRepositiory;

@RestController @CrossOrigin(origins = "http://d45b3334418e.ngrok.io") 

//@RestController @CrossOrigin(origins = "http://localhost:4200")
public class ExamScheduleController {	
	@Autowired
	private ExamScheduleRepositiory examScheduleRepositiory;
	
	  @PostMapping(value="/saveExamSchedule") 
	  public void saveExamSchedule(@RequestBody ExamSchedule examSchedule){ 
		  examScheduleRepositiory.save(examSchedule);
	  }
	  	
	  @GetMapping(value="/getScheduledExamListByEmailId/{userEmailId}") 
	  public List<ExamSchedule> getScheduledExamListByEmailId(@PathVariable(value = "userEmailId") String userEmailId){
		  List<ExamSchedule> abc = examScheduleRepositiory.findByUser(new User(userEmailId)); 
	   return abc;
	  }
	  
	  @DeleteMapping(value="/deleteByExamScheduleId/{examScheduleId}") 
	  public void  deleteScheduledExamListByEmailId(@PathVariable(value = "examScheduleId") String examScheduleId){	  	  
		 examScheduleRepositiory.deleteById(Integer.valueOf(examScheduleId));	  	  
	  }
	 
}
