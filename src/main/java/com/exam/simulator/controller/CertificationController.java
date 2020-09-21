package com.exam.simulator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.simulator.model.Certifications;
import com.exam.simulator.repository.CertificationsRepositiory;


@RestController @CrossOrigin(origins = "http://localhost:4200")
public class CertificationController {	
	@Autowired
	private CertificationsRepositiory certificationsRepositiory;
	  
	  @PostMapping(value="/addCertifications") 
	  public void addCertifications(@RequestBody Certifications certification){ 
		  certificationsRepositiory.save(certification);
	  } 
}
