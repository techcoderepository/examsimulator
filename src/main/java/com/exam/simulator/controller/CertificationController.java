package com.exam.simulator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.simulator.model.Certification;
import com.exam.simulator.repository.CertificationsRepositiory;

@RestController @CrossOrigin(origins = "*")
//@RestController @CrossOrigin(origins = "http://localhost:4200")
public class CertificationController {	
	@Autowired
	private CertificationsRepositiory certificationsRepositiory;
	  
	  @PostMapping(value="/addCertification") 
	  public void addCertifications(@RequestBody Certification certification){ 
		  certificationsRepositiory.save(certification);
	  } 
	  
	  @GetMapping(value="/getCertifications") 
	  public List<Certification> getAllCertifications(){ 
		  return certificationsRepositiory.findAll();
	  }
}
